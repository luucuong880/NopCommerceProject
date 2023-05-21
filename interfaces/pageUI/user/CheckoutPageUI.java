package pageUI.user;

public class CheckoutPageUI {
	public static final String PRODUCT_NAME = "xpath=//a[@class='product-name']";
	public static final String CONTINUE_BUTTON_BY_ID = "xpath=//div[@id='%s']//button[text()='Continue']";
	public static final String CONFIRM_BUTTON = "xpath=//div[@id='confirm-order-buttons-container']//button";
	public static final String INFO_BY_DYNAMICS_CLASS = "xpath=//div[@class='table-wrapper']//tr/td/span[@class='%s']";
	public static final String BILLING_SHIPPING_ADDRESS = "xpath=//div[@class='%s']//li[@class='%s']";
	public static final String TOTALS_INFO = "xpath=//tr[@class='%s']//span[@class='value-summary']";
	public static final String THANK_YOU_MESSAGE = "xpath=//div[@class='page-title']//h1";
	public static final String ORDER_NUMBER = "class=order-number";
	public static final String TITLE_SUCCESS_MESSAGE = "xpath=//div[@class='section order-completed']/div[@class='title']/strong";

}
