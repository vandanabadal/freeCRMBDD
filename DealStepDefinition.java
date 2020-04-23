package StepDefinition;
// Map Object using DataTable concept for data driven Cucumber
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class DealStepDefinition {
	 WebDriver driver;
	
	@Given("^user is already present on Login Page$")
	public void user_is_already_present_on_Login_Page()  {
		System.setProperty("webdriver.gecko.driver", "C://Selenium_Van/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://classic.crmpro.com/index.html");
	}

	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_Free_CRM() throws Throwable {
		Thread.sleep(2000);
		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", driver.getTitle());
	   
	}

	//Map saves values as key and value-- key is header name (columns) and value is the each row
	@Then("^user enters username and password$")
	public void user_enters_username_and_password(DataTable credentials) throws Throwable {
	 for( Map<String, String> logindata : credentials.asMaps(String.class, String.class)) {
		 
		 driver.findElement(By.name("username")).sendKeys(logindata.get("username"));// header name from feature file, gets value from under it
		 driver.findElement(By.name("password")).sendKeys(logindata.get("password"));
		 
	 }
	   
	    
	}

	@Then("^user clicks on Login button$")
	public void user_clicks_on_Login_button() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	   
	}

	@Then("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
		String title1 = driver.getTitle();
		System.out.println("Home Page is    " + title1);
		Assert.assertEquals("CRMPRO", title1);
	   
	}

	@Then("^user moves to deal page$")
	public void user_moves_to_deal_page() throws Throwable {
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		WebElement deal = driver.findElement(By.xpath("//a[contains(text(),'Deals')]"));
		action.moveToElement(deal).build().perform();
		WebElement newDeal = driver.findElement(By.xpath("//a[contains(text(), 'New Deal')]"));
		newDeal.click();
		
		Thread.sleep(3000);
	
	}

	@Then("^user uploads new deal$")
	public void user_uploads_new_deal(DataTable credentials1) throws Throwable {
	    for(Map<String, String> dealdata : credentials1.asMaps(String.class, String.class)) {
	    	driver.findElement(By.id("title")).sendKeys(dealdata.get("Title"));
	    	driver.findElement(By.id("amount")).sendKeys(dealdata.get("Amount"));
	    	driver.findElement(By.id("probability")).sendKeys(dealdata.get("Probability"));
	    	driver.findElement(By.id("commission")).sendKeys(dealdata.get("Commission"));
	    	
	    	//save
	    	
			driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
			Thread.sleep(3000);
			System.out.println("Save deal " + dealdata.get("Title"));
			
			//again go to new deal home page
			driver.findElement(By.xpath("//a[contains(text(),'Deals')]")).click();
			Thread.sleep(2000);
			click_on_new_deal();
			
//	    	Actions action1 = new Actions(driver);
//	   
////			WebElement deal1 = driver.findElement(By.xpath("//a[contains(text(),'Deals')]"));
////			System.out.println("got object Deals");
//			action1.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Deals')]"))).build().perform();
//			driver.findElement(By.xpath("//a[contains(text(), 'New Deal')]")).click();
//			Thread.sleep(2000);
////			System.out.println("New Deals Clicked");
			
	    }
	    
	}
	
	public void click_on_new_deal() throws InterruptedException{
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Deals')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(), 'New Deal')]")).click();
		Thread.sleep(2000);
		
	}

	@Then("^user clicks on save button$")
	public void user_clicks_on_save_button() throws Throwable {
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
	  
	}

	@Then("^user closes the browser$")
	public void user_closes_the_browser() throws Throwable {
	   driver.quit();
	}



}
