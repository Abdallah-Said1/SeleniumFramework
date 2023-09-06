package testes;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase 
{
	SearchPage searchPage;
	ProductDetailsPage productDetails;
	ShoppingCartPage cartPage ; 
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority=1)
	public void UserCanSearchForProductsWithAutoSuggest() throws InterruptedException {
		searchPage = new SearchPage(driver);
		productDetails = new ProductDetailsPage(driver);
		searchPage.ProductSearchUsingAutoSuggest("MacB");
		Assert.assertTrue(productDetails.productNamebreadCrumb.getText().contains(productName));
	}

	@Test(priority=2)
	public void UserCanAddProductToShoppingCart() throws InterruptedException {
		productDetails = new ProductDetailsPage(driver);
		cartPage = new ShoppingCartPage(driver);
		productDetails.AddToCart();
		Thread.sleep(1000);
		driver.navigate().to("http://demo.nopcommerce.com" + "/cart");	
		Assert.assertTrue(cartPage.totalLbl.getText().contains("3,600"));
	}

	@Test(priority=3)
	public void UserCanRemoveProductFromCart() {
		cartPage = new ShoppingCartPage(driver); 
		cartPage.RemoveProductFromCart();
	}
}
