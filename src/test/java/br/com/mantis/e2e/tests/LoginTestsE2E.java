package br.com.mantis.e2e.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.mantis.e2e.BrowserFactory;
import br.com.mantis.e2e.pages.LoginPage;
import br.com.mantis.e2e.pages.MinhaVisaoPage;


public class LoginTestsE2E {

	private MinhaVisaoPage minhaVisaoPage;

	private LoginPage loginPage;
	
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

	@Test
	@DisplayName("Login com sucesso")
	void loginComUsuarioValido() {

		LoginPage loginPage = new LoginPage(getDriver());

		this.minhaVisaoPage = loginPage.realizaLoginCom("Joao Vitor Gomes Bastos Dos Santos", "secret_pass");

		String userAtual = driver.findElement(By.className("user-info")).getText();
		assertEquals(userAtual, "Joao Vitor Gomes Bastos Dos Santos");

		loginPage.logout();
	}

	@Test
	@DisplayName("Login sem sucesso com usuario inválido")
	public void loginComUsuarioInValido() {
		
		LoginPage loginPage = new LoginPage(getDriver());

		loginPage.realizaLoginCom("Joao Vitor Gomes Bastos dos Santos", "secret_pass2");

		assertTrue(loginPage.estaNaPaginaDeLoginComErro());
	}
}
