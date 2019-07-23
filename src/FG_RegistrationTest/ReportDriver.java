package FG_RegistrationTest;

import org.openqa.selenium.WebDriver;

public class ReportDriver {
	private static WebDriver driver;
public	ReportDriver(WebDriver driver){
		this.driver=driver;
	}
public static WebDriver getDriver(){
	return driver;
}
}
