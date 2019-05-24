package academy.mate.ClassWorkSpring3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	
		context.register(Dota2Config.class);
		context.refresh();
		
		Hero hero = context.getBean(Hero.class);
		
		System.out.println(hero);

	}
}
