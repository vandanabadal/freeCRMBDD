//package StepDefinition;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//
//import cucumber.api.PendingException;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//import org.junit.Assert;
//
//public class LoginStepDefinition {
//	static WebDriver driver;
//	static String title1;
//
//	@Given("^User is already present on Login Page$")
//	public void user_is_already_present_on_Login_Page() {
//
//		System.setProperty("webdriver.gecko.driver", "C://Selenium_Van/geckodriver.exe");
//		driver = new FirefoxDriver();
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.get("https://classic.crmpro.com/index.html");
//
//	}
//
//	@When("^title of login page is Free CRM$")
//	public void title_of_login_page_is_Free_CRM() {
//		String title = driver.getTitle();
//		System.out.println("Title of Login Page    " + title);
//		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", title);
//		// driver.findElement(By.name("username")).sendKeys("javaselenium4321");
//		// driver.findElement(By.name("password")).sendKeys("java1234");
//
//	}
//
//	@Then("^User enters username \"([^\"]*)\"$")
//	public void user_enters_username(String username) throws Throwable {
//		Thread.sleep(3000);
//		driver.findElement(By.name("username")).sendKeys(username);
//
//	}
//
//	@Then("^User enters password \"([^\"]*)\"$")
//	public void user_enters_password(String password) {
//		driver.findElement(By.name("password")).sendKeys(password);
//
//	}
//
//	@Then("^User clicks on Login button$")
//	public void user_clicks_on_Login_button() throws InterruptedException {
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
//
//	}
//
//	@Then("^user is on home page$")
//
//	public void user_is_on_home_page() {
//
//		title1 = driver.getTitle();
//		System.out.println("Home Page is    " + title1);
//		Assert.assertEquals("CRMPRO", title1);
//
//	}
//
///*	@Given("^User is on homepage$")   //uncomment for login feature file
//	public void user_is_on_homepage() {
//		Assert.assertEquals("CRMPRO", title1);
//	} */
//
//	@Then("^user mouse over on contacts link$")   //use @when for login feature file
//	public void user_mouse_over_on_contacts_link() throws InterruptedException {		
//		driver.switchTo().frame("mainpanel");
//		Actions action = new Actions(driver);
//		WebElement contact = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
//		action.moveToElement(contact).build().perform();
//		Thread.sleep(3000);
//
//	}
//
//	@Then("^user clicks on New Contact link$")
//	public void user_clicks_on_New_Contact_link() {
//		WebElement newContact = driver.findElement(By.xpath("//a[contains(text(), 'New Contact')]"));
//		newContact.click();
//	}
//
//	@Then("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
//	public void user_enters_and(String firstname, String lastname) throws Throwable {
//		Thread.sleep(3000);
//		driver.findElement(By.id("first_name")).sendKeys(firstname);
//		driver.findElement(By.id("surname")).sendKeys(lastname);
//	}
//
//	@Then("^user clicks on save button$")
//	public void user_clicks_on_save_button() throws InterruptedException {
//		Thread.sleep(3000);
//		// driver.findElement(By.xpath("//input[contains(@type='submit' and
//		// @value='Save')]")).click();
//		driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
//		// + "and @value='save')]")).click();
//	} 
//
//	/*
//	 * @Then("^user verifies new contact name$") public void
//	 * user_verfies_new_contact_name() { String name =
//	 * driver.findElement(By.xpath("//td[contains(text(),'Shahrukh Khan')]")).
//	 * getText();
//	 * 
//	 * System.out.println("Saved Contact Name is   "+ name); }
//	 * 
//	 */
//
//	@Then("^user close the browser$")
//	public void user_close_the_browser() {
//		driver.quit();
//
//	}
//
//}*/
