package filehandling;

public class Drinks {

	private String category;
	private String brand;
	private int price;
	public Drinks(String category, String brand, int price) {
		super();
		this.category = category;
		this.brand = brand;
		this.price = price;
	}
	public Drinks() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getcategory() {
		return category;
	}
	public void setcategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return category +"," + brand + "," + price;
	}
	
}
