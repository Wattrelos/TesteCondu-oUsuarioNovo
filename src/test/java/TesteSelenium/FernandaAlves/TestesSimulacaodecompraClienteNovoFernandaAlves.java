package TesteSelenium.FernandaAlves;
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

public class TestesSimulacaodecompraClienteNovoFernandaAlves {
	
//	Preparação:
	String clienteNome = "Fernanda Alves";
	String clienteCpf = "16886113046";
	String clienteDataNascimento = "1987-10-21";
	String clienteSenha = "123Fatec";
	String clienteEmail = "fernanda.alves@yahoo.com.br";
	// Endereço:
	String clienteCEP = "14075080";
	String clienteCidade ="Ribeirão Preto";
	String clienteNumero = "369";
	String clienteComplemento = "Loja 4";
	// Cartão de crédito
	String clienteCartaoNome = "FERNANDA ALVES";
	String clienteCartaoNumero = "5421093069897689";
	String clienteCartaoDataValidade = "2020-06-17";
	String clienteCartaoCvv = "421";
	
	@Test
	public void cadastroCliente() {	
		
		// Carregar driver Selenium para Firefox
		System.setProperty("webdriver.gecko.driver", "c:/install/DESENVOLVIMENTO/Geckodrivers/geckodriver.exe");		
		WebDriver driver = new FirefoxDriver();
		
//		Escolher itens		
		driver.get("http://localhost:8080/index");
// 		Verificar se a página carregou:
		Assert.assertEquals("Livraria Fatec online", driver.getTitle());
//		driver.manage().window().setSize(new Dimension(1200, 765));	
		driver.manage().timeouts().implicitlyWait(1700, TimeUnit.MILLISECONDS);
		driver.findElement(By.id("livro-5")).click();
		driver.findElement(By.id("livro-5")).click();
		driver.findElement(By.id("livro-7")).click();
		driver.findElement(By.id("livro-10")).click();
		driver.findElement(By.id("livro-13")).click();		
		
		// Ir para o carrinho de compras
		driver.findElement(By.xpath("//a[@href='/carrinho/carrinho']")).click();
		// finalizar pedido (se o cliente não exister abrirá opção de login ou cadastro:
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
		driver.findElement(By.id("feminino")).click();
		driver.findElement(By.id("cadastrar-cliente")).click();
		driver.quit();
	}
	
	@Test
	public void verificarCadastro() {
		
		// Carregar driver Selenium para Firefox
		System.setProperty("webdriver.gecko.driver", "c:/install/DESENVOLVIMENTO/Geckodrivers/geckodriver.exe");		
		WebDriver driver = new FirefoxDriver();
		
		// Verifica se o usuário está cadastrado
		driver.get("http://localhost:8080/index");
		driver.findElement(By.id("selectLogin")).click();
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
		driver.quit();
	}
	
	@Test	
	public void cadastroEndereco() {
		
		// Carregar driver Selenium para Firefox
		System.setProperty("webdriver.gecko.driver", "c:/install/DESENVOLVIMENTO/Geckodrivers/geckodriver.exe");		
		WebDriver driver = new FirefoxDriver();
		
//		Escolher itens		
		driver.get("http://localhost:8080/index");
// 		Verificar se a página carregou:
		Assert.assertEquals("Livraria Fatec online", driver.getTitle());
//		driver.manage().window().setSize(new Dimension(1200, 765));	
		driver.manage().timeouts().implicitlyWait(1700, TimeUnit.MILLISECONDS);
		driver.findElement(By.id("livro-5")).click();
		driver.findElement(By.id("livro-5")).click();
		driver.findElement(By.id("livro-7")).click();
		driver.findElement(By.id("livro-10")).click();
		driver.findElement(By.id("livro-13")).click();		
		
		// Ir para o carrinho de compras
		driver.findElement(By.xpath("//a[@href='/carrinho/carrinho']")).click();
		// finalizar pedido (se o cliente não exister abrirá opção de login ou cadastro:
		driver.findElement(By.id("irPedido")).click();
		;
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
//		Cadastrar endereço (cliente novo sem nenhum endereço cadastrado):
		driver.findElement(By.id("irPedido")).click();	
		
		
		// Bloco para endereço novo (sem endereço cadastrado) Se já tiver endereço cadastrado haverá erro.
		driver.findElement(By.id("cep")).click();
		driver.findElement(By.id("cep")).sendKeys(clienteCEP);
		// Mudar de campo para acionar o preenchimento automático de endereço.
		driver.findElement(By.id("numero")).click();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
//		Se o CEP exister, haverá algum dado como resposta
		Assert.assertEquals(clienteCidade, driver.findElement(By.id("cidade")).getAttribute("value"));
		// continua...
		driver.findElement(By.id("numero")).sendKeys(clienteNumero);
			
		driver.findElement(By.id("complemento")).click();
		driver.findElement(By.id("complemento")).sendKeys(clienteComplemento);
		driver.findElement(By.id("cadastrar")).click();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
		// Escolher o primeiro endereço da lista de endereços cadastrados:
		driver.findElement(By.xpath("//button[contains(text(),'Escolher')]")).click();
		driver.quit();
	}
	
