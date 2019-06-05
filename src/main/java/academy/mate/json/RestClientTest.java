package academy.mate.json;

import java.io.FileOutputStream;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestClientTest {

	public static void main(String[] args) {

		Flea flea = null;
		try {
			flea = UglyCatRestClient.newInstance().getFlea(30).getUglycat_flea();
			System.out.println(flea);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		Flea uglyFlea = new Flea();

		uglyFlea.setColor("Bleck");
		uglyFlea.setId(2);
		uglyFlea.setName("Ugly");

		ObjectMapper objectMapper = new ObjectMapper();

		String json = null;
		try {
			json = objectMapper.writeValueAsString(flea);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(json);

		try {
			System.out.println(UglyCatRestClient.newInstance().addFlea(uglyFlea).getUglycat_flea());
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
