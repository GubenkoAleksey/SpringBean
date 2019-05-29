package academy.mate.json;

import java.util.List;

import org.json.JSONPropertyName;

public class Data {
	
	private List<Flea> uglycat_flea;
	private String service_message;
	
	

	public List<Flea> getUglycat_flea() {
		return uglycat_flea;
	}
	public void setUglycat_flea(List<Flea> uglycat_fleas) {
		this.uglycat_flea = uglycat_fleas;
	}
	public String getServiceMessage() {
		return service_message;
	}
	public void setServiceMessage(String serviceMessage) {
		this.service_message = serviceMessage;
	}
	@Override
	public String toString() {
		return "Data [uglycat_flea=" + uglycat_flea + ", service_message=" + service_message + "]";
	}
	
	
	
	
	

}
