package Interview;

import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

public class FetchColorValues {
	@Test
	public void fetchColorValues() throws Throwable {
		JSONParser jp = new JSONParser();
		FileReader reader = new FileReader("data.json");
		Response resp = when()
				.get("file:///G:/Selenium%20Practice/MyJavaSeleniumApiPractices/src/main/resources/Input.json");
		List<String> key = resp.jsonPath().get(".color");
		List<String> value = resp.jsonPath().get(".value");
		HashMap<String, String> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < key.size(); i++) {
			map.put(key.get(i), value.get(i));
		}
		System.out.println("Enter the Key:");
		String inputKey = sc.next();
		sc.close();
		for(Entry<String, String> s : map.entrySet()) {
			if(s.getKey().equalsIgnoreCase(inputKey)) {
				System.out.println(s.getValue());
			}
		}
	}
}
