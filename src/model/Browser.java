package model;

public class Browser {

	private String name;
 
	

	public Browser(String name) {
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
		return "Browser [name=" + name + "]";
	}
	
	

}
