import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class SectorDAO implements SectorInterface {
	
	Scanner in = new Scanner(System.in);

	public SectorDAO() {
		
	}
	
	@Override
	public Sector addSector(ArrayList<Sector> sectors) throws InputMismatchException, IndexOutOfBoundsException{
		
		Sector sect = new Sector();
		
		System.out.println("Put an id for the sector: ");
		int idSector = in.nextInt();
		addIdUnique(sectors, idSector, sect);
		
		System.out.println("Put a name for the sector: ");
		String nameOfSector = in.next();
		System.out.println("Put a description for the sector: ");
		String descriptionSector = in.next();

		sect.setNameOfSector(nameOfSector);
		sect.setDescriptionSector(descriptionSector);
		
		continueWithShop(sect);
		
		return sect;
	}
	
	
	
	@Override
	public void continueWithShop(Sector sect) {
		
		System.out.println("\nDo you want to add shops? Type 'y/Y' for Yes or 'n/N' for No: ");
		String choose = in.next();
		
		if(choose.equals("y") || choose.equals("Y")) {
			ShopDAO shopDAO = new ShopDAO();
			ArrayList<Shop> shopList = new ArrayList<Shop>();
			System.out.println("\nHow much shops do you want to add? Put a number: ");
			int nr = in.nextInt();
			int i;
			for(i = 0; i<nr; i++) {
				shopList.add(shopDAO.addShop(shopList));
			}
			
			sect.setShopList(shopList);
		}
		else if(choose.equals("n") || choose.equals("N")) {
			System.out.println("\nYou have not add shops!");
		}
		else {
			System.out.println("\nYou have not choosed correctly! Please press the right button:");
			continueWithShop(sect);
		}
	}
	
	
	
	@Override
	public Sector editSector(ArrayList<Sector> sectors, int idSector) throws InputMismatchException, IndexOutOfBoundsException{
		
		Sector sect = new Sector();
		if(sectors == null || sectors.isEmpty()) {
			System.out.println("\nThere are no sectors to delete!");
		}
		else {
			for(int i = 0; i < sectors.size(); i++) {
				if(sectors.get(i).getIdSector() == idSector) {
					
					System.out.println("Change name of the sector: ");
					String nameOfSector = in.next();
					System.out.println("Change description of the sector: ");
					String descriptionSector = in.next();
					
					sectors.get(i).setNameOfSector(nameOfSector);
					sectors.get(i).setDescriptionSector(descriptionSector);
					
					sect = sectors.get(i);
				}	
			}
		}
		return sect;
	}
	
	
	
	@Override
	public void deleteSector(ArrayList<Sector> sectors, int index) throws IndexOutOfBoundsException{
		
		if(sectors == null || sectors.isEmpty()) {
			System.out.println("\nThere are no sectors to delete!");
		}
		else {
			ShopDAO shopDao = new ShopDAO();
			for(int i = 0; i < sectors.size(); i++) {
				if(sectors.get(i).getIdSector() == index) {
					index = i;
				}
				break;
			}
			ArrayList<Shop> shopList = sectors.get(index).getShopList();
			shopDao.deleteAllShop(shopList);
			sectors.remove(index);
			System.out.println("\nSector has been deletet from the list!");
		}
	}
	
	
	@Override
	public void deleteAllSector(ArrayList<Sector> sectors) throws IndexOutOfBoundsException{

		if(sectors == null || sectors.isEmpty()) {
			System.out.println("\nThere are no sectors to delete!");
		}
		else {
			ShopDAO shopDao = new ShopDAO();
			ArrayList<Shop> shopList;
			
			for(int i = 0; i < sectors.size(); i++) {
				shopList = sectors.get(i).getShopList();
				shopDao.deleteAllShop(shopList);
				sectors.remove(i);
			}
			System.out.println("\nAll sectors are deleted!");
		}
	}
	
	
	
	@Override
	public String listSectors(ArrayList<Sector> sectors) {
		
		String s="";
		if(sectors == null || sectors.isEmpty()) {
			s += "\nThere are no sectors and data to show!!";
		}
		else {
			for(int i = 0; i<sectors.size(); i++) {
				int id = sectors.get(i).getIdSector();
				s += toString(sectors, id) + "\n\n";
			}
		}
		return s;
	}
	
	
	
	@Override
	public String toString(ArrayList<Sector> sectors, int id) {
		
		String info = "";
		if(sectors == null || sectors.isEmpty()) {
			info += "\nThe list has not any sector and data to show!!";
		}
		else {
			int index = 0;
		
			for(int i = 0; i<sectors.size(); i++) {
				if(sectors.get(i).getIdSector() == id) {
					index = i;
				}
			}
			info +=  "ID of Sector: " + sectors.get(index).getIdSector()  + "\n";
			info +=  "Name of Sector: " + sectors.get(index).getNameOfSector()  + "\n";
			info +=  "Description of Sector: " + sectors.get(index).getDescriptionSector() + "\n";
			
			ShopDAO dao = new ShopDAO();
			ArrayList<Shop> shopList = sectors.get(index).getShopList();
			info +=  "\n Shop List: \n" + dao.listShops(shopList);
		}
		return info;
	}
	
	
	
	@Override
	public boolean isIdUnique(ArrayList<Sector> sectors, int id) {
		for(int i = 0; i<sectors.size(); i++) {
			if(sectors.get(i).getIdSector() == id) {
				return false;
			}
		}
		return true;
	}
	
	
	
	@Override
	public void addIdUnique(ArrayList<Sector> sectors, int id, Sector sect) {
		if(isIdUnique(sectors, id)) {
			sect.setIdSector(id);
		}
		else {
			System.out.println("\nYour id is used by another sector! Please put a unique, a different id that is not used before: ");
			id = in.nextInt();
			addIdUnique(sectors, id, sect);
		}
	}



}
