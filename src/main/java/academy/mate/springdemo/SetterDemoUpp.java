package academy.mate.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoUpp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
		CricketCoach cricketCoach = context.getBean("myCricketCoach", CricketCoach.class);
		//cricketCoach = null;
		System.out.println(cricketCoach instanceof CricketCoach);
		System.out.println(cricketCoach.getClass().getName());

		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());
		System.out.println(cricketCoach.getEmailAddress());
		System.out.println(cricketCoach.getTeam());
		
		context.close();
	}

}
