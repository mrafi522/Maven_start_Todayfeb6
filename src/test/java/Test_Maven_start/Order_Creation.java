package Test_Maven_start;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Unit test for simple App.
 */

public class Order_Creation {
    public static String Name;
    public static int i, k, l, m;

    @org.testng.annotations.Test
    public void temp() throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rmoha17\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        FileInputStream fis = new FileInputStream("C:\\Users/rmoha17/Desktop/Projects/Book111.xls");
        HSSFWorkbook WB = new HSSFWorkbook(fis);
        HSSFSheet sheet = WB.getSheetAt(0);
        int Rcount = sheet.getLastRowNum();
        for (i = 11; i <= Rcount; i++) {
            HSSFRow FRC = sheet.getRow(i);
            //  FRC.getCell(0).getStringCellValue();
            String Emailid = FRC.getCell(0).getStringCellValue();
            String Password = FRC.getCell(1).getStringCellValue();
            int Shift = (int) FRC.getCell(2).getNumericCellValue();
//     String Order=FRC.getCell(3).getStringCellValue();


            System.out.println("Data Value---->" + Rcount);
            WebDriver driver = new ChromeDriver();
            WebDriverWait WT = new WebDriverWait(driver, 60);
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            //    driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
            Actions action = new Actions(driver);
            driver.get("https://shopecomqa.safeway.com/");
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//*[@href='/ecom/account/sign-in\']")).click();

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("return window.stop");
            Thread.sleep(1000);
            WebElement emailid = driver.findElement(By.xpath("//*[@name='SignIn.EmailAddress']"));
            emailid.sendKeys(String.valueOf(Emailid));
            WebElement password = driver.findElement(By.xpath("//*[@name='SignIn.Password']"));
            password.sendKeys(String.valueOf(Password));
            driver.findElement(By.name("signInButton")).click();
            driver.findElement(By.xpath("//*[@href='/ecom/shop-by-history\']")).click();
            driver.findElements(By.xpath("//*[@class='id-name']")).get(4).click();
            driver.findElement(By.xpath("//*[@id='form-sort']/div[2]/div[3]")).click();
            String Cartcount = driver.findElement(By.xpath("//*[@class='id-count']")).getText();
            System.out.println("Cart Count" + Cartcount);
            driver.findElement(By.xpath("//*[@id='form-checkout\']/div/input")).click();
            Thread.sleep(2000);
            WebElement radio = driver.findElement(By.xpath("//*[@class='unattented-radio']"));
            boolean radiocheck = radio.isSelected();

            if (radiocheck) {

                driver.findElement(By.xpath("//*[@name='unattended']")).click();
                Thread.sleep(2000);
            } else {
                driver.findElement(By.xpath("//*[@name='unattended']")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@class='btnShowtime']")).click();
                Thread.sleep(2000);
            }
            List<WebElement> count = driver.findElements(By.xpath(("//*[starts-with(@class, ' level-3  id-')]")));
            System.out.println("Sizeeeee" + count.size());


            switch (Shift) {
                case 1:

                    if ((String.valueOf(Shift)).equals("1")) {
                        String Fshift1 = count.get(13).getAttribute("class");
                        String Fshift2 = count.get(14).getAttribute("class");
                        String Fshift3 = count.get(15).getAttribute("class");
                        if (Fshift1.equalsIgnoreCase(" level-3  id-slotOpen")) {
                            driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[1]/td[2]")).click();
                            break;
                        } else if (Fshift2.equalsIgnoreCase(" level-3  id-slotOpen")) {
                            driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[2]/td[2]")).click();
                            break;
                        } else if (Fshift3.equalsIgnoreCase(" level-3  id-slotOpen")) {
                            driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[3]/td[2]")).click();
                            break;
                        } else {
                            System.out.println("Error");
                        }
                    }

                case 2:

                    if ((String.valueOf(Shift)).equals("2")) {
                        String Sshift1 = count.get(16).getAttribute("class");
                        String Sshift2 = count.get(17).getAttribute("class");
                        String Sshift3 = count.get(18).getAttribute("class");
                        String Sshift4 = count.get(19).getAttribute("class");
                        String Sshift5 = count.get(20).getAttribute("class");
                        if (Sshift1.equalsIgnoreCase(" level-3  id-slotOpen")) {
                            driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[4]/td[2]")).click();
                            break;
                        } else if (Sshift2.equalsIgnoreCase(" level-3  id-slotOpen")) {
                            driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[5]/td[2]")).click();
                            break;
                        } else if (Sshift3.equalsIgnoreCase(" level-3  id-slotOpen")) {
                            driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[6]/td[2]")).click();
                            break;
                        } else if (Sshift4.equalsIgnoreCase(" level-3  id-slotOpen")) {
                            driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[7]/td[2]")).click();
                            break;
                        } else if (Sshift5.equalsIgnoreCase(" level-3  id-slotOpen")) {
                            driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[8]/td[2]")).click();
                            break;
                        } else {
                            System.out.println("Error");
                        }
                    }
                case 3:

                    if ((String.valueOf(Shift)).equals("3")) {
                        String Tshift1 = count.get(21).getAttribute("class");
                        String Tshift2 = count.get(22).getAttribute("class");
                        String Tshift3 = count.get(23).getAttribute("class");
                        String Tshift4 = count.get(24).getAttribute("class");
                        String Tshift5 = count.get(25).getAttribute("class");
                        if (Tshift1.equalsIgnoreCase(" level-3  id-slotOpen")) {
                            driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[9]/td[2]")).click();
                            break;
                        } else if (Tshift2.equalsIgnoreCase(" level-3  id-slotOpen")) {
                            driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[10]/td[2]")).click();
                            break;
                        } else if (Tshift3.equalsIgnoreCase(" level-3  id-slotOpen")) {
                            driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[11]/td[2]")).click();
                            break;
                        } else if (Tshift4.equalsIgnoreCase(" level-3  id-slotOpen")) {
                            driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[12]/td[2]")).click();
                            break;
                        } else if (Tshift5.equalsIgnoreCase(" level-3  id-slotOpen")) {
                            driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[13]/td[2]")).click();
                            break;
                        } else {
                            System.out.println("Error");
                        }
                    }
            }
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@name='continue']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@name='continue1']")).click();
            Thread.sleep(1000);
            driver.findElement(By.name("continue")).click();

            Thread.sleep(2000);
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            WebElement scorl = driver.findElement(By.xpath("//*[@name='CardVerificationNumber']"));
            jse.executeScript("arguments[0].scrollIntoView(true);", scorl);
            scorl.sendKeys("788");
            driver.findElement(By.xpath("*//*[@id='BillingZip']")).sendKeys("19713");

            try {
                driver.findElement(By.xpath("//*[@name='completeOrder']")).click();
                WT.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='test']")));

                System.out.println("*****RAFFIIII");
            } catch (TimeoutException e) {

                //    System.out.println("*****NARRRRR");
                                List<WebElement> TT = driver.findElements(By.xpath("//*[@id='OrderId']"));
                String OrderN = driver.findElements(By.xpath("//*[@id='OrderId']")).get(0).getAttribute("Value");
                //    String OrderN1=driver.findElements(By.xpath("//*[@id='OrderId']")).get(1).getAttribute("Value");
                System.out.println(OrderN);
                //  System.out.println(OrderN1);
                HSSFCell Ccell = FRC.createCell(3);
                Ccell.setCellValue(OrderN);
                FileOutputStream fos = new FileOutputStream("C:\\Users/rmoha17/Desktop/Projects/Book111.xls");
                WB.write(fos);
                driver.close();
            }
        }


    }

}

