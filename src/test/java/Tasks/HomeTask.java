package Tasks;

import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class HomeTask {


        private WebDriver driver;
        private HomePage page;

        public HomeTask(WebDriver driver){

        this.driver=driver;
        page = new HomePage(this.driver);
        }

        public void verificaHome() throws InterruptedException {

            String label = page.homeTextLabel().getText();
            sleep(5000);
            assertEquals(label, "Basic HTML Form Example");


        }


}
