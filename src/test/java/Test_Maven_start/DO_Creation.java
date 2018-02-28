package Test_Maven_start;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import static Test_Maven_start.Adding_Items.ii;
import static Test_Maven_start.Config_Data.chromepath;


public class DO_Creation extends MIF_XML_Util {

    public static String path1;
    public static int i=1;
    public static HSSFRow FRC;
    public static HSSFCell Ccell;
    public static HSSFSheet sheet;
    public static HSSFWorkbook WB;
    public  static int Rcount;
    public  static   String MR2;
    public static String path2;
    public static String RLTOTAL=" 00000000.00";
    public  static  String ORMR="RN";
    public static int   RMERCH;
    public static String RAM;
    //   public  static  String MR1="91047396_1211";
    public final void DO_update0() throws IOException, InterruptedException {

        fis = new FileInputStream(Config_Data.DataXML);
        WB = new HSSFWorkbook(fis);
        sheet = WB.getSheetAt(0);
        Rcount = sheet.getLastRowNum();
        FRC = sheet.getRow(1);

        MR5 = String.valueOf(FRC.getCell(0).getStringCellValue());
        MR4 = String.valueOf(FRC.getCell(1).getStringCellValue());
        MR7 = String.valueOf(FRC.getCell(2).getStringCellValue());
        MR3 = String.valueOf(FRC.getCell(3).getStringCellValue());
        MR8 = String.valueOf(FRC.getCell(4).getStringCellValue());
        MR9 = String.valueOf(FRC.getCell(5).getStringCellValue());
        MR10 = String.valueOf(FRC.getCell(6).getStringCellValue());
        MR11 = String.valueOf(FRC.getCell(9).getStringCellValue());
        MR6 = String.valueOf(FRC.getCell(7).getStringCellValue());
        MR2 = String.valueOf(FRC.getCell(10).getStringCellValue());
        path2 = "C:\\Users\\Rmoha17\\Desktop\\DataMIF\\DO\\" + MR2 + ".xml";
        String X_SPC = FRC.getCell(13).getStringCellValue();
        String X_PRI_I = FRC.getCell(14).getStringCellValue();
        String X_WEG_I = FRC.getCell(15).getStringCellValue();
        String X_REG_I = FRC.getCell(16).getStringCellValue();
        String X_PLU_I =  FRC.getCell(17).getStringCellValue();
        RITEM=String.valueOf(FRC.getCell(19).getStringCellValue());
        RPRICE=String.valueOf(FRC.getCell(20).getStringCellValue());
        DOTotal=(int) FRC.getCell(42).getNumericCellValue();
       VanZone= String.valueOf(FRC.getCell(44).getStringCellValue());
        //**** Data end
    }


