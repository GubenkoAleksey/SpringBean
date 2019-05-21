package academy.mate.ClassWorkSpring;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SupportFactory {

	private static SupportFactory factory;

	private MessageProvider messageProvider;
	private MessageRenderer messageRenderer;
	private Properties properties;

	static {
		try {
			factory = new SupportFactory();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static SupportFactory getFactory() {
		return factory;
	}

	private SupportFactory() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		properties = new Properties();
		try {
			properties.load(new FileInputStream("C:/cf.properties"));
			String rendererClass = properties.getProperty("Renderer.class");
			String providerClass = properties.getProperty("Provider.class");
			messageProvider = (MessageProvider) Class.forName(providerClass).newInstance();
			messageRenderer = (MessageRenderer) Class.forName(rendererClass).newInstance();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public MessageProvider getMessageProvider() {
		return messageProvider;
	}

	public MessageRenderer getMessageRenderer() {
		return messageRenderer;
	}
}
