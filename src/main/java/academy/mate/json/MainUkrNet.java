package academy.mate.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;

public class MainUkrNet {

	public static void main(String[] args) {

		String url = "http://code-master.com.ua/uglycatapi/getflea";

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
			Data data = gSon.fromJson(response.toString().replace("}]}", "}]"), Data.class);
			if (data.getUglycat_flea() != null) {
				System.out.println(data.toString());
				List<Flea> fleas = new LinkedList<Flea>();
					fleas =	data.getUglycat_flea();
					for (Flea flea : fleas) {
						System.out.println(flea.toString());
					}

			} else {
				throw new FleaErrorException(data.getServiceMessage());
			}

		//} catch (FleaErrorException e) {
		//	System.out.println(e.getMessage());
		}
		catch (Exception e) {
			//e.getMessage();
			System.out.println(e.getMessage());
		}
		
		finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
