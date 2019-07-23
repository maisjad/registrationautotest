package FG_RegistrationTest;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ReportDriver {
	private static WebDriver driver;
	private static String platform;
	private static String method;
public	ReportDriver(WebDriver driver){
		this.driver=driver;
	}
public static WebDriver getDriver(){
	return driver;
}
public void setplatform(String str){
	platform=str;
}
public static  String getplatform(){
	return platform;
}
public void setmethod(String str){
	method=str;
}
public static  String getmethod(){
	return method;
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

}
