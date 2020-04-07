package Fw;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;


public class BaseTestFw {

        private  WebDriver driver;
        private String URL = "http://testpages.herokuapp.com/styled/basic-html-form-test.html";


    public  WebDriver getDriver() {


            this.driver = DriverManagerFw.setDriver(DriverTypeFw.CHROME);
            return this.driver;
    }

@Before
    public  void setup (){

        getDriver().get(URL);

    }

@After
    public void teardown(){


        DriverManagerFw.quitDriver();

    }


}
