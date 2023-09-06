package testes;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase
{
	String Fname="ali";
	String Lname="mahmoud";
	String email="abdallah400@gmail.com";
	String Password="123456";
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 
	String productName = "Apple MacBook Pro 13-inch"; 
	SearchPage searchObject ; 
	ProductDetailsPage detailsObject ;
	EmailPage emailObject ; 


	@Test(priority=1)
	public void UserCanRegisterSuccssfully() 
	{
		
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration(Fname,Lname,email,Password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}


	@Test(priority = 2)
	public void RegisteredUserCanLogin() 
	{
		homeObject=new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin(email,Password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
	@Test(priority=3)
	public void UserCanSearchWithAutoSuggest() 
	{
		try {
			searchObject = new SearchPage(driver); 
			searchObject.ProductSearchUsingAutoSuggest("MacB");
			detailsObject = new ProductDetailsPage(driver); 
			Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
		} catch (Exception e) {
			System.out.println("Error occurred  " + e.getMessage());
		}
	}

	@Test(priority=4)
	public void RegisteredUserCanSendProductToFriend() 
	{
		detailsObject=new ProductDetailsPage(driver);
		detailsObject.openSendEmail();
		emailObject = new EmailPage(driver); 
		emailObject.SendEmailToFriend("gg@gmail.com", "this is prouduct for you");
		Assert.assertTrue(emailObject.messageNotification.getText().contains("Your message has been sent."));
	}

}
