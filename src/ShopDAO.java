import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class ShopDAO implements ShopInterface{
	Scanner in = new Scanner(System.in);

	public ShopDAO() {
		
	}
	
	
	@Override
	public Shop addShop(ArrayList<Shop> shops) throws InputMismatchException, IndexOutOfBoundsException{
		
		Shop shop = new Shop();
		
		System.out.println("Put an id for the shop: ");
		int idShop = in.nextInt();
		addIdUnique(shops, idShop, shop);
		
		System.out.println("Put a state for the shop: ");
		String state = in.next();
		System.out.println("Put a currency for the shop: ");
		String currency = in.next();
		System.out.println("Put a quantity for the shop: ");
		int quantity = in.nextInt();
		System.out.println("Put a price for the shop: ");
		double price = in.nextDouble();
		System.out.println("Put a description for the shop: ");
		String descriptionShop = in.next();
		
		shop.setState(state);
		shop.setCurrency(currency);
		shop.setQuantity(quantity);
		shop.setPrice(price);
		shop.setDescriptionShop(descriptionShop);
		
		continueWithBrand(shop);
		
		return shop;
	}
	
	
	
	@Override
	public void continueWithBrand(Shop shop) {
		
		System.out.println("\nDo you want to add brands? Type 'y/Y' for Yes or 'n/N' for No: ");
		String choose = in.next();
		
		if(choose.equals("y") || choose.equals("Y")) {
			BrandDAO brandDAO = new BrandDAO();
			ArrayList<Brand> brandList = new ArrayList<Brand>();
			System.out.println("\nHow much brands do you want to add? Put a number bigger than 3: ");
			int nr = in.nextInt();
			int i;
			if(nr < 3) {
				nr = 3;
			}
			
			for(i = 0; i<nr; i++) {
				brandList.add(brandDAO.addBrand(brandList));
			}
			
			shop.setBrandList(brandList);
		}
		else if(choose.equals("n") || choose.equals("N")) {
			System.out.println("\nYou have not add brands!");
		}
		else {
			System.out.println("\nYou have not choosed correctly! Please press the right button:");
			continueWithBrand(shop);
		}
	}
	
	
	
	@Override
	public Shop editShop(ArrayList<Shop> shopList, int idShop) throws InputMismatchException, IndexOutOfBoundsException{
		
		Shop shop = new Shop();
		if(shopList == null || shopList.isEmpty()) {
			System.out.println("\nThere are no shops to edit!");
		}
		else {
			for(int i = 0; i < shopList.size(); i++) {
				if(shopList.get(i).getIdShop() == idShop) {
					
					System.out.println("Change state of the shop: ");
					String state = in.next();
					System.out.println("Change currency of the state: ");
					String currency = in.next();
					System.out.println("Change quantity of the shop: ");
					int quantity = in.nextInt();
					System.out.println("Change price of the shop: ");
					double price = in.nextDouble();
					System.out.println("Change description of the shop: ");
					String descriptionShop = in.next();
					
					shopList.get(i).setState(state);
					shopList.get(i).setCurrency(currency);
					shopList.get(i).setQuantity(quantity);
					shopList.get(i).setPrice(price);
					shopList.get(i).setDescriptionShop(descriptionShop);
					
					shop = shopList.get(i);
				}
			}
		}		
		return shop;
	}
	
	
	
	@Override
	public void deleteShop(ArrayList<Shop> shopList, int index) throws IndexOutOfBoundsException{
		
		if(shopList == null || shopList.isEmpty()) {
			System.out.println("\nThere are no shops to delete!");
		}
		else {
			BrandDAO brandDao = new BrandDAO();
			for(int i = 0; i < shopList.size(); i++) {
				if(shopList.get(i).getIdShop() == index) {
					index = i;
				}
				break;
			}
			ArrayList<Brand> brandList = shopList.get(index).getBrandList();
			brandDao.deleteAllBrand(brandList);
			shopList.remove(index);
			System.out.println("\nShop has been deletet from the list!");
		}
	}
	
	
	@Override
	public void deleteAllShop(ArrayList<Shop> shopList) throws IndexOutOfBoundsException{
		
		if(shopList == null || shopList.isEmpty()) {
			System.out.println("\nThere are no shops in this list!");
		}
		else {
			BrandDAO brandDao = new BrandDAO();
			ArrayList<Brand> brandList;
			
			for(int i = 0; i < shopList.size(); i++) {
				brandList = shopList.get(i).getBrandList();
				brandDao.deleteAllBrand(brandList);
				shopList.remove(i);
			}
			System.out.println("\nAll shops are deleted!");
		}
	}
	
	
	
	@Override
	public String listShops(ArrayList<Shop> shopList) {

		String s="";
		if(shopList == null || shopList.isEmpty()) {
			s += "\nThe list has not any shop and data to show!";
		}
		else {
			for(int i = 0; i<shopList.size(); i++) {
				int id = shopList.get(i).getIdShop();
				s = toString(shopList, id) + "\n\n";
			}
		}
		return s;
	}
	
	
	
	@Override
	public String toString(ArrayList<Shop> shopList, int id) {
		
		String info = "";
		if(shopList == null || shopList.isEmpty()) {
			info += "\nThere is no data to show!";
		}
		else {
			int index = 0;
		
			for(int i = 0; i<shopList.size(); i++) {
				if(shopList.get(i).getIdShop() == id) {
					index = i;
				}
			}
			info +=  "ID Shop: " + shopList.get(index).getIdShop()  + "\n";
			info +=  "State of Shop: " + shopList.get(index).getState()  + "\n";
			info +=  "Currency of State: " + shopList.get(index).getCurrency()  + "\n";
			info +=  "Quantity of Shop: " + shopList.get(index).getQuantity()  + "\n";
			info +=  "Price of Shop: " + shopList.get(index).getPrice() + "\n";
			info +=  "Description of Shop: " + shopList.get(index).getDescriptionShop() + "\n";
			
			BrandDAO dao = new BrandDAO();
			ArrayList<Brand> brandList = shopList.get(index).getBrandList();
			info +=  "\nBrand List: \n" + dao.listBrands(brandList);
		}
		return info;
	}
	
	
	
	@Override
	public boolean isIdUnique(ArrayList<Shop> shopList, int id) {
		for(int i = 0; i<shopList.size(); i++) {
			if(shopList.get(i).getIdShop() == id) {
				return false;
			}
		}
		return true;
	}
	
	
	
	@Override
	public void addIdUnique(ArrayList<Shop> shopList, int id, Shop shop) {
		if(isIdUnique(shopList, id)) {
			shop.setIdShop(id);
		}
		else {
			System.out.println("\nYour id is used by another shop! Please put a unique, a different id that is not used before: ");
			id = in.nextInt();
			addIdUnique(shopList, id, shop);
		}
	}



}
