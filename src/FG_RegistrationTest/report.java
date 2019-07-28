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
import java.util.concurrent.TimeUnit;

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
	ArrayList <String >passmethod=new ArrayList <String>();
	ArrayList <String >passplat=new ArrayList <String>();
	ArrayList <String >failmethod=new ArrayList <String>();
	ArrayList <String >failplat=new ArrayList <String>();
	ArrayList <String >skipmethod=new ArrayList <String>();
	ArrayList <String >skipplat=new ArrayList <String>();
	



	
	
	 File f;
	 BufferedWriter bw;

	
	
	private HashMap<Integer, Throwable> throwableMap1 = null;
	private int nb1Exceptions = 0;
	
	public report() {
		
	
	}
	
	
	public void onTestSuccess(ITestResult result) {
		
		 passresult.add(result);
		 passmethod.add(ReportDriver.getmethod());
		 passplat.add(ReportDriver.getplatform());
		
	}

	
	public void onTestFailure(ITestResult result) {
		
		failresult.add(result);
		 failmethod.add(ReportDriver.getmethod());
		 failplat.add(ReportDriver.getplatform());
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
		//skipmethod.add(ReportDriver.getmethod());
       //  skipplat.add(ReportDriver.getplatform());
	}

	
	public void onStart(ITestContext context) {
		
	}

	
	public void onFinish(ITestContext context) {
	try{
		if(ReportDriver.getplatform().equals("chrome")){
		
	        f = new File("reports\\chromeRegistrationreport.html");
	        bw = new BufferedWriter(new FileWriter(f));
	        writereport(f,bw);

	
	}	
	else if (ReportDriver.getplatform().equals("firefox")){
	
	        f = new File("reports\\firefoxRegistrationreport.html");
	        bw = new BufferedWriter(new FileWriter(f));
	        writereport(f,bw);

	}
	else if (ReportDriver.getplatform().equals("real mobile")){
		
        f = new File("reports\\realmobileRegistrationreport.html");
        bw = new BufferedWriter(new FileWriter(f));
        writereport(f,bw);

}
	else if (ReportDriver.getplatform().equals("mobile")){
		
	        f = new File("reports\\mobileRegistrationreport.html");
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
			        bw.write("<table border ='1'>" +"<tr>"+"<td><h4>#of Failed Test</h4></td><td>"+failresult.size()+
			        		"</td></tr><tr> <td><h4>#of pass Test</h4></td><td>"+passresult.size()+
			        		"</td></tr><tr><td><h4>#of skip Test</h4></td><td>"+skipresult.size()+
			        		"</td></tr><tr> <td><h4>total Test time(min)</h4></td><td>");
			      long sum =0;
			       for(ITestResult res :failresult){
			        	 
			        			 sum+=(res.getEndMillis()-res.getStartMillis());}
			       for(ITestResult res :passresult){
			        	 
	        			 sum+=(res.getEndMillis()-res.getStartMillis());}
			       for(ITestResult res :skipresult){
			        	 
	        			 sum+=(res.getEndMillis()-res.getStartMillis());}
			       sum=TimeUnit.MILLISECONDS.toMinutes(sum);
			        bw.write(""+sum+"</td></tr><tr><td><h4>enviroment</h4></td><td>https://devwcs2.frontgate.com/UserRegistrationFormView</td>"
			        		+ "</tr><tr><td><h4>platform</h4></td><td>"+ReportDriver.getplatform()+"</td></tr></table>");

			        bw.write("<table border ='1'>" +"<tr>"+"<h2>Failed Test</h2>"+"</tr>"
				           + "<tr>" +
				            "<td>Class</td>" +
				            "<td>TC Description</td>" +
				            "<td>Time (ms)</td>" +
				            "<td>Exception</td>" +"<td>start time(ms)</td>"+"<td>end time(ms)</td>"+
				            "<td>Platform</td>"+"</tr>");//RegistrationTesting.getDriver()
			        int i=0;
			        int j=0;
			        int k=0;
			        int m=0;
			        for(ITestResult res :failresult){
			        	bw.write(failcolor + "<td> TestClass name: RegistrationTesting</td>"+"<td>"+
			                      failmethod.get(k++)+"</td>"+ 
			        			"<td>"+ (res.getEndMillis()-res.getStartMillis()) +"</td>");
			        	Throwable throwable = res.getThrowable();
			        	
			    		if (throwable != null) {
			    			
			    			String []token=throwable.getMessage().split(",");
			    			
			        	bw.write("<td>"+failmethod.get(m++)+":"+token[0]+","+token[1]+"<a href="+img.get(i)+">[SCREEN SHOT]</a>"+"</td>");
			        	i++;
			    		}
			    		Date st=new Date(res.getStartMillis());
			    		Date et=new Date(res.getEndMillis());
			    		
			        	  bw.write("<td>"+st+"</td><td>"+et+"</td>");

			    		
						    	bw.write("<td>"+failplat.get(j++)+"</td></tr>");	
				            
				    	}
			        bw.write("</table>"+"<table border ='1'>" +"<tr>"+"<h2>Passed Test</h2>"+"</tr>"
					           + "<tr>" +
					            "<td>Class</td>" +
					            "<td>TC Description</td>" +
					            "<td>Time (ms)</td>"  +"<td>start time(ms)</td>"+"<td>end time(ms)</td>"+
					            "<td>Platform</td>"+ "</tr>");
			        j=0;
			         k=0;
			        m=0;
			    		for(ITestResult res :passresult){
				        	bw.write(passcolor + "<td> TestClass name:RegistrationTesting</td>"+"<td>"+
				                      passmethod.get(j++)+"</td>"+ 
				        			"<td>"+ (res.getEndMillis()-res.getStartMillis()) +"</td>");
				        	Date st=new Date(res.getStartMillis());
				    		Date et=new Date(res.getEndMillis());
				    		
				        	  bw.write("<td>"+st+"</td><td>"+et+"</td>");
						    	bw.write("<td>"+passplat.get(k++)+"</td></tr>");	
			    		
			    		}
			    		 bw.write("</table>"+"<table border ='1'>" +"<tr>"+"<h2>skipped Test</h2>"+"</tr>"
						           + "<tr>" +
						            "<td>Class</td>" +
						            "<td>TC Description</td>" +
						            "<td>Time (ms)</td>" +
						            "<td>Exception</td>" +"<td>start time(ms)</td>"+"<td>end time(ms)</td>"+
						            "<td>Platform</td>"+ "</tr>");
			    		  j=0;
					         k=0;
					        m=0;
				    		for(ITestResult res :skipresult){
				    			String []token=res.getThrowable().getMessage().split(":");


					        	bw.write(skipcolor + "<td> TestClass Name:RegistrationTesting</td>"+"<td>"+token[0]+"</td>"+ 
					        		"<td>"+ (res.getEndMillis()-res.getStartMillis()) +"</td>");
				    			
				    			Throwable throwable = res.getThrowable();
					    		
					            bw.write("<td>"+throwable.getMessage()+"</td>");
					            Date st=new Date(res.getStartMillis());
					    		Date et=new Date(res.getEndMillis());
					    		
					        	  bw.write("<td>"+st+"</td><td>"+et+"</td>");
							    	//bw.write("<td>"+skipplat.get(k++)+"</td></tr>");
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
