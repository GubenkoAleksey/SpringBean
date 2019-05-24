package academy.mate.ClassWorkSpring3;

import org.springframework.stereotype.Service;

@Service
public class BootsOfTrevel extends Item {

	private String name = "Boots of Trevel";


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + "]";
	}

}
