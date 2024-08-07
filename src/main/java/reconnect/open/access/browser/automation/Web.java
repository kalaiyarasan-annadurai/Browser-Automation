package reconnect.open.access.browser.automation;

// Java program to implement 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
    public static void main(String[] args)
    {
    	
    	System.setProperty("webdriver.chrome.driver", "D:\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
    	// Create an instance of ChromeDriver (launch the
        // Chrome browser)
        WebDriver driver = new ChromeDriver();

        // Navigate to the desired website 
        driver.get("http://3.21.193.9/KSEB/OA");

        

        // Get and print the page title
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);


        // Wait for a few seconds (for demonstration
        // purposes only)
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}