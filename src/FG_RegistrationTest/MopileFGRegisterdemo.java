package FG_RegistrationTest;

import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MopileFGRegisterdemo extends FGRegistrationdemo{
	WebDriver driver;
    
    By email = By.id("field-2");
    By submit = By.id("continue");
    By verifyemail =By.id("field-3");
    By pass = By.id("field-4");
    By verifypass = By.id("field-5");
    By emaillabel = By.xpath("//*[@id=\"register-form\"]/div/div[1]/div/div/div/div/div[2]");
    By verifyemptyemaillabel = By.xpath("//*[@id=\"register-form\"]/div/div[2]/div/div/div/div/div[2]");
    By passlabel =By.xpath("//*[@id=\"register-form\"]/div/div[3]/div/div/div[2]/div/div[2]");
    By verifyemptypasslabel = By.xpath("//*[@id=\"register-form\"]/div/div[4]/div/div/div/div/div[2]");
    By verifyconfermemaillabel = By.xpath("//*[@id=\"register-form\"]/div/div[2]/div/div/div/div/div[2]");
    By verifyconfermpasslabel = By.xpath("//*[@id=\"register-form\"]/div/div[4]/div/div/div/div/div[2]");
    By generalerror = By.xpath("//*[@id=\"register-form\"]/div[1]");
   
   
 
    public MopileFGRegisterdemo(WebDriver driver){
      super(driver);
       this.driver = driver;
    	}	
    
    
    public void clickcontinue(){
       
    	driver.findElement(submit).click();
       }

    public void setEmail(String str){
	   
    	driver.findElement(email).sendKeys(str);
	   }
    public void setVEmail(String str){
	   
    	driver.findElement(verifyemail).sendKeys(str);
	   }
    public void setPass(String str){
	   
    	driver.findElement(pass).sendKeys(str);
    	
	   }
    public void setVPass(String str){
	   
    	driver.findElement(verifypass).sendKeys(str);
	   }
    
    
    public String getEmailLabel(){
    	try{
    	return driver.findElement(emaillabel).getText();}
    	catch (NoSuchElementException e){
    	System.out.print(e.getMessage());
    	}
    	return "!!";
    	
       }
    public String getVerifyEmptyEmailLabel(){
    	try{
        	return driver.findElement(verifyemptyemaillabel).getText();}
        	catch (NoSuchElementException e){
        	System.out.print(e.getMessage());
        	}
        	return "!!";
    
       }
    public String getPassLabel(){
    	try{
        	return driver.findElement(passlabel).getText();}
        	catch (NoSuchElementException e){
        	System.out.print(e.getMessage());
        	}
        	return "!!";
    	
       }
    public String getVerifyEmptyPassLabel(){
    	try{
        	return driver.findElement(verifyemptypasslabel).getText();}
        	catch (NoSuchElementException e){
        	System.out.print(e.getMessage());
        	}
        	return "!!";
    	
       }
    public String getVerifyConfermEmailLabel(){
    	try{
        	return driver.findElement(verifyconfermemaillabel).getText();}
        	catch (NoSuchElementException e){
        	System.out.print(e.getMessage());
        	}
        	return "!!";
    	
       }
    public String getVerifyConfermPassLabel(){
    	try{
        	return driver.findElement(verifyconfermpasslabel).getText();}
        	catch (NoSuchElementException e){
        	System.out.print(e.getMessage());
        	}
        	return "!!";
    	
       }
    public String getGeneralError(){
    	try{
        	return driver.findElement(generalerror).getText();}
        	catch (NoSuchElementException e){
        	System.out.print(e.getMessage());
        	}
        	return "!!";
    	
    	
       }


	public String getTitle() {
		
		return driver.getTitle();
	}

  public WebDriver getdriver(){
	  return driver;
  }
	public void quit() {
		
		driver.quit();
	}

    


}



