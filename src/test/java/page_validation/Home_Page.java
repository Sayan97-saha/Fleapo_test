package page_validation;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Home_Page extends base_class{
	
	@FindBy(xpath = "//button[text()='✕']")
	private List<WebElement> close_login_popup;
	
	@FindBy(xpath = "//input[@name='q' or @title = 'Search for products, brands and more' or @title = 'Search for products, Brands and More']")
	private WebElement product_search_box;
	
	@FindBy(xpath = "//button[text()='CHAT WITH ME']")
	private WebElement chat_with_me_btn;
	
	@FindBy(xpath = "//h3[text()='Chat with me']/parent::div/button")
	private WebElement lets_start_btn;
	
	@FindBy(xpath = "//input[@type='tel']")
	private WebElement tel_num_field;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement continue_btn;
	
	@FindBy(xpath = "//input[@autocomplete='one-time-code']")
	private List<WebElement> otp_fields;
	
	@FindBy(xpath = "//div[contains(@class, 'chat-content-scroll')]")
	private WebElement scrollable_chat;
	
	@FindBy(xpath = "//p[text()='Click to preview']/parent::div//following-sibling::img")
	private WebElement image_link;
	
	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void fleapo_test_method()throws Throwable{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(chat_with_me_btn));
			chat_with_me_btn.click();
			Reporter.log("Clicked on 'CHAT WITH ME'\n");
			wait.until(ExpectedConditions.elementToBeClickable(lets_start_btn));
			lets_start_btn.click();
			Reporter.log("Clicked on 'Let's start'\n");
			wait.until(ExpectedConditions.elementToBeClickable(tel_num_field));
			tel_num_field.sendKeys("1111111111");
			Reporter.log("Provided telephone number as '+911111111111'");
			continue_btn.click();
			Reporter.log("Clicked on 'Continue'\n");
			wait.until(ExpectedConditions.visibilityOfAllElements(otp_fields));
			for(int i = 0; i < otp_fields.size(); i++) {
				(otp_fields.get(i)).sendKeys(("123456").split("")[i]);
			}
			Reporter.log("Provided OTP\n");
			wait.until(ExpectedConditions.elementToBeClickable(scrollable_chat));
			wait.until(ExpectedConditions.elementToBeClickable(image_link));
			image_link.click();
			Reporter.log("Clicked on Image");
			driver.quit();
			Assert.assertTrue(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	
	
	

	
	
	
	

}
