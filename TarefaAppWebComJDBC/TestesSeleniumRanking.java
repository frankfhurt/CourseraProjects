package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestesSeleniumRanking {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEsSeleniumRanking() throws Exception {
    driver.get(baseUrl + "/TarefaAppWebComJDBC/login");
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("usuario");
    driver.findElement(By.name("senha")).clear();
    driver.findElement(By.name("senha")).sendKeys("usuario");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.linkText("Ranking")).click();
    assertEquals("1º", driver.findElement(By.xpath("//tr[2]/th")).getText());
    assertEquals("Usuario Teste", driver.findElement(By.xpath("//tr[2]/th[2]")).getText());
    assertEquals("usuario", driver.findElement(By.xpath("//tr[2]/th[3]")).getText());
    assertEquals("10", driver.findElement(By.xpath("//tr[2]/th[4]")).getText());
    assertEquals("2º", driver.findElement(By.xpath("//tr[3]/th")).getText());
    assertEquals("Usuario Dois", driver.findElement(By.xpath("//tr[3]/th[2]")).getText());
    assertEquals("usuarioDois", driver.findElement(By.xpath("//tr[3]/th[3]")).getText());
    assertEquals("3", driver.findElement(By.xpath("//tr[3]/th[4]")).getText());
    driver.findElement(By.linkText("Voltar")).click();
    assertEquals("Tópicos", driver.findElement(By.cssSelector("h1")).getText());
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
