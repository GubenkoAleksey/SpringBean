package academy.mate.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public String getDailyWorkout() {
		return "1 hour";
	}

	public String getDailyFortune() {
		return "Just do it!!!" + fortuneService.getFortune();
	}
	
	// add a init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside method doMyStartupStuff");
	}
	
	// add a destroy method
	public void doMyCleanupStuffYoYo() {
		System.out.println("TrackCoach: inside method doMyCleanupStuffYoYo");
	}
	
	

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fortuneService == null) ? 0 : fortuneService.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrackCoach other = (TrackCoach) obj;
		if (fortuneService == null) {
			if (other.fortuneService != null)
				return false;
		} else if (!fortuneService.equals(other.fortuneService))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrackCoach [fortuneService=" + fortuneService + "]";
	}
	
	


	
	

}
