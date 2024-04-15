package br.com.mantis.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MinhaVisaoPage {

	private WebDriver driver;

	private static String PAGE_URL = "https://mantis-prova.base2.com.br/my_view_page.php";

	public MinhaVisaoPage(WebDriver driver) {
		this.driver = driver;
	}

	public void visita() {
		driver.get(PAGE_URL);
	}

	public boolean estaNaPaginaMinhaVisao() {
		Boolean currentUrl = this.driver.getCurrentUrl().equals("https://mantis-prova.base2.com.br/my_view_page.php");
		return currentUrl;
	}

	public void selectProject() {
		driver.findElement(By.xpath("//*[@id=\"dropdown_projects_menu\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"projects-list\"]/li[3]/div/ul/li[4]/a")).click();
	}
	
	public CriarTarefaPage visitandoPaginaCriarTarefa() {
		selectProject();
		driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[1]/div/a")).click();
		return new CriarTarefaPage(driver);
	}
	
	public VerTarefasPage visitandoPaginaVerTarefas() {
		selectProject();
		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[2]/a")).click();
		return new VerTarefasPage(driver);
	}
}
