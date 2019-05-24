package academy.mate.ClassWorkSpring3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Dota2Config {

	
	@Bean
	public Hero getHero() {
		return new Hero(getItem(), "Puge");
	}
	
	
	@Bean
	public Item getItem() {
		return new Item("Q");
	}

}
