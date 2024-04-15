package br.com.mantis.e2e.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.mantis.e2e.pages.MinhaVisaoPage;
import br.com.mantis.e2e.pages.VerTarefasPage;
import org.openqa.selenium.WebDriver;

public class VerTarefasTestE2E extends BaseTestsE2E {

	private MinhaVisaoPage minhaVisaoPage;

	private VerTarefasPage verTarefasPage;

	private static WebDriver driver;

	@Test
	@DisplayName("Filtrando e pesquisando tarefas")
	public void filtrandoTarefas() {
		
		this.minhaVisaoPage = new MinhaVisaoPage(getDriver());
		this.verTarefasPage = minhaVisaoPage.visitandoPaginaVerTarefas();
		this.verTarefasPage.pesquisarTarefas("Resumo Lorem ipsum");
		assertTrue(verTarefasPage.existe("Resumo Lorem ipsum"));
		//assertTrue(this.viewIssuesPage.estaNaPaginaDeViewIssuesPage());
		//assertTrue(driver.findElements(By.xpath("//*[@id=\"buglist\"]")).contains("This is New Test Features"));
		//assertTrue(this.viewIssuesPage.existe("This is Test Features"));

	}
}
