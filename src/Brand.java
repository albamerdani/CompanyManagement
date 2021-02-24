
public class Brand {
	
	private int idBrand;
	private String nameOfBrand;
	private String descriptionBrand;
	private boolean validityBrand;
	
	public Brand() {
		this.idBrand = getIdBrand();
		this.nameOfBrand = getNameOfBrand();
		this.descriptionBrand = getDescriptionBrand();
		this.validityBrand = getValidityBrand();
	}
	
	public Brand(int idBrand, String nameOfBrand, String descriptionBrand) {
		this.idBrand = idBrand;
		this.nameOfBrand = nameOfBrand;
		this.descriptionBrand = descriptionBrand;
		this.validityBrand = true;
	}
	
	public int getIdBrand() {
		return idBrand;
	}
	
	public void setIdBrand(int idBrand) {
		this.idBrand = idBrand;
	}
	
	public String getNameOfBrand() {
		return nameOfBrand;
	}
	
	public void setNameOfBrand(String nameOfBrand) {
		this.nameOfBrand = nameOfBrand;
	}

	public String getDescriptionBrand() {
		return descriptionBrand;
	}

	public void setDescriptionBrand(String descriptionBrand) {
		this.descriptionBrand = descriptionBrand;
	}

	public boolean getValidityBrand() {
		return validityBrand;
	}

	public void setValidityBrand(boolean validityBrand) {
		this.validityBrand = validityBrand;
	}	

}
