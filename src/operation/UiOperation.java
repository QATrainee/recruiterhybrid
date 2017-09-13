package operation;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UiOperation {
	static WebDriver driver;

	public UiOperation(WebDriver driver) {
		this.driver = driver;
	}

	public void perform(Properties p, String operation, String objectName,
			String objectType, String value) throws Exception {
		switch (operation.toUpperCase()) {
		case "CLICK":
			// Perform click
			Thread.sleep(5000);
			driver.findElement(this.getObject(p, objectName, objectType))
					.click();
			Thread.sleep(1000);
			break;
		case "CLICK1":
			// Perform click
			Thread.sleep(8000);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("Iframe4");
			Thread.sleep(8000);
			driver.findElement(this.getObject(p, objectName, objectType))
					.click();
			Thread.sleep(1000);
			break;

		case "CLICK2":
			// Perform click
			Thread.sleep(10000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("Iframe9");
			Thread.sleep(1000);
			driver.findElement(this.getObject(p, objectName, objectType))
					.click();

			Thread.sleep(1000);
			break;

		case "CLICK3":
			// Perform click
			Thread.sleep(10000);
			driver.switchTo().defaultContent();
			driver.findElement(this.getObject(p, objectName, objectType))
					.click();

			Thread.sleep(10000);
			break;

		case "CLICK4":
			// Perform click
			Thread.sleep(10000);
			driver.switchTo().defaultContent();
			driver.findElement(this.getObject(p, objectName, objectType))
					.click();

			Thread.sleep(10000);
			break;

		case "SETTEXT":
			// Set text on control
			Thread.sleep(10000);
			// driver.switchTo().defaultContent();
			// driver.switchTo().frame("empcontentframe");
			Thread.sleep(1000);
			driver.findElement(this.getObject(p, objectName, objectType))
					.sendKeys(p.getProperty(value));
			break;

		case "SETTEXT1":
			// Set text on control

			driver.switchTo().defaultContent();
			driver.switchTo().frame("Iframe2");
			Thread.sleep(1000);
			driver.findElement(this.getObject(p, objectName, objectType))
					.sendKeys(p.getProperty(value));
			break;

		case "SETTEXT2":
			// Set text on control

			driver.switchTo().defaultContent();
			driver.switchTo().frame("Iframe5");
			Thread.sleep(1000);
			driver.findElement(this.getObject(p, objectName, objectType))
					.clear();
			Thread.sleep(1000);
			driver.findElement(this.getObject(p, objectName, objectType))
					.sendKeys(p.getProperty(value));
			break;

		case "SETTEXT3":
			// Set text on control
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("Iframe1");

			driver.findElement(this.getObject(p, objectName, objectType))
					.sendKeys(p.getProperty(value));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.switchTo().defaultContent();
			break;
		case "SETTEXT4":
			// Set text on control
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("Iframe7");

			Thread.sleep(1000);
			driver.findElement(this.getObject(p, objectName, objectType))
					.clear();
			driver.findElement(this.getObject(p, objectName, objectType))
					.sendKeys(p.getProperty(value));
			break;
		case "SETTEXTE5":
			// Set text on control
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("Iframe8");
			Thread.sleep(1000);
			driver.findElement(this.getObject(p, objectName, objectType))
					.sendKeys(p.getProperty(value));
			break;

		case "SETTEXT6":
			// Set text on control
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("Iframe10");
			Thread.sleep(1000);
			driver.findElement(this.getObject(p, objectName, objectType))
					.sendKeys(p.getProperty(value));
			break;
		case "GOTOURL":
			// Get url of application
			driver.get(p.getProperty("url"));
			break;
		
		default:
			break;
		}
	}

	/**
	 * Find element BY using object type and value
	 * 
	 * @param p
	 * @param objectName
	 * @param objectType
	 * @return
	 * @throws Exception
	 */
	private By getObject(Properties p, String objectName, String objectType)
			throws Exception {
		// Find by xpath
		if (objectType.equalsIgnoreCase("XPATH")) {

			return By.xpath(p.getProperty(objectName));
		}
		// find by class
		else if (objectType.equalsIgnoreCase("CLASSNAME")) {

			return By.className(p.getProperty(objectName));

		}
		// find by name
		else if (objectType.equalsIgnoreCase("NAME")) {

			return By.name(p.getProperty(objectName));

		}
		// Find by css
		else if (objectType.equalsIgnoreCase("CSS")) {

			return By.cssSelector(p.getProperty(objectName));

		}
		// find by link
		else if (objectType.equalsIgnoreCase("LINK")) {

			return By.linkText(p.getProperty(objectName));

		}
		// find by partial link
		else if (objectType.equalsIgnoreCase("PARTIALLINK")) {

			return By.partialLinkText(p.getProperty(objectName));

		} else if (objectType.equalsIgnoreCase("ID")) {

			return By.id(p.getProperty(objectName));

		} else {
			throw new Exception("Wrong object type");
		}
	}
}