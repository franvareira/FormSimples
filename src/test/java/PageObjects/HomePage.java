package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

        private WebDriver driver;

        public HomePage(WebDriver driver ){

            this.driver = driver;

        }

        public WebElement homeTextLabel (){

            return this.driver.findElement(By.xpath("//div[@class='page-body']/h1"));
            //WebElement homeTextLabel = this.driver.findElement(By.xpath("//div[@class='page-body']/h1"));
           //return homeTextLabel;

        }




}
