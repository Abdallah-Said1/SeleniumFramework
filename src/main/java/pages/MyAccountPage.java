package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyAccountPage extends PageBase
{
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[7]/a")
	WebElement changePasswordLink ; 
	
	@FindBy(id = "OldPassword")
    WebElement oldPasswordTxt;
	
    @FindBy(id = "NewPassword")
    WebElement newPasswordTxt;
    
    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmPasswordTxt;
    
    @FindBy(css = "button.button-1.change-password-button")
    WebElement ChangePasswordBtn;
    
    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p")
    public WebElement resultLbl;
	
	public void openChangePasswordPage() 
	{
		clickButton(changePasswordLink);
	}

	public void ChangePassword(String oldpassword, String newpassword) {
        setTextElementText(oldPasswordTxt, oldpassword);
        setTextElementText(newPasswordTxt, newpassword);
        setTextElementText(confirmPasswordTxt, newpassword);
        clickButton(ChangePasswordBtn);
    }

}
