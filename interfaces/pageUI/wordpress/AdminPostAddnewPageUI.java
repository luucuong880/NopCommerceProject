package pageUI.wordpress;

public class AdminPostAddnewPageUI {
	public static final String TITLE_TEXTBOX = "xpath=//h1[contains(@class,'wp-block-post-title')]";
	public static final String BODY_BUTTON = "xpath=//p[contains(@class,'block-editor-default')]";
	public static final String BODY_TEXTBOX = "xpath=//p[contains(@class,'block-editor-rich-text__editable')]";
	public static final String PUBLISH_OR_UPDATE_BUTTON = "xpath=//button[contains(@class,'editor-post-publish-button')]";
	public static final String PUBLISHED_OR_UPDATED_MESSAGE = "xpath=//div[@class='components-snackbar__content' and text()='%s']";
}
