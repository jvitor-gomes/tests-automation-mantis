package br.com.mantis.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class VerTarefasPage {
	
	private WebDriver driver;

	private static String PAGE_URL = "https://mantis-prova.base2.com.br/view_all_bug_page.php";
	
	public VerTarefasPage(WebDriver driver) {
		this.driver = driver;
	}

	public void visita() {
		driver.get(PAGE_URL);
	}

	public boolean existe(String summary) {
		// Encontra todos os elementos que possuem a classe "column-summary"
		List<WebElement> colunasSummary = driver.findElements(By.className("column-summary"));
        // Se não encontrou em nenhuma coluna, retorna falso
		return colunasSummary.stream().anyMatch(coluna -> coluna.getText().contains(summary));
	}
	
	public boolean estaNaPaginaDeViewIssuesPage() {
		esperaCarregarPaginaViewIssuesPage();
		return this.driver.getCurrentUrl().contains("view_all_bug_page.php");
	}
	
	public void esperaCarregarPaginaViewIssuesPage() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.titleContains("Ver Tarefas - MantisBT"));
	}
	
	public void pesquisarTarefas(String summary) {
		esperaCarregarPaginaViewIssuesPage();
		driver.findElement(By.xpath("//*[@id=\"filter-search-txt\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"filter-search-txt\"]")).sendKeys(summary);
		driver.findElement(By.xpath("//*[@id=\"filters_form_open\"]/div[2]/div/div/input[2]")).click();
	}

	public void logout() {
		driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/ul/li[4]/a")).click();
	}
}
