package br.com.mantis.e2e.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.mantis.e2e.pages.MinhaVisaoPage;
import br.com.mantis.e2e.pages.VerTarefasPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class CriarTarefaTestsE2E extends BaseTestsE2E {

	private MinhaVisaoPage minhaVisaoPage;
	private br.com.mantis.e2e.pages.CriarTarefaPage criarTarefaPage;
	private VerTarefasPage verTarefasPage;
	private WebDriver driver;

	@Test
	@DisplayName("Criando uma tarefa preenchendo os campos obrigatórios")
	void criandoUmaTarefaValida() {
		this.minhaVisaoPage = new MinhaVisaoPage(getDriver());

		this.criarTarefaPage = minhaVisaoPage.visitandoPaginaCriarTarefa();
		this.verTarefasPage = criarTarefaPage.preencheForm("//*[@id=\"category_id\"]/option", "Resumo Lorem ipsum",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit");
		assertTrue(verTarefasPage.existe("Resumo Lorem ipsum"));
	}

	@Test
	@DisplayName("Criando uma tarefa sem preencher os campos obrigatórios")
	void criandoUmaTarefaInvalidaSemOsCamposObrigatorios() {
		
		this.minhaVisaoPage = new MinhaVisaoPage(getDriver());

		this.criarTarefaPage = minhaVisaoPage.visitandoPaginaCriarTarefa();
		this.criarTarefaPage.clickSubmit();
		assertTrue(this.criarTarefaPage.erroCriarTarefaCamposObrigatorios());

	}
}
