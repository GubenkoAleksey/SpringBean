package academy.mate.ClassWorkSpring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    	//SupportFactory factory = SupportFactory.getFactory();
    	//MessageProvider mp = factory.getMessageProvider();
    	//MessageRenderer mr = factory.getMessageRenderer();
    	
    	MessageRenderer mr = (MessageRenderer) context.getBean("Renderer.class");
    	
    	//mr.setMessage(mp);
    	mr.render();
    }
}
