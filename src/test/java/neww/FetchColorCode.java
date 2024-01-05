package neww;

import java.io.FileReader;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class FetchColorCode {	
	@Test
	public void fetchColorCode() throws Throwable {
		JSONParser p = new JSONParser();
		Object obj = p.parse(new FileReader(".\\src\\main\\resources\\Input.json"));
		try {
			JSONObject map=(JSONObject)obj;
			System.out.println(map.get(".color"));
		} catch (Exception e) {
		    
		}
	//	System.out.println(map.get(col.toString()));
	}
	

}
