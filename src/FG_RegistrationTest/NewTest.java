package FG_RegistrationTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
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
public class NewTest {
	WebDriver driver;
	private String expected;
	private String actual;
	private WebElement email;
	private WebElement submit;
	private WebElement verifyemail;
	private WebElement pass;
	private WebElement verifypass;
	private String emailaddress;
	private String password;
	
	
	public void testresult(String expected,String actual){
		  System.out.println(actual);
         AssertJUnit.assertEquals(actual, expected);
		
	}
	
	@BeforeMethod
    public void launchBrowser() {
        System.out.println("launching chrome browser"); 
        String baseUrl = "https://devwcs2.frontgate.com/UserRegistrationFormView";					
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\me\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver();					
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
        driver.get(baseUrl);	
       email = driver.findElement(By.id("logonId"));
       submit = driver.findElement(By.id("continue"));
        verifyemail = driver.findElement(By.id("verifyLogonId"));
        pass = driver.findElement(By.id("logonPassword"));
        verifypass = driver.findElement(By.id("logonPasswordVerify"));
    }
	
  @Test(priority=1)
  public void verifysuccsessRegisgtration() {
	  //this information we can read it from external file 
		 emailaddress="maria11.2019@yahoo.com"; 
		  password="**123456789987654321aA";
		 String fn="maria"; 
		 String ln="jad";
		 String mn="mj"; 
		 String phone1="456-789-1234";
		 String phone2=""; 
		 String str1="Str 245 park ave";
		 String str2="";
		 String company="itg";
		 String state="New York"; 
		 String region="United States";
		 String city="NY";
		 String code="10167";
		 Boolean billaddress=true;
		 String shipfn="mary"; 
		 String shipln="jad";
		 String shipmn="mj"; 
		 String shipphone1="456-789-1234";
		 String shipphone2=""; 
		 String shipstr1="Str 245 park ave";
		 String shipstr2="";
		 String shipcompany="itg";
		 String shipstate="New York"; 
		 String shipregion="United States";
		 String shipcity="NY";
		 String shipcode="10167"; 
		 
		 
	        
	        email.sendKeys(emailaddress);					
	        verifyemail.sendKeys(emailaddress);
	        pass.sendKeys(password);					
	        verifypass.sendKeys(password);
	        submit.click();			
	        System.out.println("Login Done with Click");
	         driver.findElement(By.id("bill_fnbox")).sendKeys(fn);
	         driver.findElement(By.id("bill_mibox")).sendKeys(mn);
	         driver.findElement(By.id("bill_lnbox")).sendKeys(ln);
	         driver.findElement(By.id("bill_cnbox")).sendKeys(company);
	         driver.findElement(By.id("bill_sa1box")).sendKeys(str1);
	         driver.findElement(By.id("bill_sa2box")).sendKeys(str2);
	         driver.findElement(By.id("bill_citybox")).sendKeys(city);
	         driver.findElement(By.id("bill_zipbox")).sendKeys(code);
	         driver.findElement(By.id("bill_phone1box")).sendKeys(phone1);
	         driver.findElement(By.id("bill_phone2box")).sendKeys(phone2);
	        Select drpCountry = new Select(driver.findElement(By.id("bill_country-name")));
			drpCountry.selectByVisibleText(region);
	        Select drpCountry1 = new Select(driver.findElement(By.id("bill_region")));
	        drpCountry1.selectByVisibleText(state);
	        if (!billaddress){
	        driver.findElement(By.id("gwt-uid-286")).click();
	        driver.findElement(By.id("ship_fnbox")).sendKeys(shipfn);
	        driver.findElement(By.id("ship_mibox")).sendKeys(shipmn);
	        driver.findElement(By.id("ship_lnbox")).sendKeys(shipln);
	        driver.findElement(By.id("ship_cnbox")).sendKeys(shipcompany);
	        driver.findElement(By.id("ship_sa1box")).sendKeys(shipstr1);
	        driver.findElement(By.id("ship_sa2box")).sendKeys(shipstr2);
	        driver.findElement(By.id("ship_citybox")).sendKeys(shipcity);
	        driver.findElement(By.id("ship_zipbox")).sendKeys(shipcode);
	        driver.findElement(By.id("ship_phone1box")).sendKeys(shipphone1);
	        driver.findElement(By.id("ship_phone2box")).sendKeys(shipphone2);
	       Select shipdrpCountry = new Select(driver.findElement(By.id("ship_country-name")));
			shipdrpCountry.selectByVisibleText(shipregion);
	       Select shipdrpCountry1 = new Select(driver.findElement(By.id("ship_region")));
	       shipdrpCountry1.selectByVisibleText(shipstate);
	        
	        }
	        
	        
	        
	        WebElement save = driver.findElement(By.xpath("//*[@id=\"gwt_billshipaddr_btn\"]/button"));
	        save.click();
      	
	        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
	    			.withTimeout(30, TimeUnit.SECONDS) 			
	    			.pollingEvery(5, TimeUnit.SECONDS) 			
	    			.ignoring(NoSuchElementException.class);
	    	WebElement pageloaded = wait.until(new Function<WebDriver, WebElement>(){
	    	
	    		public WebElement apply(WebDriver driver ) {
	    			return driver.findElement(By.xpath("//*[@id=\"bottomEspot\"]/div/img"));
	    		}
	    	});
	        expected = "Account Overview | Frontgate";
	        
	       

	        
  }
  
  
 @Test (priority=0)
  public void verifyInvalidEmail(){
	   emailaddress="lldsslcs"; 
		  password="**123456789987654321aA";
		 
	        email.sendKeys(emailaddress);
	        verifyemail.sendKeys(emailaddress);
	        pass.sendKeys(password);					
	        verifypass.sendKeys(password);
	        WebElement emaillabel = driver.findElement(By.xpath("//*[@id=\"error-div-logonId\"]/div"));
           
	        testresult("Please enter Email Address in valid format.",emaillabel.getText());
	        submit.click();
	        expected="Registration | Frontgate";
            
  }
  @Test(priority=4)
  public void verifyEmptyRegistrationFields(){
	   emailaddress=""; 
		  password="";
		
	        email.sendKeys(emailaddress);
	        verifyemail.sendKeys(emailaddress);
	        pass.sendKeys(password);					
	        verifypass.sendKeys(password);
	        submit.click();
	        WebElement emaillabel = driver.findElement(By.xpath("//*[@id=\"error-div-logonId\"]/div"));
	        WebElement verifyemaillabel = driver.findElement(By.xpath("//*[@id=\"error-div-verifyLogonId\"]/div"));
	        WebElement passlabel = driver.findElement(By.xpath("//*[@id=\"error-div-logonPassword\"]/div"));
	        WebElement verifypasslabel = driver.findElement(By.xpath("//*[@id=\"error-div-logonPasswordVerify\"]/div"));
	        testresult("Please enter Email Address.",emaillabel.getText());
	        testresult("Please Re-Enter Email Address.",verifyemaillabel.getText());
	        testresult("Please Enter Password.",passlabel.getText());
	        testresult("Please Re-Enter Password.",verifypasslabel.getText());
	        expected="Registration | Frontgate";

            
        
  }
  
