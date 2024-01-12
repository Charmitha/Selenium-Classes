package p1; 
import java.util.concurrent.TimeUnit; 
 
import org.openqa.selenium.By; 
 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver; 
 
public class skill5 { 
 
  public static void main(String[] args)  throws Exception{ 
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe"); 
    WebDriver driver = new ChromeDriver(); 
    driver.get("https://www.amazon.in"); 
    driver.manage().window().maximize(); 
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
     
    driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("mobile"); 
    driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click(); 
     
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
     
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[5]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click(); 
    driver.navigate().to("https://www.amazon.in/Redmi-9A-Sport-Octa-core-Processor/dp/B09GFLXVH9/ref=sr_1_3?crid=2PR4BFITQEC0&keywords=mobile&qid=1659759921&sprefix=mob%2Caps%2C661&sr=8-3"); 
     
     
  String s = driver.findElement(By.xpath("//select[@id='quantity']")).getText(); 
   
  s = s.replace("\n", ""); 
  s=s.trim(); 
  s= s.replace("      ",""); 
  System.out.println("Quantities avaiable for redmi 9A"); 
  System.out.println(s); 
   
  System.out.println("Comparing two mobile"); 
  System.out.println("\n"+ "Redmi 9 Active"); 
   
  driver.navigate().to("https://www.amazon.in/Redmi-Activ-Coral-Green-Storage/dp/B09GFLFMPS/ref=sr_1_6?keywords=mobile&qid=1660277648&sr=8-6&th=1"); 
  Thread.sleep(5000); 
   System.out.println(driver.findElement(By.xpath("//ul[@class='a-unordered-list a-vertical a-spacing-mini']")).getText()); 
    
   System.out.println("\n\n"+ "Samsung M13\n"); 
    
   driver.navigate().to("https://www.amazon.in/Oppo-Mystery-Storage-Additional-Exchange/dp/B08444S68L/ref=sr_1_5?keywords=mobile&qid=1660278907&sr=8-5"); 
   Thread.sleep(5000); 
   System.out.println(driver.findElement(By.xpath("//ul[@class='a-unordered-list a-vertical a-spacing-mini']")).getText()); 
    
   driver.quit(); 
  } 
 
}