package goods;

public class Item {
	String catagory;
	String name;
	double price;
	public Item(String catagory, String name, double price) {
	this.catagory = catagory;
	this.name = name;
	this.price = price;
	}
	public String getCatagory() {
	return catagory;
	}
	public String getName() {
	return name;
	}
	public double getPrice() {
	return price;
	}
	public void setPrice(double price, String personal) {
	this.price = price;
	}
	public void displayInfo(){
	}

}
