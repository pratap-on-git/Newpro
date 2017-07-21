package SeleniumUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import constants.Constants;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UtillClass extends Constants {

	public static WebElement webelement;
	static JSONObject jsonObject;

	public static WebElement webElement(WebDriver driver, String locatorType,
			String locatorValue) {
		if (locatorType.equals("id")) {
			webelement = driver.findElement(By.id(locatorValue));
		} else if (locatorType.equals("xpath")) {
			webelement = driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equals("className")) {
			webelement = driver.findElement(By.className(locatorValue));
		} else if (locatorType.equals("linkText")) {
			webelement = driver.findElement(By.linkText(locatorValue));
		} else if (locatorType.equals("name")) {
			webelement = driver.findElement(By.name(locatorValue));
		} else if (locatorType.equals("cssSelector")) {
			webelement = driver.findElement(By.cssSelector(locatorValue));
		} else if (locatorType.equals("partialLinkText")) {
			webelement = driver.findElement(By.partialLinkText(locatorValue));
		} else if (locatorType.equals("tagName")) {
			webelement = driver.findElement(By.tagName(locatorValue));
		}
		return webelement;
	}

	public static String parsertest(String path) throws FileNotFoundException,
			IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(constants.Constants.jsonPath));
		 jsonObject = (JSONObject) obj;

		
		return (String) jsonObject.get(path);
	}
}
