
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class HelloSelenium {
    public static void main(String[] args) throws IOException {
        String url = "https://www.selenium.dev/documentation/webdriver/browser/alerts/";
        System.setProperty("webdriver.chrome.driver" ,  "/Users/jiayili/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.findElement(By.linkText("See a sample prompt")).click();
        WebDriverWait wait = new WebDriverWait(driver, 4 /*timeout in seconds*/);

        //Wait for the alert to be displayed and store it in a variable
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("s");

        //Press the OK button
//        alert.accept();
//        alert.dismiss();
    }
}

