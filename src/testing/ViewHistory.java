package testing;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ViewHistory {
	WebDriver driver;

	@Before
	public void openWikipediaEnglishPage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/OOAD-Group2/login.jsp");
	}

	
	@Test
	public void bookArena() throws InterruptedException {
		WebElement searchBox = driver.findElement(By.id("username"));
		;
		searchBox.sendKeys("prathik.ganiga@utdallas.edu");
		Thread.sleep(2000);
		searchBox = driver.findElement(By.id("password"));
		searchBox.sendKeys("prathik");
		Thread.sleep(2000);
		WebElement link = driver.findElement(By.id("login"));
		link.click();
		Thread.sleep(3000);
		
		link = driver.findElement(By.id("history"));
		link.click();
		Thread.sleep(3000);
		Assert.assertEquals("Booking History", driver.getTitle());
	}	

	@After
	public void closePage() {
		driver.quit();
	}
}