package neww;

import java.io.FileReader;

import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FetchColorFromJson {
	@Test
	public void fetchColorFromJson() throws Throwable {
		JSONParser jp = new JSONParser();
		FileReader fr = new FileReader(".\\src\\test\\resources\\Input.json");
		Object obj = jp.parse(fr);
		JSONObject jobj=(JSONObject)obj;
		
	}

}
