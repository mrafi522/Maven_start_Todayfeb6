package Test_Maven_start;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class OMS_Login {

    public static WebDriver driver;
    public  static WebDriverWait wait;

    @Test
    public static void login() throws InterruptedException {

        	System.setProperty("webdriver.chrome.driver",Config_Data.chromepath);
        	driver=new ChromeDriver();
        	Actions action=new Actions(driver);

        wait = new WebDriverWait(driver, 100);

            driver.get("http://qg01064e.safeway.com:13000/");

            driver.manage().window().maximize();
            WebElement user=driver.findElement(By.name("j_username"));
            user.sendKeys("eomadmin");
            WebElement password=driver.findElement(By.name("j_password"));
            password.sendKeys("Password1!");

              password.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'1211') or contains(text(),'1502') or contains(text(),'1296')]")));
        WebElement store=driver.findElement(By.xpath("//div[contains(text(),'1211') or contains(text(),'1502') or contains(text(),'1296')]"));
        action.doubleClick(store).perform();
        driver.findElements(By.xpath("//*[@class='x-component  wt-tile-title x-box-item x-component-default']")).get(3).sendKeys("Tote");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='x-btn-icon-el x-btn-icon-el-default-toolbar-medium wt-topbar-menu-icon ']")));
        WebElement MenuS=driver.findElement(By.xpath("//span[@class='x-btn-icon-el x-btn-icon-el-default-toolbar-medium wt-topbar-menu-icon ']"));
        MenuS.click();
        Thread.sleep(1000);
        driver.findElements(By.xpath("//*[@class='x-component  wt-tile-title x-box-item x-component-default']")).get(3).sendKeys("Tote");
        WebElement store2=driver.findElement(By.xpath("//input[@class='x-form-field x-form-text x-form-text-default ']"));
        store2.click();
        store2.sendKeys("Tote Management");
        Thread.sleep(1000);
        store2.sendKeys(Keys.ENTER);


    }
}
