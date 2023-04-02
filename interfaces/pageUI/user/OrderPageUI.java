package pageUI.user;

public class OrderPageUI {

	public static final String DETAILS_BUTTON = "xpath=//button[contains(@class,'order-details-button')]";
	public static final String ORDER_OVERVIEW = "xpath=//div[@class='order-overview']";
	public static final String BILLING_INFO = "xpath=//div[@class='billing-info-wrap']";
	public static final String SHIPPING_INFO = "xpath=//div[@class='shipping-info-wrap']";
	public static final String PAYMENT_METHOD = "xpath=//div[@class='payment-method-info']";
	public static final String SHIPPING_METHOD = "xpath=//div[@class='shipping-method-info']";
	public static final String SKU_NUMBER = "xpath=//span[@class='sku-number']";
	public static final String PRODUCT_NAME = "xpath=//td[@class='product']//a";
	public static final String PRICE = "xpath=//span[@class='product-unit-price']";
	public static final String QUANTITY = "xpath=//span[@class='product-quantity']";
	public static final String PRODUCT_TOTAL = "xpath=//span[@class='product-subtotal']";
	public static final String GIFT_WRAPPING = "xpath=//div[@class='selected-checkout-attributes']";
	public static final String SUB_TOTAL = "xpath=//div[@class='total-info']//span[text()='$3,600.00']";
	public static final String SHIPPING_COST = "xpath=//label[text()='Shipping:']/parent::td[@class='cart-total-left']/following-sibling::td[@class='cart-total-right']//span[text()='$0.00']";
	public static final String TAX_VALUE = "xpath=//label[text()='Tax:']/parent::td[@class='cart-total-left']/following-sibling::td[@class='cart-total-right']//span[text()='$0.00']";
	public static final String ORDER_TOTAL = "xpath=//strong[text()='$3,600.00']/parent::span";
	public static final String RE_ORDER_BUTTON = "xpath=//div[@class='actions']//button";
	public static final String DETAILS_SECOND_BUTTON = "xpath=//span[text()='$3,600.00']/parent::li/parent::ul[@class='info']/following-sibling::div//button";

}
