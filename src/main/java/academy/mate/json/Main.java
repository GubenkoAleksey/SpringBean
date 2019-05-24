package academy.mate.json;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.json.JSONObject;

import com.google.gson.stream.JsonWriter;

public class Main {

	public static void main(String[] args) {
		
		
		String heroForJSon = "{\"name\":\"Puge\",\"level\":12}";
		
		JSONObject jsonObject = new JSONObject(heroForJSon);
		
		System.out.println(jsonObject.getString("name"));
		System.out.println(jsonObject.getInt("level"));
		
		
		String heroForGSon;
		
		OutputStream outputStream = new ByteArrayOutputStream();
		JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(outputStream));
		try {
			
			
			jsonWriter.beginObject();
			jsonWriter.name("name");
			jsonWriter.value("Puge");
			jsonWriter.name("level");
			jsonWriter.value(12);
			jsonWriter.endObject();
			jsonWriter.close();
			System.out.println("!!!" + outputStream.toString());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
