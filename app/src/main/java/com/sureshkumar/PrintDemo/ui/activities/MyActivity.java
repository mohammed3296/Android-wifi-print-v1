package com.sureshkumar.PrintDemo.ui.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import com.sureshkumar.PrintDemo.Constants;
import com.sureshkumar.PrintDemo.ObservableSingleton;
import com.sureshkumar.PrintDemo.R;
import com.sureshkumar.PrintDemo.Util;
import com.sureshkumar.PrintDemo.observers.Observable;
import com.sureshkumar.PrintDemo.observers.Observer;
import com.sureshkumar.PrintDemo.services.PrintCompleteService;
import com.sureshkumar.PrintDemo.services.PrintUtility;
import com.sureshkumar.PrintDemo.services.WifiScanner;

import java.io.File;

public class MyActivity extends Activity implements Observer, PrintCompleteService {

    Dialog mPrintDialog;
    private Button mBtnPrint, mBtnPrintFromFragment, mBtnDownloadAndPrint;
    private File pdfFile;
    private String externalStorageDirectory;
    private PrintUtility mPrintUtility;
    private WifiScanner mWifiScanner;
    private WifiManager mWifiManager;
    private Observable mObservable;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        try {
            externalStorageDirectory = Environment.getExternalStorageDirectory().toString();
            File folder = new File(externalStorageDirectory, Constants.CONTROLLER_PDF_FOLDER);
            pdfFile = new File(folder, "file name with extension");
        } catch (Exception e) {
            e.printStackTrace();
        }

        mObservable = ObservableSingleton.getInstance();

        mWifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        mWifiScanner = new WifiScanner();
        mPrintUtility = new PrintUtility(this, mWifiManager, mWifiScanner);

        mBtnPrint = (Button) findViewById(R.id.btnPrint);
        mBtnDownloadAndPrint = (Button) findViewById(R.id.btnDownloadAndPrint);
        mBtnPrintFromFragment = (Button) findViewById(R.id.btnNext);

        mBtnDownloadAndPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPrintDialog.show();
                mObservable.attach(MyActivity.this);
                if (Util.hasConnection(MyActivity.this)) {
                    mPrintUtility.downloadAndPrint("fileUrl", "fileName with extension");
                } else {
                    mObservable.notifyObserver(true);
                    Toast.makeText(MyActivity.this, "Please connect to Internet", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBtnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPrintDialog.show();
                mObservable.attach(MyActivity.this);
                mPrintUtility.print(pdfFile);
            }
        });

        mBtnPrintFromFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iNext = new Intent(MyActivity.this, PrintFragmentActivity.class);
                startActivity(iNext);
            }
        });

        initPrintDialog();
    }

    private void initPrintDialog() {
        mPrintDialog = new Dialog(this);
        mPrintDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = mPrintDialog.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        mPrintDialog.setContentView(R.layout.dialog_progressbar);


        mPrintDialog.setCancelable(true);
        mPrintDialog.setCanceledOnTouchOutside(false);

        mPrintDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(MyActivity.this);

                    alert.setMessage("Do you want to cancel printing?");

                    alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            mPrintUtility.onPrintCancelled();
                        }
                    });

                    alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });

                    alert.show();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            // This will give list of wifi available nearby.
            registerReceiver(mWifiScanner, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
            mWifiManager.startScan();
            mPrintUtility.setScanResults(mWifiScanner.getScanResults());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            unregisterReceiver(mWifiScanner);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_CODE_PRINTER && resultCode == Constants.RESULT_CODE_PRINTER) {

            // stores printer configuration and prints..
            if (!mPrintDialog.isShowing())
                mPrintDialog.show();

            mPrintUtility.getPrinterConfigAndPrint();

        } else if (requestCode == Constants.REQUEST_CODE_WIFI && resultCode == Constants.RESULT_CODE_PRINTER) {
            // after switch back to wifi..

        } else if (requestCode == Constants.REQUEST_CODE_PRINTER && resultCode == Constants.RESULT_CODE_PRINTER_CONNECT_FAILED) {

            if (!mPrintDialog.isShowing())
                mPrintDialog.show();

            mPrintUtility.onPrintCancelled();

        }
    }

    @Override
    public void onBackPressed() {
        try {
            if (mPrintDialog != null && mPrintDialog.isShowing()) {

            } else {
                finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessage(int status) {
        // get List of PrintJob from PrintManager
        mPrintUtility.completePrintJob();
    }

    @Override
    public void respondAfterWifiSwitch() {
        // code after network switch completes.
    }

    @Override
    public void update() {
        if (mPrintDialog != null && mPrintDialog.isShowing()) {
            mPrintDialog.dismiss();
        }
        mObservable.detach(this);
    }

    @Override
    public void updateObserver(boolean bool) {
        try {
            mObservable.detach(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObserverProgress(int percentage) {

    }

}