import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.lang.IndexOutOfBoundsException;

public class Main {
	Scanner input = new Scanner(System.in);
	
	ArrayList<Company> kompaniList = new ArrayList<Company>();	
	ArrayList<Department> depList = new ArrayList<Department>();
	ArrayList<Sector> sectorList = new ArrayList<Sector>();
	ArrayList<Shop> shopList = new ArrayList<Shop>();
	ArrayList<Brand> brandList = new ArrayList<Brand>();
	ArrayList<User> usersList = new ArrayList<User>();
	Role r = new Role();
	User admin = new User(1, "Alba", "Merdani", "femer", "alba@example.com", "069 xxxx xxx", "Elbasan", r, "albamerdani", "admin");
	
	CompanyDAO compDAO = new CompanyDAO();
	DepartmentDAO depDAO = new DepartmentDAO();
	SectorDAO sectDAO = new SectorDAO();
	ShopDAO shopDAO = new ShopDAO();
	BrandDAO brandDAO = new BrandDAO();
	UserDAO userDAO = new UserDAO();
	
	
	
	public void menu(String choose) {

		switch(choose) {
		case "1":													//funksionon
			compDAO.listCompany(kompaniList);			
			break;
			
		case "2":													//funksionon
			Company c1 = compDAO.addCompany(kompaniList);
			kompaniList.add(c1);
			break;
			
		case "3":													//funksionon
			System.out.println("Put a number for the id of the company that you want to show data: ");
			int idComp = input.nextInt();
			System.out.println(compDAO.toString(kompaniList, idComp));
			break;
			
		case "4":													//funksionon
			System.out.println("Put a number for the id of the company that you want to edit and update changes");
			int id = input.nextInt();
			compDAO.editCompany(kompaniList, id);
			break;
			
		case "5":													//funksionon
			System.out.println("Put a number for the id of the company that you want to delete");
			int index = input.nextInt();
			compDAO.deleteCompany(kompaniList, index);
			break;
			
		case "6":													//  ??
			int comp=0;
			System.out.println("Put a number for the id of the company where you want to edit departments:");
			int indexComp = input.nextInt();
			System.out.println("Put a number for the id of the department that you want to edit");
			int idDep = input.nextInt();
			for(int i = 0; i<kompaniList.size(); i++) {
				if(kompaniList.get(i).getIdCompany() == indexComp) {
					comp = i;
				}
			}
			depDAO.editDep(kompaniList.get(comp).getDepartmentsList(), idDep);
			break;
			
		case "7":													//funksionon
			int compId=0;
			System.out.println("Put a number for the id of the company where you want to delete departments:");
			int indexList = input.nextInt();
			System.out.println("Put a number for the id of the department that you want to delete:");
			int depId = input.nextInt();
			for(int i = 0; i<kompaniList.size(); i++) {
				if(kompaniList.get(i).getIdCompany() == indexList) {
					compId = i;
				}
			}
			depList = kompaniList.get(compId).getDepartmentsList();
			depDAO.deleteDep(depList, depId);
			break;		
			
		case "8":													// ??
			comp=-1;
			int dep=0;
			System.out.println("Put a number for the id of the company where you want to edit sectors:");
			indexComp = input.nextInt();
			System.out.println("Put a number for the id of the department where you want to edit sectors:");
			idDep = input.nextInt();
			System.out.println("Put a number for the id of the sector that you want to edit:");
			int idSector = input.nextInt();
			for(int i = 0; i<kompaniList.size(); i++) {
				if(kompaniList.get(i).getIdCompany() == indexComp) {
					comp = i;
				}
			}
			depList = kompaniList.get(comp).getDepartmentsList();
			for(int i = 0; i<depList.size(); i++) {
				if(depList.get(i).getIdDep() == idDep) {
					dep = i;
				}
			}
			sectorList = depList.get(dep).getSectorsList();
			sectDAO.editSector(sectorList, idSector);
			break;
			
		case "9":
			comp=-1;
			dep=0;
			System.out.println("Put a number for the id of the company where you want to delete sectors:");
			indexComp = input.nextInt();
			System.out.println("Put a number for the id of the department where you want to delete sectors:");
			idDep = input.nextInt();
			System.out.println("Put a number for the id of the sector that you want to delete:");
			idSector = input.nextInt();
			for(int i = 0; i<kompaniList.size(); i++) {
				if(kompaniList.get(i).getIdCompany() == indexComp) {
					comp = i;
				}
			}
			depList = kompaniList.get(comp).getDepartmentsList();
			for(int i = 0; i<depList.size(); i++) {
				if(depList.get(i).getIdDep() == idDep) {
					dep = i;
				}
			}
			sectorList = depList.get(dep).getSectorsList();
			sectDAO.deleteSector(sectorList, idSector);
			break;			

		case "0":
			comp=-1;
			dep=0;
			int sect=0;
			System.out.println("Put a number for the id of the company where you want to edit a shop:");
			indexComp = input.nextInt();
			System.out.println("Put a number for the id of the department where you want to edit a shop:");
			idDep = input.nextInt();
			System.out.println("Put a number for the id of the sector where you want to edit a shop:");
			idSector = input.nextInt();
			System.out.println("Put a number for the id of the shop that you want to edit:");
			int idShop = input.nextInt();
			for(int i = 0; i<kompaniList.size(); i++) {
				if(kompaniList.get(i).getIdCompany() == indexComp) {
					comp = i;
				}
			}
			depList = kompaniList.get(comp).getDepartmentsList();
			for(int i = 0; i<depList.size(); i++) {
				if(depList.get(i).getIdDep() == idDep) {
					dep = i;
				}
			}
			sectorList = depList.get(dep).getSectorsList();
			for(int i = 0; i<sectorList.size(); i++) {
				if(sectorList.get(i).getIdSector() == idSector) {
					sect = i;
				}
			}
			shopList = sectorList.get(sect).getShopList();
			shopDAO.editShop(shopList, idShop);
			break;
			
		case "a":
			comp=-1;
			dep=0;
			sect=0;
			System.out.println("Put a number for the id of the company where you want to delete a shop:");
			indexComp = input.nextInt();
			System.out.println("Put a number for the id of the department where you want to delete a shop:");
			idDep = input.nextInt();
			System.out.println("Put a number for the id of the sector where you want to delete a shop:");
			idSector = input.nextInt();
			System.out.println("Put a number for the id of the shop that you want to delete:");
			idShop = input.nextInt();
			for(int i = 0; i<kompaniList.size(); i++) {
				if(kompaniList.get(i).getIdCompany() == indexComp) {
					comp = i;
				}
			}
			depList = kompaniList.get(comp).getDepartmentsList();
			for(int i = 0; i<depList.size(); i++) {
				if(depList.get(i).getIdDep() == idDep) {
					dep = i;
				}
			}
			sectorList = depList.get(dep).getSectorsList();
			for(int i = 0; i<sectorList.size(); i++) {
				if(sectorList.get(i).getIdSector() == idSector) {
					sect = i;
				}
			}
			shopList = sectorList.get(sect).getShopList();
			shopDAO.deleteShop(shopList, idShop);
			break;	
			
		case "b":
			comp=-1;
			dep=0;
			sect=0;
			int shop=0;
			System.out.println("Put a number for the id of the company where you want to edit a brand:");
			indexComp = input.nextInt();
			System.out.println("Put a number for the id of the department where you want to edit a brand:");
			idDep = input.nextInt();
			System.out.println("Put a number for the id of the sector where you want to edit a brand:");
			idSector = input.nextInt();
			System.out.println("Put a number for the id of the shop where you want to edit a brand:");
			idShop = input.nextInt();
			System.out.println("Put a number for the id of the brand that you want to edit:");
			int idBrand = input.nextInt();
			for(int i = 0; i<kompaniList.size(); i++) {
				if(kompaniList.get(i).getIdCompany() == indexComp) {
					comp = i;
				}
			}
			depList = kompaniList.get(comp).getDepartmentsList();
			for(int i = 0; i<depList.size(); i++) {
				if(depList.get(i).getIdDep() == idDep) {
					dep = i;
				}
			}
			sectorList = depList.get(dep).getSectorsList();
			for(int i = 0; i<sectorList.size(); i++) {
				if(sectorList.get(i).getIdSector() == idSector) {
					sect = i;
				}
			}
			shopList = sectorList.get(sect).getShopList();
			for(int i = 0; i<shopList.size(); i++) {
				if(shopList.get(i).getIdShop() == idShop) {
					shop = i;
				}
			}
			brandList = shopList.get(shop).getBrandList();
			brandDAO.editBrand(brandList, idBrand);
			break;
			
		case "c":
			comp=-1;
			dep=0;
			sect=0;
			shop=0;
			System.out.println("Put a number for the id of the company where you want to delete a brand:");
			indexComp = input.nextInt();
			System.out.println("Put a number for the id of the department where you want to delete a brand:");
			idDep = input.nextInt();
			System.out.println("Put a number for the id of the sector where you want to delete a brand:");
			idSector = input.nextInt();
			System.out.println("Put a number for the id of the shop where you want to delete a brand:");
			idShop = input.nextInt();
			System.out.println("Put a number for the id of the brand that you want to delete:");
			idBrand = input.nextInt();
			for(int i = 0; i<kompaniList.size(); i++) {
				if(kompaniList.get(i).getIdCompany() == indexComp) {
					comp = i;
				}
			}
			depList = kompaniList.get(comp).getDepartmentsList();
			for(int i = 0; i<depList.size(); i++) {
				if(depList.get(i).getIdDep() == idDep) {
					dep = i;
				}
			}
			sectorList = depList.get(dep).getSectorsList();
			for(int i = 0; i<sectorList.size(); i++) {
				if(sectorList.get(i).getIdSector() == idSector) {
					sect = i;
				}
			}
			shopList = sectorList.get(sect).getShopList();
			for(int i = 0; i<shopList.size(); i++) {
				if(shopList.get(i).getIdShop() == idShop) {
					shop = i;
				}
			}
			brandList = shopList.get(shop).getBrandList();
			brandDAO.deleteBrand(brandList, idBrand);
			break;
			
		case "d":																//funksionon
			usersList.add(admin);
			User u1 = userDAO.addUser(usersList, admin);
			usersList.add(u1);
			break;
			
		case "e":																//funksionon
			System.out.println("Put a number for the id of the user that you want to edit");
			int idUser = input.nextInt();
			userDAO.editUser(usersList, idUser, admin);
			break;
			
		case "f":																//funksionon
			System.out.println("Put a number for the id of the user that you want to delete");
			int user = input.nextInt();
			userDAO.deleteUser(usersList, user);
			break;
			
		case "g":																//funksionon
			userDAO.listUser(usersList);
			break;
			
		case "h":																//funksionon
			System.out.println("Put a number for the id of the user that you want to show details for");
			int userId = input.nextInt();
			System.out.println(userDAO.toString(usersList, userId));
			break;
			
		case "x":
			System.out.println("You closed the program system! Good bye!");
			System.exit(0);
			break;
			
			default: 
				System.out.println("This is not an option to choose! Please choose a correct option: ");
				choose = input.next();
				menu(choose);
				break;
		}
	}
		
		
		public void chooseAgain(String again) {
			if(again.equals("y") || again.equals("Y")) {
				System.out.println("Choose an option from the menu: ");
				String option = input.next();
				menu(option);
			}
			else if(again.equals("n") || again.equals("N")) {
				System.out.println("You have not choosed any option again.");
			}
			else {
				System.out.println("You have not choosed correctly! Please press the right button:");
				System.out.println("Do you want to choose again another option? Type 'y/Y' for Yes or 'n/N' for No: ");
				again = input.next();
				
				chooseAgain(again);
			}
		}
		
	
	public static void main(String[] args) throws InputMismatchException, IndexOutOfBoundsException{
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome\n");
		System.out.println("\tMenu");
		System.out.println("Press:");
		System.out.println("\n 1 - to list companies.");
		System.out.println(" 2 - to add a company in the list.");
		System.out.println(" 3 - to show the details of the company.");
		System.out.println(" 4 - to edit data of a company.");
		System.out.println(" 5 - to delete a company from the list.");
		System.out.println(" 6 - to edit data of a department");
		System.out.println(" 7 - to delete a department from the list of a company.");
		System.out.println(" 8 - to edit data of a sector");
		System.out.println(" 9 - to delete a sector from the list of a company.");
		System.out.println(" 0 - to edit data of a shop");
		System.out.println(" a - to delete a shop from the list of a company.");
		System.out.println(" b - to edit data of a brand");
		System.out.println(" c - to delete a brand from the list of a company.");
		System.out.println(" d - to add an user.");
		System.out.println(" e - to edit an user.");
		System.out.println(" f - to delete an user.");
		System.out.println(" g - to list details of all users.");
		System.out.println(" h - to show data of an user.");
		System.out.println(" x - to close the program and to exit.");
		
		
		Main menu = new Main();
		
		System.out.println("\n\tChoose an option from the menu: ");
		String choose = input.next();
		
		menu.menu(choose);
		
		while(true) {
			System.out.println("Do you want to choose another option from the menu? Type 'y/Y' for Yes or 'n/N' for No: ");
			String again = input.next();
		
			menu.chooseAgain(again);
		}
		
		
	}

}
