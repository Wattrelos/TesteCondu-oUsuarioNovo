package TesteSelenium.SofiaGoransson;
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

public class SofiaGoranssonCadastroNovoUsuario {
	
	@Test
	public void testeSimulacaoCompraLogin() {		
		
		System.setProperty("webdriver.gecko.driver", "/install/DESENVOLVIMENTO/Geckodrivers/geckodriver.exe");
//		System.setProperty("webdriver.chrome.driver", "/Users/wcaquino/Downloads/chromedriver");
//		WebDriver driver = new FirefoxDriver();
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		
//		Prepara��o:
		String clienteNome = "Sofia G�ransson";
		String clienteCpf = "79189297059";
		String clienteDataNascimento = "2000-08-16";
		String clienteSenha = "jDiA_piQX9KOYkBL";
		String clienteEmail = "sofiagoransson745@yahoo.se";
		// Endere�o:
		String clienteCEP = "06530245";
		String clienteCidade = "Santana de Parna�ba";
		String clienteNumero = "1280";
		String clienteComplemento = "sala 23";
		
		// Cart�o de cr�dito
		String clienteCartaoNome = "SOFIA GORANSSON";
		String clienteCartaoNumero = "5454230977885501";
		String clienteCartaoDataValidade = "2022-08-21";
		String clienteCartaoCvv = "325";
		
		driver.get("http://localhost:8080/index");
//		driver.manage().window().setSize(new Dimension(1200, 765));	
		driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
		driver.findElement(By.id("livro-1")).click();
		driver.findElement(By.id("livro-2")).click();
		driver.findElement(By.id("livro-5")).click();
		driver.findElement(By.id("livro-14")).click();
		driver.findElement(By.id("livro-14")).click();
		
		// Verificar se a p�gina carregou:
		Assert.assertEquals("Livraria Fatec online", driver.getTitle());
		// Ir para o carrinho de compras
		driver.findElement(By.xpath("//a[@href='/carrinho/carrinho']")).click();
		// finalizar pedido (se o cliente n�o exister abrir� op��o de login ou cadastro:
		driver.findElement(By.id("irPedido")).click();
				
		// Cadastrar cliente novo
		driver.findElement(By.xpath("//a[@href='/cliente/cadastro']")).click();
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys(clienteNome);
		driver.findElement(By.id("cpf")).click();
		driver.findElement(By.id("cpf")).sendKeys(clienteCpf);
		driver.findElement(By.id("dataNascimento")).click();
		driver.findElement(By.id("dataNascimento")).sendKeys(clienteDataNascimento);
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
		
		// Ir para o carrinho de compras
		driver.findElement(By.xpath("//a[@href='/carrinho/carrinho']")).click();
		driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
		// finalizar pedido:
		driver.findElement(By.id("irPedido")).click();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
		// Login
		driver.findElement(By.id("login-email")).click();
		driver.findElement(By.id("login-email")).sendKeys(clienteEmail);
		driver.findElement(By.id("login-senha")).click();
		driver.findElement(By.id("login-senha")).sendKeys(clienteSenha);
		driver.findElement(By.id("login")).click();		
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
		// Deve retornar o nome do email, sem arroba.
		Assert.assertEquals(clienteEmail.split("@")[0], driver.findElement(By.id("dropdownMenuLink")).getText());
	}
}