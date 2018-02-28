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


import java.io.*;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import static Test_Maven_start.Adding_Items.ii;
import static Test_Maven_start.Config_Data.chromepath;
import static java.lang.Float.parseFloat;

public class MIF_XML_Creation extends MIF_XML_Util{

    public static String path1;
    public static int i;
    public static HSSFRow FRC;
    public static HSSFCell Ccell;
    public static HSSFSheet sheet;
    public static HSSFWorkbook WB;
    public  static int Rcount;
    public  static   String MR2;
    public static float sum_SPC= parseFloat("0.0");
    public static float sum_PRI=parseFloat("0.0");
    public static float sum_WEG=parseFloat("0.0");
    public static float sum_REG=parseFloat("0.0");
    public static float sum_PLU=parseFloat("0.0");
    public static float sum_default= (float) 44.88;
    public static float sum_Totall;
    public static DecimalFormat df;

public  static  String ORMR="RN";
    //   public  static  String MR1="91047396_1211";
public final void update0() throws IOException, InterruptedException {

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
     path1 = "C:\\Users\\Rmoha17\\Desktop\\DataMIF\\" + MR2 + ".xml";
    String X_SPC = FRC.getCell(13).getStringCellValue();
    String X_PRI_I = FRC.getCell(14).getStringCellValue();
    String X_WEG_I = FRC.getCell(15).getStringCellValue();
    String X_REG_I = FRC.getCell(16).getStringCellValue();
    String X_PLU_I =  FRC.getCell(17).getStringCellValue();

    //**** Data end
}

    public final void update1() throws FileNotFoundException, IOException {

        PrintWriter writer = new PrintWriter(path1, "UTF-8");
        writer.println("Testing");
        writer.close();
    }
   public  final static void update2() throws IOException {

        modifyFile(path1,"Testing",MIF_XML_Util.SKLT);
    }

