package academy.mate.ClassWorkSpring3;

import org.springframework.stereotype.Service;

//@Service // по умолчанию item
public class Item {
	
	


	private String name;

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
	@Override
	public String toString() {
		return "Item [name=" + name + "]";
	}
	
	
	

}
