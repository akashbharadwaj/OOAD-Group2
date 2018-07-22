package testing;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	WebDriver driver;

	@Before
	public void openWikipediaEnglishPage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/OOAD-Group2/login.jsp");
	}

//	@Test
//	public void testEnglishLink() throws InterruptedException {
//		WebElement link = driver.findElement(By.id("js-link-box-en"));
//		link.click();
//		Thread.sleep(5000);
//		Assert.assertEquals("Wikipedia, the free encyclopedia", driver.getTitle());
//	}

	@Test
	public void testLogin() throws InterruptedException {
		WebElement searchBox = driver.findElement(By.id("username"));
		;
		searchBox.sendKeys("prathik.ganiga@utdallas.edu");
		Thread.sleep(2000);
		searchBox = driver.findElement(By.id("password"));
		searchBox.sendKeys("prathik");
		Thread.sleep(2000);
//		searchBox.submit();
		WebElement link = driver.findElement(By.id("login"));
		link.click();
		Thread.sleep(3000);
		Assert.assertEquals("Welcome Page", driver.getTitle());
	}

	@After
	public void closePage() {
		driver.quit();
	}
}