import java.util.ArrayList;

public interface CompanyInterface {

	public Company addCompany(ArrayList<Company> kompaniList);
	
	public void continueWithDep(Company comp);
	
	public Company editCompany(ArrayList<Company> kompani, int idCompany);
	
	public void deleteCompany(ArrayList<Company> kompani, int id);
	
	public void listCompany(ArrayList<Company> kompaniList);
	
	public String toString(ArrayList<Company> kompaniList, int id);
	
	public boolean isIdUnique(ArrayList<Company> kompaniList, int id);
	
	public void addIdUnique(ArrayList<Company> kompaniList, int id, Company comp);
}
