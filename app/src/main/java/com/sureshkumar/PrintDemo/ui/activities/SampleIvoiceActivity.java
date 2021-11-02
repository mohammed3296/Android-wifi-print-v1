package com.sureshkumar.PrintDemo.ui.activities;

import android.content.Context;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
 import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.sureshkumar.PrintDemo.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SampleIvoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_ivoice);
    }
    public void print (){

        PrintManager printManager  = (PrintManager) getSystemService(Context.PRINT_SERVICE);

        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dMMyy", Locale.ENGLISH);
        String date = df.format(d);
        WebView webView = new WebView(SampleIvoiceActivity.this );

        // webView.loadData("", "text/html; charset=utf-8", "base64");
        webView.loadDataWithBaseURL(null, "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n" +
                "\n" +
                "<html>\n" +
                "<head>\n" +
                "\t\n" +
                "\t<meta http-equiv=\"content-type\" content=\"text/html; charset=iso-8859-1\"/>\n" +
                "\t<title></title>\n" +
                "\t<meta name=\"generator\" content=\"https://conversiontools.io\" />\n" +
                "\t<meta name=\"created\" content=\"2021-11-02T19:08:13\"/>\n" +
                "\t<meta name=\"changedby\" content=\" \"/>\n" +
                "\t<meta name=\"changed\" content=\"2017-05-01T05:34:37\"/>\n" +
                "\t<meta name=\"AppVersion\" content=\"16.0300\"/>\n" +
                "\t<meta name=\"DocSecurity\" content=\"0\"/>\n" +
                "\t<meta name=\"HyperlinksChanged\" content=\"false\"/>\n" +
                "\t<meta name=\"LinksUpToDate\" content=\"false\"/>\n" +
                "\t<meta name=\"ScaleCrop\" content=\"false\"/>\n" +
                "\t<meta name=\"ShareDoc\" content=\"false\"/>\n" +
                "\t\n" +
                "\t<style type=\"text/css\">\n" +
                "\t\tbody,div,table,thead,tbody,tfoot,tr,th,td,p { font-family:\"Calibri\"; font-size:x-small }\n" +
                "\t\ta.comment-indicator:hover + comment { background:#ffd; position:absolute; display:block; border:1px solid black; padding:0.5em;  } \n" +
                "\t\ta.comment-indicator { background:red; display:inline-block; border:1px solid black; width:0.5em; height:0.5em;  } \n" +
                "\t\tcomment { display:none;  } \n" +
                "\t</style>\n" +
                "\t\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<table cellspacing=\"0\" border=\"0\">\n" +
                "\t<colgroup width=\"378\"></colgroup>\n" +
                "\t<colgroup width=\"122\"></colgroup>\n" +
                "\t<colgroup width=\"160\"></colgroup>\n" +
                "\t<colgroup width=\"236\"></colgroup>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"76\" align=\"left\" valign=bottom><font color=\"#384448\"><br><img src=\"result_htm_e615019a90998b60.png\" width=132 height=70 hspace=123 vspace=3>\n" +
                "\t\t</font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font color=\"#384448\">Company slogan</font></td>\n" +
                "\t\t<td colspan=2 align=\"right\" valign=bottom><font face=\"Century Gothic\" size=6 color=\"#4B5A60\">INVOICE</font></td>\n" +
                "\t\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"44\" align=\"left\" valign=bottom><b><font face=\"Century Gothic\" size=4 color=\"#4B5A60\">Your Company Name</font></b></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"20\" align=\"left\" valign=bottom><font face=\"Century Gothic\" color=\"#384448\">Street Address</font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><br></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><b><font face=\"Century Gothic\" color=\"#384448\">INVOICE NO.</font></b></td>\n" +
                "\t\t<td align=\"left\" valign=bottom sdval=\"100\" sdnum=\"1033;\"><font face=\"Century Gothic\" color=\"#384448\">100</font></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"20\" align=\"left\" valign=bottom><font face=\"Century Gothic\" color=\"#384448\">City, ST  ZIP Code</font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><br></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><b><font face=\"Century Gothic\" color=\"#384448\">DATE</font></b></td>\n" +
                "\t\t<td align=\"left\" valign=bottom sdval=\"44502\" sdnum=\"1033;0;M/D/YYYY\"><font face=\"Century Gothic\" color=\"#384448\">11/2/2021</font></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"20\" align=\"left\" valign=bottom sdnum=\"1033;0;[&lt;=9999999]###-####;\\(###&quot;) &quot;###-####\"><font face=\"Century Gothic\" color=\"#384448\">[Phone] [Fax]</font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><br></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><b><font face=\"Century Gothic\" color=\"#384448\">CUSTOMER ID</font></b></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font face=\"Century Gothic\" color=\"#384448\">ABC12345</font></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"20\" align=\"left\" valign=bottom><font face=\"Century Gothic\" color=\"#384448\">email</font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"37\" align=\"left\" valign=bottom><b><font face=\"Century Gothic\" color=\"#384448\">TO</font></b></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td colspan=2 align=\"left\" valign=bottom><b><font face=\"Century Gothic\" color=\"#384448\">SHIP TO</font></b></td>\n" +
                "\t\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"19\" align=\"left\" valign=bottom><font face=\"Century Gothic\" color=\"#384448\">Name</font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font face=\"Century Gothic\" color=\"#384448\">Name</font></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"19\" align=\"left\" valign=bottom><font face=\"Century Gothic\" color=\"#384448\">Company Name</font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font face=\"Century Gothic\" color=\"#384448\">Company Name</font></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"19\" align=\"left\" valign=bottom><font face=\"Century Gothic\" color=\"#384448\">Street Address</font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font face=\"Century Gothic\" color=\"#384448\">Street Address</font></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"19\" align=\"left\" valign=bottom><font face=\"Century Gothic\" color=\"#384448\">City, ST  ZIP Code</font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font face=\"Century Gothic\" color=\"#384448\">City, ST  ZIP Code</font></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"40\" align=\"left\" valign=top sdnum=\"1033;0;[&lt;=9999999]###-####;\\(###&quot;) &quot;###-####\"><font face=\"Century Gothic\" color=\"#384448\">Phone</font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"left\" valign=top sdnum=\"1033;0;[&lt;=9999999]###-####;\\(###&quot;) &quot;###-####\"><font face=\"Century Gothic\" color=\"#384448\">Phone</font></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td style=\"border-top: 1px solid #4b5a60; border-bottom: 1px solid #4b5a60\" colspan=2 height=\"40\" align=\"left\" valign=bottom><b><font color=\"#384448\">JOB</font></b></td>\n" +
                "\t\t<td style=\"border-top: 1px solid #4b5a60; border-bottom: 1px solid #4b5a60\" colspan=2 align=\"left\" valign=bottom><b><font color=\"#384448\">PAYMENT TERMS</font></b></td>\n" +
                "\t\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td style=\"border-top: 1px solid #4b5a60; border-bottom: 1px solid #4b5a60\" colspan=2 height=\"40\" align=\"left\" valign=bottom bgcolor=\"#D9DFE1\"><font color=\"#2E2224\">Job or project title</font></td>\n" +
                "\t\t<td style=\"border-top: 1px solid #4b5a60; border-bottom: 1px solid #4b5a60\" colspan=2 align=\"left\" valign=bottom bgcolor=\"#D9DFE1\"><font color=\"#2E2224\">Due on receipt</font></td>\n" +
                "\t\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"60\" align=\"left\" valign=bottom><font color=\"#384448\">DESCRIPTION</font></td>\n" +
                "\t\t<td style=\"border-top: 1px solid #4b5a60; border-bottom: 1px solid #4b5a60\" align=\"left\" valign=bottom><b><font color=\"#384448\">QUANTITY</font></b></td>\n" +
                "\t\t<td style=\"border-top: 1px solid #4b5a60; border-bottom: 1px solid #4b5a60\" align=\"left\" valign=bottom><b><font color=\"#384448\">AMOUNT</font></b></td>\n" +
                "\t\t<td style=\"border-top: 1px solid #4b5a60; border-bottom: 1px solid #4b5a60\" align=\"left\" valign=bottom><b><font color=\"#384448\">TOTAL</font></b></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"40\" align=\"left\" valign=bottom><font color=\"#384448\">Finance charge on overdue balance at 1.5%</font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdval=\"1\" sdnum=\"1033;0;#,##0.00\"><font color=\"#384448\">1.00</font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdval=\"150\" sdnum=\"1033;0;\\$#,##0.00\"><font color=\"#384448\">$150.00</font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdval=\"150\" sdnum=\"1033;0;\\$#,##0.00\"><font color=\"#384448\">$150.00</font></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"40\" align=\"left\" valign=bottom><font color=\"#384448\">Invoice #100 for $1000 on [Date]</font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdval=\"1\" sdnum=\"1033;0;#,##0.00\"><font color=\"#384448\">1.00</font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdval=\"1000\" sdnum=\"1033;0;\\$#,##0.00\"><font color=\"#384448\">$1,000.00</font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdval=\"1000\" sdnum=\"1033;0;\\$#,##0.00\"><font color=\"#384448\">$1,000.00</font></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"40\" align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdnum=\"1033;0;#,##0.00\"><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdnum=\"1033;0;\\$#,##0.00\"><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdval=\"0\" sdnum=\"1033;0;\\$#,##0.00\"><font color=\"#384448\">$0.00</font></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"40\" align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdnum=\"1033;0;#,##0.00\"><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdnum=\"1033;0;\\$#,##0.00\"><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdval=\"0\" sdnum=\"1033;0;\\$#,##0.00\"><font color=\"#384448\">$0.00</font></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"40\" align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdnum=\"1033;0;#,##0.00\"><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdnum=\"1033;0;\\$#,##0.00\"><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdval=\"0\" sdnum=\"1033;0;\\$#,##0.00\"><font color=\"#384448\">$0.00</font></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"40\" align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdnum=\"1033;0;#,##0.00\"><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdnum=\"1033;0;\\$#,##0.00\"><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdval=\"0\" sdnum=\"1033;0;\\$#,##0.00\"><font color=\"#384448\">$0.00</font></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"40\" align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdnum=\"1033;0;#,##0.00\"><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdnum=\"1033;0;\\$#,##0.00\"><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdval=\"0\" sdnum=\"1033;0;\\$#,##0.00\"><font color=\"#384448\">$0.00</font></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"40\" align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdnum=\"1033;0;#,##0.00\"><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdnum=\"1033;0;\\$#,##0.00\"><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdval=\"0\" sdnum=\"1033;0;\\$#,##0.00\"><font color=\"#384448\">$0.00</font></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"40\" align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdnum=\"1033;0;#,##0.00\"><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdnum=\"1033;0;\\$#,##0.00\"><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdval=\"0\" sdnum=\"1033;0;\\$#,##0.00\"><font color=\"#384448\">$0.00</font></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td height=\"40\" align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"left\" valign=bottom><font color=\"#384448\"><br></font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom><font color=\"#384448\">TOTAL DUE</font></td>\n" +
                "\t\t<td align=\"right\" valign=bottom sdval=\"1150\" sdnum=\"1033;0;\\$#,##0.00\"><font color=\"#384448\">$1,150.00</font></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td colspan=4 height=\"40\" align=\"center\" valign=bottom><i><font color=\"#4B5A60\">Make all checks payable to Your Company Name.</font></i></td>\n" +
                "\t\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td colspan=4 height=\"40\" align=\"center\" valign=bottom><i><font color=\"#4B5A60\">THANK YOU FOR YOUR BUSINESS!</font></i></td>\n" +
                "\t\t</tr>\n" +
                "</table>\n" +
                "<!-- ************************************************************************** -->\n" +
                "</body>\n" +
                "\n" +
                "</html>\n", "text/HTML", "UTF-8", null);


        PrintDocumentAdapter printAdapter = webView.createPrintDocumentAdapter("CASHIN_" + date);
        String jobName = getString(R.string.app_name) + " Print Test";
        printManager.print(jobName, printAdapter, new PrintAttributes.Builder()
                .setMediaSize(PrintAttributes.MediaSize.ISO_A4).build());

    }
}