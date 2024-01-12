package p1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class skill9 {

  public static void main(String[] args) throws Exception{
    System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");  
        WebDriver driver= new ChromeDriver();  
        driver.get("https://newerp.kluniversity.in/");
        driver.manage().window().maximize();
        driver.findElement(By.className("img-responsive")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("loginform-username")).sendKeys("");             //REG. ID
        driver.findElement(By.id("loginform-password")).sendKeys("");                      //ERP PASSWORD
        driver.findElement(By.name("login-button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/nav/div/div[2]/ul/li/form/button")).click();
        driver.quit();
        

  }

}