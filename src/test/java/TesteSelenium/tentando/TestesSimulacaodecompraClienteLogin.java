package TesteSelenium.tentando;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestesSimulacaodecompraClienteLogin {
	
	@Test
	public void testeSimulacaoCompraLogin() {
		System.setProperty("webdriver.gecko.driver", "/install/DESENVOLVIMENTO/Geckodrivers/geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 768));
		driver.get("http://localhost:8080/index");
		Assert.assertEquals("Livraria Fatec online", driver.getTitle());
		// Ir para o carrinho de compras
		driver.findElement(By.xpath("//a[@href='/carrinho/carrinho']")).click();		
		// finalizar pedido:
		driver.findElement(By.id("irPedido")).click();
		// Login
		driver.findElement(By.id("login-email")).click();
		driver.findElement(By.id("login-email")).sendKeys("anabellesartorelli@yahoo.com");
		driver.findElement(By.id("login-senha")).click();
		driver.findElement(By.id("login-senha")).sendKeys("123Fatec");
		driver.findElement(By.id("login")).click();
		// Pequena pausa para esperar a tela renderizar.
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		
		// Deve retornar o nome do email, sem arroba.
		Assert.assertEquals("anabellesartorelli", driver.findElement(By.id("dropdownMenuLink")).getText());
		try {
	        Thread.sleep(5*1000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		driver.quit();
	}
}
