package Test_Maven_start;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Profile_Creation {
    public int i;
    public  static WebDriver driver;
    @Test
        public void profile() throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Rmoha17\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
         driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 80);
        driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        FileInputStream fis=new FileInputStream("C:\\Users/rmoha17/Desktop/Projects/Test_data.xls");
        HSSFWorkbook WB=new HSSFWorkbook(fis);
        HSSFSheet sheet=WB.getSheetAt(1);
        int Rcount =sheet.getLastRowNum();
        for (i=5;i<=Rcount;i++){
        HSSFRow FRC=sheet.getRow(i);
        String Fname=FRC.getCell(0).getStringCellValue();
        String Lname=FRC.getCell(1).getStringCellValue();
        String Address=FRC.getCell(2).getStringCellValue();
        int  Zipcode=(int)FRC.getCell(3).getNumericCellValue();
        String emailid=FRC.getCell(4).getStringCellValue();
        String password=FRC.getCell(5).getStringCellValue();
        int security=(int)FRC.getCell(6).getNumericCellValue();
        String phone=FRC.getCell(7).getStringCellValue();
            driver = new ChromeDriver();
        driver.get("https://shopecomqa.safeway.com/ecom/account/sign-in");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@href='/ecom/account/register?ZipCode=']")).click();
        driver.findElement(By.xpath("//*[@name='Register.ZipCode']")).sendKeys(String.valueOf(Zipcode));
        driver.findElement(By.xpath("//*[@class='submit btn-round ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='FirstName']")).sendKeys(String.valueOf(Fname));
        driver.findElement(By.xpath("//*[@id='LastName']")).sendKeys(String.valueOf(Lname));
        Select dropdown=new Select(driver.findElement(By.xpath("//*[@id='CustomerType']")));
        dropdown.selectByIndex(1);
        driver.findElement(By.xpath("//*[@id='Address1']")).sendKeys(String.valueOf(Address));
        Select drop1=new Select(driver.findElement(By.xpath("//*[@name='HowRecommended']")));
        drop1.selectByIndex(1);
        driver.findElement(By.xpath("//*[@name='EmailAddress']")).sendKeys(String.valueOf(emailid));
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(String.valueOf(password));
        Select drop2=new Select(driver.findElement(By.xpath("//*[@id='SecurityQuestion']")));
        drop2.selectByIndex(1);
        driver.findElement(By.xpath("//*[@name='SecurityAnswer']")).sendKeys(String.valueOf(security));
        driver.findElement(By.xpath("//*[@id='ClubCard']")).sendKeys(String.valueOf(phone));
        driver.findElement(By.xpath("//*[@name='TermsAndConditions']")).click();
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement  scorl1= driver.findElement(By.xpath("//*[@name='form-Registration']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", scorl1);
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@name='form-Registration']")).click();
        try {
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id='form-registration']/div[1]/ul/li/span")).isEnabled();
            driver.close();
        } catch (Exception E) {
            wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@class='id-count']"))));
            String Cartcount = driver.findElement(By.xpath("//*[@class='id-count']")).getText();
            System.out.println("Cart Count" + Cartcount);
            driver.close();
        } }
}}
