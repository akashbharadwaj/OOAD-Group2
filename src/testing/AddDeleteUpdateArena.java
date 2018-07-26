package testing;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddDeleteUpdateArena{
	WebDriver driver;
	@Before
	public void openWikipediaEnglishPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/OOAD-Group2/");
		Assert.assertEquals("Login Page", driver.getTitle());
	}
	@Test
	public void testLogin() throws InterruptedException{
		WebElement email = driver.findElement(By.id("username"));;
		email.sendKeys("akashbharadwaj006@gmail.com");
		
		WebElement pass = driver.findElement(By.id("password"));;
		pass.sendKeys("abc");
		Thread.sleep(10000);
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		Assert.assertEquals("Admin Page", driver.getTitle());
		Thread.sleep(10000);
		
		WebElement addName = driver.findElement(By.id("addName"));
		addName.sendKeys("test");
		//Thread.sleep(10000);
		WebElement addLocation = driver.findElement(By.id("addLocation"));
		addLocation.sendKeys("test10");
		Thread.sleep(10000);
		WebElement add = driver.findElement(By.id("add"));
		add.click();
		WebElement msg =driver.findElement(By.id("success"));
        String successText=msg.getText();
        System.out.println(successText);
		Assert.assertEquals("ARENA ADDED SUCCESSFULLY!",successText );
		Thread.sleep(10000);
		
		WebElement deleteName = driver.findElement(By.id("deleteName"));
		deleteName.sendKeys("test");
		WebElement deleteLocation = driver.findElement(By.id("deleteLocation"));
		deleteLocation.sendKeys("test9");
		Thread.sleep(10000);
		WebElement delete = driver.findElement(By.id("delete"));
		delete.click();
		WebElement msg1 =driver.findElement(By.id("success"));
        String successText1 = msg1.getText();
        System.out.println(successText1);
		Assert.assertEquals("ARENA DELETED SUCCESSFULLY!",successText1 );
		Thread.sleep(10000);
		
		WebElement arenaID = driver.findElement(By.id("arenaId"));
		arenaID.sendKeys("11");
		WebElement updateName = driver.findElement(By.id("updateName"));
		updateName.sendKeys("test12");
		WebElement updateLocation = driver.findElement(By.id("updateLocation"));
		updateLocation.sendKeys("test3");
		Thread.sleep(10000);
		WebElement update = driver.findElement(By.id("update"));
		update.click();
		WebElement msg2 =driver.findElement(By.id("success"));
        String successText2 = msg2.getText();
        System.out.println(successText2);
		Assert.assertEquals("ARENA UPDATED SUCCESSFULLY!",successText2 );
		Thread.sleep(10000);
		
		WebElement addNameUn = driver.findElement(By.id("addName"));
		addNameUn.sendKeys("test");
		WebElement addLocationUn = driver.findElement(By.id("addLocation"));
		addLocationUn.sendKeys("test10");
		Thread.sleep(10000);
		WebElement addUn = driver.findElement(By.id("add"));
		addUn.click();
		WebElement msgf =driver.findElement(By.id("failure"));
        String successTextf = msgf.getText();
        System.out.println(successTextf);
		Assert.assertEquals("ARENA ADD UNSUCCESSFUL!",successTextf );
		Thread.sleep(10000);
		
		WebElement deleteNameUn = driver.findElement(By.id("deleteName"));
		deleteNameUn.sendKeys("test");
		Thread.sleep(10000);
		WebElement deleteLocationUn = driver.findElement(By.id("deleteLocation"));
		deleteLocationUn.sendKeys("test9");
		Thread.sleep(10000);
		WebElement deleteUn = driver.findElement(By.id("delete"));
		deleteUn.click();
		WebElement msgf1 =driver.findElement(By.id("failure"));
        String successTextf1 = msgf1.getText();
        System.out.println(successTextf1);
		Assert.assertEquals("ARENA DELETE UNSUCCESSFUL!",successTextf1 );
		Thread.sleep(10000);
		
		WebElement arenaIDUn = driver.findElement(By.id("arenaId"));
		arenaIDUn.sendKeys("40");
		WebElement updateNameUn = driver.findElement(By.id("updateName"));
		updateNameUn.sendKeys("test12");
		WebElement updateLocationUn = driver.findElement(By.id("updateLocation"));
		updateLocationUn.sendKeys("test3");
		Thread.sleep(10000);
		WebElement updateUn = driver.findElement(By.id("update"));
		updateUn.click();
		WebElement msgf2 = driver.findElement(By.id("failure"));
        String successTextf2 = msgf2.getText();
        System.out.println(successTextf2);
		Assert.assertEquals("ARENA UPDATE UNSUCCESSFUL!",successTextf2 );
		Thread.sleep(10000);
	}
	
	@After
	public void closePage(){
		driver.quit();
	}
	
}