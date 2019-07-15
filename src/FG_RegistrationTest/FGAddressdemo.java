package FG_RegistrationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FGAddressdemo {
	WebDriver driver;
	 By save=By.xpath("//*[@id=\"gwt_billshipaddr_btn\"]/button");
	 By fn=By.id("bill_fnbox"); 
	 By ln=By.id("bill_mibox");
	 By mn=By.id("bill_lnbox"); 
	 By phone1=By.id("bill_phone1box");
	 By phone2=By.id("bill_phone2box");
	 By str1=By.id("bill_sa1box");
	 By str2=By.id("bill_sa1box");
	 By company=By.id("bill_cnbox");
	 By state=By.id("bill_region"); 
	 By region=By.id("bill_country-name");
	 By city=By.id("bill_citybox");
	 By code=By.id("bill_zipbox");
	 By samebilladdress=By.id("gwt-uid-286");
	 By shipfn=By.id("ship_fnbox"); 
	 By shipln=By.id("ship_mibox");
	 By shipmn=By.id("ship_lnbox"); 
	 By shipphone1=By.id("ship_phone1box");
	 By shipphone2=By.id("ship_phone2box");
	 By shipstr1=By.id("ship_sa1box");
	 By shipstr2=By.id("ship_sa1box");
	 By shipcompany=By.id("ship_cnbox");
	 By shipstate=By.id("ship_region"); 
	 By shipregion=By.id("ship_country-name");
	 By shipcity=By.id("ship_citybox");
	 By shipcode=By.id("ship_zipbox");
	 By fnlabel=By.xpath("//*[@id=\"error-div-bill_fnbox\"]/div");
	 By lnlabel=By.xpath("//*[@id=\"error-div-bill_lnbox\"]/div");
	 By strlabel=By.xpath("//*[@id=\"error-div-bill_sa1box\"]/div");
	 By citylabel=By.xpath("//*[@id=\"error-div-bill_citybox\"]/div");
	 By codelabel=By.xpath("//*[@id=\"error-div-bill_zipbox\"]/div");
	 By regoinlabel=By.xpath("//*[@id=\"error-div-bill_country-name\"]/div");
	 By phonelabel=By.xpath("//*[@id=\"error-div-bill_phone1box\"]/div");
	 By errcodelabel=By.xpath("//*[@id=\"error-div-bill_country-name-bill_region-bill_zipbox\"]/div");
	 By sfnlabel=By.xpath("//*[@id=\"error-div-ship_fnbox\"]/div");
	 By slnlabel=By.xpath("//*[@id=\"error-div-ship_lnbox\"]/div");
	 By sstrlabel=By.xpath("//*[@id=\"error-div-ship_sa1box\"]/div");
	 By scitylabel=By.xpath("//*[@id=\"error-div-ship_citybox\"]/div");
	 By scodelabel=By.xpath("//*[@id=\"error-div-ship_zipbox\"]/div");
	 By sregoinlabel=By.xpath("//*[@id=\"error-div-ship_country-name\"]/div");
	 By sphonelabel=By.xpath("//*[@id=\"error-div-ship_phone1box\"]/div");
	 By serrcodelabel=By.xpath("//*[@id=\"error-div-ship_country-name-bill_region-bill_zipbox\"]/div");
	 public FGAddressdemo(WebDriver driver){
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
         Select drpCountry = new Select(driver.findElement(this.region));
			drpCountry.selectByVisibleText(region);
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
         Select drpCountry = new Select(driver.findElement(this.shipregion));
			drpCountry.selectByVisibleText(region);
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
