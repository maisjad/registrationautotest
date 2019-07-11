package FG_RegistrationTest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
	FGRegisterdemo demo ;
	address add;
	String[][]  Data =new String [64][64];
	private String expected;
	
	
	private String emailaddress;
	private String password;
	private String vemail;
	private String vpass;
	private String[] Add=new String[64];
	
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
	@BeforeTest	 
	void fileopen(){
		  
		  File file = new File("C:\\Users\\me\\workspace\\FG_Registration\\files\\DTC1.xlsx"); 
		   FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		    Workbook WB = null;
			try {
				WB = new XSSFWorkbook(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		    Sheet sh = WB.getSheet("Sheet1");
            int rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
	        int colcount=sh.getRow(0).getLastCellNum();
	       
		    for (int i = 0; i < rowCount+1; i++) {
		    	if (i==10){
		    		
		    		
		    		
		    	}
		    	
		        Row row = sh.getRow(i);
		        System.out.println();
            for (int j = 0; j < row.getLastCellNum(); j++) {
            	try{ System.out.print(row.getCell(j).getStringCellValue()+"|| ");
            		if(i==10){
            		Add[j]=	row.getCell(j).getStringCellValue();
            			
            		}
            		
            		else{	
            		 Data[i][j]=row.getCell(j).getStringCellValue();
            		 }
            		
            		 }
            	 
            	 catch (IllegalStateException e){
            		 if(i==10){
             			Add[j]= "10167";
             			
             		}
             		
            		 else{ System.out.print(row.getCell(j).getRowIndex()+"|| ");
            		 
            		 Data[i][j]= ""+row.getCell(j).getRowIndex();}
            		
            		 
            	 }
            	
            	
               }}
		
		
		
	}
    
    
	@BeforeMethod
    public void launchBrowser() {
	    

        System.out.println("launching chrome browser"); 
        String baseUrl = "https://devwcs2.frontgate.com/UserRegistrationFormView";					
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\me\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver();					
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
        driver.get(baseUrl);	
        demo=new FGRegisterdemo (driver);
       
      
    }
	
  @Test(priority=0)
  public void verifysuccsessRegisgtration() {
	  
	 setup(Data[1][0],Data[1][1],Data[1][2],Data[1][3]);	
	 add=new address(demo.getdriver());
	 add.setbillNames(Add[1], Add[2], Add[3], Add[4]);

	 add.setbilladdrss(Add[5], Add[6], Add[7], Add[8], Add[9], Add[10]);
	 add.setbillphone(Add[11], Add[12]);
	 if(Add[13]!=null){
		 add.hasshipaddress();
		 add.setshipNames(Add[13], Add[14], Add[15], Add[16]);
         add.setshipaddrss(Add[17], Add[18], Add[19], Add[20], Add[21], Add[22]);
		 add.setshipphone(Add[23], Add[24]); 
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
	        
	       

	        
  }
  
  
 @Test (priority=1)
  public void verifyInvalidEmail(){
	 setup(Data[2][0],Data[2][1],Data[2][2],Data[2][3]);
	        testresult("Please enter Email Address in valid format.",demo.getEmailLabel());
	       
	        expected="Registration | Frontgate";
            
  }
  @Test(priority=9)
  public void verifyEmptyRegistrationFields(){
	  setup("","","","");
	       
	        testresult("Please enter Email Address.",demo.getEmailLabel());
	        testresult("Please Re-Enter Email Address.",demo.getVerifyEmptyEmailLabel());
	        testresult("Please Enter Password.",demo.getPassLabel());
	        testresult("Please Re-Enter Password.",demo.getVerifyEmptyPassLabel());
	        expected="Registration | Frontgate";

            
        
  }
  
  @Test (priority=2)
  public void verifyEmailConfirmationFelides(){
	  setup(Data[3][0],Data[3][1],Data[3][2],Data[3][3]);
	 
       
        testresult("The Email Addresses you entered do not match. Please try again.",demo.getVerifyConfermEmailLabel());

        expected="Registration | Frontgate";
} 
  
  @Test (priority=3)
  public void verifyPasswordContainsAtLeast1Digit(){
	  setup(Data[4][0],Data[4][1],Data[4][2],Data[4][3]);
	 
        
        testresult("Your password must contain at least 1 digit. Please try again.",demo.getPassLabel());
        
        expected="Registration | Frontgate";
        
  } 
  @Test (priority=4)
  public void verifyPasswordContainsAtLeast1Letter(){
	  
	  setup(Data[5][0],Data[5][1],Data[5][2],Data[5][3]);
        
      testresult("Your password must contain at least 1 letter. Please try again.",demo.getPassLabel());
        
        expected="Registration | Frontgate";
  } 
  @Test (priority=5)
  public void verifyPasswordContainsAtLeast6Characters(){
	  setup(Data[6][0],Data[6][1],Data[6][2],Data[6][3]);
	  
        
      testresult("Your password must be at least 6 characters. Please try again.",demo.getPassLabel());
        
        expected="Registration | Frontgate";
  } 
  @Test (priority=6)

  public void verifyPasswordNotContainsSameCharacter4Time(){
	  
	  setup(Data[7][0],Data[7][1],Data[7][2],Data[7][3]);
        
      testresult("You cannot use the same character 4 or more times. Please try again.",demo.getPassLabel());
        
        expected="Registration | Frontgate";
  }
  @Test (priority=7)

  public void verifyPasswordConfirmationFiled(){
	  setup(Data[8][0],Data[8][1],Data[8][2],Data[8][3]);
	         
       testresult("The passwords you entered do not match. Please try again.",demo.getVerifyConfermPassLabel());
        expected="Registration | Frontgate";
        
  }
  @Test (priority=8)

  public void verifyEmailAddressNotRegistered (){
	  setup(Data[9][0],Data[9][1],Data[9][2],Data[9][3]);
	  
        
        
        testresult("The email address is already registered with the website. Please enter a different email address.",demo.getGeneralError());
        expected="Registration | Frontgate";
        
  }
  
  @AfterMethod
  public void terminateBrowser(){
      testresult(expected,demo.getTitle());
	  demo.quit();
      
      
  }
}
