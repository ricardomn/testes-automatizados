package br.com.caelum.teste;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsuariosPages {
	private WebDriver driver;
	
	public UsuariosPages(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void visita() {
		driver.get("http://localhost:8080/usuarios");
	}
	
	public void edita() {
		driver.findElement(By.linkText("Novo Usuário")).click();
	}
	
	public NovoUsuarioPage novo() {
		driver.findElement(By.linkText("editar")).click();
		return new NovoUsuarioPage(driver);
	}
	
	public void excluir() {
		int posicao = 1; // queremos o 1o botao da pagina
		driver.findElements(By.tagName("button")).get(posicao-1).click();
		
	}
	
	public void confirmar() {
		// pega o alert que está aberto
		Alert alert = driver.switchTo().alert();
		// confirma
		alert.accept();
		
	}
	
	public boolean existeNaListame(String nome, String email) {
		return driver.getPageSource().contains(nome) 
				&& driver.getPageSource().contains(email);
	}

	public boolean existeCampoObrigatorio() {
		String nomeObrigatorio = "Nome obrigatorio";
		String emailObrigatorio = "E-mail obrigatorio";
		return driver.getPageSource().contains(nomeObrigatorio) 
				|| driver.getPageSource().contains(emailObrigatorio);
	}
	
}
