import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium1.Calc_page;

public class Shady_Flowers_Tests {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		String site = "C:\\Users\\shadi\\Desktop\\Project1\\home.html";

		driver.get(site);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Shady_Flowers_Main shady = new Shady_Flowers_Main(driver);

		//Navigate to contact page
		shady.contactPage().click();

		Thread.sleep(1000);

		//Check if name is empty
		if(shady.userNameValue().equals(""))
			System.out.println("Test 1 Passed - User name is Empty");
		else
			System.out.println("Test 1 Failed " + shady.userNameValue());

		//Check if last name is empty
		if(shady.userLastNameValue().equals(""))
			System.out.println("Test 1 Passed - User last name is Empty");
		else
			System.out.println("Test 1 Failed " + shady.userLastNameValue());

		//check if email is empty
		if(shady.userEmailNameValue().equals(""))
			System.out.println("Test 1 Passed - User email is Empty");
		else
			System.out.println("Test 1 Failed " + shady.userEmailNameValue());

		//check if phone is empty
		if(shady.userPhoneValue().equals(""))
			System.out.println("Test 1 Passed - User phone is Empty");
		else
			System.out.println("Test 1 Failed " + shady.userPhoneValue());

		//check if operator is empty
		if(shady.operatorValue().equals("none"))
			System.out.println("Test 1 Passed - Operaton is Empty");
		else
			System.out.println("Test 1 Failed " + shady.operatorValue());


		//Test 1 - testing short name
		shady.typeName("sh");
		shady.typeLastName("as");
		shady.typeEmail("sh@gmail.com");
		shady.typePhone("0549922359");
		shady.chooseOperator("North");

		//select the checkbox
		if(!shady.checkBox().isSelected())
			shady.checkBox().click();

		shady.sendButton().click();

		if(shady.errDivValue().equals("*Name is too short"))
			System.out.println("Test 1 Passed - Short Name");
		else
			System.out.println("Test 1 Failed " + shady.errDivValue());

		Thread.sleep(1000);

		// Restarting the form
		driver.navigate().refresh();

		Thread.sleep(1000);

		//Check if name is empty
		if(shady.userNameValue().equals(""))
			System.out.println("Test 2 Passed - User name is Empty");
		else
			System.out.println("Test 2 Failed " + shady.userNameValue());

		//Check if last name is empty
		if(shady.userLastNameValue().equals(""))
			System.out.println("Test 2 Passed - User last name is Empty");
		else
			System.out.println("Test 2 Failed " + shady.userLastNameValue());

		//check if email is empty
		if(shady.userEmailNameValue().equals(""))
			System.out.println("Test 2 Passed - User email is Empty");
		else
			System.out.println("Test 2 Failed " + shady.userEmailNameValue());

		//check if phone is empty
		if(shady.userPhoneValue().equals(""))
			System.out.println("Test 2 Passed - User phone is Empty");
		else
			System.out.println("Test 2 Failed " + shady.userPhoneValue());

		//check if operator is empty
		if(shady.operatorValue().equals("none"))
			System.out.println("Test 2 Passed - Operaton is Empty");
		else
			System.out.println("Test 2 Failed " + shady.operatorValue());



		//Test 2 - checking last name length
		shady.typeName("shady");
		shady.typeLastName("a");
		shady.typeEmail("sh@gmail.com");
		shady.typePhone("0549922359");
		shady.chooseOperator("Haifa");

		//select the checkbox
		if(!shady.checkBox().isSelected())
			shady.checkBox().click();

		shady.sendButton().click();

		if(shady.errDivValue().equals("*Last Name too short"))
			System.out.println("Test 2 Passed - Short Last Name");
		else
			System.out.println("Test 2 Failed " + shady.errDivValue());

		Thread.sleep(1000);

		// Restarting the form
		driver.navigate().refresh();

		//Test 3 - checking email regex
		shady.typeName("shady");
		shady.typeLastName("as");
		shady.typeEmail("shgmail.com");
		shady.typePhone("0549922359");
		shady.chooseOperator("Jerusalem");

		//select the checkbox
		if(!shady.checkBox().isSelected())
			shady.checkBox().click();

		shady.sendButton().click();

		if(shady.errDivValue().equals("*Invalid Email Address"))
			System.out.println("Test 3 Passed - Invalid Email");
		else
			System.out.println("Test 3 Failed " + shady.errDivValue());

		Thread.sleep(1000);

		// Restarting the form
		driver.navigate().refresh();

		//Test 4 - checking if one of the fields is empty
		shady.typeLastName("as");
		shady.typeEmail("sh@gmail.com");
		shady.typePhone("0549922359");
		shady.chooseOperator("Center");

		//select the checkbox
		if(!shady.checkBox().isSelected())
			shady.checkBox().click();

		shady.sendButton().click();

		if(shady.warningDivValue().equals("*Please fill all the fields"))
			System.out.println("Test 4 Passed - Leaving Name Empty");
		else
			System.out.println("Test 4 Failed " + shady.warningDivValue());

		Thread.sleep(1000);

		// Restarting the form
		driver.navigate().refresh();

		//Test 5 - sending valid details
		shady.typeName("shady");
		shady.typeLastName("as");
		shady.typeEmail("sh@gmail.com");
		shady.typePhone("0549922359");
		shady.chooseOperator("North");

		//select the checkbox
		if(!shady.checkBox().isSelected())
			shady.checkBox().click();

		shady.sendButton().click();

		if(shady.successDivValue().equals("*Infromation sent. We will contact you at the soonest time possible"))
			System.out.println("Test 5 Passed - Sending valid info");
		else
			System.out.println("Test 4 Failed " + shady.successDivValue());

		Thread.sleep(1000);
		
		//Check amount of checkboxes in the page
		shady.checkBoxList();

		if(shady.checkBoxSize()==1)
			System.out.println("Amount of checkbox test passed");
		else
			System.out.println("Test Failed");
		
		
		//Check amount of radio buttons in the page
		shady.radioButtonList();

		if(shady.radioButtonSize()==0)
			System.out.println("Amount of radio buttons test passed");
		else
			System.out.println("Test Failed");

		Thread.sleep(1000);

		//Navigating to another page
		shady.aboutUsPage().click();

		//Checking if navigation was to the correct page
		if(shady.aboutUsTitleValue().equalsIgnoreCase("about us"))
			System.out.println("Navigation Passed");
		else
			System.out.println("Navigation Failed " + shady.aboutUsTitleValue());

		Thread.sleep(1000);

		driver.quit();
		
		System.out.println("Tests Run Finished!");


	}

}
