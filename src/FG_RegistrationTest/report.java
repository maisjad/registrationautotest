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

	/**
	 * PdfPTables
	 */
	HTMLTableElement t=null;
	PdfPTable successTable = null, failTable = null;
	
	/**
	 * throwableMap
	 */
	private HashMap<Integer, Throwable> throwableMap = null;
	 File f ;
	 BufferedWriter bw;

	/**
	 * nbExceptions
	 */
	private int nbExceptions = 0;
	private HashMap<Integer, Throwable> throwableMap1 = null;
	private int nb1Exceptions = 0;
	/**
	 * JyperionListener
	 */
	public report() {
		log("Report()");
		
		this.document = new Document();
		this.throwableMap = new HashMap<Integer, Throwable>();
		this.throwableMap1 = new HashMap<Integer, Throwable>();
		try{
	        f = new File("reports\\Registrationreport.html");
	        bw = new BufferedWriter(new FileWriter(f));}
	catch(IOException e){
		e.printStackTrace();
	}
	}
	
	/**
	 * @see com.beust.testng.ITestListener#onTestSuccess(com.beust.testng.ITestResult)
	 */
	public void onTestSuccess(ITestResult result) {
		log("onTestSuccess("+result+")");
		 passresult.add(result);
		 System.out.print(result.getInstanceName());
		if (successTable == null) {
			this.successTable = new PdfPTable(new float[]{.3f, .3f, .1f, .3f});
			Paragraph p = new Paragraph("PASSED TESTS", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
			p.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cell = new PdfPCell(p);
			cell.setColspan(4);
			cell.setBackgroundColor(Color.GREEN);
			this.successTable.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("Class"));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.successTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Method"));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.successTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Time (ms)"));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.successTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Exception"));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.successTable.addCell(cell);
		}
		
		PdfPCell cell = new PdfPCell(new Paragraph(result.getTestClass().toString()));
		this.successTable.addCell(cell);
		cell = new PdfPCell(new Paragraph(result.getMethod().getMethodName().toString()));
		this.successTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("" + (result.getEndMillis()-result.getStartMillis())));
		this.successTable.addCell(cell);

		Throwable throwable = result.getThrowable();
		if (throwable != null) {
			this.throwableMap.put(new Integer(throwable.hashCode()), throwable);
			this.nbExceptions++;
			Paragraph excep = new Paragraph(
					new Chunk(throwable.toString(), 
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.UNDERLINE)).
							setLocalGoto("" + throwable.hashCode()));
			cell = new PdfPCell(excep);
			this.successTable.addCell(cell);
		} else {
			this.successTable.addCell(new PdfPCell(new Paragraph("")));
		}
	}

	/**
	 * @see com.beust.testng.ITestListener#onTestFailure(com.beust.testng.ITestResult)
	 */
	public void onTestFailure(ITestResult result) {
		log("onTestFailure("+result+")");
		failresult.add(result);
		 System.out.print(result.getInstanceName());
		String file = System.getProperty("user.dir")+"\\"+"screenshot"+(new Random().nextInt())+".png";
		img.add(file);
		try {
			RegistrationTesting.takeSnapShot(RegistrationTesting.getDriver(), file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (this.failTable == null) {
			this.failTable = new PdfPTable(new float[]{.3f, .3f, .1f, .3f});
			this.failTable.setTotalWidth(20f);
			Paragraph p = new Paragraph("FAILED TESTS", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
			p.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cell = new PdfPCell(p);
			cell.setColspan(4);
			cell.setBackgroundColor(Color.RED);
			this.failTable.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("Class"));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.failTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Method"));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.failTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Time (ms)"));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.failTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Exception"));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.failTable.addCell(cell);
		}
		
		PdfPCell cell = new PdfPCell(new Paragraph(result.getTestClass().toString()));
		this.failTable.addCell(cell);
		cell = new PdfPCell(new Paragraph(result.getMethod().getMethodName().toString()));
		this.failTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("" + (result.getEndMillis()-result.getStartMillis())));
		this.failTable.addCell(cell);
		//String exception = result.getThrowable() == null ? "" : result.getThrowable().toString();
		//cell = new PdfPCell(new Paragraph(exception));
		//this.failTable.addCell(cell);
		
		Throwable throwable = result.getThrowable();
		if (throwable != null) {
			this.throwableMap.put(new Integer(throwable.hashCode()), throwable);
			this.nbExceptions++;
			
			 Chunk imdb = new Chunk("[SCREEN SHOT]", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.UNDERLINE));
		        imdb.setAction(new PdfAction("file:///"+file));
		        Paragraph  excep = new Paragraph(
		            throwable.toString());
		        excep.add(imdb);
		       
			
			
			
		
			//Paragraph excep = new Paragraph(ck.setLocalGoto("" + throwable.hashCode()));
			cell = new PdfPCell(excep);
			this.failTable.addCell(cell);
		} else {
			this.failTable.addCell(new PdfPCell(new Paragraph("")));
		}
	}

	/**
	 * @see com.beust.testng.ITestListener#onTestSkipped(com.beust.testng.ITestResult)
	 */
	public void onTestSkipped(ITestResult result) {
		log("onTestSkipped("+result+")");
		skipresult.add(result);
	}

	/**
	 * @see com.beust.testng.ITestListener#onStart(com.beust.testng.ITestContext)
	 */
	public void onStart(ITestContext context) {
		log("onStart("+context+")");
		try {
			PdfWriter.getInstance(this.document, new FileOutputStream(context.getName()+".pdf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.document.open();
		
		Paragraph p = new Paragraph(context.getName() + " TESTNG RESULTS",
				FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD, new Color(0, 0, 255)));
		
		try {
			this.document.add(p);
			this.document.add(new Paragraph(new Date().toString()));
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * @see com.beust.testng.ITestListener#onFinish(com.beust.testng.ITestContext)
	 */
	public void onFinish(ITestContext context) {
		log("onFinish("+context+")");
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
			            "<td>Exception</td>" +
			            "<td>Platform</td>"+"</tr>");//RegistrationTesting.getDriver()
		        int i=0;
		        for(ITestResult res :failresult){
		        	bw.write(failcolor + "<td>"+res.getTestClass().toString()+"</td>"+"<td>"+
		                      res.getMethod().getMethodName().toString()+"</td>"+ 
		        			"<td>"+ (res.getEndMillis()-res.getStartMillis()) +"</td>");
		       
		        	Throwable throwable = res.getThrowable();
		        	
		    		if (throwable != null) {
		    			this.throwableMap1.put(new Integer(throwable.hashCode()), throwable);
		    			this.nb1Exceptions++;
		    			String []token=throwable.getMessage().split(",");
		    			
		        	bw.write("<td>"+token[0]+","+token[1]+"<a href="+img.get(i)+">[SCREEN SHOT]</a>"+"</td>");
		        	i++;
		    		}
		    		
		    		 if (RegistrationTesting.getDriver().getClass().getName().equals("org.openqa.selenium.chrome.ChromeDriver")){
					    	bw.write("<td>"+"chrome"+"</td></tr>");	}
				           else if (RegistrationTesting.getDriver().getClass().getName().equals("org.openqa.selenium.firefox.FirefoxDriver")){
                           bw.write("<td>"+"Firefox"+"</td></tr>");	}}
		    		 bw.write("</table>"+"<table border ='1'>" +"<tr>"+"<h2>Passed Test</h2>"+"</tr>"
				           + "<tr>" +
				            "<td>Class</td>" +
				            "<td>Method</td>" +
				            "<td>Time (ms)</td>" +
				            "<td>Platform</td>"+ "</tr>");
		    		
		    		for(ITestResult res :passresult){
			        	bw.write(passcolor + "<td>"+res.getTestClass().toString()+"</td>"+"<td>"+
			                      res.getMethod().getMethodName().toString()+"</td>"+ 
			        			"<td>"+ (res.getEndMillis()-res.getStartMillis()) +"</td>");
			        	 if (RegistrationTesting.getDriver().getClass().getName().equals("org.openqa.selenium.chrome.ChromeDriver")){
						    	bw.write("<td>"+"chrome"+"</td></tr>");	}
					           else if (RegistrationTesting.getDriver().getClass().getName().equals("org.openqa.selenium.firefox.FirefoxDriver")){
	                              bw.write("<td>"+"Firefox"+"</td></tr>");	}			    		 }
		    		 bw.write("</table>"+"<table border ='1'>" +"<tr>"+"<h2>skipped Test</h2>"+"</tr>"
					           + "<tr>" +
					            "<td>Class</td>" +
					            "<td>Method</td>" +
					            "<td>Time (ms)</td>" +
					            "<td>Exception</td>" +
					            "<td>Platform</td>"+ "</tr>");
			    		
			    		for(ITestResult res :skipresult){
				        	bw.write(skipcolor + "<td>"+res.getTestClass().toString()+"</td>"+"<td>"+
				                      res.getMethod().getMethodName().toString()+"</td>"+ 
				        			"<td>"+ (res.getEndMillis()-res.getStartMillis()) +"</td>");
				        	Throwable throwable = res.getThrowable();
				    		
				            bw.write("<td>"+throwable.getMessage()+"</td>");
				            if (RegistrationTesting.getDriver().getClass().getName().equals("org.openqa.selenium.chrome.ChromeDriver")){
					    	bw.write("<td>"+"chrome"+"</td></tr>");	}
				           else if (RegistrationTesting.getDriver().getClass().getName().equals("org.openqa.selenium.firefox.FirefoxDriver")){
                              bw.write("<td>"+"Firefox"+"</td></tr>");	}
				    		 }
			    		bw.write("</table>" +
			    			       "</body>" +
			    			       "</html>"); 
			    	bw.close();


		}
		 
		 
		 catch (IOException e4) {
			
			e4.printStackTrace();
		}
	       
		try {
			if (this.failTable != null) {
				log("Added fail table");
				this.failTable.setSpacingBefore(15f);
				this.document.add(this.failTable);
				this.failTable.setSpacingAfter(15f);
			}
			
			if (this.successTable != null) {
				log("Added success table");
				this.successTable.setSpacingBefore(15f);
				this.document.add(this.successTable);
				this.successTable.setSpacingBefore(15f);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		Paragraph p = new Paragraph("EXCEPTIONS SUMMARY",
				FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, new Color(255, 0, 0)));
		try {
			this.document.add(p);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
		
		Set<Integer> keys = this.throwableMap.keySet();
		
		assert keys.size() == this.nbExceptions;
		
		for(Integer key : keys) {
			Throwable throwable = this.throwableMap.get(key);
			
			Chunk chunk = new Chunk(throwable.toString(),
					FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new Color(255, 0, 0)));
			chunk.setLocalDestination("" + key);
			Paragraph throwTitlePara = new Paragraph(chunk);
			try {
				this.document.add(throwTitlePara);
			} catch (DocumentException e3) {
				e3.printStackTrace();
			}
			
			StackTraceElement[] elems = throwable.getStackTrace();
			String exception = "";
			for(StackTraceElement ste : elems) {
				Paragraph throwParagraph = new Paragraph(ste.toString());
				try {
					this.document.add(throwParagraph);
				} catch (DocumentException e2) {
					e2.printStackTrace();
				}
			}
		}
		
		this.document.close();
	}
	
	/**
	 * log
	 * @param o
	 */
	public static void log(Object o) {
		//System.out.println("[JyperionListener] " + o);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
}
