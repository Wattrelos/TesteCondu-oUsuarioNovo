package TesteSelenium.tentando;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

public class TestesUnitarioSelectRadio {
	
	@Test
	public void testeSimulacaoCompra() {
		System.setProperty("webdriver.gecko.driver", "/install/DESENVOLVIMENTO/Geckodrivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/cliente/cadastro");
		driver.findElement(By.xpath("//input[@value='f'")).click();
		                             
//		driver.findElement(By.cssSelector("//input[value='f'")).click();		
//		driver.quit();
	}

}
