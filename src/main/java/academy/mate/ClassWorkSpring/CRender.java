package academy.mate.ClassWorkSpring;

public class CRender implements MessageRenderer {
	
	private MessageProvider message;

	public void setMessage(MessageProvider messageProvider) {
		this.message = messageProvider;
		
	}

	public void render() {
		System.out.println(message.getMessage());
	}

}
