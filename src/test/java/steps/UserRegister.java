package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.UserRegistrationPage;
import testes.TestBase;

public class UserRegister extends TestBase{
	HomePage homeObject ;
	UserRegistrationPage registerObject ;

	@Given("The user in home page")
	public void the_user_in_home_page() {
		homeObject=new HomePage(driver);
		homeObject.openRegistrationPage();
	}
	@When("i click on register link")
	public void i_click_on_register_link() {

	}
	@When("i entered data user {string} ,{string} ,{string} ,{string}")
	public void i_entered_data_user(String firstname, String lastname, String email, String password) {
	registerObject=new UserRegistrationPage(driver);
	registerObject.userRegistration(firstname,lastname,email,password);
	}
	@Then("the page of registration displayed successfully")
	public void the_page_of_registration_displayed_successfully() {

	}

}