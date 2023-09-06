package utility;

import java.sql.DriverManager;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public  class loginB2BUser {
	

	// Instantiate a ChromeDriver class.
	static WebDriver driver = new ChromeDriver();
	public static void b2bUserLogin() {
		System.setProperty("webdriver.chrome.driver", "D:/Automation/chromedriver.exe");
		
		// Maximize the browser
		driver.manage().window().maximize();

		// Launch Website
		driver.get(
				"https://accstorefront.c9z0em8xjj-kawasakih2-s1-public.model-t.cc.commerce.ondemand.com/khib2b/en/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		driver.findElement(By.id("j_username")).sendKeys("test@cegb.co.jp");
		driver.findElement(By.id("j_password")).sendKeys("1");
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']")).click();

	}
	public static String returnCartNo()
	{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(By.xpath("//a[@class='nav-link position-relative min-cart-wrapper']")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			String parse =driver.findElement(By.xpath("//h4[@class='mb-0']")).getText();
			System.out.println(driver.findElement(By.xpath("//h4[@class='mb-0']")).getText());
			//
			String[] parse1 = parse.split("Cart ");
			
			//Logout
		//	driver.findElement(By.xpath("//a[@class='dropdown-toggle nav-link']")).click();
	//		driver.findElement(By.xpath("//a[@class='dropdown-item']")).click();
			return parse1[1].trim();
			
			
			
	}
	
	public static void refreshPage()
	{
	
		driver.navigate().refresh();
	}


}
