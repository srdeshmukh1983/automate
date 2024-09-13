package scripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;






public class orangetest extends baseclass{
	
	
	WebDriver driver;
	 ExtentReports ex;
	 orange.pageobjects.OrangePageLogin orageobj;
	@Test
	public void login() {
		orageobj = new orange.pageobjects.OrangePageLogin(baseclass.driver);
	orageobj.clickonlogin();
	}
	@BeforeClass
	public void generatereport() {
		ExtentSparkReporter report = new ExtentSparkReporter("../automate/reports/extentreport.html");
		report.config().setDocumentTitle("automation report for orange");
		report.config().setReportName("sriram deshmukh");
		report.config().setTheme(Theme.DARK);
		 ex = new ExtentReports();
		ex.attachReporter(report);
	}
	
	
			
	@Test
	public void  verifytitle() {
		orageobj.verifyTitle();
		
	}
	@AfterSuite()
	public void flush(){
	{
		ex.flush();
		
		
		
		
	}
		
	}
}