    public  final static void DO_update1() throws IOException {

        PrintWriter writer = new PrintWriter(path2, "UTF-8");
        writer.println("Testing");
        writer.close();
    }
    public  final static void DO_update2() throws IOException {

                modifyFile(path2,"Testing",DO_SKLT);
    }
public final static  void Do_update3() throws IOException {

    FRC = sheet.getRow(i);
    String X_SPC = FRC.getCell(13).getStringCellValue();
    String X_PRI_I = FRC.getCell(14).getStringCellValue();
    String X_WEG_I = FRC.getCell(15).getStringCellValue();
    String X_REG_I = FRC.getCell(16).getStringCellValue();
    String X_PLU_I =  FRC.getCell(17).getStringCellValue();

    if (!(X_SPC.equalsIgnoreCase(""))) {
        String[] X_SPC_SP=X_SPC.split(",");
        int ii=X_SPC_SP.length+1;
        //    for (ii = 1; ii <= SPC_SP.length; ii++) {
        for(String ITEMSP:X_SPC_SP){
            if (X_SPC_SP.length >= ii)
                break;
            FRC = sheet.getRow(Integer.parseInt(String.valueOf(ITEMSP)));
            RITEM=String.valueOf(FRC.getCell(19).getStringCellValue());
            RPRICE=String.valueOf(FRC.getCell(20).getStringCellValue());
            RAM=String.valueOf(FRC.getCell(21).getStringCellValue());
            RMERCH=(int) FRC.getCell(22).getNumericCellValue();

            String newItem_Do="</OrderLine"+ORMR+"><OrderLine><LineNumber>"+RITEM+"</LineNumber><ExternalLineID>"+RITEM+"</ExternalLineID><ItemID>"+RITEM+"</ItemID><MerchType>"+RMERCH+"</MerchType><LineTotal>00000000.00</LineTotal><ReasonCode/><PriceInfo><Price>"+RPRICE+"</Price></PriceInfo><Quantity><OrderedQty>6</OrderedQty><OrderedQtyUOM>unit</OrderedQtyUOM></Quantity><ShippingInfo><MustDeliverBy>01/18/18 19:00 PST</MustDeliverBy><PromisedDeliveryBy>01/18/18 18:02 PST</PromisedDeliveryBy><RequestedDeliveryBy>01/18/18 18:02 PST</RequestedDeliveryBy><ShipVia>A1</ShipVia><ShippingAddress><ShipToFirstName>RR5</ShipToFirstName><ShipToLastName>RR4 84</ShipToLastName><ShipToAddressLine1>RR8</ShipToAddressLine1><ShipToAddressLine2/><ShipToCity>RR9</ShipToCity><ShipToState>CA</ShipToState><ShipToPostalCode>RR10</ShipToPostalCode><ShipToCountry>US</ShipToCountry><ShipToPhone>RR6</ShipToPhone><ShipToEmail>RR7</ShipToEmail></ShippingAddress></ShippingInfo><LineReferenceFields><ReferenceField1>2</ReferenceField1><ReferenceField2>0</ReferenceField2><ReferenceField3>9.94999980</ReferenceField3><ReferenceField4>1</ReferenceField4><ReferenceField9>"+RAM+"</ReferenceField9></LineReferenceFields><WMNotes><WMNote><NoteType>UC</NoteType><CommentText>No notes</CommentText></WMNote></WMNotes></OrderLine>";

            String old_Do="</OrderLine>";
            modifyFile(path2,old_Do,newItem_Do);



        }}
    //**Priced item
    if (!(X_PRI_I.equalsIgnoreCase(""))) {
        String[] X_PRI_SP=X_PRI_I.split(",");
        int ii=X_PRI_SP.length+1;
        //    for (ii = 1; ii <= SPC_SP.length; ii++) {
        for(String ITEMPX:X_PRI_SP){
            if (X_PRI_SP.length >= ii)
                break;
            FRC = sheet.getRow(Integer.parseInt(String.valueOf(ITEMPX)));
            RITEM=String.valueOf(FRC.getCell(24).getStringCellValue());
            RPRICE=String.valueOf(FRC.getCell(25).getStringCellValue());
            RAM=String.valueOf(FRC.getCell(26).getStringCellValue());
            RMERCH=(int) FRC.getCell(27).getNumericCellValue();
            String newItem_Do="</OrderLine"+ORMR+"><OrderLine><LineNumber>"+RITEM+"</LineNumber><ExternalLineID>"+RITEM+"</ExternalLineID><ItemID>"+RITEM+"</ItemID><MerchType>"+RMERCH+"</MerchType><LineTotal>00000000.00</LineTotal><ReasonCode/><PriceInfo><Price>"+RPRICE+"</Price></PriceInfo><Quantity><OrderedQty>6</OrderedQty><OrderedQtyUOM>unit</OrderedQtyUOM></Quantity><ShippingInfo><MustDeliverBy>01/18/18 19:00 PST</MustDeliverBy><PromisedDeliveryBy>01/18/18 18:02 PST</PromisedDeliveryBy><RequestedDeliveryBy>01/18/18 18:02 PST</RequestedDeliveryBy><ShipVia>A1</ShipVia><ShippingAddress><ShipToFirstName>RR5</ShipToFirstName><ShipToLastName>RR4 84</ShipToLastName><ShipToAddressLine1>RR8</ShipToAddressLine1><ShipToAddressLine2/><ShipToCity>RR9</ShipToCity><ShipToState>CA</ShipToState><ShipToPostalCode>RR10</ShipToPostalCode><ShipToCountry>US</ShipToCountry><ShipToPhone>RR6</ShipToPhone><ShipToEmail>RR7</ShipToEmail></ShippingAddress></ShippingInfo><LineReferenceFields><ReferenceField1>2</ReferenceField1><ReferenceField2>0</ReferenceField2><ReferenceField3>9.94999980</ReferenceField3><ReferenceField4>1</ReferenceField4><ReferenceField9>"+RAM+"</ReferenceField9></LineReferenceFields><WMNotes><WMNote><NoteType>UC</NoteType><CommentText>No notes</CommentText></WMNote></WMNotes></OrderLine>";

            String old_Do="</OrderLine>";
            modifyFile(path2,old_Do,newItem_Do);
        }}
    //**Weighted Items
    if (!(X_WEG_I.equalsIgnoreCase(""))) {
        String[] X_WEG_SP=X_WEG_I.split(",");
        int ii=X_WEG_SP.length+1;
        //    for (ii = 1; ii <= SPC_SP.length; ii++) {
        for(String ITEMWX:X_WEG_SP){
            if (X_WEG_SP.length >= ii)
                break;
            FRC = sheet.getRow(Integer.parseInt(String.valueOf(ITEMWX)));
            RITEM=String.valueOf(FRC.getCell(29).getStringCellValue());
            RPRICE=String.valueOf(FRC.getCell(30).getStringCellValue());
            RAM=String.valueOf(FRC.getCell(31).getStringCellValue());
            RMERCH=(int) FRC.getCell(32).getNumericCellValue();
            String newItem_Do="</OrderLine"+ORMR+"><OrderLine><LineNumber>"+RITEM+"</LineNumber><ExternalLineID>"+RITEM+"</ExternalLineID><ItemID>"+RITEM+"</ItemID><MerchType>"+RMERCH+"</MerchType><LineTotal>00000000.00</LineTotal><ReasonCode/><PriceInfo><Price>"+RPRICE+"</Price></PriceInfo><Quantity><OrderedQty>6</OrderedQty><OrderedQtyUOM>unit</OrderedQtyUOM></Quantity><ShippingInfo><MustDeliverBy>01/18/18 19:00 PST</MustDeliverBy><PromisedDeliveryBy>01/18/18 18:02 PST</PromisedDeliveryBy><RequestedDeliveryBy>01/18/18 18:02 PST</RequestedDeliveryBy><ShipVia>A1</ShipVia><ShippingAddress><ShipToFirstName>RR5</ShipToFirstName><ShipToLastName>RR4 84</ShipToLastName><ShipToAddressLine1>RR8</ShipToAddressLine1><ShipToAddressLine2/><ShipToCity>RR9</ShipToCity><ShipToState>CA</ShipToState><ShipToPostalCode>RR10</ShipToPostalCode><ShipToCountry>US</ShipToCountry><ShipToPhone>RR6</ShipToPhone><ShipToEmail>RR7</ShipToEmail></ShippingAddress></ShippingInfo><LineReferenceFields><ReferenceField1>2</ReferenceField1><ReferenceField2>0</ReferenceField2><ReferenceField3>9.94999980</ReferenceField3><ReferenceField4>1</ReferenceField4><ReferenceField9>"+RAM+"</ReferenceField9></LineReferenceFields><WMNotes><WMNote><NoteType>UC</NoteType><CommentText>No notes</CommentText></WMNote></WMNotes></OrderLine>";

            String old_Do="</OrderLine>";
            modifyFile(path2,old_Do,newItem_Do);

        }}
    //**Regular Items

    if (!(X_REG_I.equalsIgnoreCase(""))) {
        String[] X_REG_SP=X_REG_I.split(",");
        int ii=X_REG_SP.length+1;
        //    for (ii = 1; ii <= SPC_SP.length; ii++) {
        for(String ITEMRX:X_REG_SP){
            if (X_REG_SP.length >= ii)
                break;
            FRC = sheet.getRow(Integer.parseInt(String.valueOf(ITEMRX)));
            RITEM=String.valueOf(FRC.getCell(34).getStringCellValue());
            RPRICE=String.valueOf(FRC.getCell(35).getStringCellValue());
            RAM=String.valueOf(FRC.getCell(36).getStringCellValue());
            RMERCH=(int) FRC.getCell(37).getNumericCellValue();

            String newItem_Do="</OrderLine"+ORMR+"><OrderLine><LineNumber>"+RITEM+"</LineNumber><ExternalLineID>"+RITEM+"</ExternalLineID><ItemID>"+RITEM+"</ItemID><MerchType>"+RMERCH+"</MerchType><LineTotal>00000000.00</LineTotal><ReasonCode/><PriceInfo><Price>"+RPRICE+"</Price></PriceInfo><Quantity><OrderedQty>6</OrderedQty><OrderedQtyUOM>unit</OrderedQtyUOM></Quantity><ShippingInfo><MustDeliverBy>01/18/18 19:00 PST</MustDeliverBy><PromisedDeliveryBy>01/18/18 18:02 PST</PromisedDeliveryBy><RequestedDeliveryBy>01/18/18 18:02 PST</RequestedDeliveryBy><ShipVia>A1</ShipVia><ShippingAddress><ShipToFirstName>RR5</ShipToFirstName><ShipToLastName>RR4 84</ShipToLastName><ShipToAddressLine1>RR8</ShipToAddressLine1><ShipToAddressLine2/><ShipToCity>RR9</ShipToCity><ShipToState>CA</ShipToState><ShipToPostalCode>RR10</ShipToPostalCode><ShipToCountry>US</ShipToCountry><ShipToPhone>RR6</ShipToPhone><ShipToEmail>RR7</ShipToEmail></ShippingAddress></ShippingInfo><LineReferenceFields><ReferenceField1>2</ReferenceField1><ReferenceField2>0</ReferenceField2><ReferenceField3>9.94999980</ReferenceField3><ReferenceField4>1</ReferenceField4><ReferenceField9>"+RAM+"</ReferenceField9></LineReferenceFields><WMNotes><WMNote><NoteType>UC</NoteType><CommentText>No notes</CommentText></WMNote></WMNotes></OrderLine>";

            String old_Do="</OrderLine>";
            modifyFile(path2,old_Do,newItem_Do);
        }}
    //** PLU Items

    if (!(X_PLU_I.equalsIgnoreCase(""))) {
        String[] X_PLU_SP=X_PLU_I.split(",");
        int ii=X_PLU_SP.length+1;
        //    for (ii = 1; ii <= SPC_SP.length; ii++) {
        for(String ITEMPX:X_PLU_SP){
            if (X_PLU_SP.length >= ii)
                break;
            FRC = sheet.getRow(Integer.parseInt(String.valueOf(ITEMPX)));
            RITEM=String.valueOf(FRC.getCell(39).getStringCellValue());
            RPRICE=String.valueOf(FRC.getCell(40).getStringCellValue());
            RAM=String.valueOf(FRC.getCell(41).getStringCellValue());
            RMERCH=(int) FRC.getCell(42).getNumericCellValue();
            String newItem_Do="</OrderLine"+ORMR+"><OrderLine><LineNumber>"+RITEM+"</LineNumber><ExternalLineID>"+RITEM+"</ExternalLineID><ItemID>"+RITEM+"</ItemID><MerchType>"+RMERCH+"</MerchType><LineTotal>00000000.00</LineTotal><ReasonCode/><PriceInfo><Price>"+RPRICE+"</Price></PriceInfo><Quantity><OrderedQty>6</OrderedQty><OrderedQtyUOM>unit</OrderedQtyUOM></Quantity><ShippingInfo><MustDeliverBy>01/18/18 19:00 PST</MustDeliverBy><PromisedDeliveryBy>01/18/18 18:02 PST</PromisedDeliveryBy><RequestedDeliveryBy>01/18/18 18:02 PST</RequestedDeliveryBy><ShipVia>A1</ShipVia><ShippingAddress><ShipToFirstName>RR5</ShipToFirstName><ShipToLastName>RR4 84</ShipToLastName><ShipToAddressLine1>RR8</ShipToAddressLine1><ShipToAddressLine2/><ShipToCity>RR9</ShipToCity><ShipToState>CA</ShipToState><ShipToPostalCode>RR10</ShipToPostalCode><ShipToCountry>US</ShipToCountry><ShipToPhone>RR6</ShipToPhone><ShipToEmail>RR7</ShipToEmail></ShippingAddress></ShippingInfo><LineReferenceFields><ReferenceField1>2</ReferenceField1><ReferenceField2>0</ReferenceField2><ReferenceField3>9.94999980</ReferenceField3><ReferenceField4>1</ReferenceField4><ReferenceField9>"+RAM+"</ReferenceField9></LineReferenceFields><WMNotes><WMNote><NoteType>UC</NoteType><CommentText>No notes</CommentText></WMNote></WMNotes></OrderLine>";

           String old_Do="</OrderLine>";
    modifyFile(path2,old_Do,newItem_Do);
}}}

