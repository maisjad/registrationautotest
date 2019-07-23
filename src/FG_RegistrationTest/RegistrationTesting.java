package FG_RegistrationTest;
import java.io.File;




import org.openqa.selenium.OutputType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.SkipException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.AssertJUnit;
import org.testng.annotations.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@Listeners(report.class)

public class RegistrationTesting {
	
	
	
	private static WebDriver driver;
	ChromeOptions options;
	String[][]  Data =new String [64][64];
	private String expected;
	private String[][] address;
	private String baseUrl;
	private int i=2;
	private ReportDriver d;
	FGRegistrationdemo demo;
	private FGAddressdemo add;

	@BeforeTest
public void readTC(){
		Data=ReadTC.fileopen("files\\DTC1.xlsx","RegistrationTCData");  
        address=ReadTC.fileopen("files\\DTC1.xlsx","AddressData");
        System.out.println("launching chrome browser"); 
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
	 System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe"); 
		 options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
        baseUrl = "https://devwcs2.frontgate.com/UserRegistrationFormView";	
    	   
	}
	
@Parameters ({"browser"})
@Test (invocationCount = 12 )
public void regTest(String browser){
		
	System.out.println(i+":"+Data[i][0]+":"+Data[i][1]);
	if (!Data[i][0].equals("T")){ i++;
		throw new SkipException(Data[i-1][1]+ ":not need to test");}
	
	if(browser.equals("firefox")){
	
		 driver = new FirefoxDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		    driver.get(baseUrl);
		     demo =new DesktopFGRegisterdemo (driver);

	}
	 if(browser.equalsIgnoreCase("chrome")){

		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	    driver.get(baseUrl);
	     demo =new DesktopFGRegisterdemo (driver);
	
	 }
	 if(browser.equalsIgnoreCase("mopile")){
		 Map<String, String> mobileEmulation = new HashMap<>();

	        mobileEmulation.put("deviceName", "iPhone 6");


	         options = new ChromeOptions();
	       options.setExperimentalOption("mobileEmulation", mobileEmulation);
	       driver = new ChromeDriver(options);
	       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	       driver.get(baseUrl);	
	        demo =new MopileFGRegisterdemo (driver);

	 }
	
    

    if(!Data[i][1].equals("verifyEmptyRegistrationFields")){
    setup(demo,Data[i][2],Data[i][3],Data[i][4],Data[i][5]);}
	
	if(Data[i][1].equals("verifyssucsessregistration")){
		if (browser.equals("mopile")){
			 add=new MopileFGAddressdemo(demo.getdriver());

		}
		else{add=new DesktopFGAddressdemo(demo.getdriver());}
		 add.setbillNames(address[1][0], address[1][1], address[1][2],address[1][3]);
	 	 add.setbilladdrss(address[1][4], address[1][5], address[1][6],address[1][7], address[1][8], address[1][9]);
		 add.setbillphone(address[1][10], address[1][11]);
		 if(Data[i][6]!=null){
			 add.hasshipaddress();
			 add.setshipNames(address[1][0], address[1][1], address[1][2],address[1][3]);
	         add.setshipaddrss(address[1][4], address[1][5], address[1][6],address[1][7], address[1][8], address[1][9]);
			 add.setshipphone(address[1][10], address[1][11]);
		 }
		add.clicksave();
		        
		        Wait<WebDriver> wait = new FluentWait<WebDriver>(add.getDriver())							
		    			.withTimeout(30, TimeUnit.SECONDS) 			
		    			.pollingEvery(5, TimeUnit.SECONDS) 			
		    			.ignoring(NoSuchElementException.class);
		    	WebElement pageloaded = wait.until(new Function<WebDriver, WebElement>(){
		    	
		    		public WebElement apply(WebDriver driver ) {
		    			return driver.findElement(By.xpath("//*[@id=\"bottomEspot\"]/div/img"));
		    		}
		    	});
		        expected = "Account Overview | Frontgate";
		        i++;  
		    	d=new ReportDriver(driver);
		    	d.setplatform(browser);
		    	d.setmethod(Data[i][1]);
		     testresult(expected,demo.getTitle());
		 
		
	}
	
	else if(Data[i][1].equals("verifyInvalidEmail")){
		i++;
		d=new ReportDriver(driver);
		d.setplatform(browser);
		d.setmethod(Data[i][1]);
		testresult("Please enter Email Address in valid format.",demo.getEmailLabel());
		
	}
else if(Data[i][1].equals("verifyEmailConfirmationFelides")){
	i++;
	d=new ReportDriver(driver);
	d.setplatform(browser);
	d.setmethod(Data[i][1]);
	testresult("The Email Addresses you entred do not match. Please try again.",demo.getVerifyConfermEmailLabel());
		
	}
	
else if(Data[i][1].equals("verifyPasswordContainsAtLeast1Digit")){
	i++;
	d=new ReportDriver(driver);
	d.setplatform(browser);
	d.setmethod(Data[i][1]);
	testresult("Your password must contain at least 1 digit. Please try again.",demo.getPassLabel());
		
	}
else if(Data[i][1].equals("verifyPasswordContainsAtLeast1Letter")){
	i++;
	d=new ReportDriver(driver);
	d.setplatform(browser);
	d.setmethod(Data[i][1]);
	testresult("Your password must contain at least 1 letter. Please try again.",demo.getPassLabel());
		
	}
else if(Data[i][1].equals("verifyPasswordContainsAtLeast6Characters")){
	i++;
	d=new ReportDriver(driver);
	d.setplatform(browser);
	d.setmethod(Data[i][1]);
	testresult("Your password must be at least 6 characters. Please try again.",demo.getPassLabel());
		
	}
	
else if(Data[i][1].equals("verifyPasswordNotContainsSameCharacter4Time")){
	i++;
	d=new ReportDriver(driver);
	d.setplatform(browser);
	d.setmethod(Data[i][1]);
	testresult("You cannot use the same character 4 or more times. Please try again.",demo.getPassLabel());
		
	}
else if(Data[i][1].equals("verifyPasswordConfirmationFiled")){
	i++;
	d=new ReportDriver(driver);
	d.setplatform(browser);
	d.setmethod(Data[i][1]);
	testresult("The passwords you entered do not match. Please try again.",demo.getVerifyConfermPassLabel());
		
	}
else if(Data[i][1].equals("verifyEmailAddressNotRegistered")){
	i++;
	d=new ReportDriver(driver);
	d.setplatform(browser);
	d.setmethod(Data[i][1]);
	 testresult("The email address is already registered with the website. Please enter a different email address.",demo.getGeneralError());
		
	}
else if(Data[i][1].equals("verifyEmptyRegistrationFields")){
	setup(demo,"","","","");
	i++;
	d=new ReportDriver(driver);
	d.setplatform(browser);
	d.setmethod(Data[i][1]);
	 testresult("Please enter Email Address.",demo.getEmailLabel());
	    testresult("Please Re-Enter Email Address.",demo.getVerifyEmptyEmailLabel());
	    testresult("Please Enter Password.",demo.getPassLabel());
	    testresult("Please Re-Enter Password.",demo.getVerifyEmptyPassLabel());		
	}
else if(Data[i][1].equals("verifyEmptyRegistrationInfoFields")){
	
	if (browser.equals("mopile")){
		 add=new MopileFGAddressdemo(demo.getdriver());

	}
	else{add=new DesktopFGAddressdemo(demo.getdriver());}
	add.setbillNames("", "", "", "");
	 add.setbilladdrss("","", "", "", "Select Country", "");
	
	 add.setbillphone("", "");
	 	 add.hasshipaddress();
		 add.setshipNames("", "", "","");
        add.setshipaddrss("", "","", "","Select Country", "");
		 add.setshipphone("", ""); 
			add.clicksave();
			i++;
			d=new ReportDriver(driver);
			d.setplatform(browser);
			d.setmethod(Data[i][1]);
if(browser.equals("mopile")){
	
	   testresult("Please select a State/Province.",add.getRegoinLabel());
	   testresult("Please select a State/Province.",add.getSRegoinLabel());


}
else{
	 testresult("Please select a Country Name.",add.getRegoinLabel());
	   testresult("Please select a Country Name.",add.getSRegoinLabel());
}
			testresult("Please enter First Name.",add.getFNLabel());
   testresult("Please enter Last Name.",add.getLNLabel());
   testresult("Please enter Street Address 1.",add.getstrLabel());
   testresult("Please enter City.",add.getCityLabel());
   testresult("Please enter Zip/Postal Code.",add.getcodeLabel());
   testresult("Please enter a Daytime phone number, including area code (US Only).",add.getPhoneLabel());
   testresult("Please enter First Name.",add.getSFNLabel());
   testresult("Please enter Last Name.",add.getSLNLabel());
   testresult("Please enter Street Address 1.",add.getSstrLabel());
   testresult("Please enter City.",add.getSCityLabel());
   testresult("Please enter Zip/Postal Code.",add.getScodeLabel());
   testresult("Please enter a Daytime phone number, including area code (US Only).",add.getSPhoneLabel());	
	}
else if(Data[i][1].equals("verifyErrZipCodeRegistration")){
	if (browser.equals("mopile")){
		 add=new MopileFGAddressdemo(demo.getdriver());

	}
	else{add=new DesktopFGAddressdemo(demo.getdriver());}
	 add.setbillNames(address[1][0], address[1][1], address[1][2],address[1][3]);
	 add.setbilladdrss(address[1][4], address[1][5], address[1][6],"101", address[1][8], address[1][9]);
	 add.setbillphone(address[1][10], address[1][11]);
	 if(Data[i][6]!=null){
		 add.hasshipaddress();
		 add.setshipNames(address[1][0], address[1][1], address[1][2],address[1][3]);
        add.setshipaddrss(address[1][4], address[1][5], address[1][6],address[1][7], address[1][8], address[1][9]);
		 add.setshipphone(address[1][10], address[1][11]);
	 }
	add.clicksave();
	i++;
	d=new ReportDriver(driver);
	d.setplatform(browser);
    d.setmethod(Data[i][1]);
	testresult("Please enter a valid Zip/Postal code for the selected state.",add.getErrCodeLabel());
	 if(Data[i][17]!=null){
		
			testresult("Please enter a valid Zip/Postal code for the selected state.",add.getSErrCodeLabel());

	 }	
	}
	//i++;

    demo.quit();
    
}

void setup(FGRegistrationdemo demo,String email, String pass, String vemail,String vpass){

    demo.setEmail(email);
    demo.setVEmail(vemail);
    demo.setPass(pass);
    demo.setVPass(vpass);
    demo.clickcontinue();
	
}
 
private void testresult(String expected,String actual){
	  System.out.println(actual);
	  
     AssertJUnit.assertEquals("actual:"+actual+",expected:"+expected+",",actual, expected);
     
}
	 
	
	 






public static WebDriver getDriver() {
	
	return driver;
}

 
  
}