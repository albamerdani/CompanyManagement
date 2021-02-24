import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class CompanyDAO implements CompanyInterface{
	
	Scanner input = new Scanner(System.in);
	
	public CompanyDAO() {
		
	}
	
	
	@Override
	public Company addCompany(ArrayList<Company> kompaniList) throws InputMismatchException, IndexOutOfBoundsException{
		Company comp = new Company();
		
		System.out.println("Put an id for the company: ");
		int idCompany = input.nextInt();
		addIdUnique(kompaniList, idCompany, comp);
		System.out.println("Put a name for the company: ");
		String nameOfCompany = input.next();
		System.out.println("Put a nipt for the company: ");
		String nipt = input.next();
		System.out.println("Put an address for the company: ");
		String address = input.next();
		System.out.println("Put a description for the company: ");
		String descriptionCompany = input.next();
	
		comp.setIdCompany(idCompany);
		comp.setNameOfCompany(nameOfCompany);
		comp.setNipt(nipt);
		comp.setAddress(address);
		comp.setDescriptionCompany(descriptionCompany);
		
		continueWithDep(comp);
				
		return comp;
	}
	
	@Override
	public void continueWithDep(Company comp) {
		
		System.out.println("Do you want to add departments? Type 'y or Y' for 'Yes' or 'n or N' for 'No': ");
		String choose = input.next();
		
		if(choose.equals("y") || choose.equals("Y")) {
			DepartmentDAO depDAO = new DepartmentDAO();
			ArrayList<Department> departmentsList = new ArrayList<Department>();
			System.out.println("How much departments do you want to create: ");
			int nr = input.nextInt();
			int i;
			for(i = 0; i<nr; i++) {
				departmentsList.add(depDAO.addDep(departmentsList));
			}
			comp.setDepartmentsList(departmentsList);
		}
		else if(choose.equals("n") || choose.equals("N")) {
			System.out.println("You add only the company!");
		}
		else {
			System.out.println("You have not choosed correctly! Please press the right button:");
			continueWithDep(comp);
		}

	}
	
	
	@Override
	public Company editCompany(ArrayList<Company> kompaniList, int idCompany) throws InputMismatchException, IndexOutOfBoundsException{
		Company comp = new Company();
		
		for(int i = 0; i < kompaniList.size(); i++) {
			if(kompaniList.get(i).getIdCompany() == idCompany) {
				
				System.out.println("Change name of the company: ");
				String nameOfCompany = input.next();
				System.out.println("Change nipt of the company: ");
				String nipt = input.next();
				System.out.println("Change address of the company: ");
				String address = input.next();
				System.out.println("Change description of the company: ");
				String descriptionCompany = input.next();
				
				kompaniList.get(i).setNameOfCompany(nameOfCompany);
				kompaniList.get(i).setNipt(nipt);
				kompaniList.get(i).setAddress(address);
				kompaniList.get(i).setDescriptionCompany(descriptionCompany);
				comp = kompaniList.get(i);
			}
		}
		
		return comp;
	}
	
	
	@Override
	public void deleteCompany(ArrayList<Company> kompaniList, int id) throws IndexOutOfBoundsException{

		if(kompaniList == null || kompaniList.isEmpty()) {
			System.out.println("\nThere are no companies to delete!");
		}
		else {		
			DepartmentDAO depDao = new DepartmentDAO();
			int index = -1;
			for(int i = 0; i < kompaniList.size(); i++) {
			if(kompaniList.get(i).getIdCompany() == id) {
				index = i;
			}
			break;
		}
		ArrayList<Department> depList = kompaniList.get(index).getDepartmentsList();
		depDao.deleteAllDep(depList);
		kompaniList.remove(index);
		System.out.println("Company has been deletet from the list!");
		}
	}
	
	
	
	@Override
	public void listCompany(ArrayList<Company> kompaniList) {
		String s="";
		if(kompaniList == null || kompaniList.isEmpty()) {
			s += "\nThe list has not any company and data to show!";
		}
		else {
			for(int i = 0; i<kompaniList.size(); i++) {
				int id = kompaniList.get(i).getIdCompany();
				s += toString(kompaniList, id) + "\n\n";
			}
		}
		System.out.println(s);
	}
	
	
	
	@Override
	public String toString(ArrayList<Company> kompaniList, int id) {
	
		String info = "";
		if(kompaniList == null || kompaniList.isEmpty()) {
			info += "\nThere is no data to show!";
		}
		else {
			int index = 0;
		
			for(int i = 0; i<kompaniList.size(); i++) {
				if(kompaniList.get(i).getIdCompany() == id) {
					index = i;
				}
			}
			info += "ID of Company: " + kompaniList.get(index).getIdCompany()  + "\n";
			info += "Name of Company: " + kompaniList.get(index).getNameOfCompany()  + "\n";
			info += "NIPT of Company: " + kompaniList.get(index).getNipt()  + "\n";
			info += "Address of Company: " + kompaniList.get(index).getAddress()  + "\n";
			info += "Decription of Company: " + kompaniList.get(index).getDescriptionCompany() + "\n";
			
			DepartmentDAO dao = new DepartmentDAO();
			ArrayList<Department> depList = kompaniList.get(index).getDepartmentsList();
			info += "\nDepartment List: \n" + dao.listDepartments(depList);
		}
		return info;
	}
	
	
	
	@Override
	public boolean isIdUnique(ArrayList<Company> kompaniList, int id) {
		for(int i = 0; i<kompaniList.size(); i++) {
			if(kompaniList.get(i).getIdCompany() == id) {
				return false;
			}
		}
		return true;
	}
	
	
	
	@Override
	public void addIdUnique(ArrayList<Company> kompaniList, int id, Company comp) {
		if(isIdUnique(kompaniList, id)) {
			comp.setIdCompany(id);
		}
		else {
			System.out.println("Your id is used by another company! Please put a unique, a different id that is not used before: ");
			id = input.nextInt();
			addIdUnique(kompaniList, id, comp);
		}
	}

}
