package Test_Maven_start;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {


    public static  String screens(WebDriver driver, String screensho) throws IOException {



        System.out.println("RAFFFFF");
        try {
            //driver=new ChromeDriver();
            //System.out.println("Rehananananan");
            TakesScreenshot ts=(TakesScreenshot)driver;

            File src=ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("./Pictures/"+screensho+".png"));
            System.out.println("Error Screenshot Taken");
        } catch (Exception e) {
            System.out.println("Error message innscrenshot"+e.getMessage());
        }
        return screensho;
    }
}
