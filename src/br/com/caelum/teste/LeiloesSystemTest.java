package br.com.caelum.teste;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LeiloesSystemTest {

	private static FirefoxDriver driver;
	private static LeiloesPage leiloes;

	@BeforeClass
	public static void inicializa() {
		System.setProperty("webdriver.gecko.driver", "C:\\GeckoDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		leiloes = new LeiloesPage(driver);
	}
	
	@Test
	public void deveSerPossivelCadastrarUmLeilao() {
		leiloes.visita();
		NovoLeilaoPages novoLeilaoPages = leiloes.novo();
		novoLeilaoPages.prencher("Geladeira", 123, "ricardo", true);
		leiloes.visita();
		assertEquals(true, leiloes.existe("Geladeira", 123, "ricardo", true));
	}

	@AfterClass
	public static void finaliza() {
		driver.close();
	}
	
}
