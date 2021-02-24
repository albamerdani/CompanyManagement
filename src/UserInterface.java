import java.util.ArrayList;
public interface UserInterface {
	
	public User addUser(ArrayList<User> usersList, User admin);
	
	public User editUser(ArrayList<User> usersList, int idUser, User admin);
	
	public void deleteUser(ArrayList<User> usersList, int idUser);
	
	public void listUser(ArrayList<User> userList);
	
	public String toString(ArrayList<User> userList, int id);
	
	public boolean isIdUnique(ArrayList<User> userList, int id);
	
	public void addIdUnique(ArrayList<User> userList, int id, User user);
	
	public boolean isValidEmail(String email);
	
	public void addValidEmail(String email, User user);

}
