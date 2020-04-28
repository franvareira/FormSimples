package Fw;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import static Fw.Report.endReport;
import static Fw.Report.setExtent;


public class BaseTestFw {

        private  WebDriver driver;
        private String URL = "http://testpages.herokuapp.com/styled/basic-html-form-test.html";


    public  WebDriver getDriver() {


            this.driver = DriverManagerFw.setDriver(DriverTypeFw.CHROME);
            return this.driver;
    }

@Before
    public  void setup (){



         setExtent();
         getDriver().get(URL);

    }

@After
    public void teardown(){
        endReport();
        DriverManagerFw.quitDriver();

    }


}
