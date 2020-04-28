package Tasks;


import Fw.Report;
import Fw.ScreenshotFw;
import PageObjects.HomePage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

import static Fw.Report.test;

public class HomeTask {


        private static WebDriver driver;
        private static HomePage page;


        public HomeTask(WebDriver driver){

        this.driver=driver;
        page = new HomePage(this.driver);
        }




        public void  verificaHome() throws InterruptedException, IOException {

            try {
                String label = page.homeTextLabel().getText();
                sleep(5000);
                assertEquals(label, "Basic HTML Form Example");
                Report.test.info("Teste passou por aqui: " + label);
                Report.test.log(Status.PASS,"Form Carregou com sucesso: " + label ,ScreenshotFw.takeViewpointShot(driver));
                //test.pass("Form Carregou com sucesso", ScreenshotFw.takeViewpointShot(driver));
            }catch (Exception e){

                test.log(Status.FAIL, "Form nao carregou", ScreenshotFw.takeViewpointShot(driver));

                //test.fail("Form nao carregou", ScreenshotFw.takeViewpointShot(driver));


            }
        }


        public void preencherForm() throws InterruptedException, IOException {

            try{

             page.userNameTextField().click();
             page.userNameTextField().sendKeys("Fran");
             sleep(4000);
             page.passwordTextField().click();
             page.passwordTextField().sendKeys("1234");
             sleep(4000);
             Report.test.info("Preencheu nome e password");
             Report.test.log(Status.INFO,"Nome e password preenchido com sucesso",ScreenshotFw.takeViewpointShot(driver));

            }catch (Exception e){

                test.log(Status.FAIL, "Nome e password não foi preenchido", ScreenshotFw.takeViewpointShot(driver));
            }
        }




}
