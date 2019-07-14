package FG_RegistrationTest;
import java.io.File;




import org.openqa.selenium.OutputType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

@Listeners(JyperionListener.class)

public class NewTest {
	static WebDriver driver;
	FGRegisterdemo demo ;
	address add;
	String[][]  Data =new String [64][64];
	private String expected;
	
@BeforeTest
public void readTC(){
		Data=ReadTC.fileopen("files\\DTC1.xlsx","sheet1");  }
   
@BeforeMethod 
public void launchBrowser() {
	
        System.out.println("launching chrome browser"); 
        String baseUrl = "https://devwcs2.frontgate.com/UserRegistrationFormView";					
    	System.setProperty("webdriver.chrome.driver","Jars\\chromedriver.exe");
        driver = new ChromeDriver();					
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
        driver.get(baseUrl);	
        demo=new FGRegisterdemo (driver);}
	

	
@Test  
public void verifyssucsessregistration(){
	int i=TCindex("verifyssucsessregistration");
	 setup(Data[i][1],Data[i][2],Data[i][3],Data[i][4]);
	 
	 add=new address(demo.getdriver());
	 add.setbillNames(Data[i][5], Data[i][6], Data[i][7], Data[i][8]);
 	 add.setbilladdrss(Data[i][9], Data[i][10], Data[i][11], Data[i][12], Data[i][13], Data[i][14]);
	 add.setbillphone(Data[i][15], Data[i][16]);
	 if(Data[i][17]!=null){
		 add.hasshipaddress();
		 add.setshipNames(Data[i][18], Data[i][19], Data[i][20],Data[i][21]);
         add.setshipaddrss(Data[i][22], Data[i][23],Data[i][24], Data[i][25],Data[i][26], Data[i][27]);
		 add.setshipphone(Data[i][28], Data[i][29]); 
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
	     
	     testresult(expected,demo.getTitle());
	 
	 
	
}

@Test 
public void verifyInvalidEmail(){
	int i=TCindex("verifyInvalidEmail");
	setup(Data[i][1],Data[i][2],Data[i][3],Data[i][4]);
	 testresult("Please enter Email Address in valid format.",demo.getEmailLabel());

}

@Test
public void verifyEmailConfirmationFelides(){
	int i=TCindex("verifyEmailConfirmationFelides");
	setup(Data[i][1],Data[i][2],Data[i][3],Data[i][4]);
    testresult("The Email Addresses you entered do not match. Please try again.",demo.getVerifyConfermEmailLabel());

}

@Test
public void verifyPasswordContainsAtLeast1Digit(){
	int i=TCindex("verifyPasswordContainsAtLeast1Digit");
	setup(Data[i][1],Data[i][2],Data[i][3],Data[i][4]);
    testresult("Your password must contain at least 1 digit. Please try again.",demo.getPassLabel());

}
@Test
public void verifyPasswordContainsAtLeast1Letter(){
	int i=TCindex("verifyPasswordContainsAtLeast1Letter");
	setup(Data[i][1],Data[i][2],Data[i][3],Data[i][4]);
    testresult("Your password must contain at least 1 letter. Please try again.",demo.getPassLabel());

}
@Test
public void verifyPasswordContainsAtLeast6Characters(){
	int i=TCindex("verifyPasswordContainsAtLeast6Characters");
	setup(Data[i][1],Data[i][2],Data[i][3],Data[i][4]);
    testresult("Your password must be at least 6 characters. Please try again.",demo.getPassLabel());

}
@Test
public void verifyPasswordNotContainsSameCharacter4Time(){
	int i=TCindex("verifyPasswordNotContainsSameCharacter4Time");
	setup(Data[i][1],Data[i][2],Data[i][3],Data[i][4]);
    testresult("You cannot use the same character 4 or more times. Please try again.",demo.getPassLabel());

}
@Test
public void verifyPasswordConfirmationFiled(){
	int i=TCindex("verifyPasswordConfirmationFiled");
	setup(Data[i][1],Data[i][2],Data[i][3],Data[i][4]);
    testresult("The passwords you entered do not match. Please try again.",demo.getVerifyConfermPassLabel());

}
@Test
public void verifyEmailAddressNotRegistered (){
	int i=TCindex("verifyEmailAddressNotRegistered");
	
	setup(Data[i][1],Data[i][2],Data[i][3],Data[i][4]);
    testresult("The email address is already registered with the website. Please enter a different email address.",demo.getGeneralError());

}
@Test
public void verifyEmptyRegistrationFields(){
	int i=TCindex("verifyEmptyRegistrationFields");
	setup("","","","");
    
    testresult("Please enter Email Address.",demo.getEmailLabel());
    testresult("Please Re-Enter Email Address.",demo.getVerifyEmptyEmailLabel());
    testresult("Please Enter Password.",demo.getPassLabel());
    testresult("Please Re-Enter Password.",demo.getVerifyEmptyPassLabel());
}
@Test
public void verifyEmptyRegistrationInfoFields(){
	int i=TCindex("verifyEmptyRegistrationInfoFields");
	setup(Data[i][1],Data[i][2],Data[i][3],Data[i][4]);
	 add=new address(demo.getdriver());
	 add.setbillNames("", "", "", "");
 	 add.setbilladdrss("","", "", "", "Select Country", "");
	
 	 add.setbillphone("", "");
	 	 add.hasshipaddress();
		 add.setshipNames("", "", "","");
         add.setshipaddrss("", "","", "","Select Country", "");
		 add.setshipphone("", ""); 
			add.clicksave();
    testresult("Please enter First Name.",add.getFNLabel());
    testresult("Please enter Last Name.",add.getLNLabel());
    testresult("Please enter Street Address 1.",add.getstrLabel());
    testresult("Please enter City.",add.getCityLabel());
    testresult("Please enter Zip/Postal Code.",add.getcodeLabel());
    testresult("Please select a Country Name.",add.getRegoinLabel());
    testresult("Please enter a Daytime phone number, including area code (US Only).Evening Phone",add.getPhoneLabel());
    testresult("Please enter First Name.",add.getSFNLabel());
    testresult("Please enter Last Name.",add.getSLNLabel());
    testresult("Please enter Street Address 1.",add.getSstrLabel());
    testresult("Please enter City.",add.getSCityLabel());
    testresult("Please enter Zip/Postal Code.",add.getScodeLabel());
    testresult("Please select a Country Name.",add.getSRegoinLabel());
    testresult("Please enter a Daytime phone number, including area code (US Only).Evening Phone",add.getSPhoneLabel());
}
@Test  
public void verifyErrZipCodeRegistration(){
	int i=TCindex("verifyErrZipCodeRegistration");
	 setup(Data[i][1],Data[i][2],Data[i][3],Data[i][4]);
	 
	 add=new address(demo.getdriver());
	 add.setbillNames(Data[i][5], Data[i][6], Data[i][7], Data[i][8]);
 	 add.setbilladdrss(Data[i][9], Data[i][10], Data[i][11], Data[i][12], Data[i][13], Data[i][14]);
	 add.setbillphone(Data[i][15], Data[i][16]);
	 if(Data[i][17]!=null){
		 add.hasshipaddress();
		 add.setshipNames(Data[i][18], Data[i][19], Data[i][20],Data[i][21]);
         add.setshipaddrss(Data[i][22], Data[i][23],Data[i][24], Data[i][25],Data[i][26], Data[i][27]);
		 add.setshipphone(Data[i][28], Data[i][29]); 
	 }
	add.clicksave();
	testresult("Please enter a valid Zip/Postal code for the selected state.",add.getErrCodeLabel());
	 if(Data[i][17]!=null){
			testresult("Please enter a valid Zip/Postal code for the selected state.",add.getSErrCodeLabel());
 
	 }
	 
	
}

void setup(String email, String pass, String vemail,String vpass){

    demo.setEmail(email);
    demo.setVEmail(vemail);
    demo.setPass(pass);
    demo.setVPass(vpass);
    demo.clickcontinue();
	
}
 
private void testresult(String expected,String actual){
	  System.out.println(actual);
	  
     AssertJUnit.assertEquals(actual, expected);
	
}
public int TCindex(String msg){
	int i=0;
	for ( ;i<Data.length;i++){
	//	if (msg.equals("verifyEmailAddressNotRegistered")){return 10;}
		                 
				 if(Data[i][0].equals(msg)){
        System.out.println(i);
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

  
  @AfterMethod
  public void terminateBrowser(){
      
	  demo.quit();
      
      
  }

public static WebDriver getDriver() {
	
	return driver;
}

 
  
}
