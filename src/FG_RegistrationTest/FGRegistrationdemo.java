package FG_RegistrationTest;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class FGRegistrationdemo {
	

	

		WebDriver driver;
	    
	    By email ;
	    By submit ;
	    By verifyemail ;
	    By pass ;
	    By verifypass ;
	    By emaillabel ;
	    By verifyemptyemaillabel ;
	    By passlabel ;
	    By verifyemptypasslabel ;
	    By verifyconfermemaillabel ;
	    By verifyconfermpasslabel;
	    By generalerror ;
	   
	   

	    public FGRegistrationdemo(WebDriver driver){
	       
	    	this.driver = driver;
	    	}	
	    
	    
	    public void clickcontinue(){
	       
	    	
	       }

	    public void setEmail(String str){
		   
	    
		   }
	    public void setVEmail(String str){
		   
	    	
		   }
	    public void setPass(String str){
		   
	    	
	    	
		   }
	    public void setVPass(String str){
		   
	    	
		   }
	    
	    
	    public String getEmailLabel(){
	    	
	    	return "!!";
	    	
	       }
	    public String getVerifyEmptyEmailLabel(){
	    	
	        	return "!!";
	    
	       }
	    public String getPassLabel(){
	    	
	        	return "!!";
	    	
	       }
	    public String getVerifyEmptyPassLabel(){
	    	
	        	return "!!";
	    	
	       }
	    public String getVerifyConfermEmailLabel(){
	    	
	        	return "!!";
	    	
	       }
	    public String getVerifyConfermPassLabel(){
	    	
	        	return "!!";
	    	
	       }
	    public String getGeneralError(){
	    	
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
