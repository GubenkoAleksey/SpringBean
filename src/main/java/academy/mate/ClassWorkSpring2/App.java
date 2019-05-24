package academy.mate.ClassWorkSpring2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    	Hero hero =  (Hero)context.getBean("hero");
    	System.out.println("11");
    	System.out.println(hero);
    }
}
