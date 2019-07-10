package FG_RegistrationTest;
import java.util.concurrent.TimeUnit;		
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FGRegisterTest {
	//this information we can read it from external file 
	static String emailaddress="mary1.2019@yahoo.com"; 
	static String password="**123456789987654321aA";
	static String fn="mary"; 
	static String ln="jad";
	static String mn="mj"; 
	static String phone1="456-789-1234";
	static String phone2=""; 
	static String str1="Str 245 park ave";
	static String str2="";
	static String company="itg";
	static String state="New York"; 
	static String region="United States";
	static String city="NY";
	static String code="10167";
	static Boolean billaddress=true;
	static String shipfn="mary"; 
	static String shipln="jad";
	static String shipmn="mj"; 
	static String shipphone1="456-789-1234";
	static String shipphone2=""; 
	static String shipstr1="Str 245 park ave";
	static String shipstr2="";
	static String shipcompany="itg";
	static String shipstate="New York"; 
	static String shipregion="United States";
	static String shipcity="NY";
	static String shipcode="10167";
	public static void main(String[] args) {									
        String baseUrl = "https://devwcs2.frontgate.com/UserRegistrationFormView";					
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\me\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();					
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
        driver.get(baseUrl);	
        WebElement email = driver.findElement(By.id("logonId"));
        WebElement submit = driver.findElement(By.id("continue"));
        WebElement verifyemail = driver.findElement(By.id("verifyLogonId"));
        WebElement pass = driver.findElement(By.id("logonPassword"));
        WebElement verifypass = driver.findElement(By.id("logonPasswordVerify"));
        /*WebElement emaillabel = driver.findElement(By.xpath("//*[@id=\"error-div-logonId\"]/div"));
        WebElement verifyemaillabel = driver.findElement(By.xpath("//*[@id=\"error-div-verifyLogonId\"]/div"));
        WebElement passlabel = driver.findElement(By.xpath("//*[@id=\"error-div-logonPassword\"]/div"));
        WebElement verifypasslabel = driver.findElement(By.xpath("//*[@id=\"error-div-logonPasswordVerify\"]/div"));
        WebElement generalerror = driver.findElement(By.xpath("//*[@id=\"gwt-error-placement-div\"]/div/span"));*/
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
        System.out.println("registration completed succsisfully");

}}