	@Test
	public void cadastrarCartao() {
		
		// Carregar driver Selenium para Firefox
		System.setProperty("webdriver.gecko.driver", "c:/install/DESENVOLVIMENTO/Geckodrivers/geckodriver.exe");		
		WebDriver driver = new FirefoxDriver();
		
//		Escolher itens		
		driver.get("http://localhost:8080/index");
// 		Verificar se a página carregou:
		Assert.assertEquals("Livraria Fatec online", driver.getTitle());
//		driver.manage().window().setSize(new Dimension(1200, 765));	
		driver.manage().timeouts().implicitlyWait(1700, TimeUnit.MILLISECONDS);
		driver.findElement(By.id("livro-5")).click();
		driver.findElement(By.id("livro-5")).click();
		driver.findElement(By.id("livro-7")).click();
		driver.findElement(By.id("livro-10")).click();
		driver.findElement(By.id("livro-13")).click();		
		
		// Ir para o carrinho de compras
		driver.findElement(By.xpath("//a[@href='/carrinho/carrinho']")).click();
		// finalizar pedido (se o cliente não exister abrirá opção de login ou cadastro:
		driver.findElement(By.id("irPedido")).click();
		driver.manage().timeouts().implicitlyWait(1700, TimeUnit.MILLISECONDS);
		
		// Login
		driver.findElement(By.id("login-email")).click();
		driver.findElement(By.id("login-email")).sendKeys(clienteEmail);
		driver.findElement(By.id("login-senha")).click();
		driver.findElement(By.id("login-senha")).sendKeys(clienteSenha);
		driver.findElement(By.id("login")).click();		
		driver.manage().timeouts().implicitlyWait(1700, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
		
		// Finalizar pedido. Irá para forma de pagamento
		driver.findElement(By.id("irPedido")).click();
		driver.manage().timeouts().implicitlyWait(1700, TimeUnit.MILLISECONDS);
		
		// Escolher o primeiro endereço da lista de endereços cadastrados:
		driver.findElement(By.xpath("//button[contains(text(),'Escolher')]")).click();
		
		
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
		
		driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
//		Selecioanar cartão existente:
		driver.findElement(By.xpath("//button[contains(text(),'Pagar com cartão final')]")).click();
		
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
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
	
	@Test
	public void verificarPedido() {
		
		// Carregar driver Selenium para Firefox
		System.setProperty("webdriver.gecko.driver", "c:/install/DESENVOLVIMENTO/Geckodrivers/geckodriver.exe");		
		WebDriver driver = new FirefoxDriver();
		
		// Verifica se o usuário está cadastrado
		driver.get("http://localhost:8080/index");
		driver.findElement(By.id("selectLogin")).click();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
		// Login
		driver.findElement(By.id("login-email")).click();
		driver.findElement(By.id("login-email")).sendKeys(clienteEmail);
		driver.findElement(By.id("login-senha")).click();
		driver.findElement(By.id("login-senha")).sendKeys(clienteSenha);
		driver.findElement(By.id("login")).click();		
		driver.manage().timeouts().implicitlyWait(1700, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
		// Deve retornar o nome do email, sem arroba.
		// Assert.assertEquals(clienteEmail.split("@")[0], driver.findElement(By.id("dropdownMenuLink")).getText());
		driver.findElement(By.id("dropdownMenuLink")).click();
		driver.manage().timeouts().implicitlyWait(1700, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
		driver.findElement(By.xpath("//a[contains(text(),'Meus pedidos')]")).click();
		driver.manage().timeouts().implicitlyWait(1700, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
		driver.findElement(By.xpath("//a[contains(@href,'/pedido/meuPedido')]")).click();
		try {
	        Thread.sleep(10*1000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		driver.quit();
	}
	
}
