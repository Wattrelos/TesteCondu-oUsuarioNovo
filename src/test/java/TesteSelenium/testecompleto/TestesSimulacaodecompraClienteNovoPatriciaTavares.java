package TesteSelenium.testecompleto;
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

public class TestesSimulacaodecompraClienteNovoPatriciaTavares {
	
	@Test
	public void testeSimulacaoCompraLogin() {		
		
		System.setProperty("webdriver.gecko.driver", "/install/DESENVOLVIMENTO/Geckodrivers/geckodriver.exe");
//		System.setProperty("webdriver.chrome.driver", "/Users/wcaquino/Downloads/chromedriver");
//		WebDriver driver = new FirefoxDriver();
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		
//		//		Prepara��o:
		String clienteNome = "Patr�cia Tavares";
		String clienteCpf = "78516603008";
		String clienteDataNascimento = "1995-04-25";
		String clienteSenha = "123Fatec";
		String clienteEmail = "patriciatavares@yahoo.com.br";
		// Endere�o:
		String clienteCEP = "59180970";
		String clienteCidade ="Esp�rito Santo";
		String clienteNumero = "126";
		String clienteComplemento = "casa 2";
		// Cart�o de cr�dito
		String clienteCartaoNome = "PATRICIA TAVARES";
		String clienteCartaoNumero = "5348569034150411";
		String clienteCartaoDataValidade = "2023-08-11";
		String clienteCartaoCvv = "421";
		
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
		driver.manage().timeouts().implicitlyWait(1700, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
		// finalizar pedido:
		driver.findElement(By.id("irPedido")).click();
		driver.manage().timeouts().implicitlyWait(1700, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
		// Login
		driver.findElement(By.id("login-email")).click();
		driver.findElement(By.id("login-email")).sendKeys(clienteEmail);
		driver.findElement(By.id("login-senha")).click();
		driver.findElement(By.id("login-senha")).sendKeys(clienteSenha);
		driver.findElement(By.id("login")).click();		
		driver.manage().timeouts().implicitlyWait(1700, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
		// Deve retornar o nome do email, sem arroba.
		Assert.assertEquals(clienteEmail.split("@")[0], driver.findElement(By.id("dropdownMenuLink")).getText());
//		Cadastrar endere�o (cliente novo sem nenhum endere�o cadastrado):
		driver.findElement(By.id("irPedido")).click();
		
		// Bloco para endere�o novo (sem endere�o cadastrado)
		driver.findElement(By.id("cep")).click();
		driver.findElement(By.id("cep")).sendKeys(clienteCEP);
		// Mudar de campo para acionar o preenchimento autom�tico de endere�o.
		driver.findElement(By.id("numero")).click();
		driver.manage().timeouts().implicitlyWait(1700, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
//		Se o CEP exister, haver� algum dado como resposta
		Assert.assertEquals(clienteCidade, driver.findElement(By.id("cidade")).getAttribute("value"));
		// continua...
		driver.findElement(By.id("numero")).sendKeys(clienteNumero);
			
		driver.findElement(By.id("complemento")).click();
		driver.findElement(By.id("complemento")).sendKeys(clienteComplemento);
		driver.findElement(By.id("cadastrar")).click();
		driver.manage().timeouts().implicitlyWait(1700, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
		// Escolher o primeiro endere�o da lista de endere�os cadastrados:
		driver.findElement(By.xpath("//button[contains(text(),'Escolher')]")).click();
		// Quando n�o tem nenhum cart�o cadastrado
		//Cadastrar cart�o:
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys(clienteCartaoNome);
		driver.findElement(By.id("numero")).click();
		driver.findElement(By.id("numero")).sendKeys(clienteCartaoNumero);
		driver.findElement(By.id("dataValidade")).click();
		driver.findElement(By.id("dataValidade")).sendKeys(clienteCartaoDataValidade);
		driver.findElement(By.id("cvv")).click();
		driver.findElement(By.id("cvv")).sendKeys(clienteCartaoCvv);
		driver.findElement(By.id("cadastrar-cartao")).click();
		
		driver.manage().timeouts().implicitlyWait(1700, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
//		Selecioanar cart�o existente:
		driver.findElement(By.xpath("//button[contains(text(),'Pagar com cart�o')]")).click();
		
		driver.manage().timeouts().implicitlyWait(1700, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
		// Confirmar pedido:
		driver.findElement(By.xpath("//button[contains(text(),'Confirmar pedido')]")).click();
		
		// Pausa antes de finalizar.
		try {
	        Thread.sleep(5*1000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		driver.quit();
	}
}
