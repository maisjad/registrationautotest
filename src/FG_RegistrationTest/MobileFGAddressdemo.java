package FG_RegistrationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MobileFGAddressdemo extends FGAddressdemo{
	WebDriver driver;
	 By save=By.xpath("//*[@id=\"register-form\"]/div[2]/button");
	 By fn=By.id("field-7"); 
	 By ln=By.id("field-9");
	 By mn=By.id("field-8"); 
	 By phone1=By.id("field-16");
	 By phone2=By.id("field-17");
	 By str1=By.id("field-11");
	 By str2=By.id("field-12");
	 By company=By.id("field-10");
	 By state=By.id("field-14"); 
	// By region=By.id("bill_country-name");
	 By city=By.id("field-13");
	 By code=By.id("field-15");
	 By samebilladdress=By.id("field-18");
	 By shipfn=By.id("field-19"); 
	 By shipln=By.id("field-21");
	 By shipmn=By.id("field-20"); 
	 By shipphone1=By.id("field-27");
	 By shipphone2=By.id("field-28");
	 By shipstr1=By.id("field-22");
	 By shipstr2=By.id("field-23");
	 By shipcompany=By.id("field-21");
	 By shipstate=By.id("field-25"); 
	// By shipregion=By.id("ship_country-name");
	 By shipcity=By.id("field-24");
	 By shipcode=By.id("field-26");
	 By fnlabel=By.xpath("//*[@id=\"register-form\"]/div[1]/div[2]/div/div/div/div[1]/div[1]/div/div/div/div[2]");
	 By lnlabel=By.xpath("//*[@id=\"register-form\"]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[2]");
	 By strlabel=By.xpath("//*[@id=\"register-form\"]/div[1]/div[2]/div/div/div/div[4]/div/div/div/div/div[2]");
	 By citylabel=By.xpath("//*[@id=\"register-form\"]/div[1]/div[2]/div/div/div/div[6]/div/div/div/div/div[2]");
	 By codelabel=By.xpath("//*[@id=\"register-form\"]/div[1]/div[2]/div/div/div/div[8]/div/div/div/div/div[2]");
	 By regoinlabel=By.xpath("//*[@id=\"register-form\"]/div[1]/div[2]/div/div/div/div[8]/div/div/div/div/div[2]");
	 By phonelabel=By.xpath("//*[@id=\"register-form\"]/div[1]/div[2]/div/div/div/div[9]/div/div/div/div/div[2]");
	 By errcodelabel=By.xpath("//*[@id=\"register-form\"]/div[1]/div[2]/div/div/div/div[8]/div/div/div/div/div[2]");
	 By sfnlabel=By.xpath("//*[@id=\"register-form\"]/div[1]/div[3]/div[2]/div/div[1]/div[1]/div/div/div/div[2]");
	 By slnlabel=By.xpath("//*[@id=\"register-form\"]/div[1]/div[3]/div[2]/div/div[2]/div/div/div/div/div[2]");
	 By sstrlabel=By.xpath("//*[@id=\"register-form\"]/div[1]/div[3]/div[2]/div/div[4]/div/div/div/div/div[2]");
	 By scitylabel=By.xpath("//*[@id=\"register-form\"]/div[1]/div[3]/div[2]/div/div[6]/div/div/div/div/div[2]");
	 By scodelabel=By.xpath("//*[@id=\"register-form\"]/div[1]/div[3]/div[2]/div/div[8]/div/div/div/div/div[2]");
	 By sregoinlabel=By.xpath("//*[@id=\"register-form\"]/div[1]/div[3]/div[2]/div/div[7]/div/div[2]");
	 By sphonelabel=By.xpath("//*[@id=\"register-form\"]/div[1]/div[3]/div[2]/div/div[9]/div/div/div/div/div[2]");
	 By serrcodelabel=By.xpath("//*[@id=\"register-form\"]/div[1]/div[3]/div[2]/div/div[8]/div/div/div/div/div[2]");
	 public MobileFGAddressdemo(WebDriver driver){
		 super(driver);
	    	this.driver = driver;
	       }	
	 public String getLNLabel(){
	    	try{
	    	return driver.findElement(lnlabel).getText();}
	    	catch (NoSuchElementException e){
	    	System.out.print(e.getMessage());
	    	}
	    	return "!!";
	    	
	       }
	 public String getcodeLabel(){
	    	try{
	    	return driver.findElement(codelabel).getText();}
	    	catch (NoSuchElementException e){
	    	System.out.print(e.getMessage());
	    	}
	    	return "!!";
	    	
	       }
	 public String getCityLabel(){
	    	try{
	    	return driver.findElement(citylabel).getText();}
	    	catch (NoSuchElementException e){
	    	System.out.print(e.getMessage());
	    	}
	    	return "!!";
	    	
	       }
	 public String getstrLabel(){
	    	try{
	    	return driver.findElement(strlabel).getText();}
	    	catch (NoSuchElementException e){
	    	System.out.print(e.getMessage());
	    	}
	    	return "!!";
	    	
	       }
	 public String getPhoneLabel(){
	    	try{
	    	return driver.findElement(phonelabel).getText();}
	    	catch (NoSuchElementException e){
	    	System.out.print(e.getMessage());
	    	}
	    	return "!!";
	    	
	       }
	 public String getErrCodeLabel(){
	    	try{
	    	return driver.findElement(errcodelabel).getText();}
	    	catch (NoSuchElementException e){
	    	System.out.print(e.getMessage());
	    	}
	    	return "!!";
	    	
	       }
	 public String getFNLabel(){
	    	try{
	    	return driver.findElement(fnlabel).getText();}
	    	catch (NoSuchElementException e){
	    	System.out.print(e.getMessage());
	    	}
	    	return "!!";
	    	
	       }
	 public String getRegoinLabel(){
	    	try{
	    	return driver.findElement(regoinlabel).getText();}
	    	catch (NoSuchElementException e){
	    	System.out.print(e.getMessage());
	    	}
	    	return "!!";
	    	
	       }
	 public String getSRegoinLabel(){
	    	try{
	    	return driver.findElement(sregoinlabel).getText();}
	    	catch (NoSuchElementException e){
	    	System.out.print(e.getMessage());
	    	}
	    	return "!!";
	    	
	       }
	 
	 public String getSLNLabel(){
	    	try{
	    	return driver.findElement(slnlabel).getText();}
	    	catch (NoSuchElementException e){
	    	System.out.print(e.getMessage());
	    	}
	    	return "!!";
	    	
	       }
	 public String getScodeLabel(){
	    	try{
	    	return driver.findElement(scodelabel).getText();}
	    	catch (NoSuchElementException e){
	    	System.out.print(e.getMessage());
	    	}
	    	return "!!";
	    	
	       }
	 public String getSCityLabel(){
	    	try{
	    	return driver.findElement(scitylabel).getText();}
	    	catch (NoSuchElementException e){
	    	System.out.print(e.getMessage());
	    	}
	    	return "!!";
	    	
	       }
	 public String getSstrLabel(){
	    	try{
	    	return driver.findElement(sstrlabel).getText();}
	    	catch (NoSuchElementException e){
	    	System.out.print(e.getMessage());
	    	}
	    	return "!!";
	    	
	       }
	 public String getSPhoneLabel(){
	    	try{
	    	return driver.findElement(sphonelabel).getText();}
	    	catch (NoSuchElementException e){
	    	System.out.print(e.getMessage());
	    	}
	    	return "!!";
	    	
	       }
	 public String getSErrCodeLabel(){
	    	try{
	    	return driver.findElement(serrcodelabel).getText();}
	    	catch (NoSuchElementException e){
	    	System.out.print(e.getMessage());
	    	}
	    	return "!!";
	    	
	       }
	 public String getSFNLabel(){
	    	try{
	    	return driver.findElement(sfnlabel).getText();}
	    	catch (NoSuchElementException e){
	    	System.out.print(e.getMessage());
	    	}
	    	return "!!";
	    	
	       }
	 

	public void setbillNames(String fn,String mn,String ln,String com){
		  try {
	     driver.findElement(this.fn).sendKeys(fn);
         driver.findElement(this.mn).sendKeys(mn);
         driver.findElement(this.ln).sendKeys(ln);
         driver.findElement(this.company).sendKeys(com);
         }
		  catch (NoSuchElementException e){
		    	System.out.print(e.getMessage());
		    	}
		 
	 }
	 public void setbilladdrss(String str1,String str2,String city,String code,String region,String state){
		try{ driver.findElement(this.str1).sendKeys(str1);
         driver.findElement(this.str2).sendKeys(str2);
         driver.findElement(this.city).sendKeys(city);
         driver.findElement(this.code).sendKeys(code);
       
	     Select drpCountry1 = new Select(driver.findElement(this.state));
	        drpCountry1.selectByVisibleText(state);}
		catch (NoSuchElementException e){
	    	System.out.print(e.getMessage());
	    	}
	    	
	    	
	       
	 }
	 public void setbillphone(String ph1,String ph2){
		 driver.findElement(this.phone1).sendKeys(ph1);
         driver.findElement(this.phone2).sendKeys(ph2); 
	 }
	 
	 public void setshipNames(String fn,String mn,String ln,String com){
		 driver.findElement(this.shipfn).sendKeys(fn);
         driver.findElement(this.shipmn).sendKeys(mn);
         driver.findElement(this.shipln).sendKeys(ln);
         driver.findElement(this.shipcompany).sendKeys(com);
		 
	 }
	 public void setshipaddrss(String str1,String str2,String city,String code,String region,String state){
	try{	 driver.findElement(this.shipstr1).sendKeys(str1);
         driver.findElement(this.shipstr2).sendKeys(str2);
         driver.findElement(this.shipcity).sendKeys(city);
         driver.findElement(this.shipcode).sendKeys(code);
        
	     Select drpCountry1 = new Select(driver.findElement(this.shipstate));
	        drpCountry1.selectByVisibleText(state);}
	catch (NoSuchElementException e){
    	System.out.print(e.getMessage());
    	}
    
	 }
	 public void setshipphone(String ph1,String ph2){
		 driver.findElement(this.shipphone1).sendKeys(ph1);
         driver.findElement(this.shipphone2).sendKeys(ph2); 
	 }
	 public void hasshipaddress(){
		 driver.findElement(samebilladdress).click();
	 }
	 public void clicksave(){
		 driver.findElement(save).click();
	 }
	 
	public WebDriver getDriver(){return driver;}    
}
