package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestesSeleniumCadastro {
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
  public void cadastro() throws Exception {
    driver.get(baseUrl + "/TarefaAppWebComJDBC/");
    driver.findElement(By.linkText("Criar Cadastro")).click();
    driver.findElement(By.name("nome")).clear();
    driver.findElement(By.name("nome")).sendKeys("Usuario Teste");
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("usuario");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("usuario@usuario.com.br");
    driver.findElement(By.name("senha")).clear();
    driver.findElement(By.name("senha")).sendKeys("usuario");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("usuario");
    driver.findElement(By.name("senha")).clear();
    driver.findElement(By.name("senha")).sendKeys("usuario");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("Tópicos", driver.findElement(By.cssSelector("h1")).getText());
  }

  @Test
  public void criacaoDeTopicojava() throws Exception {
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
  
  @Test
  public void cadastroEComentarTopico() throws Exception {
    driver.get(baseUrl + "/TarefaAppWebComJDBC/");
    driver.findElement(By.linkText("Criar Cadastro")).click();
    driver.findElement(By.name("nome")).clear();
    driver.findElement(By.name("nome")).sendKeys("Usuario Dois");
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("usuarioDois");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("usuarioDois@usuario.com.br");
    driver.findElement(By.name("senha")).clear();
    driver.findElement(By.name("senha")).sendKeys("usuario");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("usuarioDois");
    driver.findElement(By.name("senha")).clear();
    driver.findElement(By.name("senha")).sendKeys("usuario");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("Tópicos", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("Novo Tópico")).click();
    assertEquals("Novo Tópico", driver.findElement(By.cssSelector("u")).getText());
    driver.findElement(By.name("comentario")).clear();
    driver.findElement(By.name("comentario")).sendKeys("Comentando o Novo Tópico");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("Comentando o Novo Tópico", driver.findElement(By.cssSelector("th.tg-yw4l")).getText());
    assertEquals("Usuario Dois", driver.findElement(By.xpath("//th[2]")).getText());
    driver.findElement(By.linkText("Voltar")).click();
    assertEquals("Tópicos", driver.findElement(By.cssSelector("h1")).getText());
  }

  @Test
  public void falhaNoLogin() throws Exception {
    driver.get(baseUrl + "/TarefaAppWebComJDBC/");
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("usuario");
    driver.findElement(By.name("senha")).clear();
    driver.findElement(By.name("senha")).sendKeys("usuarui");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("Não foi possível autenticar o usuário! \n Criar Cadastro", driver.findElement(By.xpath("//div[2]")).getText());
  }

  @Test
  public void ranking() throws Exception {
    driver.get(baseUrl + "/TarefaAppWebComJDBC/");
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
