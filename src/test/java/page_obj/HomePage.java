package page_obj;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage extends DriverManager{
        @FindBy(css = "input[data-test='search-input']")
        private WebElement searchBox;
        @FindBy(css ="button[type='submit']")
        private WebElement submit_button;


        public String getCurrentUrl(){
                return driver.getCurrentUrl();
        }
        public void doSearch(String item){
            sleep(5000);
            driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
           searchBox.sendKeys(item);
           sleep(5000);
           searchBox.sendKeys(Keys.ENTER);
           sleep(5000);
           submit_button.click();
        }


        }

