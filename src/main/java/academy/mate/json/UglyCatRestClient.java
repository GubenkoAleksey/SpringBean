package academy.mate.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.google.gson.Gson;

import sun.net.www.content.text.plain;

public class UglyCatRestClient {

	private final static String GET_ALL_FLEAS = "/uglycatapi/getflea";
	private final static String GET_FLEA_BY_ID = "/uglycatapi/getflea";
	private final static String ADD_FLEA = "/uglycatapi/addflea/";
	private final static String DELETE_FLEA = "/uglycatapi/deleteflea/";
	private final static String UPDATE_FLEA = "/uglycatapi/updateflea";

	private final static String STATUS = "Status OK";

	private final static String HOST = "http://code-master.com.ua";

	private static UglyCatRestClient restClient = null;
	private static ObjectMapper objectMapper = null;

	public static UglyCatRestClient newInstance() {
		if (restClient == null) {
			restClient = new UglyCatRestClient();
			objectMapper = new ObjectMapper();
		}
		return restClient;
	}

	private UglyCatRestClient() {
	}

	public <T> T sendRequest(Class<?> clazz, String url, String method, String json, Map<String, String> params)
			throws IOException {
		URL obj;
		BufferedReader in = null;
		ObjectReader objectReader = null;
		StringBuffer response = new StringBuffer();
		StringBuffer request = new StringBuffer();
		if (params != null) {
			for (Map.Entry<String, String> entry : params.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				System.out.println(key + " = " + value);
				request.append(key +  "=" + value + "&");
			}
			url += "?" + request.toString();
		}
		try {
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod(method);

			con.setRequestProperty("Content-Type", "application/json");
			con.setDoOutput(true);
			con.setDoInput(true);
			if (json != null) {

				try (OutputStream os = con.getOutputStream()) {
					byte[] input = json.getBytes("utf-8");
					os.write(input, 0, input.length);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			System.out.println("Response = " + response);
			objectReader = objectMapper.readerFor(clazz);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return objectReader.readValue(response.toString());

	}

	public SinglData getFlea(int id) throws IOException {

		String url = HOST + GET_FLEA_BY_ID;
		Map<String, String> params = new HashMap<>();
		params.put("id", String.valueOf(id));

		return sendRequest(SinglData.class, url, "GET", null, params);

	}

	public SinglData addFlea(Flea flea) throws IOException {
		String json = null;
		try {
			json = objectMapper.writeValueAsString(flea);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(json);
		String url = HOST + ADD_FLEA;
		return sendRequest(SinglData.class, url, "POST", json, null);

	}

}
