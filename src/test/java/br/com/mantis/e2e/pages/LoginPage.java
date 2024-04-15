package br.com.mantis.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public MinhaVisaoPage realizaLoginCom(String nome, String senha) {
    	driver.get("https://mantis-prova.base2.com.br/login_page.php");

        WebElement txtNome = driver.findElement(By.id("username"));
        txtNome.sendKeys(nome);
        txtNome.submit();

        WebElement txtSenha = driver.findElement(By.id("password"));
        txtSenha.sendKeys(senha);
        txtSenha.submit();
                
        return new MinhaVisaoPage(driver);

    }

	public boolean estaNaPaginaDeLoginComErro() {
        String erroLogin = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div/div/div/div[4]/p")).getText();
        return erroLogin.equals("Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.");
    }

    public void logout() {
        driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/ul/li[4]/a")).click();
    }

}
