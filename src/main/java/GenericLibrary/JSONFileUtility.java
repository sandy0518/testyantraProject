package GenericLibrary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

public class JSONFileUtility {

	public String jSONUtil(String key) throws Throwable {
		FileReader fr=new FileReader(IPathConstant.JSONFILEPATH);
		
		JSONParser jp=new JSONParser();
		Object jObj = jp.parse(fr);
		
		HashMap hp=(HashMap)jObj;
		String value=(String) hp.get(key);
		
		return value;
	}
}
