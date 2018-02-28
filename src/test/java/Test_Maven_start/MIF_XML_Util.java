package Test_Maven_start;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;

import static java.lang.System.lineSeparator;

public class MIF_XML_Util
    {

        public  static   String MR3;
        public  static   String MR4;
        public  static   String MR5;
        public  static   String MR6;
        public  static   String MR7;
        public  static  String MR8;
        public  static  String MR9;
        public  static  String MR10;
        public  static  String MR11;
        public static   String RITEM;
        public static String RLTOTAL=" 00000000.00";
        public static String RLTOTALAUT;
        public static String RPRICE;
        public static FileInputStream fis;

        public static int X_SPC;
        public static int X_PRI_I;
        public static int X_WEG_I;
        public static int X_REG_I;
        public static int X_PLU_I;
        public static double DOTotal;
        public static String  VanZone;
        public static  String SKLT="<tXML xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:wsdl=\"http://schemas.xmlsoap.org/wsdl/\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><Header><Source>Host</Source><Action_Type>Create</Action_Type><Reference_ID>RR2_1211</Reference_ID><Message_Type>Customer Order</Message_Type><Company_ID>70</Company_ID><Msg_Locale>English (United States)</Msg_Locale></Header><Message><Order><OrderNumber>RR2</OrderNumber><ExternalOrderNumber>RR2</ExternalOrderNumber><OrderType>RG</OrderType><OrderTotal>"+RLTOTAL+"</OrderTotal><OrderCurrency>USD</OrderCurrency><EnteredBy>ecommerce</EnteredBy><EnteredLocation>RR3</EnteredLocation><EntryType>Web</EntryType><Canceled>False</Canceled><CustomerInfo><CustomerId>15732070</CustomerId><CustomerLastName>RR4</CustomerLastName><CustomerFirstName>RR5</CustomerFirstName><CustomerPhone>RR6</CustomerPhone><CustomerEmail>RR7</CustomerEmail></CustomerInfo><PaymentDetails><PaymentDetail><ExternalPaymentDetailId>72606001</ExternalPaymentDetailId><CardType>Visa</CardType><PaymentMethod>Credit Card</PaymentMethod><AccountNumber>9279539800391109</AccountNumber><CardExpiryMonth>12</CardExpiryMonth><CardExpiryYear>2019</CardExpiryYear><SecurityCode>1</SecurityCode><CurrencyCode>USD</CurrencyCode><ReqAuthorizationAmount> RLTOTALAUT</ReqAuthorizationAmount><ReferenceFields><ReferenceField1/><ReferenceField2/><ReferenceField3/><ReferenceField4>37.7588</ReferenceField4><ReferenceField5>-121.944</ReferenceField5><ReferenceField6>49123329863</ReferenceField6><ReferenceField7>RR3</ReferenceField7><ReferenceField8>15732070</ReferenceField8></ReferenceFields><BillToDetail><BillToFirstName>RR5</BillToFirstName><BillToLastName>RR4</BillToLastName><BillToAddressLine1>RR8</BillToAddressLine1><BillToAddressLine2/><BillToCity>RR9</BillToCity><BillToState>CA</BillToState><BillToPostalCode>RR10</BillToPostalCode><BillToCountry>US</BillToCountry><BillToPhone>RR6</BillToPhone><BillToEmail>RR7</BillToEmail></BillToDetail></PaymentDetail></PaymentDetails><ReferenceFields><ReferenceField1/><ReferenceField2/><ReferenceField3/><ReferenceField4/><ReferenceField5/><ReferenceField6/><ReferenceField7/><ReferenceField8/><ReferenceField9/><ReferenceField10/><ReferenceNumber1/><ReferenceNumber2/><ReferenceNumber3/><ReferenceNumber4/><ReferenceNumber5/></ReferenceFields><ChargeDetails><ChargeDetail><ExtChargeDetailId>0000000022173</ExtChargeDetailId><ChargeCategory>Misc</ChargeCategory><ChargeName>Fuel Surcharge</ChargeName><ChargeAmount>1.48</ChargeAmount></ChargeDetail><ChargeDetail><ExtChargeDetailId>0000000029103</ExtChargeDetailId><ChargeCategory>Misc</ChargeCategory><ChargeName>Bag Fee non regulatory</ChargeName><ChargeAmount>0.1</ChargeAmount></ChargeDetail><ChargeDetail><ExtChargeDetailId>0000000022123</ExtChargeDetailId><ChargeCategory>Shipping</ChargeCategory><ChargeName>Delivery Charge</ChargeName><ChargeAmount>9.9499998092651367</ChargeAmount></ChargeDetail></ChargeDetails><OrderLines><OrderLine><LineNumber>960056464</LineNumber><ExternalLineID>960056464</ExternalLineID><ItemID>960056464</ItemID><MerchType>1</MerchType><LineTotal> 00000033.35</LineTotal><Canceled>False</Canceled><ReasonCode>TS</ReasonCode><AllocationInfo><FulfillmentFacility>RR3</FulfillmentFacility></AllocationInfo><PriceInfo><Price>33.349998474121094</Price></PriceInfo><Quantity><OrderedQty>1</OrderedQty><OrderedQtyUOM>unit</OrderedQtyUOM></Quantity><ShippingInfo><MustDeliverBy>01/18/18 21:00</MustDeliverBy><PromisedDeliveryBy>01/18/18 20:02</PromisedDeliveryBy><RequestedDeliveryBy>01/18/18 20:02</RequestedDeliveryBy><ShipVia>A1</ShipVia><ShippingAddress><ShipToFirstName>RR5</ShipToFirstName><ShipToLastName>RR4</ShipToLastName><ShipToAddressLine1>RR8</ShipToAddressLine1><ShipToAddressLine2/><ShipToCity>RR9</ShipToCity><ShipToState>CA</ShipToState><ShipToPostalCode>RR10</ShipToPostalCode><ShipToCountry>US</ShipToCountry><ShipToPhone>RR6</ShipToPhone><ShiptoFax/><ShipToEmail>RR7</ShipToEmail></ShippingAddress></ShippingInfo><LineReferenceFields><ReferenceField1>2</ReferenceField1><ReferenceField2>0</ReferenceField2><ReferenceField3>12.949999809265137</ReferenceField3><ReferenceField4>1</ReferenceField4><ReferenceField6/><ReferenceField7/><ReferenceField8/></LineReferenceFields><WMNotes><WMNote><NoteType>UC</NoteType><CommentText>No notes</CommentText></WMNote></WMNotes></OrderLine></OrderLines></Order></Message></tXML>";

   public static  String DO_SKLT="<?xml version=\"1.0\" encoding=\"UTF-8\"?><tXML xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:wsdl=\"http://schemas.xmlsoap.org/wsdl/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" ><Header><Source>Host</Source><Action_Type>Update</Action_Type><Reference_ID>RR2</Reference_ID><Message_Type>Customer Order</Message_Type><Company_ID>70</Company_ID><Msg_Locale>English (United States)</Msg_Locale></Header><Message><Order><OrderNumber>RR2</OrderNumber><ExternalOrderNumber>RR2</ExternalOrderNumber><OrderType>RG</OrderType><OrderTotal>00000000.00</OrderTotal><OrderCurrency>USD</OrderCurrency><EnteredBy>ecommerce</EnteredBy><EnteredLocation>RR3</EnteredLocation><EntryType>Web</EntryType><Canceled/><CustomerInfo><CustomerId>15731106</CustomerId><CustomerLastName>RR4 84</CustomerLastName><CustomerFirstName>RR5</CustomerFirstName><CustomerPhone>RR6</CustomerPhone><CustomerEmail>RR7</CustomerEmail></CustomerInfo><PaymentDetails><PaymentDetail><CardType>Visa</CardType><ExternalPaymentDetailId>77698001</ExternalPaymentDetailId><PaymentMethod>Credit Card</PaymentMethod><AccountNumber>2681457726051109</AccountNumber><CardExpiryMonth>12</CardExpiryMonth><CardExpiryYear>2019</CardExpiryYear><SecurityCode/><CurrencyCode>USD</CurrencyCode><ReqAuthorizationAmount>RLTOTALAUTDO</ReqAuthorizationAmount><ReferenceFields><ReferenceField1>test order do not deliver</ReferenceField1><ReferenceField2/><ReferenceField3/><ReferenceField4>37.8102</ReferenceField4><ReferenceField5>-121.904</ReferenceField5><ReferenceField6>49123260905</ReferenceField6><ReferenceField7>RR3</ReferenceField7><ReferenceField8>15731106</ReferenceField8><ReferenceField9>Routed</ReferenceField9></ReferenceFields><BillToDetail><BillToFirstName>TestA</BillToFirstName><BillToLastName>RR4 84</BillToLastName><BillToAddressLine1>RR8</BillToAddressLine1><BillToAddressLine2/><BillToCity>RR9</BillToCity><BillToState>CA</BillToState><BillToPostalCode>RR10</BillToPostalCode><BillToCountry>US</BillToCountry><BillToPhone>RR6</BillToPhone><BillToEmail>RR7</BillToEmail></BillToDetail></PaymentDetail></PaymentDetails><ReferenceFields><ReferenceField1>VAN</ReferenceField1><ReferenceField2>01/18/18 17:30</ReferenceField2><ReferenceField3>2911402</ReferenceField3><ReferenceField4>01/18/18 20:24</ReferenceField4><ReferenceField5>006</ReferenceField5><ReferenceField6>01/18/18 17:30</ReferenceField6><ReferenceField7>01/18/18 20:24</ReferenceField7><ReferenceNumber1>1</ReferenceNumber1><ReferenceNumber2>1</ReferenceNumber2><ReferenceNumber3>0</ReferenceNumber3><ReferenceNumber4>0</ReferenceNumber4><ReferenceNumber5>3</ReferenceNumber5></ReferenceFields><ChargeDetails><ChargeDetail><ExtChargeDetailId>0000000022140</ExtChargeDetailId><ChargeCategory>Shipping</ChargeCategory><ChargeName>Delivery Charge</ChargeName><ChargeAmount>9.9499998092651367</ChargeAmount></ChargeDetail><ChargeDetail><ExtChargeDetailId>0000000022173</ExtChargeDetailId><ChargeCategory>Misc</ChargeCategory><ChargeName>Fuel Surcharge</ChargeName><ChargeAmount>1.4800000190734863</ChargeAmount></ChargeDetail><ChargeDetail><ExtChargeDetailId>0000000029103</ExtChargeDetailId><ChargeCategory>Misc</ChargeCategory><ChargeName>Bag Fee non regulatory</ChargeName><ChargeAmount>0.10000000149011612</ChargeAmount></ChargeDetail></ChargeDetails><OrderLines><OrderLine><LineNumber>960056464</LineNumber><ExternalLineID>960056464</ExternalLineID><ItemID>960056464</ItemID><MerchType>308</MerchType><LineTotal>00000000.00</LineTotal><ReasonCode/><PriceInfo><Price>33.34</Price></PriceInfo><Quantity><OrderedQty>1</OrderedQty><OrderedQtyUOM>unit</OrderedQtyUOM></Quantity><ShippingInfo><MustDeliverBy>01/18/18 19:00 PST</MustDeliverBy><PromisedDeliveryBy>01/18/18 18:02 PST</PromisedDeliveryBy><RequestedDeliveryBy>01/18/18 18:02 PST</RequestedDeliveryBy><ShipVia>A1</ShipVia><ShippingAddress><ShipToFirstName>RR5</ShipToFirstName><ShipToLastName>RR4 84</ShipToLastName><ShipToAddressLine1>RR8</ShipToAddressLine1><ShipToAddressLine2/><ShipToCity>RR9</ShipToCity><ShipToState>CA</ShipToState><ShipToPostalCode>RR10</ShipToPostalCode><ShipToCountry>US</ShipToCountry><ShipToPhone>RR6</ShipToPhone><ShipToEmail>RR7</ShipToEmail></ShippingAddress></ShippingInfo><LineReferenceFields><ReferenceField1>2</ReferenceField1><ReferenceField2>0</ReferenceField2><ReferenceField3>9.94999980</ReferenceField3><ReferenceField4>1</ReferenceField4><ReferenceField9>AM</ReferenceField9></LineReferenceFields><WMNotes><WMNote><NoteType>UC</NoteType><CommentText>No notes</CommentText></WMNote></WMNotes></OrderLine></OrderLines></Order></Message></tXML>";


        static void modifyFile(String filePath, String oldString, String newString) throws IOException {
            File fileToBeModified = new File(filePath);

            String oldContent = "";

            BufferedReader reader = null;

            FileWriter writer = null;



          //***** Data sheet*****
            /*fis = new FileInputStream(Config_Data.DataXML);
            WB = new HSSFWorkbook(fis);
            sheet = WB.getSheetAt(0);
             Rcount = sheet.getLastRowNum();
            FRC=sheet.getRow(1);

             MR5=String.valueOf(FRC.getCell(0).getStringCellValue());
             MR4=String.valueOf(FRC.getCell(1).getStringCellValue());
             MR7=String.valueOf(FRC.getCell(2).getStringCellValue());
             MR3=String.valueOf(FRC.getCell(3).getStringCellValue());
             MR8=String.valueOf(FRC.getCell(4).getStringCellValue());
             MR9=String.valueOf(FRC.getCell(5).getStringCellValue());
             MR10=String.valueOf(FRC.getCell(6).getStringCellValue());
             MR6=String.valueOf(FRC.getCell(7).getStringCellValue());
             MR2=String.valueOf(FRC.getCell(10).getStringCellValue());
             RITEM=String.valueOf(FRC.getCell(19).getStringCellValue());
            RPRICE=String.valueOf(FRC.getCell(20).getStringCellValue());
            X_SPC= Integer.parseInt(String.valueOf(FRC.getCell(13).getNumericCellValue()));
            //**** Data end
*/
            try
            {
                reader = new BufferedReader(new FileReader(fileToBeModified));

                //Reading all the lines of input text file into oldContent

                String line = reader.readLine();

                while (line != null)
                {
                    oldContent = oldContent + line + lineSeparator();

                    line = reader.readLine();
                }

                //Replacing oldString with newString in the oldContent

                String newContent = oldContent.replaceAll(oldString, newString);

                //Rewriting the input text file with newContent

                writer = new FileWriter(fileToBeModified);

                writer.write(newContent);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    //Closing the resources

                    reader.close();

                    writer.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }


    }

