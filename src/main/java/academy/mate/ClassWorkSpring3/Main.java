package academy.mate.ClassWorkSpring3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

		Hero hero = (Hero) context.getBean("hero");

		System.out.println(hero);

	}

}
