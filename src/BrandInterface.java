import java.util.ArrayList;

public interface BrandInterface {

	public Brand addBrand(ArrayList<Brand> brandList);
	
	public Brand editBrand(ArrayList<Brand> brandList, int index);
	
	public void deleteBrand(ArrayList<Brand> brandList, int index);
	
	public void deleteAllBrand(ArrayList<Brand> brandList);
	
	public String listBrands(ArrayList<Brand> brandList);
	
	public String toString(ArrayList<Brand> brandList, int id);
	
	public boolean isIdUnique(ArrayList<Brand> brandList, int id);
	
	public void addIdUnique(ArrayList<Brand> brandList, int id, Brand brand);

}
