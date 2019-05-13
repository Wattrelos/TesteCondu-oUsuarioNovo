package TesteSelenium;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

public class TestesUnitariosLivraria {
	
	@Test
	public void teste() {
		System.setProperty("webdriver.gecko.driver", "/install/DESENVOLVIMENTO/Geckodrivers/geckodriver.exe");
//		System.setProperty("webdriver.chrome.driver", "/Users/wcaquino/Downloads/chromedriver");
//		WebDriver driver = new FirefoxDriver();
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
//		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://localhost:8080/index");
		Assert.assertEquals("Livraria Fatec online", driver.getTitle());		
		// Teste selecionar um livro para o carrinho:
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.findElement(By.id("livro-4")).click();
		driver.findElement(By.id("livro-4")).click();
		driver.findElement(By.id("livro-6")).click();
		driver.findElement(By.id("livro-13")).click();
		driver.findElement(By.id("livro-15")).click();
		driver.quit();
	}
	
	@Test
	public void irCarrinho() {
		
		System.setProperty("webdriver.gecko.driver", "/install/DESENVOLVIMENTO/Geckodrivers/geckodriver.exe");//		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/index");
		// Ir para o carrinho de compras
		driver.findElement(By.xpath("//a[@href='/carrinho/carrinho']")).click();		
		driver.quit();
	}

}
