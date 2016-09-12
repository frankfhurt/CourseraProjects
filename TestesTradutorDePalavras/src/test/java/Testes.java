import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testes {
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
  public void testePortuguesParaIngles() throws Exception {
    driver.get(baseUrl + "/TradutorDePalavras/index.html");
    driver.findElement(By.name("palavra")).clear();
    driver.findElement(By.name("palavra")).sendKeys("homem");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("Tradução: man", driver.findElement(By.cssSelector("h3")).getText());
  }
  
  @Test
  public void testeInglesParaPortugues() throws Exception {
    driver.get(baseUrl + "/TradutorDePalavras/index.html");
    driver.findElement(By.name("palavra")).clear();
    driver.findElement(By.name("palavra")).sendKeys("computer");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("Tradução: computador", driver.findElement(By.cssSelector("h3")).getText());
  }
  
  @Test
  public void testePortuguesParaIngles2() throws Exception {
    driver.get(baseUrl + "/TradutorDePalavras/index.html");
    driver.findElement(By.name("palavra")).clear();
    driver.findElement(By.name("palavra")).sendKeys("mesa");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("Tradução: table", driver.findElement(By.cssSelector("h3")).getText());
    driver.findElement(By.linkText("Voltar")).click();
  }
  
  @Test
  public void testePalavraNaoCadastrada() throws Exception {
    driver.get(baseUrl + "/TradutorDePalavras/index.html");
    driver.findElement(By.name("palavra")).clear();
    driver.findElement(By.name("palavra")).sendKeys("sapato");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("Tradução: sapato", driver.findElement(By.cssSelector("h3")).getText());
    driver.findElement(By.linkText("Voltar")).click();
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
