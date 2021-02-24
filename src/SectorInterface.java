import java.util.ArrayList;
public interface SectorInterface {
	
	public Sector addSector(ArrayList<Sector> sectors);
	
	public void continueWithShop(Sector sect);
	
	public Sector editSector(ArrayList<Sector> sectors, int idSector);
	
	public void deleteSector(ArrayList<Sector> sectors, int index);
	
	public void deleteAllSector(ArrayList<Sector> sectors);
	
	public String listSectors(ArrayList<Sector> sectors);
	
	public String toString(ArrayList<Sector> sectors, int id);
	
	public boolean isIdUnique(ArrayList<Sector> sectors, int id);
	
	public void addIdUnique(ArrayList<Sector> sectors, int id, Sector sect);

}
