import java.util.ArrayList;

public interface DepInterface {
	
	public Department addDep(ArrayList<Department> departs);
	
	public void continueWithSector(Department dep);
	
	public Department editDep(ArrayList<Department> departs, int idDep);
	
	public void deleteDep(ArrayList<Department> departs, int index);
	
	public void deleteAllDep(ArrayList<Department> departs);
	
	public String listDepartments(ArrayList<Department> departs);
	
	public String toString(ArrayList<Department> departs, int id);
	
	public boolean isIdUnique(ArrayList<Department> departs, int id);
	
	public void addIdUnique(ArrayList<Department> departs, int id, Department dep);

}
