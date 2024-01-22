package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame1 {

	public static void main(String[] args) throws Exception {
		// setting the property of chrome browser and passing chromedriver path
		System.setProperty("webdriver.chrome.driver", "D:\\Training Materials\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.paytm.com/");
		
		//login click
		driver.findElement(By.xpath("//*[text()='Sign In']")).click();
		
		//find total no. of frame
		int allFrames = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total frames : " + allFrames);
        
		// go inside each frame and check if the element is present
		for (int i = 0; i < allFrames; i++) {
			driver.switchTo().frame(i);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[contains(text(),'Watch Video')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[contains(text(),'close')]")).click();
			
		}
	}

}
