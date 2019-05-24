package academy.mate.ClassWorkSpring2;

public class Hero {

	private String name;
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
