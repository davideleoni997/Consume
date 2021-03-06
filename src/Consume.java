
import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Consume {

	@Test
	void test() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Conversione miglia a chilometri
		driver.get("https://www.unitconverters.net/speed/mph-to-kph.htm");
		Integer kilometers = 20;
		
		driver.findElement(By.xpath("//*[@id=\"ucfrom\"]")).sendKeys("75");
	
		WebElement convResult = driver.findElement(By.xpath("//*[@id=\"ucto\"]"));
	
		Double convResult75 = Double.parseDouble(convResult.getAttribute("value"));
		
		
		Double hours75 = kilometers/convResult75;
		Double minutes75 = hours75*60;
		
		driver.findElement(By.xpath("//*[@id=\"ucfrom\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"ucfrom\"]")).sendKeys("55");
		
		convResult = driver.findElement(By.xpath("//*[@id=\"ucto\"]"));
		Double convResult55 = Double.parseDouble(convResult.getAttribute("value"));
		
		
		Double hours55 = kilometers/convResult55;
		Double minutes55 = hours55*60;
		
		Double difference = minutes55 - minutes75;
		
		driver.close();
		
		assertTrue(difference<5);
		
		

		
		
	}

}
