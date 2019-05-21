package academy.mate.ClassWorkSpring;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingRender extends JFrame implements MessageRenderer {
	
	MessageProvider messageProvider;

	public void setMessage(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
		
	}

	public void render() {
		JLabel label = new JLabel(messageProvider.getMessage());
		add(label);
		setVisible(true);
		
	}

}
