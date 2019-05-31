package academy.mate.json;

import java.io.FileOutputStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestClientTest {

	public static void main(String[] args) {

		Flea flea = UglyCatRestClient.newInstance().getFlea(30);
		System.out.println(flea);
		
		Flea uglyFlea = new Flea();
		
		uglyFlea.setColor("Bleck");
		uglyFlea.setId(2);
		uglyFlea.setName("Ugly");
		
		ObjectMapper objectMapper = new ObjectMapper();



		String json = null;
		try {
			json = objectMapper.writeValueAsString(flea);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(json);
		
		UglyCatRestClient.newInstance().addFlea(uglyFlea);

	}

}
