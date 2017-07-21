package Hello;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Foo {
	public static void main(String[] args) throws Exception {

		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader(
					"D:/screenshots/via-workspace/Newpro/src/xpath.json"));

			JSONObject jsonObject = (JSONObject) obj;

			String name = (String) jsonObject.get("xpath");
			String author = (String) jsonObject.get("name");

			JSONArray companyList = (JSONArray) jsonObject.get("something");

			System.out.println("Name: " + name);
			System.out.println("Author: " + author);
			System.out.println("\nCompany List:");
			Iterator<String> iterator = companyList.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
