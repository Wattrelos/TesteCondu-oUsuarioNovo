package TesteSelenium.tentando;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

public class TestesSimulacaodecompraCadastroEndereco {
	
	@Test
	public void testeSimulacaoCompraLogin() {		
		
		System.setProperty("webdriver.gecko.driver", "/install/DESENVOLVIMENTO/Geckodrivers/geckodriver.exe");
//		System.setProperty("webdriver.chrome.driver", "/Users/wcaquino/Downloads/chromedriver");
//		WebDriver driver = new FirefoxDriver();
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		
//		Preparação:
		String clienteNome = "Pedro Silva";
		String clienteCpf = "21601942044";
		String clienteDataNascimento = "1992-08-11";
		String clienteSenha = "123Fatec";
		String clienteEmail = "pedrosilva@yahoo.com";
		// Endereço:
		String clienteCEP = "16010-400";
		String clienteNumero = "258";
		String clienteComplemento = "bloco 4 apt 11";
		// Cartão de crédito
		String clienteCartaoNome = "PEDRO SILVA";
		String clienteCartaoNumero = "4929786104470509";
		String clienteCartaoDataValidade = "2020-11-13";
		String clienteCartaoCvv = "453";
		
		driver.get("http://localhost:8080/index");
//		driver.manage().window().setSize(new Dimension(1200, 765));	
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
		driver.findElement(By.id("livro-5")).click();
		driver.findElement(By.id("livro-7")).click();
		driver.findElement(By.id("livro-7")).click();
		driver.findElement(By.id("livro-12")).click();
		driver.findElement(By.id("livro-16")).click();
		
		// Verificar se a página carregou:
		Assert.assertEquals("Livraria Fatec online", driver.getTitle());
		// Ir para o carrinho de compras
		driver.findElement(By.xpath("//a[@href='/carrinho/carrinho']")).click();		
		// finalizar pedido:
		driver.findElement(By.id("irPedido")).click();
		// Login
		driver.findElement(By.id("login-email")).click();
		driver.findElement(By.id("login-email")).sendKeys(clienteEmail);
		driver.findElement(By.id("login-senha")).click();
		driver.findElement(By.id("login-senha")).sendKeys(clienteSenha);
		driver.findElement(By.id("login")).click();		
		// Deve retornar o nome do email, sem arroba.
		Assert.assertEquals(clienteEmail.split("@")[0], driver.findElement(By.id("dropdownMenuLink")).getText());
//		Cadastrar endereço (cliente novo sem nenhum endereço cadastrado):
		driver.findElement(By.id("irPedido")).click();
		
		/*// Bloco para endereço novo (sem endereço cadastrado)
		driver.findElement(By.id("cep")).click();
		driver.findElement(By.id("cep")).sendKeys(clienteCEP);
		// Mudar de campo para acionar o preenchimento automático de endereço.
		driver.findElement(By.id("numero")).click();
//		Se o CEP exister, haverá algum dado como resposta
		Assert.assertNotEquals("", driver.findElement(By.id("cidade")).getAttribute("value"));
		// continua...
		driver.findElement(By.id("numero")).sendKeys(clienteNumero);
			
		driver.findElement(By.id("complemento")).click();
		driver.findElement(By.id("complemento")).sendKeys(clienteComplemento);
		driver.findElement(By.id("cadastrar")).click();
		*/
		// Escolher o primeiro endereço da lista de endereços cadastrados:
		driver.findElement(By.xpath("//button[contains(.,'Escolher')]")).click();
		/*// Quando não tem nenhum cartão cadastrado
		//Cadastrar cartão:
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys(clienteCartaoNome);
		driver.findElement(By.id("numero")).click();
		driver.findElement(By.id("numero")).sendKeys(clienteCartaoNumero);
		driver.findElement(By.id("dataValidade")).click();
		driver.findElement(By.id("dataValidade")).sendKeys(clienteCartaoDataValidade);
		driver.findElement(By.id("cvv")).click();
		driver.findElement(By.id("cvv")).sendKeys(clienteCartaoCvv);
		driver.findElement(By.id("cadastrar-cartao")).click();
		*/
//		Selecioanar cartão existente:
		driver.findElement(By.xpath("//button[contains(text(),'Pagar com cartão final')]")).click();
		
		// Confirmar pedido:
		driver.findElement(By.xpath("//button[contains(text(),'Confirmar pedido')]")).click();
		
		// Pausa antes de finalizar.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.quit();
	}
}
