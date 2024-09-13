package scripts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class baseclass {
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String suiteName;
	 static WebDriver driver;
	 ExtentReports ex;
	 @BeforeSuite
		public static void setUp(ITestContext ctx) {

			// String currentDate=getDateTime();
			suiteName = ctx.getCurrentXmlTest().getSuite().getName();
			htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/" + suiteName + ".html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);

			extent.setSystemInfo("OS", "Windows");
			extent.setSystemInfo("Host Name", "CI");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("User Name", "QA_User");

			
			htmlReporter.config().setDocumentTitle("AutomationTesting Report");
			htmlReporter.config().setReportName("testReport");
			
			htmlReporter.config().setTheme(Theme.STANDARD);
		}

	@BeforeTest
	public void setup() {
		 driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

		@AfterMethod
		public void getResult(ITestResult result) throws IOException {
			if (result.getStatus() == ITestResult.FAILURE) {
				
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getTestName() + " Test case FAILED due to below issues:",
						ExtentColor.RED));
				test.fail(result.getThrowable());
				
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				test.log(Status.PASS, MarkupHelper.createLabel(result.getTestName() + " Test Case PASSED", ExtentColor.GREEN));
			} else {
				test.log(Status.SKIP,
						MarkupHelper.createLabel(result.getTestName()+ " Test Case SKIPPED", ExtentColor.ORANGE));
				test.skip(result.getThrowable());
			}
			extent.flush();
		}

		@AfterSuite 
		public void tearDown() throws Exception {
			System.out.println("In After Suite");
			
		}
		
		
	
	}


