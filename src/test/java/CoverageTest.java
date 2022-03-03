import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class CoverageTest{

    WebDriver driver;

    @Before
    public void Setup(){
        System.setProperty("webdriver.chrome.driver" ,  "/Users/jiayili/Applications/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testAddCookie() {
        driver.get("http://www.google.com");
        driver.manage().addCookie(new Cookie("key", "value"));
        Cookie cookie1 = driver.manage().getCookieNamed("key");
        Assert.assertEquals("get correct cookie", cookie1.getValue(), "value");
    }

    @Test
    public void testGetAllCookie() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().deleteAllCookies();
        driver.manage().addCookie(new Cookie("key1", "value1"));
        driver.manage().addCookie(new Cookie("key2", "value2"));
        Set<Cookie> cookies = driver.manage().getCookies();
        Assert.assertEquals("get correct cookie size", cookies.size(), 2);
    }

    @Test
    public void testDeleteCookie() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().addCookie(new Cookie("key", "value"));
        driver.manage().deleteCookieNamed("key");
        Assert.assertNull("cookie deleted",driver.manage().getCookieNamed("key"));
    }

    @Test
    public void testDeleteAllCookie() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().addCookie(new Cookie("test1", "cookie1"));
        driver.manage().addCookie(new Cookie("test2", "cookie2"));
        // deletes all cookies
        driver.manage().deleteAllCookies();
        Assert.assertNull("cookie deleted 1",driver.manage().getCookieNamed("test1"));
        Assert.assertNull("cookie deleted 2",driver.manage().getCookieNamed("test2"));
    }

}