package p1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class skill1 {

  public static void main(String[] args) throws InterruptedException
  {
    System.setProperty("webdriver.chrome.driver","/F:\\chromedriver.exe");
    
    WebDriver driver = new ChromeDriver();
    
    driver.get("http://amazon.com/");
    driver.manage().window().maximize();
    Thread.sleep(5000);
    System.out.println(driver.getTitle());
    Thread.sleep(5000);
    
    driver.quit();
    
  }

}