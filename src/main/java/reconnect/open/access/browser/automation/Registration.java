package reconnect.open.access.browser.automation;

import java.io.IOException;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

public class Registration {

	public static String successText = "User Registration Submitted Successfully";

	public static void main(String[] args) throws InterruptedException, IOException {

//	ChromeOptions option=new ChromeOptions();

//	option.addArguments("--incognito=new");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set a reasonable timeout

		// Login to the application

		driver.get("http://3.21.193.9/KSEB/OA");

		// clicking on new register? link

		// driver.findElement(By.xpath("//a[text()='New Register?']")).click();

		// file pathe

//		String filepath = System.getProperty("user.dir") + "\\testdata\\TRADER.xlsx";
		
		String filepath = "D:\\Selanium Java Workspace\\REGISTRATION_USER_DATA";

		int rows = ReadRegistrationData.getRowCount(filepath, "Trader1");

		for (int i = 5; i <= rows; i++) {

			// clicking on new register? link

			driver.findElement(By.xpath("//a[text()='New Register?']")).click();

			// 1) read data from excel

			String ApplicantTypes = ReadRegistrationData.getCellData(filepath, "Trader1", i, 0);

			String subType = ReadRegistrationData.getCellData(filepath, "Trader1", i, 47);

			String ApplicantName = ReadRegistrationData.getCellData(filepath, "Trader1", i, 1);

			String LoginName = ReadRegistrationData.getCellData(filepath, "Trader1", i, 2);

			String Designation = ReadRegistrationData.getCellData(filepath, "Trader1", i, 3);

			String CompanyName = ReadRegistrationData.getCellData(filepath, "Trader1", i, 4);

			String SelectTheSecurityTQuestion = ReadRegistrationData.getCellData(filepath, "Trader1", i, 5);

			String Answer = ReadRegistrationData.getCellData(filepath, "Trader1", i, 6);

			String MobileNumber = ReadRegistrationData.getCellData(filepath, "Trader1", i, 7);

			String PhoneNumber = ReadRegistrationData.getCellData(filepath, "Trader1", i, 8);

			String Address = ReadRegistrationData.getCellData(filepath, "Trader1", i, 9);

			String Email = ReadRegistrationData.getCellData(filepath, "Trader1", i, 10);

			String Fax = ReadRegistrationData.getCellData(filepath, "Trader1", i, 11);

			String ApplicanName = ReadRegistrationData.getCellData(filepath, "Trader1", i, 12);

			String Designtion = ReadRegistrationData.getCellData(filepath, "Trader1", i, 13);

			String MobileNumber2 = ReadRegistrationData.getCellData(filepath, "Trader1", i, 14);

			String PhoneNumber2 = ReadRegistrationData.getCellData(filepath, "Trader1", i, 15);

			String Fax2 = ReadRegistrationData.getCellData(filepath, "Trader1", i, 16);

			String Email2 = ReadRegistrationData.getCellData(filepath, "Trader1", i, 17);

			String CoordinatorName = ReadRegistrationData.getCellData(filepath, "Trader1", i, 18);

			String CoordinatorDesignation = ReadRegistrationData.getCellData(filepath, "Trader1", i, 19);

			String CoordinatorMobileNumber = ReadRegistrationData.getCellData(filepath, "Trader1", i, 20);

			String CoordinatorEmail = ReadRegistrationData.getCellData(filepath, "Trader1", i, 21);

			String TraderName = ReadRegistrationData.getCellData(filepath, "Trader1", i, 22);

			String TypeofTrader = ReadRegistrationData.getCellData(filepath, "Trader1", i, 23);

			String HERCTradingLicenseNo = ReadRegistrationData.getCellData(filepath, "Trader1", i, 24);

			String HERCLicenseFrom = ReadRegistrationData.getCellData(filepath, "Trader1", i, 25);

			String HERCValidityTo = ReadRegistrationData.getCellData(filepath, "Trader1", i, 26);

			String UploadLicenseCopyHERC = ReadRegistrationData.getCellData(filepath, "Trader1", i, 27);

			String CERCLicenseLevel = ReadRegistrationData.getCellData(filepath, "Trader1", i, 28);

			String CERCTradingLicenseNo = ReadRegistrationData.getCellData(filepath, "Trader1", i, 29);

			String CERCLicensFrom = ReadRegistrationData.getCellData(filepath, "Trader1", i, 30);

			String CERCLicenseTo = ReadRegistrationData.getCellData(filepath, "Trader1", i, 31);

			String UploadLicenseCopyCERC = ReadRegistrationData.getCellData(filepath, "Trader1", i, 32);

			String PaymentMode = ReadRegistrationData.getCellData(filepath, "Trader1", i, 33);

			String UTRNumber = ReadRegistrationData.getCellData(filepath, "Trader1", i, 34);

			String BankName = ReadRegistrationData.getCellData(filepath, "Trader1", i, 35);

			String PANNumber = ReadRegistrationData.getCellData(filepath, "Trader1", i, 36);

			String GSTNumber = ReadRegistrationData.getCellData(filepath, "Trader1", i, 37);

			String TransactionMonthYear = ReadRegistrationData.getCellData(filepath, "Trader1", i, 38);

			String SupportingDocuments = ReadRegistrationData.getCellData(filepath, "Trader1", i, 39);

			String DiscomLicenseName = ReadRegistrationData.getCellData(filepath, "Trader1", i, 40);

			String DiscomLicenseNumber = ReadRegistrationData.getCellData(filepath, "Trader1", i, 41);

			String LicenseIssuingAuthority = ReadRegistrationData.getCellData(filepath, "Trader1", i, 42);

			String DiscomOfficerDesignation = ReadRegistrationData.getCellData(filepath, "Trader1", i, 43);

			String DiscomOfficerEmailId = ReadRegistrationData.getCellData(filepath, "Trader1", i, 44);

			String DiscomOfficerMobileNumber = ReadRegistrationData.getCellData(filepath, "Trader1", i, 45);

			// passing data in to the fileds

			// Applicant type sending

			List<WebElement> applicantType = driver
					.findElements(By.xpath("//div[contains(@class,'css-p58oka')]/label"));

			for (WebElement Applicants : applicantType)

			{

				String applicantTyp = Applicants.getText();

				// System.out.println(applicantTyp);

				if (applicantTyp.equals(ApplicantTypes))

				{

					Applicants.click();

					break;

				}

			}

			// Below code to select the sub type

			// Seller

			if (ApplicantTypes.equals("Seller")) {

				List<WebElement> sellerTypeElement = driver
						.findElements(By.xpath("//div[contains(@class,'css-13sljp9')]//div[@id='sellerType']//label"));

				System.out.println("seller type " + sellerTypeElement.size());

				for (WebElement seller : sellerTypeElement)

				{

					System.out.println("sellrt Text--->" + seller.getText());

					if (seller.getText().equals(subType))

					{

						seller.click();

						break;

					}

				}

			}

			// Below code to select the sub type

			// Buyer

//    	  if(ApplicantTypes.equals("BUYER")) {

//        	  List<WebElement>buyerTypeElement = driver.findElements(By.xpath("//div[contains(@class,'css-p58oka')]/label"));

//

//    		  for(WebElement buyer:buyerTypeElement)

//        	  {

//     	    	// System.out.println(applicantTyp);

//     	    	if(buyer.getText().equals(sellerType))

//     	    	{

//     	    		buyer.click();

//     	    		break;

//     	    	}

//     	    	}

//    	  }

			Thread.sleep(5000);

			WebElement loginname = driver.findElement(By.xpath(" //input[@id='userName']"));

			loginname.sendKeys(LoginName);

			WebElement ApplicantNames = driver.findElement(By.xpath("//input[@id='applicantName']"));

			ApplicantNames.sendKeys(ApplicantName);

			WebElement Designations = driver.findElement(By.xpath("//input[@id='applicantDesignation']"));

			Designations.sendKeys(Designation);

			WebElement companyName = driver.findElement(By.xpath("//input[@id='companyName']"));

			companyName.sendKeys(CompanyName);

			JavascriptExecutor js = (JavascriptExecutor) driver;

			driver.findElement(By.xpath("//div[@id='securityQuestion']")).click();

			List<WebElement> securitydropdown = driver
					.findElements(By.xpath("//ul[contains(@class,'css-r8u8y9')]//li[@tabindex='-1']"));

			System.out.println(securitydropdown.size());

			for (WebElement allquastions : securitydropdown)

			{

				if (allquastions.getText().equals(SelectTheSecurityTQuestion))

				{

					allquastions.click();

					break;

				}

			}

			WebElement securityAnswer = driver.findElement(By.xpath("//input[@id='securityAnswer']"));

			securityAnswer.sendKeys(Answer);

			WebElement applicantMobileNumber = driver.findElement(By.xpath("//input[@id='applicantMobileNumber']"));

			applicantMobileNumber.sendKeys(MobileNumber);

			WebElement applicantPhoneNumber = driver.findElement(By.xpath("//input[@id='applicantPhoneNumber']"));

			applicantPhoneNumber.sendKeys(PhoneNumber);

			WebElement applicantAddress = driver.findElement(By.xpath("//input[@id='applicantAddress']"));

			applicantAddress.sendKeys(Address);

			WebElement applicantEmailId = driver.findElement(By.xpath("//input[@id='applicantEmailId']"));

			applicantEmailId.sendKeys(Email);

			WebElement applicantFaxNumber = driver.findElement(By.xpath("//input[@id='applicantFaxNumber']"));

			applicantFaxNumber.sendKeys(Fax);

			WebElement secondaryApplicantName = driver.findElement(By.xpath("//input[@id='secondaryApplicantName']"));

			secondaryApplicantName.sendKeys(ApplicanName);

			WebElement secondaryDesignation = driver.findElement(By.xpath("//input[@id='secondaryDesignation']"));

			secondaryDesignation.sendKeys(Designtion);

			WebElement secondaryMobileNumber = driver.findElement(By.xpath("//input[@id='secondaryMobileNumber']"));

			secondaryMobileNumber.sendKeys(MobileNumber2);

			WebElement secondaryPhoneNumber = driver.findElement(By.xpath("//input[@id='secondaryPhoneNumber']"));

			secondaryPhoneNumber.sendKeys(PhoneNumber2);

			WebElement secondaryFaxNumber = driver.findElement(By.xpath("//input[@id='secondaryFaxNumber']"));

			secondaryFaxNumber.sendKeys(Fax2);

			WebElement secondaryEmailId = driver.findElement(By.xpath("//input[@id='secondaryEmailId']"));

			secondaryEmailId.sendKeys(Email2);

			WebElement NextButton = driver.findElement(By.xpath("//button[normalize-space()='Next']"));

			NextButton.click();

			// Coordinator Details

			WebElement coordinatorName = driver.findElement(By.xpath("//input[@id='coordinatorName']"));

			coordinatorName.sendKeys(CoordinatorName);

			WebElement coordinatorDesignation = driver.findElement(By.xpath("//input[@id='coordinatorDesignation']"));

			coordinatorDesignation.sendKeys(CoordinatorDesignation);

			WebElement coordinatorMobileNumber = driver.findElement(By.xpath("//input[@id='coordinatorMobileNumber']"));

			coordinatorMobileNumber.sendKeys(CoordinatorMobileNumber);

			WebElement coordinatorEmailId = driver.findElement(By.xpath("//input[@id='coordinatorEmailId']"));

			coordinatorEmailId.sendKeys(CoordinatorEmail);

			WebElement NextButton1 = driver.findElement(By.xpath("//button[normalize-space()='Next']"));

			NextButton1.click();

			String applicationSubType = "UTILITY"; // Dulicate static value

			switch (subType) {

			case "UTILITY":

			{

			}

			case "TRADER":

			{

				WebElement traderName = driver.findElement(By.xpath("//input[@id='traderName']"));

				traderName.sendKeys(TraderName);

				driver.findElement(By.xpath(" //button[@title='Open']")).click();

				List<WebElement> traderType = driver.findElements(By.xpath("//ul[@id='traderType-listbox']/li"));

				for (WebElement tradertyps : traderType)

				{

					if (tradertyps.getText().endsWith(TypeofTrader))

					{

						tradertyps.click();

						break;

					}

				}

				WebElement herctadinglicenseno = driver.findElement(By.xpath("//input[@id='hercTradingLicenseNo']"));

				herctadinglicenseno.sendKeys(HERCTradingLicenseNo);

				// KSERC License Validity From Date and to date

				WebElement KSERCLicenseFromdate = driver.findElement(By.xpath("//input[@id=':rp:']"));

				KSERCLicenseFromdate.click();

				KSERCLicenseFromdate.sendKeys(HERCLicenseFrom);

				WebElement KSERCLicenseTodate = driver.findElement(By.xpath("//input[@id=':rr:']"));

				KSERCLicenseTodate.click();

				KSERCLicenseTodate.sendKeys(HERCValidityTo);

				// file upload

				WebElement UploadKSERC = driver.findElement(By.xpath("//input[@id='hercLicenseCopy']"));

				UploadKSERC.sendKeys(UploadLicenseCopyHERC);

				WebElement cercLicenseLevel = driver.findElement(By.xpath("//input[@id='cercLicenseLevel']"));

				cercLicenseLevel.sendKeys(CERCLicenseLevel);

				WebElement cercTradingLicenseNo = driver.findElement(By.xpath("//input[@id='cercTradingLicenseNo']"));

				cercTradingLicenseNo.sendKeys(CERCTradingLicenseNo);

				// CERC License Validity From Date and to date

				WebElement CERCLicenseFromdate2 = driver.findElement(By.xpath("//input[@id=':rv:']"));

				CERCLicenseFromdate2.click();

				CERCLicenseFromdate2.sendKeys(CERCLicensFrom);

				WebElement CERCLicenseTodate2 = driver.findElement(By.xpath("//input[@id=':r11:']"));

				CERCLicenseTodate2.click();

				CERCLicenseTodate2.sendKeys(CERCLicenseTo);

				WebElement file2 = driver.findElement(By.xpath("//input[@id='cercLicenseCopy']"));

				file2.sendKeys(UploadLicenseCopyCERC);

				WebElement next = driver.findElement(By.xpath("//button[text()='Next']"));

				next.click();

			}

			case "CONSUMER":

			{

			}

			case "GENERATOR":

			{

			}

			case "DISCOM":

			{

			} // Discom

				WebElement discomname = driver.findElement(By.xpath("//input[@id='discomName']"));

				discomname.sendKeys(DiscomLicenseName);

				WebElement discomlicensenum = driver.findElement(By.xpath("//input[@id='licenseeNumber']"));

				discomlicensenum.sendKeys(DiscomLicenseNumber);

				WebElement licenseissueautority = driver
						.findElement(By.xpath("//input[@id='licenseeIssuingAuthority']"));

				licenseissueautority.sendKeys(LicenseIssuingAuthority);

				WebElement discomdesignation = driver.findElement(By.xpath("//input[@id='discomDesignation']"));

				discomdesignation.sendKeys(DiscomOfficerDesignation);

				WebElement discommail = driver.findElement(By.xpath("//input[@id='discomEmailId']"));

				discommail.sendKeys(DiscomOfficerEmailId);

				WebElement discommobile = driver.findElement(By.xpath("//input[@id='discomMobileNumber']"));

				discommobile.sendKeys(DiscomOfficerMobileNumber);

				WebElement nextbutton = driver.findElement(By.xpath("//button[normalize-space()='Next']"));

				nextbutton.click();

			default:

			{

			}

			}

			// Trader Details

			// Payment details

			js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");

			WebElement transdropdown = driver.findElement(By.cssSelector("button[title='Open'] svg"));

			transdropdown.click()

			;
			Thread.sleep(5000);

			List<WebElement> PaymentModeList = driver.findElements(By.xpath("//ul[@id='transactionType-listbox']/li"));

			for (WebElement typeOfMatment : PaymentModeList)

			{

				if (typeOfMatment.getText().equals(PaymentMode))

				{

					typeOfMatment.click();

					break;

				}

			}

			WebElement bankName = driver.findElement(By.xpath("//input[@id='bankName']"));

			bankName.sendKeys(BankName);

			WebElement utrNumber = driver.findElement(By.xpath("//input[@id='utrNumber']"));

			utrNumber.sendKeys(UTRNumber);

			WebElement panNumber = driver.findElement(By.xpath("//input[@id='panNumber']"));

			panNumber.sendKeys(PANNumber);

			WebElement gstNumber = driver.findElement(By.xpath("//input[@id='gstNumber']"));

			gstNumber.sendKeys(GSTNumber);

			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			// PAYMENT DATE

			WebElement Paymentdate = driver.findElement(By.xpath("//input[@placeholder='DD-MM-YYYY']"));

			Paymentdate.click();

			Paymentdate.sendKeys(TransactionMonthYear);

			WebElement file3 = driver.findElement(By.xpath("//input[@id='supportingDocuments']"));

			file3.sendKeys(SupportingDocuments);

			WebElement next3 = driver.findElement(By.xpath("//button[text()='Next']"));

			next3.click();

			// Subsmitting the application

			WebElement submitting = driver.findElement(By.xpath("//button[contains(@class,'css-18qgb0n')]"));

			// submitting.click();

			Thread.sleep(5000);

			boolean loggedIn = false;

			try

			{

				WebElement successful = driver.findElement(By.xpath("//div[@class='MuiAlert-message css-18mfsq4']"));

				System.out.println("text-?>>>>" + successful.getText());

				loggedIn = successful.getText().equals(successText);

				System.out.println("loggedIn" + loggedIn);

			}

			catch (Exception e) {

				e.printStackTrace();

			}

			if (loggedIn == true)

			{

				System.out.println("New User is Registered successfully ");

				ReadRegistrationData.setCellData(filepath, "Trader1", i, 50, "user is registered ");

			}

			else

			{

				System.out.println("New User is  Not Registered  ");

				ReadRegistrationData.setCellData(filepath, "Trader1", i, 50, "user is Not registered ");

			}

			driver.navigate().refresh();

		}

		driver.quit();

	}

}