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
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Calendar;
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

public class RegistrationTesting2 {
	
	
	private static WebDriver driver;
	
	String[][]  Data =new String [64][64];
	private String expected;
	private String[][] address;
	private String baseUrl;

	private ReportDriver d;
	

	@BeforeTest
public void readTC(){
		Data=ReadTC.fileopen("files\\DTC1.xlsx","RegistrationTCData");  
        address=ReadTC.fileopen("files\\DTC1.xlsx","AddressData");
        System.out.println("launching chrome browser"); 
		 System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe"); 

        System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe"); 
    	//driver = new ChromeDriver();
        baseUrl = "https://devwcs2.frontgate.com/UserRegistrationFormView";					
    	   
	}


	

	
@Test  
@Parameters ({"browser"})
public void verifyssucsessregistration(String browser){
	int i=TCindex("verifyssucsessregistration");
	if (!Data[i][0].equals("T")){throw new SkipException("not need to test");}
	//launchBrowser();
	WebDriver	driver=null;
	if(browser.equals("firefox")){
	//	 System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe"); 
		 driver = new FirefoxDriver();
	}
	 if(browser.equalsIgnoreCase("chrome")){
//	System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe"); 
		driver = new ChromeDriver();}					
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
    driver.get(baseUrl);	
    DesktopFGRegisterdemo demo    =new DesktopFGRegisterdemo (driver);
	setup(demo,Data[i][2],Data[i][3],Data[i][4],Data[i][5]);
	 
	DesktopFGAddressdemo add=new DesktopFGAddressdemo(demo.getdriver());
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
	        this.driver=driver;
	     testresult(expected,demo.getTitle());
	 	d=new ReportDriver(driver);

	     demo.quit();
	
}

@Test 
@Parameters ({"browser"})
public void verifyInvalidEmail(String browser){
	int i=TCindex("verifyInvalidEmail");
	if (!Data[i][0].equals("T")){throw new SkipException("not need to test");}
	//launchBrowser();
	WebDriver	driver=null;
	if(browser.equals("firefox")){
	//	 System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe"); 
		 driver = new FirefoxDriver();
	}
	 if(browser.equalsIgnoreCase("chrome")){
	//System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe"); 
		driver = new ChromeDriver();}					
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
    driver.get(baseUrl);	
    DesktopFGRegisterdemo demo    =new DesktopFGRegisterdemo (driver);
	setup(demo,Data[i][2],Data[i][3],Data[i][4],Data[i][5]);
	this.driver=driver;
	testresult("Please enter Email Address in valid format.",demo.getEmailLabel());
	d=new ReportDriver(driver);

	demo.quit();
	 
}

@Test
@Parameters ({"browser"})
public void verifyEmailConfirmationFelides(String browser){
	int i=TCindex("verifyEmailConfirmationFelides");
	if (!Data[i][0].equals("T")){throw new SkipException("not need to test");}
	//launchBrowser();
	WebDriver	driver=null;
	if(browser.equals("firefox")){
		
		// System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe"); 
		 driver = new FirefoxDriver();
	}
	 if(browser.equalsIgnoreCase("chrome")){
	
		 driver = new ChromeDriver();
		}									
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
    driver.get(baseUrl);	
    DesktopFGRegisterdemo demo    =new DesktopFGRegisterdemo (driver);
	setup(demo,Data[i][2],Data[i][3],Data[i][4],Data[i][5]);
	this.driver=driver;
	testresult("The Email Addresses you entered do not match. Please try again.",demo.getVerifyConfermEmailLabel());
	d=new ReportDriver(driver);

	demo.quit();
}

@Test
@Parameters ({"browser"})
public void verifyPasswordContainsAtLeast1Digit(String browser){
	int i=TCindex("verifyPasswordContainsAtLeast1Digit");
	if (!Data[i][0].equals("T")){throw new SkipException("not need to test");}
	//launchBrowser();
	WebDriver	driver=null;
	if(browser.equals("firefox")){
	//	 System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe"); 
		 driver = new FirefoxDriver();
	}
	 if(browser.equalsIgnoreCase("chrome")){
	//System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe"); 
		driver = new ChromeDriver();}									
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
    driver.get(baseUrl);	
    DesktopFGRegisterdemo demo    =new DesktopFGRegisterdemo (driver);
	setup(demo,Data[i][2],Data[i][3],Data[i][4],Data[i][5]);
	this.driver=driver;
	testresult("Your password must contain at least 1 digit. Please try again.",demo.getPassLabel());
	d=new ReportDriver(driver);

	demo.quit();
}
@Test
@Parameters ({"browser"})
public void verifyPasswordContainsAtLeast1Letter(String browser){
	int i=TCindex("verifyPasswordContainsAtLeast1Letter");
	if (!Data[i][0].equals("T")){throw new SkipException("not need to test");}
	//launchBrowser();
	WebDriver	driver=null;
	if(browser.equals("firefox")){
	//	 System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe"); 
		 driver = new FirefoxDriver();
	}
	 if(browser.equalsIgnoreCase("chrome")){
	//System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe"); 
		driver = new ChromeDriver();}										
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
    driver.get(baseUrl);	
    DesktopFGRegisterdemo demo    =new DesktopFGRegisterdemo (driver);
	
	setup(demo,Data[i][2],Data[i][3],Data[i][4],Data[i][5]);
	this.driver=driver;
	testresult("Your password must contain at least 1 letter. Please try again.",demo.getPassLabel());
	d=new ReportDriver(driver);

	demo.quit();
}
@Test
@Parameters ({"browser"})
public void verifyPasswordContainsAtLeast6Characters(String browser){
	int i=TCindex("verifyPasswordContainsAtLeast6Characters");
	if (!Data[i][0].equals("T")){throw new SkipException("not need to test");}
	//launchBrowser();
	WebDriver	driver=null;
	if(browser.equals("firefox")){
		// System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe"); 
		 driver = new FirefoxDriver();
	}
	 if(browser.equalsIgnoreCase("chrome")){
	//System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe"); 
		driver = new ChromeDriver();}									
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
    driver.get(baseUrl);	
    DesktopFGRegisterdemo demo    =new DesktopFGRegisterdemo (driver);
	setup(demo,Data[i][2],Data[i][3],Data[i][4],Data[i][5]);
	this.driver=driver;
	testresult("Your password must be at least 6 characters. Please try again.",demo.getPassLabel());
	d=new ReportDriver(driver);

	demo.quit();
}
@Test
@Parameters ({"browser"})
public void verifyPasswordNotContainsSameCharacter4Time(String browser){
	int i=TCindex("verifyPasswordNotContainsSameCharacter4Time");
	if (!Data[i][0].equals("T")){throw new SkipException("not need to test");}
//	launchBrowser();
	WebDriver	driver=null;
	if(browser.equals("firefox")){
	//	 System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe"); 
		 driver = new FirefoxDriver();
	}
	 if(browser.equalsIgnoreCase("chrome")){
	//System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe"); 
		driver = new ChromeDriver();}									
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
    driver.get(baseUrl);
    DesktopFGRegisterdemo demo    =new DesktopFGRegisterdemo (driver);
	setup(demo,Data[i][2],Data[i][3],Data[i][4],Data[i][5]);
	this.driver=driver;
	
	testresult("You cannot use the same character 4 or more times. Please try again.",demo.getPassLabel());
	d=new ReportDriver(driver);

	demo.quit();
}
@Test
@Parameters ({"browser"})
public void verifyPasswordConfirmationFiled(String browser){
	int i=TCindex("verifyPasswordConfirmationFiled");
	if (!Data[i][0].equals("T")){throw new SkipException("not need to test");}
	//launchBrowser();
	WebDriver	driver=null;
	if(browser.equals("firefox")){
		// System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe"); 
		 driver = new FirefoxDriver();
	}
	 if(browser.equalsIgnoreCase("chrome")){
//	System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe"); 
		driver = new ChromeDriver();}										
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
    driver.get(baseUrl);	
    DesktopFGRegisterdemo demo    =new DesktopFGRegisterdemo (driver);
	setup(demo,Data[i][2],Data[i][3],Data[i][4],Data[i][5]);
	this.driver=driver;
	testresult("The passwords you entered do not match. Please try again.",demo.getVerifyConfermPassLabel());
	d=new ReportDriver(driver);

	demo.quit();
}
@Test
@Parameters ({"browser"})
public void verifyEmailAddressNotRegistered (String browser){
	int i=TCindex("verifyEmailAddressNotRegistered");
	if (!Data[i][0].equals("T")){throw new SkipException("not need to test");}
	//launchBrowser();
	WebDriver	driver=null;
	if(browser.equals("firefox")){
	//	 System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe"); 
		 driver = new FirefoxDriver();
	}
	 if(browser.equalsIgnoreCase("chrome")){
	//System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe"); 
		driver = new ChromeDriver();}									
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
    driver.get(baseUrl);	
    DesktopFGRegisterdemo demo    =new DesktopFGRegisterdemo (driver);
	 setup(demo,Data[i][2],Data[i][3],Data[i][4],Data[i][5]);
	 this.driver=driver;
	 testresult("The email address is already registered with the website. Please enter a different email address.",demo.getGeneralError());
		d=new ReportDriver(driver);

	 demo.quit();
}
@Test
@Parameters ({"browser"})
public void verifyEmptyRegistrationFields(String browser){
	int i=TCindex("verifyEmptyRegistrationFields");
	if (!Data[i][0].equals("T")){throw new SkipException("not need to test");}
	//launchBrowser();
	WebDriver	driver=null;
	if(browser.equals("firefox")){
	//	 System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe"); 
		 driver = new FirefoxDriver();
	}
	 if(browser.equalsIgnoreCase("chrome")){
	//System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe"); 
		driver = new ChromeDriver();}										
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
    driver.get(baseUrl);	
    DesktopFGRegisterdemo demo    =new DesktopFGRegisterdemo (driver);
	setup(demo,"","","","");
	this.driver=driver;
    testresult("Please enter Email Address.",demo.getEmailLabel());
    testresult("Please Re-Enter Email Address.",demo.getVerifyEmptyEmailLabel());
    testresult("Please Enter Password.",demo.getPassLabel());
    testresult("Please Re-Enter Password.",demo.getVerifyEmptyPassLabel());
	d=new ReportDriver(driver);

    demo.quit();
}
@Test
@Parameters ({"browser"})
public void verifyEmptyRegistrationInfoFields(String browser){
	int i=TCindex("verifyEmptyRegistrationInfoFields");
	if (!Data[i][0].equals("T")){throw new SkipException("not need to test");}
	//launchBrowser();
	WebDriver	driver=null;
	if(browser.equals("firefox")){
	//	 System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe"); 
		 driver = new FirefoxDriver();
	}
	 if(browser.equalsIgnoreCase("chrome")){
//	System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe"); 
		driver = new ChromeDriver();}								
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
    driver.get(baseUrl);	
    DesktopFGRegisterdemo demo    =new DesktopFGRegisterdemo (driver);
	setup(demo,Data[i][2],Data[i][3],Data[i][4],Data[i][5]);
	DesktopFGAddressdemo add=new DesktopFGAddressdemo(demo.getdriver());
	 add.setbillNames("", "", "", "");
 	 add.setbilladdrss("","", "", "", "Select Country", "");
	
 	 add.setbillphone("", "");
	 	 add.hasshipaddress();
		 add.setshipNames("", "", "","");
         add.setshipaddrss("", "","", "","Select Country", "");
		 add.setshipphone("", ""); 
			add.clicksave();
			this.driver=driver;
			testresult("Please enter First Name.",add.getFNLabel());
    testresult("Please enter Last Name.",add.getLNLabel());
    testresult("Please enter Street Address 1.",add.getstrLabel());
    testresult("Please enter City.",add.getCityLabel());
    testresult("Please enter Zip/Postal Code.",add.getcodeLabel());
    testresult("Please select a Country Name.",add.getRegoinLabel());
    testresult("Please enter a Daytime phone number, including area code (US Only).",add.getPhoneLabel());
    testresult("Please enter First Name.",add.getSFNLabel());
    testresult("Please enter Last Name.",add.getSLNLabel());
    testresult("Please enter Street Address 1.",add.getSstrLabel());
    testresult("Please enter City.",add.getSCityLabel());
    testresult("Please enter Zip/Postal Code.",add.getScodeLabel());
    testresult("Please select a Country Name.",add.getSRegoinLabel());
    testresult("Please enter a Daytime phone number, including area code (US Only).",add.getSPhoneLabel());
	d=new ReportDriver(driver);

    demo.quit();
}
@Test 
@Parameters ({"browser"})
public void verifyErrZipCodeRegistration(String browser){
	int i=TCindex("verifyErrZipCodeRegistration");
	if (!Data[i][0].equals("T")){throw new SkipException("not need to test");}
	WebDriver	driver=null;
	if(browser.equals("firefox")){
		// System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe"); 
		 driver = new FirefoxDriver();
	}
	 if(browser.equalsIgnoreCase("chrome")){
//	System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe"); 
		driver = new ChromeDriver();}												
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
    driver.get(baseUrl);	
    DesktopFGRegisterdemo demo    =new DesktopFGRegisterdemo (driver);
	setup(demo,Data[i][2],Data[i][3],Data[i][4],Data[i][5]);
	 
	DesktopFGAddressdemo add=new DesktopFGAddressdemo(demo.getdriver());
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
	this.driver=driver;
	testresult("Please enter a valid Zip/Postal code for the selected state.",add.getErrCodeLabel());
	 if(Data[i][17]!=null){
			testresult("Please enter a valid Zip/Postal code for the selected state.",add.getSErrCodeLabel());
 
	 }
		d=new ReportDriver(driver);

	 demo.quit();
	 
	
}

void setup(DesktopFGRegisterdemo demo,String email, String pass, String vemail,String vpass){

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
public int TCindex(String msg){
	int i=0;
	for ( ;i<Data.length;i++){
		if (msg.equals("verifyEmailAddressNotRegistered")){return 10;}
		                 
				 if(Data[i][1].equals(msg)){
       
					break;
					 }
				 
	 }
	return i;
}	 
	
public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

    //Convert web driver object to TakeScreenshot

    TakesScreenshot scrShot =((TakesScreenshot)webdriver);

    //Call getScreenshotAs method to create image file

            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

            File DestFile=new File(fileWithPath);

            //Copy file at destination

            FileUtils.copyFile(SrcFile, DestFile);

        

}	 






public static WebDriver getDriver() {
	
	return driver;
}

 
  
}