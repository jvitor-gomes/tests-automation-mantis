package br.com.mantis.e2e;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	public WebDriver createWebDriver() {

		String webdriver = System.getProperty("browser", "chrome");
		return initChromeDriver();

	}

	private WebDriver initChromeDriver() {
		// Defina o caminho do chromedriver aqui
		System.setProperty("webdriver.chrome.driver", "C:\\Projetos Tecnicos\\testes-automatizados-mantis\\src\\driver\\chromedriver.exe");
		return new ChromeDriver();
	}
}
