package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestesSeleniumCriacaoDeTopicojava {
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
  public void testEsSeleniumCriacaoDeTopicojava() throws Exception {
    driver.get(baseUrl + "/TarefaAppWebComJDBC/");
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("usuario");
    driver.findElement(By.name("senha")).clear();
    driver.findElement(By.name("senha")).sendKeys("usuario");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.linkText("Inserir Tópico")).click();
    driver.findElement(By.name("titulo")).clear();
    driver.findElement(By.name("titulo")).sendKeys("Novo Tópico");
    driver.findElement(By.name("conteudo")).clear();
    driver.findElement(By.name("conteudo")).sendKeys("Conteúdo do Novo Tópico");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("Novo Tópico", driver.findElement(By.linkText("Novo Tópico")).getText());
    assertEquals("Usuario Teste", driver.findElement(By.id("nomeUsuario")).getText());
    driver.findElement(By.linkText("Novo Tópico")).click();
    assertEquals("Conteúdo do Novo Tópico", driver.findElement(By.cssSelector("th")).getText());
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
