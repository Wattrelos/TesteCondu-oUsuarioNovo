package TesteSelenium.tentando;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

public class TestesSimulacaodecompraClienteNovo2 {
	
	@Test
	public void testeSimulacaoCompra() {
//		Preparação:
		String clienteNome = "Pedro Silva";
		String clienteCpf = "21601942044";
		String clienteDataNascimento = "1992-08-11";
		String clienteSenha = "123Fatec";
		String clienteEmail = "pedrosilva@yahoo.com";
		
		System.setProperty("webdriver.gecko.driver", "/install/DESENVOLVIMENTO/Geckodrivers/geckodriver.exe");
//		System.setProperty("webdriver.chrome.driver", "/Users/wcaquino/Downloads/chromedriver");
//		WebDriver driver = new FirefoxDriver();
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://localhost:8080/index");
		Assert.assertEquals("Livraria Fatec online", driver.getTitle());		
		// Teste selecionar um livro para o carrinho:
		driver.manage().window().setSize(new Dimension(1200, 768));
		driver.findElement(By.id("livro-4")).click();
		driver.findElement(By.id("livro-4")).click();
		driver.findElement(By.id("livro-6")).click();
		driver.findElement(By.id("livro-13")).click();
		driver.findElement(By.id("livro-15")).click();
		
		// Ir para o carrinho de compras
		driver.findElement(By.xpath("//a[@href='/carrinho/carrinho']")).click();		
		// finalizar pedido:
		driver.findElement(By.id("irPedido")).click();
		driver.findElement(By.xpath("//a[@href='/cliente/cadastro']")).click();
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys(clienteNome);
		driver.findElement(By.id("cpf")).click();
		driver.findElement(By.id("cpf")).sendKeys(clienteCpf);
		driver.findElement(By.id("dataNascimento")).click();
		driver.findElement(By.id("dataNascimento")).sendKeys(clienteDataNascimento);
		driver.findElement(By.id("dataNascimento")).sendKeys(Keys.ESCAPE);
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys(clienteEmail);
		driver.findElement(By.id("senha")).click();
		driver.findElement(By.id("senha")).sendKeys(clienteSenha);
		driver.findElement(By.id("confirmar-senha")).click();
		driver.findElement(By.id("confirmar-senha")).sendKeys(clienteSenha);
//		driver.findElement(By.xpath("//input[@value='f'")).click();
//		driver.findElement(By.cssSelector("//input[value='f'")).click();
		driver.findElement(By.id("feminino")).click();
		driver.findElement(By.id("cadastrar-cliente")).click();
//		Ir para o carrinho de compras
		driver.findElement(By.xpath("//a[@href='/carrinho/carrinho']")).click();
		// Pequena pausa para esperar a tela renderizar.
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
//		finalizar pedido:
		driver.findElement(By.id("irPedido")).click();
		
		// Pequena pausa antes de finalizar.
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.quit();
	}
}
