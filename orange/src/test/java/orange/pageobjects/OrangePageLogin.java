package orange.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import scripts.baseclass;

public class OrangePageLogin  {
	static WebDriver driver;
	@FindBy(name="username") WebElement username ;
	@FindBy(name="password") WebElement password; 
	@FindBy(xpath="//button[text()=\" Login \"]") WebElement loginbutton; 
	
	
	public OrangePageLogin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	public void verifyTitle() {
	Assert.assertEquals("OrngeHRM",driver.getTitle());	
	}
	public void clickonlogin() {
		username.sendKeys("admin");
		password.sendKeys("admin123");
		loginbutton.click();
	
	}
	

}
