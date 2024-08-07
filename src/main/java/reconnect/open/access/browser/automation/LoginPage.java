package reconnect.open.access.browser.automation;

import java.io.IOException;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set a reasonable timeout

		// Login to the application

		driver.get("http://3.21.193.9/KSEB/OA/");

//        String Filepath = System.getProperty("user.dir") + "\\testdata\\caldata.xlsx";

		String filePath = "D:\\Selanium Java Workspace\\OA_LOGIN_CREDENTAILS.xlsx";
		int totalrows = Excel.getRowCount(filePath, "sheet1");

		for (int i = 1; i <= totalrows; i++) {

			// Reading excel data

			String Username = Excel.getCellData(filePath, "sheet1", i, 0);

			String Password = Excel.getCellData(filePath, "sheet1", i, 1);

			String Validate = Excel.getCellData(filePath, "sheet1", i, 2);

			System.out.println("The validate value -> " + Validate);

			// Passing data

			WebElement userField = driver.findElement(By.cssSelector("#userId"));

			WebElement passwordField = driver.findElement(By.cssSelector("#-password-login"));

			userField.sendKeys(Username);

			passwordField.sendKeys(Password);

			// Clicking login button

			driver.findElement(By.xpath("//button[@tabindex='0']")).click();

			boolean isInvalidCred = false;

			try {

				String invalidCredText = driver.findElement(By.xpath("//span[text()='Invalid Credentials']")).getText();

				isInvalidCred = invalidCredText.equals("Invalid Credentials");

			} catch (NoSuchElementException e) {

				// No invalid credentials message found

			}

			System.out.println("isInvalidCred: " + isInvalidCred);

			if (!isInvalidCred) {

//				String actual = driver.findElement(By.xpath("//li/h6[text()='Dashboard']")).getTagName();

					System.out.println("Logged in successfully");

					Excel.setCellData(filePath, "sheet1", i, 4, "pass");


					driver.findElement(By.xpath("//button[@title='Logout']")).click();


			} else {

				System.out.println("Not Logged in");

				Excel.setCellData(filePath, "sheet1", i, 4, "failed");


			}

		}

		driver.quit();

	}

}
