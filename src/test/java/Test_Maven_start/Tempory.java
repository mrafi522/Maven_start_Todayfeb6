package Test_Maven_start;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tempory {

@Test
public static void testing() throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", Config_Data.chromepath);
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 80);
    driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
    Actions action = new Actions(driver);

    driver.get("https://shopecomqa.safeway.com/");
    driver.manage().window().maximize();
    driver.findElement(By.xpath("//*[@href='/ecom/account/sign-in\']")).click();
    WebElement email=driver.findElement(By.xpath("//*[@name='SignIn.EmailAddress']"));
    email.sendKeys("fifa@example.com");
    WebElement password = driver.findElement(By.xpath("//*[@name='SignIn.Password']"));
    password.sendKeys("password1!");
    driver.findElement(By.name("signInButton")).click();

    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@id='btnDelivery']")).click();

    Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@href='/ecom/shop-by-history\']")).click();
    driver.findElements(By.xpath("//*[@class='id-name']")).get(4).click();
    driver.findElement(By.xpath("//*[@id='form-sort']/div[2]/div[3]")).click();
    String Cartcount = driver.findElement(By.xpath("//*[@class='id-count']")).getText();}}
    /*System.out.println("Cart Count" + Cartcount);
    driver.findElement(By.xpath("//*[@id='form-checkout\']/div/input")).click();
    Thread.sleep(2000);
    try {
        driver.findElement(By.xpath("//*[@class='submit btn-link cancel']")).click();
        Thread.sleep(2000);
    } catch (Exception e) {
        System.out.println("No chnage");
    }
    int Day1=3, Shift=1,Day=1;
 //   List<WebElement> countt=driver.findElements(By.xpath( "//*[starts-with(@class, ' level-3  id-slotOpen')]"));
    List<WebElement> countt = driver.findElements(By.xpath(("//*[starts-with(@class, ' level-" + Day1 + "  id-')]")));

    switch (Shift) {
        case 1:

            if ((String.valueOf(Shift)).equals("1")) {
                String Fshift1 = countt.get(1).getAttribute("class");
                String Fshift2 = countt.get(2).getAttribute("class");
                String Fshift3 = countt.get(3).getAttribute("class");
                if (Fshift1.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                    driver.findElement(By.xpath("//*[@id='checkoutStep']/div[3]/div/div[2]/div/div[7]/div[2]/div[2]/table/tbody/tr[1]/td[" + Day + "]")).click();
                    break;
                } else if (Fshift2.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                    driver.findElement(By.xpath("//*[@id='checkoutStep']/div[3]/div/div[2]/div/div[7]/div[2]/div[2]/table/tbody/tr[2]/td[" + Day + "]")).click();
                    break;
                } else if (Fshift3.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                    driver.findElement(By.xpath("//*[@id='checkoutStep']/div[3]/div/div[2]/div/div[7]/div[2]/div[2]/table/tbody/tr[3]/td[" + Day + "]")).click();
                    break;
                } else {
                    System.out.println("Error");
                }
            }

        case 2:

            if ((String.valueOf(Shift)).equals("2")) {
                String Sshift1 = countt.get(4).getAttribute("class");
                String Sshift2 = countt.get(5).getAttribute("class");
                String Sshift3 = countt.get(6).getAttribute("class");
                String Sshift4 = countt.get(7).getAttribute("class");
                String Sshift5 = countt.get(8).getAttribute("class");
                if (Sshift1.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                    driver.findElement(By.xpath("//*[@id='checkoutStep']/div[3]/div/div[2]/div/div[7]/div[2]/div[2]/table/tbody/tr[4]/td[" + Day + "]")).click();
                    break;
                } else if (Sshift2.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                    driver.findElement(By.xpath("//*[@id='checkoutStep']/div[3]/div/div[2]/div/div[7]/div[2]/div[2]/table/tbody/tr[5]/td[" + Day + "]")).click();
                    break;
                } else if (Sshift3.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                    driver.findElement(By.xpath("//*[@id='checkoutStep']/div[3]/div/div[2]/div/div[7]/div[2]/div[2]/table/tbody/tr[6]/td[" + Day + "]")).click();
                    break;
                } else if (Sshift4.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                    driver.findElement(By.xpath("//*[@id='checkoutStep']/div[3]/div/div[2]/div/div[7]/div[2]/div[2]/table/tbody/tr[7]/td[" + Day + "]")).click();
                    break;
                } else if (Sshift5.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                    driver.findElement(By.xpath("//*[@id='checkoutStep']/div[3]/div/div[2]/div/div[7]/div[2]/div[2]/table/tbody/tr[8]/td[" + Day + "]")).click();
                    break;
                } else {
                    System.out.println("Error");
                }
            }
        case 3:

            if ((String.valueOf(Shift)).equals("3")) {
                try {
                    String Tshift1 = countt.get(9).getAttribute("class");
                    String Tshift2 = countt.get(10).getAttribute("class");
                    String Tshift3 = countt.get(11).getAttribute("class");
                    String Tshift4 = countt.get(12).getAttribute("class");
                    String Tshift5 = countt.get(13).getAttribute("class");
                    if (Tshift1.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                        driver.findElement(By.xpath("//*[@id='checkoutStep']/div[3]/div/div[2]/div/div[7]/div[2]/div[2]/table/tbody/tr[9]/td[" + Day + "]")).click();
                        break;
                    } else if (Tshift2.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                        driver.findElement(By.xpath("//*[@id='checkoutStep']/div[3]/div/div[2]/div/div[7]/div[2]/div[2]/table/tbody/tr[10]/td[" + Day + "]")).click();
                        break;
                    } else if (Tshift3.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                        driver.findElement(By.xpath("//*[@id='checkoutStep']/div[3]/div/div[2]/div/div[7]/div[2]/div[2]/table/tbody/tr[11]/td[" + Day + "]")).click();
                        break;
                    } else if (Tshift4.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                        driver.findElement(By.xpath("//*[@id='checkoutStep']/div[3]/div/div[2]/div/div[7]/div[2]/div[2]/table/tbody/tr[12]/td[" + Day + "]")).click();
                        break;
                    } else if (Tshift5.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                        driver.findElement(By.xpath("//*[@id='checkoutStep']/div[3]/div/div[2]/div/div[7]/div[2]/div[2]/table/tbody/tr[13]/td[" + Day + "]")).click();
                        break;
                    }
                } catch (Exception e) {

                    String TDTshift1 = Counttoday1.get(9).getAttribute("class");
                    System.out.println(TDTshift1);
                    String TDTshift2 = Counttoday1.get(10).getAttribute("class");
                    String TDTshift3 = Counttoday1.get(11).getAttribute("class");
                    String TDTshift4 = Counttoday1.get(12).getAttribute("class");
                    String TDTshift5 = Counttoday1.get(13).getAttribute("class");
                    if (TDTshift1.equalsIgnoreCase(" level-" + Day1 + " id-slotToday id-slotOpen")) {
                        driver.findElement(By.xpath("//*[@id='checkoutStep']/div[3]/div/div[2]/div/div[7]/div[2]/div[2]/table/tbody/tr[9]/td[" + Day + "]")).click();
                        break;
                    } else if (TDTshift2.equalsIgnoreCase(" level-" + Day1 + " id-slotToday id-slotOpen")) {
                        driver.findElement(By.xpath("//*[@id='checkoutStep']/div[3]/div/div[2]/div/div[7]/div[2]/div[2]/table/tbody/tr[10]/td[" + Day + "]")).click();
                        break;
                    } else if (TDTshift3.equalsIgnoreCase(" level-" + Day1 + " id-slotToday id-slotOpen")) {
                        driver.findElement(By.xpath("//*[@id='checkoutStep']/div[3]/div/div[2]/div/div[7]/div[2]/div[2]/table/tbody/tr[11]/td[" + Day + "]")).click();
                        break;
                    } else if (TDTshift4.equalsIgnoreCase(" level-" + Day1 + " id-slotToday id-slotOpen")) {
                        driver.findElement(By.xpath("//*[@id='checkoutStep']/div[3]/div/div[2]/div/div[7]/div[2]/div[2]/table/tbody/tr[12]/td[" + Day + "]")).click();
                        break;
                    } else if (TDTshift5.equalsIgnoreCase(" level-" + Day1 + " id-slotToday id-slotOpen")) {
                        driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[13]/td[" + Day + "]")).click();
                        break;
                    }
                }
                ;


            } }
            }*/

 //   System.out.println("coubt"+countt);
   // driver.findElement(By.xpath("//*[@id='checkoutStep']/div[3]/div/div[2]/div/div[7]/div[2]/div[2]/table/tbody/tr[9]/td[2]")).click();
