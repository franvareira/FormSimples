package TestesCases;

import Fw.BaseTestFw;
import Fw.Report;
import Fw.ScreenshotFw;
import Tasks.HomeTask;
import com.aventstack.extentreports.Status;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static Fw.Report.extent;
import static Fw.Report.test;


public class PreencherFormTest extends BaseTestFw {

    private WebDriver driver = this.getDriver();


    @Test
    public void popularForm() throws InterruptedException, IOException {

        HomeTask home = new HomeTask(driver);

        try {

            test = extent.createTest("Preencher Form");
            home.verificaHome();
            //test.info("Form Carregado");
            //test.pass("teste",ScreenshotFw.takeViewpointShot(driver));
            home.preencherForm();

        }catch (Exception e) {

             test.log(Status.ERROR, e.getMessage(),ScreenshotFw.takeViewpointShot(driver));

        }


    }
}