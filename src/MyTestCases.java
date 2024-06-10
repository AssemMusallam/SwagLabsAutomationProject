import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	WebDriver driver = new ChromeDriver();

	String myUrl = "https://www.saucedemo.com/inventory.html";
	String userName = "standard_user";
	String password = "secret_sauce";

	@BeforeTest
	public void mySetup() {
		driver.get(myUrl);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void loginTest() {
		// List
		// String [] myStudents = {"ahmad","anas","omar","eman","layan","ethar"};

		WebElement userNameInput = driver.findElement(By.id("user-name"));
		userNameInput.sendKeys(userName);

		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(password);

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
	}

	@Test(priority = 2, enabled = false)
	public void addAllItems() {

		List<WebElement> myAddToCartButtons = driver.findElements(By.className("btn"));

		for (WebElement webElement : myAddToCartButtons) {
			webElement.click();
		}
	}

	@Test(priority = 3, enabled = false)
	public void addOneItemAndSkipTheNextOne() {
		List<WebElement> myAddToCartButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < myAddToCartButtons.size(); i = i + 2) {
			myAddToCartButtons.get(i).click();
		}

	}

	@Test(priority = 4, enabled = false)
	public void addAllExceptTheLastTwoButtons() {
		List<WebElement> myAddToCartButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < myAddToCartButtons.size(); i = i + 1) {
			myAddToCartButtons.get(i).click();
			if (i == 3) {
				break;
			}
		}

	}

	@Test(priority = 5, enabled = false)
	public void addAllExceptTheThirdButtons() {
		List<WebElement> myAddToCartButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < myAddToCartButtons.size(); i = i + 1) {
			if (i == 2) {
				continue;
			}
			myAddToCartButtons.get(i).click();
		}

	}

	@Test(priority = 6)
	public void findAllElementsThatHasTheTextLabs() {
		List<WebElement> itemNames = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> myAddToCartButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < itemNames.size(); i = i + 1) {
			String itemName = itemNames.get(i).getText();
			
			if (itemName.contains("Labs")) {
				myAddToCartButtons.get(i).click();
			}

		}

	}

}
