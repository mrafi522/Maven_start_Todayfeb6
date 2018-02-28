package Test_Maven_start;

import org.apache.poi.hssf.usermodel.HSSFCell;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Test_Maven_start.Adding_Items.Emailid;

public class Profile_Creation {
    public int i;
    public WebDriver driver;
    public static  String methodName;
    public  static String emailid;
    public  static HSSFRow FRC;
    public static HSSFCell Ccell;

    @Test
    public void profile() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", Config_Data.chromepath);

        FileInputStream fis = new FileInputStream(Config_Data.Datasheet);
        HSSFWorkbook WB = new HSSFWorkbook(fis);
        HSSFSheet sheet = WB.getSheetAt(1);
        int Rcount = sheet.getLastRowNum();
        for (i = 1; i <= Rcount; i++) {
            try{
                 FRC = sheet.getRow(i);
                String Exe = FRC.getCell(9).getStringCellValue();
                if(String.valueOf(Exe).equalsIgnoreCase("No_run"))
                    continue;
            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, 80);
            driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
            Actions action = new Actions(driver);

            String Fname = FRC.getCell(0).getStringCellValue();
            String Lname = FRC.getCell(1).getStringCellValue();
            String Address = FRC.getCell(2).getStringCellValue();
            int Zipcode = (int) FRC.getCell(3).getNumericCellValue();
            emailid = FRC.getCell(4).getStringCellValue();
            String password = FRC.getCell(5).getStringCellValue();
            int security = (int) FRC.getCell(6).getNumericCellValue();
            String phone = FRC.getCell(7).getStringCellValue();
            String CCard = FRC.getCell(8).getStringCellValue();
            driver.get("https://shopecomqa5.safeway.com/ecom/account/sign-in");
            driver.manage().window().maximize();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@href='/ecom/account/register?ZipCode=']")).click();
            driver.findElement(By.xpath("//*[@name='Register.ZipCode']")).sendKeys(String.valueOf(Zipcode));
            driver.findElement(By.xpath("//*[@class='submit btn-round ']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='FirstName']")).sendKeys(String.valueOf(Fname));
            driver.findElement(By.xpath("//*[@id='LastName']")).sendKeys(String.valueOf(Lname));
            Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='CustomerType']")));
            dropdown.selectByIndex(1);
            driver.findElement(By.xpath("//*[@id='Address1']")).sendKeys(String.valueOf(Address));
            Select drop1 = new Select(driver.findElement(By.xpath("//*[@name='HowRecommended']")));
            drop1.selectByIndex(1);
            driver.findElement(By.xpath("//*[@name='EmailAddress']")).sendKeys(String.valueOf(emailid));
            driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(String.valueOf(password));
            Select drop2 = new Select(driver.findElement(By.xpath("//*[@id='SecurityQuestion']")));
            drop2.selectByIndex(1);
            driver.findElement(By.xpath("//*[@name='SecurityAnswer']")).sendKeys(String.valueOf(security));
            driver.findElement(By.xpath("//*[@id='ClubCard']")).sendKeys(String.valueOf(phone));
            driver.findElement(By.xpath("//*[@name='TermsAndConditions']")).click();
            Thread.sleep(2000);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement scorl1 = driver.findElement(By.xpath("//*[@name='form-Registration']"));
            jse.executeScript("arguments[0].scrollIntoView(true);", scorl1);
            Thread.sleep(4000);
            try {
                driver.findElement(By.xpath("//*[@name='form-Registration']")).click();

                Thread.sleep(3000);
                driver.findElement(By.xpath("//*[@id='form-registration']/div[1]/ul/li/span")).isEnabled();
                Boolean erro = driver.findElement(By.xpath("//*[@class='validation-summary-errors']")).isEnabled();
                if (erro == true) {

                    methodName = emailid;
                    Screenshot.screens(driver, methodName);
                    FileOutputStream fos = new FileOutputStream(Config_Data.Datasheet);
                    WB.write(fos);
                    driver.close();
                }
            } catch (Exception e) {
                wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@class='id-count']"))));
                String Cartcount = driver.findElement(By.xpath("//*[@class='id-count']")).getText();
                System.out.println("Cart Count" + Cartcount);

            }

            try {
                driver.findElement(By.xpath("//*[@id='toPushFooter']/div[1]/div/div[4]/ul/li[2]/a")).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='DayPhone']")));
                driver.findElement(By.xpath("//*[@id='DayPhone']")).sendKeys(String.valueOf(phone));
                driver.findElement(By.xpath("//*[@name='form-MyAccount-Phone']")).click();

                WebElement scor2 = driver.findElement(By.xpath("//*[@name='CardHolderName']"));
                jse.executeScript("arguments[0].scrollIntoView(true);", scor2);
                scor2.sendKeys("Test");
                driver.findElement(By.xpath("*//*[@id='CreditCardNumber']")).sendKeys(String.valueOf(CCard));
                Thread.sleep(1000);
                Select dropdown2 = new Select(driver.findElement(By.xpath("//*[@id='ExpirationMonth']")));
                dropdown2.selectByIndex(11);
                Thread.sleep(1000);
                Select dropdown3 = new Select(driver.findElement(By.xpath("//*[@id='ExpirationYear']")));
                dropdown3.selectByIndex(2);
                driver.findElement(By.xpath("//*[@id='CardVerificationNumber']")).sendKeys("788");
                driver.findElement(By.xpath("//*[@name='form-MyAccount-PaymentToken']")).click();
                Thread.sleep(2000);
                driver.close();
                FRC = sheet.getRow(i);
                Ccell = FRC.createCell(10);
                Ccell.setCellValue("Success");
                FileOutputStream fos = new FileOutputStream(Config_Data.Datasheet);
                WB.write(fos);
                fos.close();
            } catch (Exception e) {

                System.out.println("Error");
                FRC = sheet.getRow(i);
                Ccell = FRC.createCell(10);
                Ccell.setCellValue("Failed");
                FileOutputStream fos = new FileOutputStream(Config_Data.Datasheet);
                WB.write(fos);
                fos.close();
                methodName = emailid;
                Screenshot.screens(driver, methodName);
            }
        }catch (Exception e) {
                System.out.println("Error");
                FRC = sheet.getRow(i);
                Ccell = FRC.createCell(10);
                Ccell.setCellValue("Failed");
                FileOutputStream fos = new FileOutputStream(Config_Data.Datasheet);
                WB.write(fos);
                fos.close();
                 methodName = emailid;
                Screenshot.screens(driver, methodName);
    }}

}}
