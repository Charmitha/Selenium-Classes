	package p1; 
 
import java.io.File; 
 
import org.apache.commons.io.FileUtils; 
import org.openqa.selenium.By; 
import org.openqa.selenium.OutputType; 
import org.openqa.selenium.TakesScreenshot; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver; 
 
public class skill4 { 
  public static void main(String[] args)  throws Exception{ 
     
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");  
        WebDriver driver= new ChromeDriver();  
        driver.get("https://www.amazon./");  
         
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("yellow puma shoe");  
        driver.findElement(By.xpath("//input[@value='Go']")).click();  
        Thread.sleep(5000); 
        WebElement  element = null; 
        element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/div/div/div/div[2]/div[1]/h2/a/span")); 
        String p1 = element.getText(); 
        element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/div/div/div/div[2]/div[3]/div/a/span[2]/span[2]/span[2]")); 
        Integer price1 = Integer.parseInt(element.getText()); 
         
        element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div[2]/div[1]/h2/a/span")); 
        String p2 = element.getText(); 
        element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div[2]/div[3]/div/a/span[2]/span[2]/span[2]")); 
        Integer price2 = Integer.parseInt(element.getText()); 
        System.out.println("Product:  " +p1 +"  price:  " +price1 ); 
        System.out.println("Product:  " +p2+"  price:  " +price2 ); 
        System.out.println("Difference:  "+(Math.abs(price1-price2))); 
         
        TakesScreenshot ts = (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE); 
        FileUtils.copyFile(source, new File("E:/Compare.png")); 
        System.out.println("Screenshot is taken"); 
         
         
 
} 
}