  @Test (priority=1)
  public void verifyEmailConfirmationFelides(){
	  
	  emailaddress="mary22.2019@yahoo.com"; 
	  password="a12356911";
	String vemail="mary220.2019@yahoo.com";
        email.sendKeys(emailaddress);
        verifyemail.sendKeys(vemail);
        pass.sendKeys(password);					
        verifypass.sendKeys(password);
        WebElement verifyemaillabel = driver.findElement(By.xpath("//*[@id=\"error-div-logonId-verifyLogonId\"]/div"));
        testresult("The Email Addresses you entered do not match. Please try again.",verifyemaillabel.getText());
submit.click();
expected="Registration | Frontgate";
} 
  
  @Test (priority=3)
  public void verifyPasswordContainsAtLeast1Digit(){
	  
	  emailaddress="mary22.2019@yahoo.com"; 
	  password="jkiutrf";
	
        email.sendKeys(emailaddress);
        verifyemail.sendKeys(emailaddress);
        pass.sendKeys(password);					
        verifypass.sendKeys(password);
        WebElement passlabel = driver.findElement(By.xpath("//*[@id=\"error-div-logonPassword\"]/div"));
        testresult("Your password must contain at least 1 digit. Please try again.",passlabel.getText());
        submit.click();
        expected="Registration | Frontgate";
        
  } 
  @Test (priority=4)
  public void verifyPasswordContainsAtLeast1Letter(){
	  
	  emailaddress="mary22.2019@yahoo.com"; 
	  password="123365486";
	
        email.sendKeys(emailaddress);
        verifyemail.sendKeys(emailaddress);
        pass.sendKeys(password);					
        verifypass.sendKeys(password);
        WebElement passlabel = driver.findElement(By.xpath("//*[@id=\"error-div-logonPassword\"]/div"));
        testresult("Your password must contain at least 1 letter. Please try again.",passlabel.getText());
  
        submit.click();
        expected="Registration | Frontgate";
  } 
  @Test (priority=5)
  public void verifyPasswordContainsAtLeast6Characters(){
	  
	  emailaddress="mary22.2019@yahoo.com"; 
	  password="123k";
	
        email.sendKeys(emailaddress);
        verifyemail.sendKeys(emailaddress);
        pass.sendKeys(password);					
        verifypass.sendKeys(password);
        WebElement passlabel = driver.findElement(By.xpath("//*[@id=\"error-div-logonPassword\"]/div"));
       
        testresult("Your password must be at least 6 characters. Please try again.",passlabel.getText());
        submit.click();
        expected="Registration | Frontgate";
  } 
  @Test (priority=6)

