package p1;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class endlab {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.inviul.com");
		String actualTitle = driver.getTitle();
		driver.manage().window().maximize();
		String expectedTitle = "Avinash Mishra Blogger: Learn Selenium WebDriver, Automation Framework, QA, SEO & Digital Marketing | Inviul Blog | Inviul";
		Assert.assertEquals("Condition true", actualTitle, expectedTitle);
		driver.close();
		driver.quit();

	}

}