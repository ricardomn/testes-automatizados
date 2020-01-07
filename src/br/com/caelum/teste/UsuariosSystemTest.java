package br.com.caelum.teste;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsuariosSystemTest {

	private static FirefoxDriver driver;
	private static UsuariosPages usuarios;

	@BeforeClass
	public static void inicializa() {
		System.setProperty("webdriver.gecko.driver", "C:\\GeckoDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		usuarios = new UsuariosPages(driver);
	}

	

	@Test
	@Ignore
	public void deveSerPossivelAdicionarUmUsuario() {

		
		usuarios.visita();
		usuarios.novo().cadastrar("Ricardo Mateus do Nascimento", "ricardo@gmail.com");
		usuarios.visita();
		assertEquals(true, usuarios.existeNaListame("Ricardo Mateus do Nascimento", "ricardo@gmail.com"));

	}
	
	@Test
	//@Ignore
	public void deveSePossivelExcluirUmUmUsuario() {

		
		usuarios.visita();
		usuarios.novo().cadastrar("Ricardo Mateus do Nascimento", "ricardo@gmail.com");
		usuarios.visita();
		
		usuarios.excluir();
		usuarios.confirmar();
		
		assertEquals(true, usuarios.existeNaListame("Ricardo Mateus do Nascimento", "ricardo@gmail.com"));

	}

	@Test
	@Ignore
	public void naoDeveSerPossivelAdicionarUsuarioSemNome() {

		usuarios.visita();
		usuarios.novo().cadastrar("", "ricardo@gmail.com");
		assertEquals(true, usuarios.existeCampoObrigatorio());

	}

	@Test
	@Ignore
	public void naoDeveSerPossivelAdicionarUsuarioSemNomeEEmail() {

		usuarios.visita();
		usuarios.novo().cadastrar("Ricardo Mateus do Nascimento", "ricardo@gmail.com");
		assertEquals(true, usuarios.existeCampoObrigatorio());

	}
	
	@AfterClass
	public static void finaliza() {
		driver.close();
	}

}
