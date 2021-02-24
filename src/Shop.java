import java.util.ArrayList;

public class Shop {

	private int idShop;
	private String state;
	private String currency;
	private int quantity;
	private double price;
	private String descriptionShop;
	private boolean validityShop;
	private ArrayList<Brand> brandList;
	
	
	public Shop() {
	
		this.idShop = getIdShop();
		this.state = getState();
		this.currency = getCurrency();
		this.quantity = getQuantity();
		this.price = getPrice();
		this.descriptionShop = getDescriptionShop();
		this.validityShop = true;
		this.brandList = getBrandList();
	}

	public Shop(int idShop, String state, String currency, int quantity, double price, String descriptionShop, ArrayList<Brand> brandList) {
		this.idShop = idShop;
		this.state = state;
		this.currency = currency;
		this.quantity = quantity;
		this.price = price;
		this.descriptionShop = descriptionShop;
		this.validityShop = true;
		this.brandList = brandList;
	}
	
	
	public int getIdShop() {
		return idShop;
	}
	public void setIdShop(int idShop) {
		this.idShop = idShop;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDescriptionShop() {
		return descriptionShop;
	}

	public void setDescriptionShop(String descriptionShop) {
		this.descriptionShop = descriptionShop;
	}

	public boolean getValidityShop() {
		return validityShop;
	}

	public void setValidityShop(boolean validityShop) {
		this.validityShop = validityShop;
	}

	public ArrayList<Brand> getBrandList() {
		return brandList;
	}

	public void setBrandList(ArrayList<Brand> brandList) {
		this.brandList = brandList;
	}
	
	
	

}
