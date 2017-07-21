package Hello;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import SeleniumUtils.UtillClass;

public class Hello {

	public static void main(String[] args) throws InterruptedException,
			FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(
				"D:/screenshots/via-workspace/Newpro/src/xpath.json"));
		JSONObject jsonObject = (JSONObject) obj;

		System.setProperty("webdriver.firefox.marionette",
				"D:/screenshots/via-workspace/Practise/Driver/geckodriver.exe");

		WebDriver web = new FirefoxDriver();
		web.manage().window().maximize();
		web.get("https://in.via.com/bdo");
		web.findElement(By.xpath(UtillClass.parsertest("xpath"))).click();
		Thread.sleep(5000);
		web.findElement(By.name((String) jsonObject.get("name"))).sendKeys(
				(String) jsonObject.get("sendkeys"));

		web.findElement(By.name((String) jsonObject.get("passwd"))).sendKeys(
				(String) jsonObject.get("data"));
		web.findElement(By.name("signin")).click();
		web.findElement(By.xpath((String) jsonObject.get("topuphead"))).click();
		Thread.sleep(5000);

		Select dropdwn = new Select(web.findElement(By.id((String) jsonObject
				.get("areadropdown"))));

		dropdwn.selectByValue((String) jsonObject.get("area"));
		Thread.sleep(2000);

		Select oprtr = new Select(web.findElement(By.id((String) jsonObject
				.get("operator"))));
		oprtr.selectByValue("6");

		web.findElement(By.className((String) jsonObject.get("proceed")))
				.click();
		Thread.sleep(2000);
		web.findElement(By.id((String) jsonObject.get("amount"))).sendKeys(
				(String) jsonObject.get("money"));
		web.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		web.findElement(By.xpath((String) jsonObject.get("procedd"))).click();
		Thread.sleep(10000);

		web.findElement(By.id((String) jsonObject.get("Mobileno"))).sendKeys(
				(String) jsonObject.get("number"));
		web.findElement(By.xpath((String) jsonObject.get("button"))).click();
		Thread.sleep(10000);

		web.findElement(By.name("read_terms")).click();
		web.findElement(By.xpath((String) jsonObject.get("topupbooking")))
				.click();
		Thread.sleep(5000);
		web.findElement(By.xpath((String) jsonObject.get("confirm"))).click();

	}
}
