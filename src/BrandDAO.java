import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class BrandDAO implements BrandInterface{
	
	Scanner input = new Scanner(System.in);
	
	public BrandDAO() {
		
	}
	
	@Override
	public Brand addBrand(ArrayList<Brand> brandList) throws InputMismatchException, IndexOutOfBoundsException{
		
		Brand brand = new Brand();
		
		System.out.println("Put an id for the brand: ");
		int idBrand = input.nextInt();
		addIdUnique(brandList, idBrand, brand);
		
		System.out.println("Put a name for the brand: ");
		String nameOfBrand = input.next();
		System.out.println("Put a description for the brand: ");
		String descriptionBrand = input.next();
		
		brand.setNameOfBrand(nameOfBrand);
		brand.setDescriptionBrand(descriptionBrand);
		
		return brand;
	}
	
	
	@Override
	public Brand editBrand(ArrayList<Brand> brandList, int idBrand) throws InputMismatchException, IndexOutOfBoundsException{
		Brand brand = new Brand();
		
		if(brandList == null || brandList.isEmpty()) {
			System.out.println("\nThere are no brands!");
		}
		else {
			for(int i = 0; i < brandList.size(); i++) {
				if(brandList.get(i).getIdBrand() == idBrand) {
					
					System.out.println("Change name of the brand: ");
					String nameOfBrand = input.next();
					System.out.println("Change description of the brand: ");
					String descriptionBrand = input.next();
					
					brandList.get(i).setNameOfBrand(nameOfBrand);
					brandList.get(i).setDescriptionBrand(descriptionBrand);
					
					brand = brandList.get(i);
				}
			}
		}
		return brand;
	}
	
	
	@Override
	public void deleteBrand(ArrayList<Brand> brandList, int index) throws IndexOutOfBoundsException{
		if(brandList == null || brandList.isEmpty()) {
			System.out.println("\nThere are no brands to delete!");
		}
		else {
			int i;
			for(i = 0; i < brandList.size(); i++) {
				if(brandList.get(i).getIdBrand() == index) {
					index = i;
					break;
				}
				else {
					index = -1;
					System.out.println("\nThere is no brand to delete with this id!");
				}
			}
			brandList.remove(index);
		}
		
	}
	
	
	@Override
	public void deleteAllBrand(ArrayList<Brand> brandList) throws IndexOutOfBoundsException{
		if(brandList == null || brandList.isEmpty()) {
			System.out.println("\nThere are no brands to delete!");
		}
		else {
			for(int i = 0; i < brandList.size(); i++) {
				brandList.remove(i);
			}
			System.out.println("All brands are deleted!");
		}
	}
	
	
	
	@Override
	public String listBrands(ArrayList<Brand> brandList) {

		String s="";
		if(brandList == null || brandList.isEmpty()) {
			s += "\nThe list has not any brand and data to show!";
		}
		else {
			for(int i = 0; i<brandList.size(); i++) {
				int id = brandList.get(i).getIdBrand();
				s = toString(brandList, id) + "\n\n";
			}
		}
		return s;
	}
	
	
	
	
	@Override
	public String toString(ArrayList<Brand> brandList, int id) {
		
		String info = "";
		if(brandList == null || brandList.isEmpty()) {
			info += "\nThere is no data to show!";
		}
		else {
			int index = 0;
		
			for(int i = 0; i<brandList.size(); i++) {
				if(brandList.get(i).getIdBrand() == id) {
					index = i;
				}
			}
			info +=  "ID Brand: " + brandList.get(index).getIdBrand()  + "\n";
			info +=  "Name of Brand: " + brandList.get(index).getNameOfBrand()  + "\n";
			info +=  "Description of Brand: " + brandList.get(index).getDescriptionBrand() + "\n";
		}
		return info;
	}
	
	
	@Override
	public boolean isIdUnique(ArrayList<Brand> brandList, int id) {
		for(int i = 0; i<brandList.size(); i++) {
			if(brandList.get(i).getIdBrand() == id) {
				return false;
			}
		}
		return true;
	}
	
	
	
	@Override
	public void addIdUnique(ArrayList<Brand> brandList, int id, Brand brand) {
		if(isIdUnique(brandList, id)) {
			brand.setIdBrand(id);
		}
		else {
			System.out.println("Your id is used by another brand! Please put a unique, a different id that is not used before: ");
			id = input.nextInt();
			addIdUnique(brandList, id, brand);
		}
	}

}