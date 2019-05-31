package academy.mate.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

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

	public void sendRequest(String url, String method, String data) {
		URL obj;
		BufferedReader in = null;
		try {
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod(method);
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoOutput(true);
			con.setDoInput(true);

			if (data != null) {

				try (OutputStream os = con.getOutputStream()) {
					byte[] input = data.getBytes("utf-8");
					os.write(input, 0, input.length);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			System.out.println("Response = " + response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public Flea getFlea(int id) {

		Flea flea = null;
		String url = HOST + GET_FLEA_BY_ID + "?id=" + id;

		URL obj;
		BufferedReader in = null;
		try {
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			Gson gSon = new Gson();
			SinglData data = gSon.fromJson(response.toString(), SinglData.class);
			if (data != null && data.getService_message() != null && data.getService_message().contains(STATUS)) {
				flea = data.getUglycat_flea();
			} else {
				throw new FleaErrorException(data.getService_message());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flea;
	}

	public void addFlea(Flea flea) {
		String json = null;
		try {
			json = objectMapper.writeValueAsString(flea);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(json);
		String url = HOST + ADD_FLEA;
		sendRequest(url, "POST", json);

	}

}