    public final void DO_update4() throws IOException{
        FRC = sheet.getRow(i);

        MR2 = String.valueOf(FRC.getCell(10).getStringCellValue());
        modifyFile(path2,"RR2",MR2);
        System.out.println("done");

    }

    public final void DO_update5() throws IOException {
        FRC = sheet.getRow(i);
        MR3 = String.valueOf(FRC.getCell(3).getStringCellValue());

        modifyFile(path2,"RR3",MR3);
    }

    public final void DO_update6() throws IOException {
        FRC = sheet.getRow(i);
        MR4 = String.valueOf(FRC.getCell(1).getStringCellValue());

        modifyFile(path2,"RR4",MR4);

    }

    public final void DO_update7() throws IOException {

        FRC = sheet.getRow(i);
        MR5 = String.valueOf(FRC.getCell(0).getStringCellValue());

        modifyFile(path2,"RR5",MR5);

    }

    public final void DO_update8() throws IOException {
        FRC = sheet.getRow(i);
        MR6 = String.valueOf(FRC.getCell(7).getStringCellValue());

        modifyFile(path2,"RR6",MR6);

    }

    public final void DO_update9() throws IOException {
        FRC = sheet.getRow(i);
        MR7 = String.valueOf(FRC.getCell(2).getStringCellValue());


        modifyFile(path2,"RR7",MR7);

    }

