package p1; 
 
import java.util.concurrent.TimeUnit; 
 
import org.openqa.selenium.By; 
import org.openqa.selenium.JavascriptExecutor; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver; 
 
public class skill3 { 
 
  public static void main(String[] args)  throws Exception{ 
    System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe"); 
    WebDriver driver = new ChromeDriver(); 
    driver.get("https://www.amazon.in"); 
    driver.manage().window().maximize(); 
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
     
     
    System.out.println("Title verification"); 
        String actual = driver.getTitle(); 
        String expected= "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"; 
        if(actual.equals(expected)) { 
          System.out.println("Title verified successfully"); 
        } 
           
           
          System.out.println(" Categrozise product-Samsung charger"); 
    driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("charger"); 
    driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click(); 
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  
  WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[3]/span/div[1]/div/div/div[3]/ul/li[5]/span/a/span")); 
   
  element.click(); 
   
   
   
    Thread.sleep(10000); 
     
     
     
           
    System.out.println("Scrollbar Verification"); 
      String execScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;"; 
    JavascriptExecutor scrollBarPresent = (JavascriptExecutor) driver; 
    Boolean test = (Boolean) (scrollBarPresent.executeScript(execScript)); 
    if (test == true) { 
      System.out.print("Scrollbar is present."); 
    } else if (test == false){ 
      System.out.print("Scrollbar is not present."); 
    } 
    driver.close(); 
           
         
         
       
 
  } 
 
}