    public final void update3() throws IOException, InterruptedException {
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
            String newItem="</OrderLine"+ORMR+"><OrderLine><LineNumber>"+RITEM+"</LineNumber><ExternalLineID>"+RITEM+"</ExternalLineID><ItemID>"+RITEM+"</ItemID><MerchType>1</MerchType><LineTotal>"+RLTOTAL+"</LineTotal><Canceled>False</Canceled><ReasonCode>TS</ReasonCode><AllocationInfo><FulfillmentFacility>RR3</FulfillmentFacility></AllocationInfo><PriceInfo><Price>"+RPRICE+"</Price></PriceInfo><Quantity><OrderedQty>6</OrderedQty><OrderedQtyUOM>unit</OrderedQtyUOM></Quantity><ShippingInfo><MustDeliverBy>01/18/18 21:00</MustDeliverBy><PromisedDeliveryBy>01/18/18 20:02</PromisedDeliveryBy><RequestedDeliveryBy>01/18/18 20:02</RequestedDeliveryBy><ShipVia>A1</ShipVia><ShippingAddress><ShipToFirstName>RR5</ShipToFirstName><ShipToLastName>MR4</ShipToLastName><ShipToAddressLine1>RR8</ShipToAddressLine1><ShipToAddressLine2/><ShipToCity>RR9</ShipToCity><ShipToState>CA</ShipToState><ShipToPostalCode>RR10</ShipToPostalCode><ShipToCountry>US</ShipToCountry><ShipToPhone>RR6</ShipToPhone><ShiptoFax/><ShipToEmail>RR7</ShipToEmail></ShippingAddress></ShippingInfo><LineReferenceFields><ReferenceField1>2</ReferenceField1><ReferenceField2>0</ReferenceField2><ReferenceField3>9.949999809265137</ReferenceField3><ReferenceField4>1</ReferenceField4><ReferenceField6/><ReferenceField7/><ReferenceField8/></LineReferenceFields><WMNotes><WMNote><NoteType>UC</NoteType><CommentText>No notes</CommentText></WMNote></WMNotes></OrderLine>";
        String old="</OrderLine>";

        modifyFile(path1,old,newItem);
             df = new DecimalFormat("###.##");
            float number = Float.valueOf(sum_SPC);

            float number1 = Float.valueOf(RPRICE);

        sum_SPC= (number)+(number1*6);
        df.format(sum_SPC);
     //       System.out.println(""+df.format(sum_SPC));

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
                String newItem="</OrderLine"+ORMR+"><OrderLine><LineNumber>"+RITEM+"</LineNumber><ExternalLineID>"+RITEM+"</ExternalLineID><ItemID>"+RITEM+"</ItemID><MerchType>1</MerchType><LineTotal>"+RLTOTAL+"</LineTotal><Canceled>False</Canceled><ReasonCode>TS</ReasonCode><AllocationInfo><FulfillmentFacility>RR3</FulfillmentFacility></AllocationInfo><PriceInfo><Price>"+RPRICE+"</Price></PriceInfo><Quantity><OrderedQty>6</OrderedQty><OrderedQtyUOM>unit</OrderedQtyUOM></Quantity><ShippingInfo><MustDeliverBy>01/18/18 21:00</MustDeliverBy><PromisedDeliveryBy>01/18/18 20:02</PromisedDeliveryBy><RequestedDeliveryBy>01/18/18 20:02</RequestedDeliveryBy><ShipVia>A1</ShipVia><ShippingAddress><ShipToFirstName>RR5</ShipToFirstName><ShipToLastName>MR4</ShipToLastName><ShipToAddressLine1>RR8</ShipToAddressLine1><ShipToAddressLine2/><ShipToCity>RR9</ShipToCity><ShipToState>CA</ShipToState><ShipToPostalCode>RR10</ShipToPostalCode><ShipToCountry>US</ShipToCountry><ShipToPhone>RR6</ShipToPhone><ShiptoFax/><ShipToEmail>RR7</ShipToEmail></ShippingAddress></ShippingInfo><LineReferenceFields><ReferenceField1>2</ReferenceField1><ReferenceField2>0</ReferenceField2><ReferenceField3>9.949999809265137</ReferenceField3><ReferenceField4>1</ReferenceField4><ReferenceField6/><ReferenceField7/><ReferenceField8/></LineReferenceFields><WMNotes><WMNote><NoteType>UC</NoteType><CommentText>No notes</CommentText></WMNote></WMNotes></OrderLine>";
                String old="</OrderLine>";

                modifyFile(path1,old,newItem);

                df = new DecimalFormat("###.##");
                float number2 = Float.valueOf(sum_PRI);

                float number3 = Float.valueOf(RPRICE);

                sum_PRI= (number2)+(number3*6);
                df.format(sum_PRI);
                System.out.println(""+df.format(sum_PRI));

              //  sum_total=(sum_PRI)+(sum_SPC);
               // System.out.println(""+df.format(sum_total));
            //    sum_Totall= Float.parseFloat(df.format(sum_total));

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
                String newItem="</OrderLine"+ORMR+"><OrderLine><LineNumber>"+RITEM+"</LineNumber><ExternalLineID>"+RITEM+"</ExternalLineID><ItemID>"+RITEM+"</ItemID><MerchType>1</MerchType><LineTotal>"+RLTOTAL+"</LineTotal><Canceled>False</Canceled><ReasonCode>TS</ReasonCode><AllocationInfo><FulfillmentFacility>RR3</FulfillmentFacility></AllocationInfo><PriceInfo><Price>"+RPRICE+"</Price></PriceInfo><Quantity><OrderedQty>6</OrderedQty><OrderedQtyUOM>unit</OrderedQtyUOM></Quantity><ShippingInfo><MustDeliverBy>01/18/18 21:00</MustDeliverBy><PromisedDeliveryBy>01/18/18 20:02</PromisedDeliveryBy><RequestedDeliveryBy>01/18/18 20:02</RequestedDeliveryBy><ShipVia>A1</ShipVia><ShippingAddress><ShipToFirstName>RR5</ShipToFirstName><ShipToLastName>MR4</ShipToLastName><ShipToAddressLine1>RR8</ShipToAddressLine1><ShipToAddressLine2/><ShipToCity>RR9</ShipToCity><ShipToState>CA</ShipToState><ShipToPostalCode>RR10</ShipToPostalCode><ShipToCountry>US</ShipToCountry><ShipToPhone>RR6</ShipToPhone><ShiptoFax/><ShipToEmail>RR7</ShipToEmail></ShippingAddress></ShippingInfo><LineReferenceFields><ReferenceField1>2</ReferenceField1><ReferenceField2>0</ReferenceField2><ReferenceField3>9.949999809265137</ReferenceField3><ReferenceField4>1</ReferenceField4><ReferenceField6/><ReferenceField7/><ReferenceField8/></LineReferenceFields><WMNotes><WMNote><NoteType>UC</NoteType><CommentText>No notes</CommentText></WMNote></WMNotes></OrderLine>";
                String old="</OrderLine>";

                modifyFile(path1,old,newItem);
                /*sum_WEG+=(sum_WEG+(RPRICE));
                System.out.println(""+sum_WEG);*/
                df = new DecimalFormat("###.##");
                float number4 = Float.valueOf(sum_WEG);

                float number5 = Float.valueOf(RPRICE);

                sum_WEG= (number4)+(number5*6);
                df.format(sum_WEG);

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
                String newItem="</OrderLine"+ORMR+"><OrderLine><LineNumber>"+RITEM+"</LineNumber><ExternalLineID>"+RITEM+"</ExternalLineID><ItemID>"+RITEM+"</ItemID><MerchType>1</MerchType><LineTotal>"+RLTOTAL+"</LineTotal><Canceled>False</Canceled><ReasonCode>TS</ReasonCode><AllocationInfo><FulfillmentFacility>RR3</FulfillmentFacility></AllocationInfo><PriceInfo><Price>"+RPRICE+"</Price></PriceInfo><Quantity><OrderedQty>6</OrderedQty><OrderedQtyUOM>unit</OrderedQtyUOM></Quantity><ShippingInfo><MustDeliverBy>01/18/18 21:00</MustDeliverBy><PromisedDeliveryBy>01/18/18 20:02</PromisedDeliveryBy><RequestedDeliveryBy>01/18/18 20:02</RequestedDeliveryBy><ShipVia>A1</ShipVia><ShippingAddress><ShipToFirstName>RR5</ShipToFirstName><ShipToLastName>MR4</ShipToLastName><ShipToAddressLine1>RR8</ShipToAddressLine1><ShipToAddressLine2/><ShipToCity>RR9</ShipToCity><ShipToState>CA</ShipToState><ShipToPostalCode>RR10</ShipToPostalCode><ShipToCountry>US</ShipToCountry><ShipToPhone>RR6</ShipToPhone><ShiptoFax/><ShipToEmail>RR7</ShipToEmail></ShippingAddress></ShippingInfo><LineReferenceFields><ReferenceField1>2</ReferenceField1><ReferenceField2>0</ReferenceField2><ReferenceField3>9.949999809265137</ReferenceField3><ReferenceField4>1</ReferenceField4><ReferenceField6/><ReferenceField7/><ReferenceField8/></LineReferenceFields><WMNotes><WMNote><NoteType>UC</NoteType><CommentText>No notes</CommentText></WMNote></WMNotes></OrderLine>";
                String old="</OrderLine>";

                modifyFile(path1,old,newItem);
                df = new DecimalFormat("###.##");
                float number6 = Float.valueOf(sum_REG);

                float number7 = Float.valueOf(RPRICE);

                sum_REG= (number6)+(number7*6);
                df.format(sum_REG);
                /*sum_REG+=(sum_REG+(RPRICE));
                System.out.println(""+sum_REG);*/

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
                String newItem="</OrderLine"+ORMR+"><OrderLine><LineNumber>"+RITEM+"</LineNumber><ExternalLineID>"+RITEM+"</ExternalLineID><ItemID>"+RITEM+"</ItemID><MerchType>1</MerchType><LineTotal>"+RLTOTAL+"</LineTotal><Canceled>False</Canceled><ReasonCode>TS</ReasonCode><AllocationInfo><FulfillmentFacility>RR3</FulfillmentFacility></AllocationInfo><PriceInfo><Price>"+RPRICE+"</Price></PriceInfo><Quantity><OrderedQty>6</OrderedQty><OrderedQtyUOM>unit</OrderedQtyUOM></Quantity><ShippingInfo><MustDeliverBy>01/18/18 21:00</MustDeliverBy><PromisedDeliveryBy>01/18/18 20:02</PromisedDeliveryBy><RequestedDeliveryBy>01/18/18 20:02</RequestedDeliveryBy><ShipVia>A1</ShipVia><ShippingAddress><ShipToFirstName>RR5</ShipToFirstName><ShipToLastName>MR4</ShipToLastName><ShipToAddressLine1>RR8</ShipToAddressLine1><ShipToAddressLine2/><ShipToCity>RR9</ShipToCity><ShipToState>CA</ShipToState><ShipToPostalCode>RR10</ShipToPostalCode><ShipToCountry>US</ShipToCountry><ShipToPhone>RR6</ShipToPhone><ShiptoFax/><ShipToEmail>RR7</ShipToEmail></ShippingAddress></ShippingInfo><LineReferenceFields><ReferenceField1>2</ReferenceField1><ReferenceField2>0</ReferenceField2><ReferenceField3>9.949999809265137</ReferenceField3><ReferenceField4>1</ReferenceField4><ReferenceField6/><ReferenceField7/><ReferenceField8/></LineReferenceFields><WMNotes><WMNote><NoteType>UC</NoteType><CommentText>No notes</CommentText></WMNote></WMNotes></OrderLine>";
                String old="</OrderLine>";

                modifyFile(path1,old,newItem);
                df = new DecimalFormat("###.##");
                float number8 = Float.valueOf(sum_PLU);

                float number9 = Float.valueOf(RPRICE);

                sum_PLU= (number8)+(number9*6);
                df.format(sum_PLU);
                /*sum_PLU+=(sum_PLU+(RPRICE));
                System.out.println(""+sum_PLU);*/


            }}
 }

    /* public final void update2() {

         modifyFile(path, "RR1", MR1);
         System.out.println("done");
     }*/

    public final void update4() throws IOException{
        FRC = sheet.getRow(i);

        MR2 = String.valueOf(FRC.getCell(10).getStringCellValue());
        modifyFile(path1,"RR2",MR2);
        System.out.println("done");

    }

    public final void update5() throws IOException {
        FRC = sheet.getRow(i);
        MR3 = String.valueOf(FRC.getCell(3).getStringCellValue());

        modifyFile(path1,"RR3",MR3);
    }

    public final void update6() throws IOException {
        FRC = sheet.getRow(i);
        MR4 = String.valueOf(FRC.getCell(1).getStringCellValue());

        modifyFile(path1,"RR4",MR4);

    }

    public final void update7() throws IOException {

        FRC = sheet.getRow(i);
        MR5 = String.valueOf(FRC.getCell(0).getStringCellValue());

        modifyFile(path1,"RR5",MR5);

    }

    public final void update8() throws IOException {
        FRC = sheet.getRow(i);
        MR6 = String.valueOf(FRC.getCell(7).getStringCellValue());

        modifyFile(path1,"RR6",MR6);

    }

    public final void update9() throws IOException {
        FRC = sheet.getRow(i);
        MR7 = String.valueOf(FRC.getCell(2).getStringCellValue());


        modifyFile(path1,"RR7",MR7);

    }

    public final void update10() throws IOException {
        FRC = sheet.getRow(i);
        MR8 = String.valueOf(FRC.getCell(4).getStringCellValue());
        modifyFile(path1,"RR8",MR8);

    }

    public final void update11() throws IOException {
        FRC = sheet.getRow(i);
        MR9 = String.valueOf(FRC.getCell(5).getStringCellValue());

        modifyFile(path1,"RR9",MR9);

    }

    public final void update12() throws IOException {
        FRC = sheet.getRow(i);
        MR10 = String.valueOf(FRC.getCell(6).getStringCellValue());
        modifyFile(path1,"RR10",MR10);

    }

    public final void update13() throws IOException {

        modifyFile(path1,"01/18/18",MR11);

    }
    public final void update15() throws IOException {


        modifyFile(path1,"RLTOTALAUT", String.valueOf(sum_Totall));
      //  System.out.println("XML created successfully for Order number---"+MR2);
    }
    public final void update14() throws IOException {

        modifyFile(path1,"</OrderLineRN>","</OrderLine>");
        System.out.println("XML created successfully for Order number---"+MR2);
    }


    public final void MIFORDER() throws InterruptedException, IOException {

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
        choose.sendKeys(path1);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='sendMsg']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Message posted')]")));

        String result= driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[3]")).getText();
        if(result.equalsIgnoreCase("Message sent to destination successfully")){
            System.out.println("Passed");
            FRC = sheet.getRow(i);
            Ccell = FRC.createCell(12);
            Ccell.setCellValue("PASSED");
            FileOutputStream fos = new FileOutputStream(Config_Data.DataXML);
            WB.write(fos);
            fos.close();
        }

        else{
            FRC = sheet.getRow(i);
            Ccell = FRC.createCell(12);
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

            MIF_XML_Creation te=new MIF_XML_Creation();

        te.update0();
        for (i = 1; i <= Rcount; i++) {
            try {
                FRC = sheet.getRow(i);

                String Status = FRC.getCell(11).getStringCellValue();
                if (String.valueOf(Status).equalsIgnoreCase("No_run"))
                    continue;
                MR2 = String.valueOf(FRC.getCell(10).getStringCellValue());
                path1 = "C:\\Users\\Rmoha17\\Desktop\\DataMIF\\" + MR2 + ".xml";
             //   System.out.println(""+path1);
                te.update1();
                te.update2();
                te.update3();
                FRC = sheet.getRow(i);
                sum_Totall=(sum_PRI)+(sum_SPC)+(sum_WEG)+(sum_REG)+(sum_PLU)+(sum_default);
                Ccell = FRC.createCell(43);
                Ccell.setCellValue(sum_Totall);
                FileOutputStream fos = new FileOutputStream(Config_Data.DataXML);
                WB.write(fos);
                fos.close();
                te.update4();
                te.update5();
                te.update6();
                te.update7();
                te.update8();
                te.update9();
                te.update10();
                te.update11();
                te.update12();
                te.update13();
                te.update15();
                te.update14();
                te.MIFORDER();

            }catch (Exception E){
                System.out.println("Error in EXCEL Boss");

            }
        };



    }  }