import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class PartitionTesting {
    WebDriver driver;

    @Before
    public void Setup(){
        System.setProperty("webdriver.chrome.driver" ,  "/Users/jiayili/Applications/chromedriver");
        driver = new ChromeDriver();
    }


    @Test
    public void testURL1() throws IOException {
        String url = "http://eqbin.com/";
        driver.navigate().to(url);
        String currUrl = driver.getCurrentUrl();
        System.out.println(currUrl);
        Assert.assertEquals(currUrl,url);
    }

    @Test
    public void testURL2() throws IOException {
        String url = "https://www.tillmanstranquils.com/?utm_source=Oogle&utm_medium=Web&utm_campaign=Oogle";
        driver.navigate().to(url);
        String currUrl = driver.getCurrentUrl();
        System.out.println(currUrl);
        Assert.assertEquals(currUrl,url);
    }

    @Test
    public void testURL3() throws IOException {
        String url = "https://stackoverflow.com/jobs/450184/senior-full-stack-developer-work-remotely-for-onepak-inc";
        driver.navigate().to(url);
        String currUrl = driver.getCurrentUrl();
        System.out.println(currUrl);
        Assert.assertEquals(currUrl,url);
    }

    @Test
    public void testURL4() throws IOException {
        String url = "http://www.4399.com/";
        driver.navigate().to(url);
        String currUrl = driver.getCurrentUrl();
        System.out.println(currUrl);
        Assert.assertEquals(currUrl,url);
    }

    @Test
    public void testURL5() throws IOException {
        boolean thrown = false;
        String url = "";
        try {
            driver.navigate().to(url);
            String currUrl = driver.getCurrentUrl();
            System.out.println(currUrl);
        } catch (WebDriverException e) {
            thrown = true;
        }
        Assert.assertTrue(thrown);
    }

    @Test
    public void testURL6() throws IOException {
        String url = "https:www.in";
        String targetURL = "https://www.in/";
        driver.navigate().to(url);
        String currUrl = driver.getCurrentUrl();
        System.out.println(currUrl);
        Assert.assertEquals(currUrl,targetURL);
    }

    @Test
    public void testURL7() throws IOException {
        String url = "https://ww w.qaachary a@.in";
        String targetURL = "https://ww%20w.qaachary%20a@.in/";
        driver.navigate().to(url);
        String currUrl = driver.getCurrentUrl();
        System.out.println(currUrl);
        Assert.assertEquals(currUrl,targetURL);
    }

    @Test
    public void testURL8() throws IOException {
        String url = "HTTp://wwW.4399.cOm/";
        String targetURL = "http://www.4399.com/";
        driver.navigate().to(url);
        String currUrl = driver.getCurrentUrl();
        System.out.println(currUrl);
        Assert.assertEquals(currUrl,targetURL);
    }


    @After
    public void end(){
        driver.quit();
    }
}