    public final void DO_update10() throws IOException {
        FRC = sheet.getRow(i);
        MR8 = String.valueOf(FRC.getCell(4).getStringCellValue());
        modifyFile(path2,"RR8",MR8);

    }

    public final void DO_update11() throws IOException {
        FRC = sheet.getRow(i);
        MR9 = String.valueOf(FRC.getCell(5).getStringCellValue());

        modifyFile(path2,"RR9",MR9);

    }

    public final void DO_update12() throws IOException {
        FRC = sheet.getRow(i);
        MR10 = String.valueOf(FRC.getCell(6).getStringCellValue());
        modifyFile(path2,"RR10",MR10);

    }

    public final void DO_update13() throws IOException {

        modifyFile(path2,"01/18/18",MR11);

    }
    public final void DO_update15()throws IOException{
        FRC = sheet.getRow(i);
        DOTotal=FRC.getCell(43).getNumericCellValue();

        modifyFile(path2,"RLTOTALAUTDO", String.valueOf(DOTotal));
    }
    public final void DO_update16()throws IOException{
        FRC = sheet.getRow(i);
        VanZone= String.valueOf(FRC.getCell(44).getStringCellValue());
                modifyFile(path2,"VAN", String.valueOf(VanZone));
    }
    public final void DO_update14() throws IOException {

        modifyFile(path2,"</OrderLineRN>","</OrderLine>");
        System.out.println("XML created successfully for Order number---"+MR2);
    }

