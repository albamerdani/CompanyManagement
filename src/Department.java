import java.util.ArrayList;

public class Department {

	private int idDep;
	private String nameOfDep;
	private String descriptionDep;
	private boolean validityDep;
	private ArrayList<Sector> sectorsList;
	
	public Department() {
		this.idDep = getIdDep();
		this.nameOfDep = getNameOfDep();
		this.descriptionDep = getDescriptionDep();
		this.validityDep = true;
		this.sectorsList = getSectorsList();
	}
	

	public Department(int idDep, String nameOfDep, String descriptionDep, ArrayList<Sector> sectorsList) {
		this.idDep = idDep;
		this.nameOfDep = nameOfDep;
		this.descriptionDep = descriptionDep;
		this.validityDep = true;
		this.sectorsList = sectorsList;
	}

	public int getIdDep() {
		return idDep;
	}
	
	public void setIdDep(int idDep) {
		this.idDep = idDep;
	}
	
	public String getNameOfDep() {
		return nameOfDep;
	}
	
	public void setNameOfDep(String nameOfDep) {
		this.nameOfDep = nameOfDep;
	}


	public String getDescriptionDep() {
		return descriptionDep;
	}


	public void setDescriptionDep(String descriptionDep) {
		this.descriptionDep = descriptionDep;
	}


	public boolean getValidityDep() {
		return validityDep;
	}


	public void setValidityDep(boolean validityDep) {
		this.validityDep = validityDep;
	}


	public ArrayList<Sector> getSectorsList() {
		return sectorsList;
	}


	public void setSectorsList(ArrayList<Sector> sectorsList) {
		this.sectorsList = sectorsList;
	}
	
	
	
}
