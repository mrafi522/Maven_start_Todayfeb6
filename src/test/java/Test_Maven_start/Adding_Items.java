package Test_Maven_start;

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

public class Adding_Items {

    public static String Name;
    public static String OrderN;
    public static int i, k, l, m, cons, ii;
    public static HSSFRow FRC;
    public static HSSFCell Ccell;
    public static HSSFSheet sheet;
    public static HSSFWorkbook WB;
    public static FileInputStream fis;
    public static String Qtvalue;
    public static WebDriver driver;
    public static String Emailid;
    public static int Day;
    public static int Day1;

    @org.testng.annotations.Test
    public static void temp() throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", Config_Data.chromepath);
        fis = new FileInputStream(Config_Data.Datasheet);
        WB = new HSSFWorkbook(fis);
        sheet = WB.getSheetAt(0);
        int Rcount = sheet.getLastRowNum();
        for (i = 1; i <= Rcount; i++) {
            try {
                FRC = sheet.getRow(i);
                String Status = FRC.getCell(5).getStringCellValue();
                if (String.valueOf(Status).equalsIgnoreCase("No_run"))
                    continue;

                //  FRC.getCell(0).getStringCellValue();
                Emailid = FRC.getCell(0).getStringCellValue();
                String Password = FRC.getCell(1).getStringCellValue();
                int Shift = (int) FRC.getCell(2).getNumericCellValue();
                Day = (int) FRC.getCell(3).getNumericCellValue();
                Day1 = Day + 1;
                String Consider = FRC.getCell(6).getStringCellValue();

                String  SPC = FRC.getCell(7).getStringCellValue();
                String PRC = FRC.getCell(8).getStringCellValue();
                String WET = FRC.getCell(9).getStringCellValue();
                String REG = FRC.getCell(10).getStringCellValue();
                String PLU = FRC.getCell(11).getStringCellValue();


                System.out.println("Data Value---->" + Rcount);
                driver = new ChromeDriver();
                WebDriverWait WT = new WebDriverWait(driver, 60);
                driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
                //    driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
                Actions action = new Actions(driver);
                driver.get(Config_Data.URL);
                driver.manage().window().maximize();
                driver.findElement(By.xpath("//*[@href='/ecom/account/sign-in\']")).click();

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("return window.stop");
                Thread.sleep(1000);
                if (String.valueOf(Consider).equalsIgnoreCase("YES")) {
                    WebElement emailid = driver.findElement(By.xpath("//*[@name='SignIn.EmailAddress']"));
                    emailid.sendKeys(String.valueOf(Emailid));
                    WebElement password = driver.findElement(By.xpath("//*[@name='SignIn.Password']"));
                    password.sendKeys(String.valueOf(Password));
                    driver.findElement(By.name("signInButton")).click();
                    Thread.sleep(1000);

                    try{
                        driver.findElement(By.xpath("//*[@id='btnDelivery']")).click();}catch (Exception e){
                        System.out.println("NAI Orders");
                    }
                    Thread.sleep(2000);


                    if (!(SPC.equalsIgnoreCase(""))) {
                        String[] SPC_SP=SPC.split(",");
                        int ii=SPC_SP.length+1;
                        //    for (ii = 1; ii <= SPC_SP.length; ii++) {
                        for(String ITEM:SPC_SP){
                            if (SPC_SP.length >= ii)
                                break;
                            FRC = sheet.getRow(Integer.parseInt(String.valueOf(ITEM)));
                            String SPC_Item = FRC.getCell(12).getStringCellValue();

                            driver.findElement(By.xpath("//*[@id='form-search-input']")).sendKeys(String.valueOf(SPC_Item));
                            driver.findElement(By.xpath("//*[@class='submit btn-round ']")).click();
                            Qtvalue = driver.findElement(By.xpath("//*[@name='Quantity']")).getAttribute("Value");
                            if (!(String.valueOf(Qtvalue).equalsIgnoreCase("")))
                                continue;
                            driver.findElement(By.xpath("//*[@name='Quantity']")).sendKeys("6");
                            driver.findElement(By.xpath("//*[@name='add']")).click();
                            Thread.sleep(1000);
                        /*if (SPC == ii)
                            break;*/
                        }}
                    if (!(PRC.equalsIgnoreCase(""))) {
                        String[] PRC_SP=PRC.split(",");
                        int ii=PRC_SP.length+1;
                        //    for (ii = 1; ii <= SPC_SP.length; ii++) {
                        for(String ITEMP:PRC_SP){
                            if (PRC_SP.length >= ii)
                                break;
                            FRC = sheet.getRow(Integer.parseInt(String.valueOf(ITEMP)));
                            String PRC_Item = FRC.getCell(13).getStringCellValue();

                            driver.findElement(By.xpath("//*[@id='form-search-input']")).sendKeys(String.valueOf(PRC_Item));
                            driver.findElement(By.xpath("//*[@class='submit btn-round ']")).click();
                            Qtvalue = driver.findElement(By.xpath("//*[@name='Quantity']")).getAttribute("Value");
                            if (!(String.valueOf(Qtvalue).equalsIgnoreCase("")))
                                continue;
                            driver.findElement(By.xpath("//*[@name='Quantity']")).sendKeys("6");
                            driver.findElement(By.xpath("//*[@name='add']")).click();
                            Thread.sleep(1000);

                        }
                    }
                    if (!(WET.equalsIgnoreCase(""))) {
                        String[] WET_SP=WET.split(",");
                        int ii=WET_SP.length+1;
                        //    for (ii = 1; ii <= SPC_SP.length; ii++) {
                        for(String ITEMW:WET_SP){
                            if (WET_SP.length >= ii)
                                break;
                            FRC = sheet.getRow(Integer.parseInt(String.valueOf(ITEMW)));
                            String WET_Item = FRC.getCell(14).getStringCellValue();

                            driver.findElement(By.xpath("//*[@id='form-search-input']")).sendKeys(String.valueOf(WET_Item));

                            driver.findElement(By.xpath("//*[@class='submit btn-round ']")).click();
                            Qtvalue = driver.findElement(By.xpath("//*[@name='Quantity']")).getAttribute("Value");
                            if (!(String.valueOf(Qtvalue).equalsIgnoreCase("")))
                                continue;
                            driver.findElement(By.xpath("//*[@name='Quantity']")).sendKeys("6");
                            driver.findElement(By.xpath("//*[@name='add']")).click();
                            Thread.sleep(1000);

                        }
                    }
                    if (!(REG.equalsIgnoreCase(""))) {
                        String[] REG_SP=REG.split(",");
                        int ii=REG_SP.length+1;
                        //    for (ii = 1; ii <= SPC_SP.length; ii++) {
                        for(String ITEMR:REG_SP){
                            if (REG_SP.length >= ii)
                                break;
                            FRC = sheet.getRow(Integer.parseInt(String.valueOf(ITEMR)));
                            String REG_Item = FRC.getCell(15).getStringCellValue();

                            driver.findElement(By.xpath("//*[@id='form-search-input']")).sendKeys(String.valueOf(REG_Item));
                            driver.findElement(By.xpath("//*[@class='submit btn-round ']")).click();
                            Qtvalue = driver.findElement(By.xpath("//*[@name='Quantity']")).getAttribute("Value");
                            if (!(String.valueOf(Qtvalue).equalsIgnoreCase("")))
                                continue;
                            driver.findElement(By.xpath("//*[@name='Quantity']")).sendKeys("6");
                            driver.findElement(By.xpath("//*[@name='add']")).click();
                            Thread.sleep(1000);

                        }
                    }
                    if (!(PLU.equalsIgnoreCase(""))) {
                        String[] PLU_SP=PLU.split(",");
                        int ii=PLU_SP.length+1;
                        //    for (ii = 1; ii <= SPC_SP.length; ii++) {
                        for(String ITEMP:PLU_SP){
                            if (PLU_SP.length >= ii)
                                break;
                            FRC = sheet.getRow(Integer.parseInt(String.valueOf(ITEMP)));
                            String PLU_Item = FRC.getCell(16).getStringCellValue();

                            driver.findElement(By.xpath("//*[@id='form-search-input']")).sendKeys(String.valueOf(PLU_Item));
                            driver.findElement(By.xpath("//*[@class='submit btn-round ']")).click();
                            Qtvalue = driver.findElement(By.xpath("//*[@name='Quantity']")).getAttribute("Value");
                            if (!(String.valueOf(Qtvalue).equalsIgnoreCase("")))
                                continue;
                            driver.findElement(By.xpath("//*[@name='Quantity']")).sendKeys("6");
                            driver.findElement(By.xpath("//*[@name='add']")).click();
                            Thread.sleep(1000);

                        }
                    }
                } else {

                    Thread.sleep(1000);
                    WebElement emailid = driver.findElement(By.xpath("//*[@name='SignIn.EmailAddress']"));
                    emailid.sendKeys(String.valueOf(Emailid));
                    WebElement password = driver.findElement(By.xpath("//*[@name='SignIn.Password']"));
                    password.sendKeys(String.valueOf(Password));
                    driver.findElement(By.name("signInButton")).click();
                    Thread.sleep(2000);
                    try{
                        driver.findElement(By.xpath("//*[@id='btnDelivery']")).click();}catch (Exception e){
                        System.out.println("NAI Orders");
                    }
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//*[@href='/ecom/shop-by-history\']")).click();
                    driver.findElements(By.xpath("//*[@class='id-name']")).get(4).click();
                    driver.findElement(By.xpath("//*[@id='form-sort']/div[2]/div[3]")).click();
                    String Cartcount = driver.findElement(By.xpath("//*[@class='id-count']")).getText();
                    System.out.println("Cart Count" + Cartcount);
                }
                driver.findElement(By.xpath("//*[@id='form-checkout\']/div/input")).click();
                Thread.sleep(2000);
                try {
                    driver.findElement(By.xpath("//*[@class='submit btn-link cancel']")).click();
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("No chnage");
                }
                try {
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

                }catch (Exception e){System.out.println("NAI Orders");}
                List<WebElement> count = driver.findElements(By.xpath(("//*[starts-with(@class, ' level-" + Day1 + "  id-')]")));
                int  countall = driver.findElements(By.xpath(("//*[starts-with(@class, ' level-" + Day1 + "  id-')]"))).size();
                System.out.println("Count"+countall);
                List<WebElement> Counttoday = driver.findElements(By.xpath("//*[starts-with(@class, ' level-" + Day1 + " id-slotToday id-')]"));
                if((countall)==37){

                    switch (Shift) {
                        case 1:

                            if ((String.valueOf(Shift)).equals("1")) {
                                String Fshift1 = count.get(13).getAttribute("class");
                                String Fshift2 = count.get(14).getAttribute("class");
                                String Fshift3 = count.get(15).getAttribute("class");
                                if (Fshift1.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                                    driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[1]/td[" + Day + "]")).click();
                                    break;
                                } else if (Fshift2.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                                    driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[2]/td[" + Day + "]")).click();
                                    break;
                                } else if (Fshift3.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                                    driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[3]/td[" + Day + "]")).click();
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
                                if (Sshift1.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                                    driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[4]/td[" + Day + "]")).click();
                                    break;
                                } else if (Sshift2.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                                    driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[5]/td[" + Day + "]")).click();
                                    break;
                                } else if (Sshift3.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                                    driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[6]/td[" + Day + "]")).click();
                                    break;
                                } else if (Sshift4.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                                    driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[7]/td[" + Day + "]")).click();
                                    break;
                                } else if (Sshift5.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                                    driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[8]/td[" + Day + "]")).click();
                                    break;
                                } else {
                                    System.out.println("Error");
                                }
                            }
                        case 3:

                            if ((String.valueOf(Shift)).equals("3")) {
                                try {
                                    String Tshift1 = count.get(21).getAttribute("class");
                                    String Tshift2 = count.get(22).getAttribute("class");
                                    String Tshift3 = count.get(23).getAttribute("class");
                                    String Tshift4 = count.get(24).getAttribute("class");
                                    String Tshift5 = count.get(25).getAttribute("class");
                                    if (Tshift1.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                                        driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[9]/td[" + Day + "]")).click();
                                        break;
                                    } else if (Tshift2.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                                        driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[10]/td[" + Day + "]")).click();
                                        break;
                                    } else if (Tshift3.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                                        driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[11]/td[" + Day + "]")).click();
                                        break;
                                    } else if (Tshift4.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                                        driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[12]/td[" + Day + "]")).click();
                                        break;
                                    } else if (Tshift5.equalsIgnoreCase(" level-" + Day1 + "  id-slotOpen")) {
                                        driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[13]/td[" + Day + "]")).click();
                                        break;
                                    }
                                } catch (Exception e) {

                                    String TDTshift1 = Counttoday.get(21).getAttribute("class");
                                    System.out.println(TDTshift1);
                                    String TDTshift2 = Counttoday.get(22).getAttribute("class");
                                    String TDTshift3 = Counttoday.get(23).getAttribute("class");
                                    String TDTshift4 = Counttoday.get(24).getAttribute("class");
                                    String TDTshift5 = Counttoday.get(25).getAttribute("class");
                                    if (TDTshift1.equalsIgnoreCase(" level-" + Day1 + " id-slotToday id-slotOpen")) {
                                        driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[9]/td[" + Day + "]")).click();
                                        break;
                                    } else if (TDTshift2.equalsIgnoreCase(" level-" + Day1 + " id-slotToday id-slotOpen")) {
                                        driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[10]/td[" + Day + "]")).click();
                                        break;
                                    } else if (TDTshift3.equalsIgnoreCase(" level-" + Day1 + " id-slotToday id-slotOpen")) {
                                        driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[11]/td[" + Day + "]")).click();
                                        break;
                                    } else if (TDTshift4.equalsIgnoreCase(" level-" + Day1 + " id-slotToday id-slotOpen")) {
                                        driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[12]/td[" + Day + "]")).click();
                                        break;
                                    } else if (TDTshift5.equalsIgnoreCase(" level-" + Day1 + " id-slotToday id-slotOpen")) {
                                        driver.findElement(By.xpath("//*[@id='timeSlots']/div/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr[13]/td[" + Day + "]")).click();
                                        break;
                                    }
                                }
                                ;


                            } else {
                                System.out.println("No SLOT available");
                            }
                    }}else{
                    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,700)");

                    switch (Shift) {
                        case 1:

                            if ((String.valueOf(Shift)).equals("1")) {
                                String Fshift1 = count.get(0).getAttribute("class");
                                String Fshift2 = count.get(1).getAttribute("class");
                                String Fshift3 = count.get(2).getAttribute("class");
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
                                String Sshift1 = count.get(3).getAttribute("class");
                                String Sshift2 = count.get(4).getAttribute("class");
                                String Sshift3 = count.get(5).getAttribute("class");
                                String Sshift4 = count.get(6).getAttribute("class");
                                String Sshift5 = count.get(7).getAttribute("class");
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
                                    String Tshift1 = count.get(8).getAttribute("class");
                                    String Tshift2 = count.get(9).getAttribute("class");
                                    String Tshift3 = count.get(10).getAttribute("class");
                                    String Tshift4 = count.get(11).getAttribute("class");
                                    String Tshift5 = count.get(12).getAttribute("class");
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

                                    String TDTshift1 = Counttoday.get(8).getAttribute("class");
                                    System.out.println(TDTshift1);
                                    String TDTshift2 = Counttoday.get(9).getAttribute("class");
                                    String TDTshift3 = Counttoday.get(10).getAttribute("class");
                                    String TDTshift4 = Counttoday.get(11).getAttribute("class");
                                    String TDTshift5 = Counttoday.get(12).getAttribute("class");
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
                                        driver.findElement(By.xpath("//*[@id='checkoutStep']/div[3]/div/div[2]/div/div[7]/div[2]/div[2]/table/tbody/tr[13]/td[" + Day + "]")).click();
                                        break;
                                    }
                                }
                                ;


                            } else {
                                System.out.println("No SLOT available");
                            }
                    }

                };

                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[@name='continue']")).click();
                Thread.sleep(2000);
                try {
                    driver.findElement(By.xpath("//*[@name='continue']")).click();
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("No Special");
                }
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
                    try {
                        try {
                            boolean check = driver.findElement(By.xpath("//*[@id='chkAcceptUATerms']")).isSelected();
                            if (check == true) {
                                System.out.println("Check");
                            } else {
                                driver.findElement(By.xpath("//*[@id='chkAcceptUATerms']")).click();
                            }
                        } catch (Exception e) {
                            boolean Scheck = driver.findElement(By.xpath("//*[@id='TermsVersionAccepted']")).isSelected();
                            if (Scheck == true) {
                                System.out.println("Check");
                            } else {
                                driver.findElement(By.xpath("//*[@id='TermsVersionAccepted']")).click();
                            }
                        }
                        ;
                    } catch (Exception e) {
                        System.out.println("No Error");
                    }
                    driver.findElement(By.xpath("//*[@name='completeOrder']")).click();
                    WT.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='test']")));

                    System.out.println("*****RAFFIIII");
                } catch (TimeoutException e) {

                    List<WebElement> TT = driver.findElements(By.xpath("//*[@id='OrderId']"));
                    OrderN = driver.findElements(By.xpath("//*[@id='OrderId']")).get(0).getAttribute("Value");
                    System.out.println(OrderN);
                    System.out.println("IIII" + i);
                    FRC = sheet.getRow(i);
                    Ccell = FRC.createCell(4);
                    Ccell.setCellValue(OrderN);
                    FileOutputStream fos = new FileOutputStream(Config_Data.Datasheet);
                    WB.write(fos);
                    fos.close();
                    driver.close();
                }
            } catch (Exception E) {

                System.out.println("Error");
                FRC = sheet.getRow(i);
                Ccell = FRC.createCell(4);
                Ccell.setCellValue("Failed");
                FileOutputStream fos = new FileOutputStream(Config_Data.Datasheet);
                WB.write(fos);
                fos.close();
                try {
                    String methodName;
                    methodName = Emailid;
                    Screenshot.screens(driver, methodName);
                    driver.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
