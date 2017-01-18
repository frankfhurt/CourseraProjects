package com.coursera.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MarcarComoLido {
	private WebDriver driver;
	private String baseUrl;
//	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8080/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testMarcarComoLido() throws Exception {
		driver.get(baseUrl + "/TarefaLivrosAJato");
		driver.findElement(By.name("login")).clear();
		driver.findElement(By.name("login")).sendKeys("bruna@email.com");
		driver.findElement(By.name("senha")).clear();
		driver.findElement(By.name("senha")).sendKeys("teste");
		driver.findElement(By.cssSelector("button")).click();
		assertEquals("Olá Bruna", driver.findElement(By.cssSelector("p")).getText());
		assertEquals("Marley e Eu", driver.findElement(By.linkText("Marley e Eu")).getText());
		driver.findElement(By.linkText("Marley e Eu")).click();
		assertEquals("Detalhes do Livro", driver.findElement(By.cssSelector("h2")).getText());
		assertEquals("Marley e Eu", driver.findElement(By.id("titulo")).getText());
		assertEquals("283", driver.findElement(By.id("paginas")).getText());
		assertEquals("Marcar Como Lido", driver.findElement(By.cssSelector("button.button.button1")).getText());
		driver.findElement(By.cssSelector("button.button.button1")).click();
		assertEquals("Livro já lido", driver.findElement(By.xpath("//div[2]/form/button")).getText());
		driver.findElement(By.cssSelector("button.button.button2")).click();
		driver.findElement(By.cssSelector("button.button.button3")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

//	private boolean isElementPresent(By by) {
//		try {
//			driver.findElement(by);
//			return true;
//		} catch (NoSuchElementException e) {
//			return false;
//		}
//	}
//
//	private boolean isAlertPresent() {
//		try {
//			driver.switchTo().alert();
//			return true;
//		} catch (NoAlertPresentException e) {
//			return false;
//		}
//	}
//
//	private String closeAlertAndGetItsText() {
//		try {
//			Alert alert = driver.switchTo().alert();
//			String alertText = alert.getText();
//			if (acceptNextAlert) {
//				alert.accept();
//			} else {
//				alert.dismiss();
//			}
//			return alertText;
//		} finally {
//			acceptNextAlert = true;
//		}
//	}
}