  public void verifyPasswordNotContainsSameCharacter4Time(){
	  
	  emailaddress="mary22.2019@yahoo.com"; 
	  password="kkkkkkk";
	
        email.sendKeys(emailaddress);
        verifyemail.sendKeys(emailaddress);
        pass.sendKeys(password);					
        verifypass.sendKeys(password);
        WebElement passlabel = driver.findElement(By.xpath("//*[@id=\"error-div-logonPassword\"]/div"));
       testresult("You cannot use the same character 4 or more times. Please try again.",passlabel.getText()); 
       submit.click();
       expected="Registration | Frontgate";
  }
  @Test (priority=7)

  public void verifyPasswordConfirmationFiled(){
	  
	  emailaddress="mary22.2019@yahoo.com"; 
	  password="a123456789";
	String vpass="887hhjuij";
        email.sendKeys(emailaddress);
        verifyemail.sendKeys(emailaddress);
        pass.sendKeys(password);					
        verifypass.sendKeys(vpass);
        submit.click();
        WebElement verifypasslabel = driver.findElement(By.xpath("//*[@id=\"error-div-logonPassword-logonPasswordVerify\"]/div"));
        
        testresult("The passwords you entered do not match. Please try again.",verifypasslabel.getText());
        expected="Registration | Frontgate";
        
  }
  @Test (priority=1)

  public void verifyEmailAddressNotRegistered (){
	  
	  emailaddress="mais.jad@outlook.com"; 
	  password="bn123456";
	
        email.sendKeys(emailaddress);
        verifyemail.sendKeys(emailaddress);
        pass.sendKeys(password);					
        verifypass.sendKeys(password);
        submit.click();
        
        WebElement generalerror = driver.findElement(By.xpath("//*[@id=\"gwt-error-placement-div\"]/div/span"));
        testresult("The email address is already registered with the website. Please enter a different email address.",generalerror.getText());
        expected="Registration | Frontgate";
        
  }
  
  @AfterMethod
  public void terminateBrowser(){
      testresult(expected,driver.getTitle());
	  driver.quit();
      
      
  }
}
