package testes;



import data.JsonDataReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.IOException;

public class UserRegistrationTest extends TestBase
{
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 

	@Test(priority = 1)
	public void UserCanRegisterSuccssfully() throws IOException, ParseException {
		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.JsonReader();

		homeObject = new HomePage(driver); 
		registerObject = new UserRegistrationPage(driver); 
		homeObject.openRegistrationPage();
		registerObject.userRegistration(jsonReader.firstname,jsonReader.lastname,jsonReader.email,jsonReader.password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	@Test(priority = 2)
	public void RegisteredUserCanLogin() throws IOException, ParseException {
		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.JsonReader();
		homeObject=new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin(jsonReader.email, jsonReader.password);
		
	}
}
