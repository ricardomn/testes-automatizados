package br.com.caelum.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NovoLeilaoPages {

	private WebDriver driver;

	public NovoLeilaoPages(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void prencher(String nome, double valor, String usuario, boolean usado) {
		WebElement txtNome = driver.findElement(By.name("leilao.nome"));
		WebElement txtValorInicial = driver.findElement(By.name("leilao.valorInicial"));
		
		txtNome.sendKeys(nome);
		txtValorInicial.sendKeys(String.valueOf(valor));
		
		
		Select cbUsuario = new Select(driver.findElement(By.name("leilao.usuario.id")));
		cbUsuario.selectByVisibleText(usuario);
		
		if(usado) {
			WebElement ckUsado = driver.findElement(By.name("leilao.usado"));
			ckUsado.click();
		}

		txtNome.submit();
		
	}
}