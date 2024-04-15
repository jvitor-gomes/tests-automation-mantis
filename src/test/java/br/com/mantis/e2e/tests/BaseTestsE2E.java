package br.com.mantis.e2e.tests;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.mantis.e2e.BrowserFactory;
import br.com.mantis.e2e.pages.LoginPage;

public class BaseTestsE2E {
	private static WebDriver driver;

	protected WebDriver getDriver() {
		return driver;
	}

	@BeforeAll
	public static void setUpAll() {
		driver = new BrowserFactory().createWebDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterAll
	public static void tearDownAll() {
		driver.close();
		driver.quit();
	}
	
	@BeforeEach
	public void setUp() {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.realizaLoginCom("Joao Vitor Gomes Bastos Dos Santos", "secret_pass");
	}
	
	@AfterEach
	public void tearDown() {
		driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/ul/li[4]/a")).click();
	}
}
