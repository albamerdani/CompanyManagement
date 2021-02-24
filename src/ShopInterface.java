import java.util.ArrayList;

public interface ShopInterface {

	public Shop addShop(ArrayList<Shop> shops);
	
	public void continueWithBrand(Shop shop);
	
	public Shop editShop(ArrayList<Shop> shops, int idShop);
	
	public void deleteShop(ArrayList<Shop> shops, int index);
	
	public void deleteAllShop(ArrayList<Shop> shopList);
		
	public String listShops(ArrayList<Shop> shops);
	
	public String toString(ArrayList<Shop> shops, int id);
	
	public boolean isIdUnique(ArrayList<Shop> shops, int id);
	
	public void addIdUnique(ArrayList<Shop> shops, int id, Shop shop);

}
