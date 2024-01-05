package Interview;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class FetchValuesFromKey {
	@Test
	public void fetchValuesFromKey() {
		Response resp = when().get("https://reqres.in/api/users?page=2");
		List<String> key = resp.jsonPath().get("data.first_name");
		List<String> value = resp.jsonPath().get("data.email");
		HashMap<String, String> map = new HashMap<>();

		for (int i = 0; i < key.size(); i++) {
			map.put(key.get(i), value.get(i));
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Key: ");
		String inputKey = sc.next();
		sc.close();
		for (Entry<String, String> s : map.entrySet()) {
			if (s.getKey().equalsIgnoreCase(inputKey)) {
				System.out.println(s.getValue());
			}
		}
	}
}