    public final void MIFORDERDO() throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver", chromepath);
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 80);
        driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
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
        choose.sendKeys(path2);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='sendMsg']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Message posted')]")));

        String result= driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[3]")).getText();
        if(result.equalsIgnoreCase("Message sent to destination successfully")){
            System.out.println("Passed");
            FRC = sheet.getRow(i);
            Ccell = FRC.createCell(45);
            Ccell.setCellValue("PASSED");
            FileOutputStream fos = new FileOutputStream(Config_Data.DataXML);
            WB.write(fos);
            fos.close();
        }

        else{
            FRC = sheet.getRow(i);
            Ccell = FRC.createCell(45);
            Ccell.setCellValue("FAILED");
            FileOutputStream fos = new FileOutputStream(Config_Data.DataXML);
            WB.write(fos);
            fos.close();
            System.out.println("FAILED");

        }
        Thread.sleep(2000);
        driver.close();
    }

    public static void main(String args[]) throws IOException, InterruptedException {
        DO_Creation DO = new DO_Creation();
        DO.DO_update0();
        for (i = 1; i <= Rcount; i++) {
            try {
                FRC = sheet.getRow(i);
                String Status = FRC.getCell(12).getStringCellValue();
                if (String.valueOf(Status).equalsIgnoreCase("FAILED"))
                    continue;
                DO_update1();
                DO_update2();
                Do_update3();
                DO.DO_update4();
                DO.DO_update5();
                DO.DO_update6();
                DO.DO_update7();
                DO.DO_update8();
                DO.DO_update9();
                DO.DO_update10();
                DO.DO_update11();
                DO.DO_update12();
                DO.DO_update13();
                DO.DO_update15();
                DO.DO_update16();
                DO.DO_update14();
                DO.MIFORDERDO();

            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }}