package academy.mate.ClassWorkSpring3;

import org.springframework.stereotype.Service;

//@Service // по умолчанию item
public class Item {
	
	private String name;
	private int intelligence;
	private int agility;
	private int strength;
	

	public Item() {
	}
	
	

	public Item(String name) {
		super();
		this.name = name;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public int getIntelligence() {
		return intelligence;
	}



	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}



	public int getAgility() {
		return agility;
	}



	public void setAgility(int agility) {
		this.agility = agility;
	}



	public int getStrength() {
		return strength;
	}



	public void setStrength(int strength) {
		this.strength = strength;
	}



	@Override
	public String toString() {
		return "Item [name=" + name + ", intelligence=" + intelligence + ", agility=" + agility + ", strength="
				+ strength + "]";
	}

	
	
	
	

}
