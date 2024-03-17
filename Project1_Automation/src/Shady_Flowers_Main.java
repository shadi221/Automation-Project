import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Shady_Flowers_Main {
	WebDriver driver;
	
	Shady_Flowers_Main(WebDriver driver){
		this.driver=driver;
	}
		
	WebElement userName() {
		return driver.findElement(By.id("UserName"));
	}

	WebElement userLastName() {
		return driver.findElement(By.cssSelector("[class='form-control'][placeholder='Last Name']"));
	}

	WebElement userEmail() {
		return driver.findElement(By.name("email"));
	}

	WebElement userPhone() {
		return driver.findElement(By.id("PhoneNumber"));
	}
	
	WebElement sendButton() {
		return driver.findElement(By.id("btn"));
	}

	WebElement operator() {
		return driver.findElement(By.cssSelector("#region"));
	}
	
	WebElement errDiv() {
		return driver.findElement(By.id("errorDV"));
	}
	
	WebElement warningDiv() {
		return driver.findElement(By.id("warning"));
	}
	
	WebElement successDiv() {
		return driver.findElement(By.id("success"));
	}
	
	
	WebElement checkBox() {
		return driver.findElement(By.xpath("//input[@id='flexCheckDefault']"));
	}
	
	
	WebElement contactPage() {
		return driver.findElement(By.xpath("//a[@href='contact.html']"));
	}
	
	WebElement aboutUsPage() {
		return driver.findElement(By.xpath("//a[@href='about.html']"));
	}
	
	WebElement aboutUsTitle() {
		return driver.findElement(By.linkText("About Us"));
	}
	
	String userNameValue() {
		return userName().getAttribute("value");
	}
	
	String userLastNameValue() {
		return userLastName().getAttribute("value");
	}
	
	String userEmailNameValue() {
		return userEmail().getAttribute("value");
	}
	
	String userPhoneValue() {
		return userPhone().getAttribute("value");
	}
	
	String operatorValue() {
		return operator().getAttribute("value");
	}
	
	String errDivValue() {
		return errDiv().getText();
	}
	
	String aboutUsTitleValue() {
		return aboutUsTitle().getText();
	}
	
	String warningDivValue() {
		return warningDiv().getText();
	}
	
	String successDivValue() {
		return successDiv().getText();
	}
	
	void typeName(String name) {
		userName().sendKeys(name);
	}
	
	void typeLastName(String lname) {
		userLastName().sendKeys(lname);
	}
	
	void typeEmail(String mail) {
		userEmail().sendKeys(mail);
	}
	
	void typePhone(String num) {
		userPhone().sendKeys(num);
	}
	
	void chooseOperator(String op) {
		Select sel = new Select(operator());
		sel.selectByVisibleText(op);
	}
	
	List<WebElement> checkBoxList() {
		return driver.findElements(By.className("form-check-input"));
	}
	
	int checkBoxSize() {
		return checkBoxList().size();
	}
	
	List<WebElement> radioButtonList() {
		return driver.findElements(By.cssSelector("[type='radio']"));
	}
	
	int radioButtonSize() {
		return radioButtonList().size();
	}
	
}
