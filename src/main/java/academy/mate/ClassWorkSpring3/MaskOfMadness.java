package academy.mate.ClassWorkSpring3;

import org.springframework.stereotype.Service;

@Service
public class MaskOfMadness extends Item{

	private String name = "Mask of Madness";

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
