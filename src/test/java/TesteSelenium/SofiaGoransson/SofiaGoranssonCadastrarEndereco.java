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

public class SofiaGoranssonCadastrarEndereco {
	
	@Test
	public void testeSimulacaoCompraLogin() {		
		
		System.setProperty("webdriver.gecko.driver", "/install/DESENVOLVIMENTO/Geckodrivers/geckodriver.exe");
//		System.setProperty("webdriver.chrome.driver", "/Users/wcaquino/Downloads/chromedriver");
//		WebDriver driver = new FirefoxDriver();
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		
//		Preparação:
		String clienteNome = "Sofia Göransson";
		String clienteCpf = "79189297059";
		String clienteDataNascimento = "2000-08-16";
		String clienteSenha = "jDiA_piQX9KOYkBL";
		String clienteEmail = "sofiagoransson745@yahoo.se";
		// Endereço:
		String clienteCEP = "06530245";
		String clienteCidade = "Santana de Parnaíba";
		String clienteNumero = "1280";
		String clienteComplemento = "sala 23";
		
		// Cartão de crédito
		String clienteCartaoNome = "SOFIA GORANSSON";
		String clienteCartaoNumero = "5454230977885501";
		String clienteCartaoDataValidade = "2022-08-21";
		String clienteCartaoCvv = "325";
		
		driver.get("http://localhost:8080/index");
//		driver.manage().window().setSize(new Dimension(1200, 765));	
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
		driver.findElement(By.id("livro-1")).click();
		driver.findElement(By.id("livro-2")).click();
		driver.findElement(By.id("livro-5")).click();
		driver.findElement(By.id("livro-14")).click();
		driver.findElement(By.id("livro-14")).click();
		
		// Verificar se a página carregou:
		Assert.assertEquals("Livraria Fatec online", driver.getTitle());
				
		// Ir para o carrinho de compras
		driver.findElement(By.xpath("//a[@href='/carrinho/carrinho']")).click();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
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
//		Cadastrar endereço (cliente novo sem nenhum endereço cadastrado):
		driver.findElement(By.id("irPedido")).click();
		
		// Bloco para endereço novo (sem endereço cadastrado)
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
		driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
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
		
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS); // Adicionar um delay para esperar a tela carregar.
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
		driver.quit();;
	}
}
