import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.lang.IndexOutOfBoundsException;

public class DepartmentDAO implements DepInterface{
	Scanner in = new Scanner(System.in);
	
	public DepartmentDAO() {
		
	}
	
	@Override
	public Department addDep(ArrayList<Department> departs) throws InputMismatchException, IndexOutOfBoundsException{
		Department dep = new Department();
		
		System.out.println("Put an id for the department: ");
		int idDep = in.nextInt();
		addIdUnique(departs, idDep, dep);
		
		System.out.println("Put a name for the department: ");
		String nameOfDep = in.next();
		System.out.println("Put a description for the department: ");
		String descriptionDep = in.next();
		
		dep.setNameOfDep(nameOfDep);
		dep.setDescriptionDep(descriptionDep);
		
		continueWithSector(dep);
		
		return dep;
	}
	
	
	@Override
	public void continueWithSector(Department dep) {
		
		System.out.println("\nDo you want to add sectors? Type 'y/Y' for Yes or 'n/N' for No: ");
		String choose = in.next();
		
		if(choose.equals("y") || choose.equals("Y")) {
			SectorDAO sectorDAO = new SectorDAO();
			ArrayList<Sector> sectorsList = new ArrayList<Sector>();
			System.out.println("\nHow much sectors do you want to create? Put a number: ");
			int nr = in.nextInt();
			int i;
			for(i = 0; i<nr; i++) {
				sectorsList.add(sectorDAO.addSector(sectorsList));
			}
			dep.setSectorsList(sectorsList);
		}
		else if(choose.equals("n") || choose.equals("N")) {
			System.out.println("\nYou have not add sectors!");
		}
		else {
			System.out.println("\nYou have not choosed correctly! Please press the right button:");
			continueWithSector(dep);
		}

	}
	
	
	@Override
	public Department editDep(ArrayList<Department> departs, int idDep) throws InputMismatchException, IndexOutOfBoundsException{
		Department dep = new Department();
		
		if(departs==null || departs.isEmpty()) {
			System.out.println("\nThere are no departments to edit!");
		}
		else {
			for(int i = 0; i < departs.size(); i++) {
				if(departs.get(i).getIdDep() == idDep) {
					System.out.println("Change name of the department: ");
					String nameOfDep = in.next();
					System.out.println("Change description of the department: ");
					String descriptionDep = in.next();
					
					departs.get(i).setNameOfDep(nameOfDep);
					departs.get(i).setDescriptionDep(descriptionDep);
					
					dep = departs.get(i);
				}
			}
		}
		return dep;
	}
	
	
	
	@Override
	public void deleteDep(ArrayList<Department> departs, int index) throws IndexOutOfBoundsException{

		if(departs==null || departs.isEmpty()) {
			System.out.println("\nThere are no departments to delete!");
		}
		else {
			SectorDAO sectDao = new SectorDAO();
	
			for(int i = 0; i < departs.size(); i++) {
				if(departs.get(i).getIdDep() == index) {
					index = i;
				}
				break;
			}
			ArrayList<Sector> sectList = departs.get(index).getSectorsList();
			sectDao.deleteAllSector(sectList);
			departs.remove(index);
			System.out.println("\nDepartment has been deletet from the list!");
		}	
	}
	
	
	@Override
	public void deleteAllDep(ArrayList<Department> departs) throws IndexOutOfBoundsException{
		
		if(departs==null || departs.isEmpty()) {
			System.out.println("\nThere are no departments!");
		}
		else {
			SectorDAO sectorDao = new SectorDAO();
			ArrayList<Sector> sectList;
			
			for(int i = 0; i < departs.size(); i++) {
				sectList = departs.get(i).getSectorsList();
				sectorDao.deleteAllSector(sectList);
				departs.remove(i);
			}
			System.out.println("\nAll sectors are deleted!");
		}
	}
	
	
	
	@Override
	public String listDepartments(ArrayList<Department> departs) {
		String s="";
		if(departs==null || departs.isEmpty()) {
			s += "\nThe list has not any department and data to show!";
		}
		else {
			for(int i = 0; i<departs.size(); i++) {
				int id = departs.get(i).getIdDep();
				s += toString(departs, id) + "\n\n";
			}
		}
		return s;
	}
	
	
	@Override
	public String toString(ArrayList<Department> departs, int id) {
		
		String info = "";
		if(departs==null || departs.isEmpty()) {
			info += "\nThe list has not any department and data to show!";
		}
		else {
			int index = 0;
		
			for(int i = 0; i<departs.size(); i++) {
				if(departs.get(i).getIdDep() == id) {
					index = i;
				}
			}
			info += "ID Department: " + departs.get(index).getIdDep()  + "\n";
			info += "Name of Department: " + departs.get(index).getNameOfDep()  + "\n";
			info += "Description of Department: " + departs.get(index).getDescriptionDep() + "\n";
			
			SectorDAO dao = new SectorDAO();
			ArrayList<Sector> sectorList = departs.get(index).getSectorsList();
			info += "\nSector List: \n" + dao.listSectors(sectorList);
		}
		return info;
	}
	
	
	
	@Override
	public boolean isIdUnique(ArrayList<Department> departs, int id) {
		for(int i = 0; i<departs.size(); i++) {
			if(departs.get(i).getIdDep() == id) {
				return false;
			}
		}
		return true;
	}
	
	
	
	@Override
	public void addIdUnique(ArrayList<Department> departs, int id, Department dep) {
		if(isIdUnique(departs, id)) {
			dep.setIdDep(id);
		}
		else {
			System.out.println("\nYour id is used by another department! Please put a unique, a different id that is not used before: ");
			id = in.nextInt();
			addIdUnique(departs, id, dep);
		}
	}


}
