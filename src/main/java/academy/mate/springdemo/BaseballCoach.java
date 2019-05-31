package academy.mate.springdemo;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	

	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public String getDailyWorkout() {
		return "30 minutes";
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}
