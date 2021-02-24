import java.util.ArrayList;

public class Company {
	
	private int idCompany;
	private String nameOfCompany;
	private String nipt;
	private String address;
	private String descriptionCompany;
	private boolean validityCompany;
	private ArrayList<Department> departmentsList;
	
	
	public Company() {
	
		this.idCompany = getIdCompany();
		this.nameOfCompany = getNameOfCompany();
		this.nipt = getNipt();
		this.address = getAddress();
		this.descriptionCompany = getDescriptionCompany();
		this.validityCompany = true;
		this.departmentsList = getDepartmentsList();
	}
	
	
	public Company(int idCompany, String nameOfCompany, String nipt, String address, String descriptionCompany, ArrayList<Department> departmentsList) {
		
		this.idCompany = idCompany;
		this.nameOfCompany = nameOfCompany;
		this.nipt = nipt;
		this.address = address;
		this.descriptionCompany = descriptionCompany;
		this.validityCompany = true;
		this.departmentsList = departmentsList;
	}
	
	public int getIdCompany() {
		return idCompany;
	}
	
	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}
	
	public String getNameOfCompany() {
		return nameOfCompany;
	}
	
	public void setNameOfCompany(String nameOfCompany) {
		this.nameOfCompany = nameOfCompany;
	}
	
	public String getNipt() {
		return nipt;
	}
	
	public void setNipt(String nipt) {
		this.nipt = nipt;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescriptionCompany() {
		return descriptionCompany;
	}

	public void setDescriptionCompany(String descriptionCompany) {
		this.descriptionCompany = descriptionCompany;
	}

	public boolean getValidityCompany() {
		return validityCompany;
	}

	public void setValidityCompany(boolean validityCompany) {
		this.validityCompany = validityCompany;
	}

	public ArrayList<Department> getDepartmentsList() {
		return departmentsList;
	}

	public void setDepartmentsList(ArrayList<Department> departmentsList) {
		this.departmentsList = departmentsList;
	}
		

}
