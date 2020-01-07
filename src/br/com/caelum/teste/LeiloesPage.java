package br.com.caelum.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeiloesPage {

	private WebDriver driver;

	public LeiloesPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void visita() {
		driver.get("http://localhost:8080/leiloes");
	}

	public NovoLeilaoPages novo() {
		driver.findElement(By.linkText("Novo Leilão")).click();
		return new NovoLeilaoPages(driver);
	}
	
	public boolean existe(String nome, double valor, String usuario, boolean usado) {
		return driver.getPageSource().contains(nome) 
				&& driver.getPageSource().contains(usuario)
				&& driver.getPageSource().contains(String.valueOf(valor))
				&& driver.getPageSource().contains(usado ? "Sim": "Não");
				
	}
	
}
