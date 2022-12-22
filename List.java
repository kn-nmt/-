package swingapp;

public class List {

	private int number;
	private String name;
	private String age;
	private String address;

	public List (int number, String name, String age, String address) {
		this.number = number;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public int getNumber() {
		return this.number;
	}
	public String getName() {
		return this.name;
	}
	public String getAge() {
		return this.age;
	}
	public String getAddress() {
		return this.address;
	}
}
