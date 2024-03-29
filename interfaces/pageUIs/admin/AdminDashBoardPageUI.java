package pageUIs.admin;

public class AdminDashBoardPageUI {

	public static final String DASHBOARD_HEADER = "xpath=//h1[contains(text(),'Dashboard')]";
	public static final String AJAX_BUSY_ICON = "xpath=//div[@id='ajaxBusy']";
	public static final String CATALOG_BUTTON = "xpath=//p[contains(text(),'Catalog')]//i";
	public static final String PRODUCTS_BUTTON = "xpath=//p[text()=' Products']";
	public static final String ITEM_IN_TREEVIEW_MENU = "xpath=//i[@class='%s']";
	public static final String ITEM_IN_TREEVIEW = "xpath=//i[@class='%s']/parent::a/following-sibling::ul//p[contains(text(),'%s')]";
}
