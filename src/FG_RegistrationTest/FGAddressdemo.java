package FG_RegistrationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FGAddressdemo {
	
	
		WebDriver driver;
		 By save;
		 By fn; 
		 By ln;
		 By mn; 
		 By phone1;
		 By phone2;
		 By str1;
		 By str2;
		 By company;
		 By state; 
		// By region=By.id("bill_country-name");
		 By city;
		 By code;
		 By samebilladdress;
		 By shipfn; 
		 By shipln;
		 By shipmn; 
		 By shipphone1;
		 By shipphone2;
		 By shipstr1;
		 By shipstr2;
		 By shipcompany;
		 By shipstate; 
		// By shipregion=By.id("ship_country-name");
		 By shipcity;
		 By shipcode;
		 By fnlabel;
		 By lnlabel;
		 By strlabel;
		 By citylabel;
		 By codelabel;
		 By regoinlabel;
		 By phonelabel;
		 By errcodelabel;
		 By sfnlabel;
		 By slnlabel;
		 By sstrlabel;
		 
		 By scitylabel;
		 By scodelabel;
		 By sregoinlabel;
		 By sphonelabel;
		 By serrcodelabel;
		 public FGAddressdemo(WebDriver driver){
		    	this.driver = driver;
		       }	
		 public String getLNLabel(){
		    	
		    	return "!!";
		    	
		       }
		 public String getcodeLabel(){
		    	
		    	return "!!";
		    	
		       }
		 public String getCityLabel(){
		    	
		    	return "!!";
		    	
		       }
		 public String getstrLabel(){
		    	
		    	return "!!";
		    	
		       }
		 public String getPhoneLabel(){
		    	
		    	return "!!";
		    	
		       }
		 public String getErrCodeLabel(){
		    	
		    	return "!!";
		    	
		       }
		 public String getFNLabel(){
		    	
		    	return "!!";
		    	
		       }
		 public String getRegoinLabel(){
		    	
		    	return "!!";
		    	
		       }
		 public String getSRegoinLabel(){
		    	
		    	return "!!";
		    	
		       }
		 
		 public String getSLNLabel(){
		    	
		    	return "!!";
		    	
		       }
		 public String getScodeLabel(){
		    
		    	return "!!";
		    	
		       }
		 public String getSCityLabel(){
		    	
		    	return "!!";
		    	
		       }
		 public String getSstrLabel(){
		    	
		    	return "!!";
		    	
		       }
		 public String getSPhoneLabel(){
		    	
		    	return "!!";
		    	
		       }
		 public String getSErrCodeLabel(){
		    	
		    	return "!!";
		    	
		       }
		 public String getSFNLabel(){
		    	
		    	return "!!";
		    	
		       }
		 

		public void setbillNames(String fn,String mn,String ln,String com){
		
		 }
		 public void setbilladdrss(String str1,String str2,String city,String code,String region,String state){
			
		    	
		       
		 }
		 public void setbillphone(String ph1,String ph2){
			
		 }
		 
		 public void setshipNames(String fn,String mn,String ln,String com){
			
			 
		 }
		 public void setshipaddrss(String str1,String str2,String city,String code,String region,String state){
		
	    
		 }
		 public void setshipphone(String ph1,String ph2){

		 }
		 public void hasshipaddress(){
			 
		 }
		 public void clicksave(){
		 }
		 
		public WebDriver getDriver(){return driver;}    
	

}
