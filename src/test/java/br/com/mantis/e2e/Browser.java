package br.com.mantis.e2e;

import br.com.mantis.e2e.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Browser {

	private WebDriver driver;

	public Browser() {
		this.driver = new BrowserFactory().createWebDriver();
	}

	protected WebDriver getDriver() {
		return driver;
	}

	public LoginPage getLoginPage() {
		return new LoginPage(driver);
	}

	public void clean() {
		driver.manage().deleteAllCookies();
		driver.close();
	}
}
