package BongoCodeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VideoVerify {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Setupfiles\\Drivers\\chromedriverFolder\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://bongobd.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//Validating we Enter BongoBD Website or somewhere Else
		String actual_URL = driver.getCurrentUrl();
		System.out.println("The Title is = "+actual_URL);
		String expected_URL = "https://bongobd.com/";
		if(actual_URL.contentEquals(expected_URL)) {
			System.out.println("It matches with Expected URL");
		}
		else {
			System.out.println("It Does not match with Expected URL");
		}
		//This command will scroll to the "Just Added" section 
		((JavascriptExecutor)driver).executeScript("scroll(0,700)");
		Thread.sleep(2000);
		    
		 //It will capture the "Just Added" section 
		 List<WebElement> Just_added_video =driver.findElements(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div[5]/div/div[1]/div/div/div[2]"));
		 Thread.sleep(5000);
		 int i= Just_added_video.size();
			for(int j=0; j<i; j++) {              
				//Printing the all Video Name Under Just Added section 
				System.out.println("Names of Just Added section videos are :\n\r"+Just_added_video.get(j).getText()); 
				}
		Thread.sleep(2000);
		//validate Exclusive Video
		
		/*After Clicking on an exclusive video user redirect to the Register page and 
		after registration user need to subscriibe the Plan,
		So i validate exclusive video with bongo register page*/

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div[5]/div/div[1]/div/div/div[2]/div/div/div/div/div[7]/div/div/div/a/div[2]/h6")).click();
		Thread.sleep(2000);
		String Actual_URL=driver.getCurrentUrl();
		System.out.println("The URL of the Exclusive Video is : "+Actual_URL);
		String Expected_URL= "https://bongobd.com/register";
		if(Actual_URL.contentEquals(Expected_URL)) {
			System.out.println("It redirect to the Register page,So the video is not free");
		}
		else {
			System.out.println("It Doesn`t redirect to the exclusive video URL");
		}
		driver.navigate().back();  //navigate to the home page again
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("scroll(0,700)");
		
		//Validate the free video.If the video is exist/displayed it will play the video
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div[5]/div/div[1]/div/div/div[2]/div/div/div/div/div[8]/div/div/div/a/div[2]/h6")).click();
		Thread.sleep(50000); //long wait because of advertisement
		WebElement Free_video = driver.findElement(By.xpath("//*[@id=\"vid1_html5_api\"]"));
		
		if(Free_video.isDisplayed()) {
			Free_video.click();
			System.out.println("The Free Video is Displayed and Played Successfully");
		}
		else {
			System.out.println("The Video doesn`t Exist and can`t Play");
		}		 
	}
}
