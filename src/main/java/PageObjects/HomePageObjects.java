package PageObjects;

public class HomePageObjects {
	public String SearchBox= "//input[@placeholder='Search for anything']";
	public String AddtoCartBtn = "//span[text()='Add to cart']";
	public String SearchButton = "//button[@value='Search']";
	public String CartIcon = "//a[@href='https://cart.ebay.com/']";
	public String SeeinCart = "(//span[text()='See in cart'])[2]";
	public String CartItemName = "//a[@data-test-id='cart-item-link']";
	public String CartIconCount="//a//span[@role='img']";

}
