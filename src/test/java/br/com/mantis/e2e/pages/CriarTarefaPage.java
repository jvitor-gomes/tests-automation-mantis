package br.com.mantis.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CriarTarefaPage {

	private WebDriver driver;

	public CriarTarefaPage(WebDriver driver) {
		this.driver = driver;
	}

	public VerTarefasPage preencheForm(String category, String summary, String description) {

		estaNaPaginaCriarTarefa();
		driver.findElement(By.id("category_id")).click();
	    driver.findElement(By.xpath(category)).click();

		driver.findElement(By.id("summary")).sendKeys(summary);
		driver.findElement(By.id("description")).sendKeys(description);
	    
	    clickSubmit();
		return new VerTarefasPage(driver);
	}
	
	public boolean estaNaPaginaCriarTarefa() {
        return this.driver.getCurrentUrl().contains("bug_report_page.php");
	}
	
	public boolean erroCriarTarefaCamposObrigatorios() {
		boolean mensagemDeErro = this.driver.getPageSource().contains("APPLICATION ERROR");
		boolean currentUrl = this.driver.getCurrentUrl().contains("bug_report_page.php");
        return currentUrl || mensagemDeErro;
    }
	
	public void clickSubmit() {
		driver.findElement(By.xpath("//*[@id=\"report_bug_form\"]/div/div[2]/div[2]/input")).submit();
		if(!erroCriarTarefaCamposObrigatorios()){
			driver.get("https://mantis-prova.base2.com.br/view_all_bug_page.php");
		}
	}

	public void logout() {
		driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/ul/li[4]/a")).click();
	}
}
