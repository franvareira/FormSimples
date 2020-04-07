package TestesCases;

import Fw.BaseTestFw;
import Tasks.HomeTask;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class PreencherFormTest extends BaseTestFw {

    private WebDriver driver = this.getDriver();

    @Test
    public void popularForm() throws InterruptedException {

        HomeTask home = new HomeTask(driver);

        home.verificaHome();

    }
}