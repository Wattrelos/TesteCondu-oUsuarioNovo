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

public class TestesSimulacaodecompraClienteCadastradoPatriciaTavaresComEnderecoSemCartao {
	
	/*
	 * Este teste é para o cliente já com endereço, mas sem cartão cadastrado.
	 * 
	 */
	@Test
	public void testeSimulacaoCompraLogin() {		
		
		System.setProperty("webdriver.gecko.driver", "/install/DESENVOLVIMENTO/Geckodrivers/geckodriver.exe");
//		System.setProperty("webdriver.chrome.driver", "/Users/wcaquino/Downloads/chromedriver");
//		WebDriver driver = new FirefoxDriver();
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		
//		Preparação:
		String clienteNome = "Patrícia Tavares";
		String clienteCpf = "78516603008";
		String clienteDataNascimento = "1995-04-251";
		String clienteSenha = "123Fatec";
		String clienteEmail = "patriciatavares@yahoo.com.br";
		// Endereço:
		String clienteCEP = "59180970";
		String clienteNumero = "126";
		String clienteComplemento = "casa 2";
		// Cartão de crédito
		String clienteCartaoNome = "PATRICIA TAVARES";
		String clienteCartaoNumero = "5373774571439627";
		String clienteCartaoDataValidade = "2023-08-11";
		String clienteCartaoCvv = "421";
		
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
		// finalizar pedido (se o cliente não exister abrirá opção de login ou cadastro:
		driver.findElement(By.id("irPedido")).click();
		
		// Login
		driver.findElement(By.id("login-email")).click();
		driver.findElement(By.id("login-email")).sendKeys(clienteEmail);
		driver.findElement(By.id("login-senha")).click();
		driver.findElement(By.id("login-senha")).sendKeys(clienteSenha);
		driver.findElement(By.id("login")).click();		
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
		// Deve retornar o nome do email, sem arroba.
		Assert.assertEquals(clienteEmail.split("@")[0], driver.findElement(By.id("dropdownMenuLink")).getText());
//		Cadastrar endereço (cliente novo sem nenhum endereço cadastrado):
		driver.findElement(By.id("irPedido")).click();		
		
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
		// Escolher o primeiro endereço da lista de endereços cadastrados:
		driver.findElement(By.xpath("//button[contains(.,'Escolher')]")).click();
		// Quando não tem nenhum cartão cadastrado
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
		
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
//		Selecioanar cartão existente:
		driver.findElement(By.xpath("//button[contains(text(),'Pagar com cartão final')]")).click();
		
		// Confirmar pedido:
		driver.findElement(By.xpath("//button[contains(text(),'Confirmar pedido')]")).click();
		
		// Pausa antes de finalizar.
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.quit();
	}
}
