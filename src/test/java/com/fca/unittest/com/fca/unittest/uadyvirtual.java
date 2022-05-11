package com.fca.unittest.com.fca.unittest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class uadyvirtual {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\David\\Desktop\\Practica katalon\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testAccesoCorrecto() throws Exception {
    driver.get("https://www.google.com/search?q=uady+virtual&rlz=1C1UUXU_esMX987MX987&oq=uady+vir&aqs=chrome.0.0i131i433i512l2j0i512j69i57j0i512l6.2636j0j7&sourceid=chrome&ie=UTF-8");
    driver.findElement(By.xpath("//div[@id='rso']/div/div/div/div/a/h3")).click();
    driver.get("https://es.uadyvirtual.uady.mx/admin/tool/dataprivacy/summary.php");
    driver.findElement(By.linkText("Iniciar sesión (ingresar)")).click();
    driver.get("https://es.uadyvirtual.uady.mx/login/index.php");
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("a16211452");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("123Monaguillo,");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.get("https://es.uadyvirtual.uady.mx/admin/tool/dataprivacy/summary.php");
    driver.findElement(By.xpath("//div[@id='nav-drawer']/nav/ul/li/a/div/div/span[2]")).click();
    driver.get("https://es.uadyvirtual.uady.mx/my/");
    //Warning: assertTextPresent may require manual changes
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*UADY_Virtual_ES[\\s\\S]*$"));
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

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
