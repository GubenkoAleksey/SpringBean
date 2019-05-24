package academy.mate.ClassWorkSpring3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("hero")
public class Hero {

	private String name = "Puge";
	@Autowired
	@Qualifier("bootsOfTrevel")
	private Item item;

	public Hero() {
	}

	public Hero(Item item, String name) {
		this.item = item;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Hero [name=" + name + ", item=" + item + "]";
	}

}
