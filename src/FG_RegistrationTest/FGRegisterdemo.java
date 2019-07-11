package FG_RegistrationTest;

import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FGRegisterdemo {
	WebDriver driver;
    
    By email = By.id("logonId");
    By submit = By.id("continue");
    By verifyemail =By.id("verifyLogonId");
    By pass = By.id("logonPassword");
    By verifypass = By.id("logonPasswordVerify");
    By emaillabel = By.xpath("//*[@id=\"error-div-logonId\"]/div");
    By verifyemptyemaillabel = By.xpath("//*[@id=\"error-div-verifyLogonId\"]/div");
    By passlabel =By.xpath("//*[@id=\"error-div-logonPassword\"]/div");
    By verifyemptypasslabel = By.xpath("//*[@id=\"error-div-logonPasswordVerify\"]/div");
    By verifyconfermemaillabel = By.xpath("//*[@id=\"error-div-logonId-verifyLogonId\"]/div");
    By verifyconfermpasslabel = By.xpath("//*[@id=\"error-div-logonPassword-logonPasswordVerify\"]/div");
    By generalerror = By.xpath("//*[@id=\"gwt-error-placement-div\"]/div/span");
   
   

    public FGRegisterdemo(WebDriver driver){
       
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



