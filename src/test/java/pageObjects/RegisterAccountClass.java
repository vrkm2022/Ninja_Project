package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountClass {

	//constructor
	WebDriver driver;
	public RegisterAccountClass(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//locators
	
	@FindBy(xpath="//i[@class='fa fa-user']")
	WebElement BtnIcon;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement BtnRegistorIcon;
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement InputFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement InputLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement InputEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement InputPhone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement InputPwd;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement InputConfPwd;
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	WebElement CheckNewsletter;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement CheckAgree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement BtnContinue;
	
	@FindBy(xpath="//div[@id=\"content\"]/h1")
	WebElement actmsg;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement warPrivactPolicy;
	
	
	//action
	
	public void primaryBtn() {
		BtnIcon.click();
		BtnRegistorIcon.click();
	}
	
	public void mandFields(String fName, String lName,String mail,String phn,String pwd,String cnpwd) {
		
		InputFirstName.sendKeys(fName);
		InputLastName.sendKeys(lName);
		InputEmail.sendKeys(mail);
		InputPhone.sendKeys(phn);
		InputPwd.sendKeys(pwd);
		InputConfPwd.sendKeys(cnpwd);	
	}
	
	public void newsltr() {
		CheckNewsletter.click();
	
	}
	
	public void agree() {
		
		CheckAgree.click();
		
		
	}
	
public void Cont() {
		
		BtnContinue.click();
		
	}


public String acmessage() {
	
	String actualmessage=actmsg.getText();
	return actualmessage;
}

public String warPrivactPolicy() {
	
	String warPP=warPrivactPolicy.getText();
	return warPP;
}
}