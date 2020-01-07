import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAutomatizadoGoogle {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\googleDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("www.bing.com");
		WebElement campoDePesquisa = driver.findElement(By.name("q"));
		campoDePesquisa.sendKeys("Caelum");
		campoDePesquisa.submit();
	}
}
