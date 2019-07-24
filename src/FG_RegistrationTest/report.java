package FG_RegistrationTest;



import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.remote.html5.AddApplicationCache;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.w3c.dom.html.HTMLTableElement;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfAction;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

/**
 * JyperionListener
 * 
 * @author */
public class report implements ITestListener {
	/**
	 * Document
	 */
	private Document document = null;
	ArrayList <ITestResult >passresult=new ArrayList <ITestResult>();
	ArrayList <ITestResult >failresult=new ArrayList <ITestResult>();
	ArrayList <ITestResult >skipresult=new ArrayList <ITestResult>();
	ArrayList <String >img=new ArrayList <String>();



	
	
	 File f;
	 BufferedWriter bw;

	
	
	private HashMap<Integer, Throwable> throwableMap1 = null;
	private int nb1Exceptions = 0;
	
	public report() {
		
	
	}
	
	
	public void onTestSuccess(ITestResult result) {
		
		 passresult.add(result);
		
	}

	
	public void onTestFailure(ITestResult result) {
		
		failresult.add(result);
		String file = System.getProperty("user.dir")+"\\"+"screenshot"+(new Random().nextInt())+".png";
		img.add(file);
		try {
			ReportDriver.takeSnapShot(ReportDriver.getDriver(), file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void onTestSkipped(ITestResult result) {
		
		skipresult.add(result);
	}

	
	public void onStart(ITestContext context) {
		
	}

	
	public void onFinish(ITestContext context) {
		try{
	if (ReportDriver.getplatform().equals("chrome")){
		
	        f = new File("reports\\chromeRegistrationreport.html");
	        bw = new BufferedWriter(new FileWriter(f));
	        writereport(f,bw);

	
	}	
	else if (ReportDriver.getplatform().equals("firefox")){
	
	        f = new File("reports\\firefoxRegistrationreport.html");
	        bw = new BufferedWriter(new FileWriter(f));
	        writereport(f,bw);

	}
	else if (ReportDriver.getplatform().equals("mopile")){
		
	        f = new File("reports\\mopileRegistrationreport.html");
	        bw = new BufferedWriter(new FileWriter(f));
	        writereport(f,bw);
	
	}}
		catch (IOException e){
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void log(Object o) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		
		
	}
	public void writereport(File f ,BufferedWriter bw){
		 try {
				String passcolor = " <tr bgcolor=\"#5FFF33\">";
				String failcolor =" <tr bgcolor=\"red\">";
				String skipcolor=" <tr bgcolor=\"yellow\">";
				bw.write("<html>");
				 bw.write("<body>");
			        bw.write("<h1>Registration Report</h1>");
			        bw.write("<table border ='1'>" +"<tr>"+"<h2>Failed Test</h2>"+"</tr>"
				           + "<tr>" +
				            "<td>Class</td>" +
				            "<td>Method</td>" +
				            "<td>Time (ms)</td>" +
				            "<td>Exception</td>" +"<td>start time(ms)</td>"+"<td>end time(ms)</td>"+
				            "<td>Platform</td>"+"</tr>");//RegistrationTesting.getDriver()
			        int i=0;
			        
			        for(ITestResult res :failresult){
			        
			        	bw.write(failcolor + "<td>"+res.getTestClass().toString()+"</td>"+"<td>"+
			                      res.getMethod().getMethodName().toString()+":"+ReportDriver.getmethod()+"</td>"+ 
			        			"<td>"+ (res.getEndMillis()-res.getStartMillis()) +"</td>");
			        	Throwable throwable = res.getThrowable();
			        	
			    		if (throwable != null) {
			    			
			    			String []token=throwable.getMessage().split(",");
			    			
			        	bw.write("<td>"+ReportDriver.getmethod()+":"+token[0]+","+token[1]+"<a href="+img.get(i)+">[SCREEN SHOT]</a>"+"</td>");
			        	i++;
			    		}
			    		Date st=new Date(res.getStartMillis());
			    		Date et=new Date(res.getEndMillis());
			    		
			        	  bw.write("<td>"+st+"</td><td>"+et+"</td>");

			    		
						    	bw.write("<td>"+ReportDriver.getplatform()+"</td></tr>");	
				            
				    	}
			        bw.write("</table>"+"<table border ='1'>" +"<tr>"+"<h2>Passed Test</h2>"+"</tr>"
					           + "<tr>" +
					            "<td>Class</td>" +
					            "<td>Method</td>" +
					            "<td>Time (ms)</td>"  +"<td>start time(ms)</td>"+"<td>end time(ms)</td>"+
					            "<td>Platform</td>"+ "</tr>");
			    		
			    		for(ITestResult res :passresult){
				        	bw.write(passcolor + "<td>"+res.getTestClass().toString()+"</td>"+"<td>"+
				                      res.getMethod().getMethodName().toString()+":"+ReportDriver.getmethod()+"</td>"+ 
				        			"<td>"+ (res.getEndMillis()-res.getStartMillis()) +"</td>");
				        	Date st=new Date(res.getStartMillis());
				    		Date et=new Date(res.getEndMillis());
				    		
				        	  bw.write("<td>"+st+"</td><td>"+et+"</td>");
						    	bw.write("<td>"+ReportDriver.getplatform()+"</td></tr>");	
			    		
			    		}
			    		 bw.write("</table>"+"<table border ='1'>" +"<tr>"+"<h2>skipped Test</h2>"+"</tr>"
						           + "<tr>" +
						            "<td>Class</td>" +
						            "<td>Method</td>" +
						            "<td>Time (ms)</td>" +
						            "<td>Exception</td>" +"<td>start time(ms)</td>"+"<td>end time(ms)</td>"+
						            "<td>Platform</td>"+ "</tr>");
				    		
				    		for(ITestResult res :skipresult){
					        	bw.write(skipcolor + "<td>"+res.getTestClass().toString()+"</td>"+"<td>"+
					                      res.getMethod().getMethodName().toString()+":"+ReportDriver.getmethod()+"</td>"+ 
					        			"<td>"+ (res.getEndMillis()-res.getStartMillis()) +"</td>");
					        	Throwable throwable = res.getThrowable();
					    		
					            bw.write("<td>"+throwable.getMessage()+"</td>");
					            Date st=new Date(res.getStartMillis());
					    		Date et=new Date(res.getEndMillis());
					    		
					        	  bw.write("<td>"+st+"</td><td>"+et+"</td>");
							    	bw.write("<td>"+ReportDriver.getplatform()+"</td></tr>");	


					    		 }
				    		bw.write("</table>" +
				    			       "</body>" +
				    			       "</html>"); 
				    	bw.close();


			}
			 
			 
			 catch (IOException e4) {
				
				e4.printStackTrace();
			}
		       
	}
}
