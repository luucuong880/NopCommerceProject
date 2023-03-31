package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import nopcommerce.user.GlobalConstants;

public class FirefoxDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		WebDriverManager.firefoxdriver().setup();
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.getGlobalConstants().getBrowserLogPath() + "Firefox.log");

		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("browser.download.folderList", 2);
		options.addPreference("browser.download.dir", GlobalConstants.getGlobalConstants().getDownloadFolderPath());
		options.addPreference("browser.download.useDownloadDir", true);
		options.addPreference("browser.helperApps.neverAsk.saveToDisk",
				"multipart/x-zip, application/zip,application/x-zip-compressed,application/msword,application/csv,text/csv, image/png, image/jpeg, application/pdf, text/html, text/plain, application/excel, application/vnd.ms-excel, application/x-excel, application/msexcel, application/octet-stream");
		options.addPreference("pdfjs.disabled", true);

		// Private
		// options.addArguments("-private");

		return null;
	}

}
