package Test_Maven_start;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static Test_Maven_start.Config_Data.*;

public class MIF_Order_Post {

    @Test
    public static void MIFORDER() throws InterruptedException {

     System.setProperty("webdriver.chrome.driver", chromepath);
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 80);
    driver.manage().timeouts().pageLoadTimeout(70,TimeUnit.SECONDS);
    Actions action = new Actions(driver);

    /*driver.get("http://qg01064e.safeway.com:5555/");
    driver.manage().window().maximize();*/
    String MIFUSER="Administrator";
        String MIFPASS="manage";

         String URL = "http://" + MIFUSER + ":" + MIFPASS + "@" + "qg01064e.safeway.com:5555";
        driver.get(URL+"/");
        driver.get("http://qg01064e.safeway.com:5555/");

        driver.manage().window().maximize();
        driver.get("http://qg01064e.safeway.com:5555/web/ILS/ILSHelpers/main.jsp");
                driver.findElement(By.xpath("//*[@id='phMenu']")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[@id='mmTab3']")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id='mmCon3']/table/tbody/tr/td/dl/dd[3]/a")).click();
                Thread.sleep(1000);
                driver.switchTo().frame(0);
              WebElement choose=  driver.findElement(By.xpath("//*[@id='fileUpload']"));
              choose.sendKeys("C:\\Users\\Rmoha17\\Desktop\\DataMIF\\9105202.xml");
              Thread.sleep(2000);
              driver.findElement(By.xpath("//*[@id='sendMsg']")).click();
              wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Message posted')]")));

      String result= driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[3]")).getText();
        if(result.equalsIgnoreCase("Message sent to destination successfully")){
            System.out.println("Passed");
        }

          else{
                  System.out.println("Failed");

        }
}}
