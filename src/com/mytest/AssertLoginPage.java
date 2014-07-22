package com.mytest;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AssertLoginPage {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://sizer.nutanix.cloudbees.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
//test using junit
  @Test
  public void testUntitled() throws Exception {
    driver.get(baseUrl + "/#/login");
    assertEquals("SizingTools", driver.getTitle());
    assertEquals("", driver.findElement(By.id("username")).getAttribute("value"));
    assertEquals("", driver.findElement(By.id("password")).getAttribute("value"));
    assertTrue(isElementPresent(By.xpath("//button[@type='submit']")));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}