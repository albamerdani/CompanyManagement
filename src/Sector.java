import java.util.ArrayList;

public class Sector {
	
	private int idSector;
	private String nameOfSector;
	private String descriptionSector;
	private boolean validitySector;
	private ArrayList<Shop> shopList;
	
	
	public Sector() {
		this.idSector = getIdSector();
		this.nameOfSector = getNameOfSector();
		this.descriptionSector = getDescriptionSector();
		this.validitySector = true;
		this.shopList = getShopList();
	}
	
	
	public Sector(int idSector, String nameOfSector, String descriptionSector, ArrayList<Shop> shopList) {
		this.idSector = idSector;
		this.nameOfSector = nameOfSector;
		this.descriptionSector = descriptionSector;
		this.validitySector = true;
		this.shopList = shopList;
	}

	public int getIdSector() {
		return idSector;
	}

	public void setIdSector(int idSector) {
		this.idSector = idSector;
	}

	public String getNameOfSector() {
		return nameOfSector;
	}

	public void setNameOfSector(String nameOfSector) {
		this.nameOfSector = nameOfSector;
	}

	public String getDescriptionSector() {
		return descriptionSector;
	}

	public void setDescriptionSector(String descriptionSector) {
		this.descriptionSector = descriptionSector;
	}

	public boolean getValiditySector() {
		return validitySector;
	}

	public void setValiditySector(boolean validitySector) {
		this.validitySector = validitySector;
	}


	public ArrayList<Shop> getShopList() {
		return shopList;
	}


	public void setShopList(ArrayList<Shop> shopList) {
		this.shopList = shopList;
	}
	
	
	
	

}
