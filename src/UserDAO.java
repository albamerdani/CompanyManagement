import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.regex.*;

public class UserDAO implements UserInterface{
	
	Scanner input = new Scanner(System.in);
	
	@Override
	public User addUser(ArrayList<User> usersList, User admin) {
		User user = new User();
		
		if(admin.getUserRole().getRole().equalsIgnoreCase("administrator")) {
			int idUser;
			try {
				System.out.println("Put an id for the user: ");
				idUser = input.nextInt();
				addIdUnique(usersList, idUser, user);
			}catch(InputMismatchException ime){
				System.out.println("Please put a number for the id. Put an id for the user: ");
				idUser = input.nextInt();
			}
			
			System.out.println("Put firstname for the user: ");
			String firstname = input.next();
			System.out.println("Put lastname for the user: ");
			String lastname = input.next();
			System.out.println("Put gender for the user: ");
			String gender = input.next();
			System.out.println("Put email for the user: ");
			String email = input.next();
			addValidEmail(email, user);
			System.out.println("Put cel number for the user: ");
			String cel = input.next();
			System.out.println("Put address for the user: ");
			String address = input.next();
			System.out.println("Put username for the user: ");
			String username = input.next();
			System.out.println("Put password for the user: ");
			String password = input.next();
			
			System.out.println("Put an id for the role of the user: ");
			int idRoli = input.nextInt();
			System.out.println("Put a role for the user: ");
			String roli = input.next();
			
			Role role = new Role(idRoli,roli);

			user.setFirstName(firstname);
			user.setLastName(lastname);
			user.setGender(gender);
			user.setCel(cel);
			user.setAddressUser(address);
			user.setUsername(username);
			user.setPassword(password);
			user.setUserRole(role);
		}
		else {
			System.out.println("You do not have permission to add a user!");
		}	
		return user;
	}
	
	
	
	@Override
	public User editUser(ArrayList<User> usersList, int idUser, User admin) {
		User u = new User();
		if(admin.getUserRole().getRole().equalsIgnoreCase("administrator")) {
			for(int i = 0; i < usersList.size(); i++) {
				if(usersList.get(i).getIdUser() == idUser) {
				
					System.out.println("Change email for the user: ");
					String email = input.next();
					System.out.println("Change cel number for the user: ");
					String cel = input.next();
					System.out.println("Change address for the user: ");
					String address = input.next();
					System.out.println("Change username for the user: ");
					String username = input.next();
					System.out.println("Change password for the user: ");
					String password = input.next();
					
					System.out.println("Change role for the user: ");
					String roli = input.next();
	
					usersList.get(i).setEmail(email);
					usersList.get(i).setCel(cel);
					usersList.get(i).setAddressUser(address);
					usersList.get(i).setUsername(username);
					usersList.get(i).setPassword(password);
					usersList.get(i).getUserRole().setRole(roli);
				
					u = usersList.get(i);
				}
			}
		}
		else {
			System.out.println("You do not have permission to edit users data!!");
		}	
		return u;
	}
	
	
	
	@Override
	public void deleteUser(ArrayList<User> usersList, int idUser) {
		
		for(int i = 0; i < usersList.size(); i++) {
			if(usersList.get(i).getIdUser() == idUser) {
				idUser = i;
			}
			break;
		}
		usersList.remove(idUser);
		System.out.println("User has been deleted!");
	}
	
	
	
	@Override
	public void listUser(ArrayList<User> userList) {
		String s="";
		
		for(int i = 0; i<userList.size(); i++) {
			int id = userList.get(i).getIdUser();
			s = toString(userList, id) + "\n\n";
			System.out.println(s);
		}
		
		if(s == "") {
			System.out.println("The list has not any company and data to show!");
		}
	}
	
	
	@Override
	public String toString(ArrayList<User> userList, int id) {
	
		String info = "";
		int index = 0;
		
		for(int i = 0; i<userList.size(); i++) {
			if(userList.get(i).getIdUser() == id) {
				index = i;
			}
		}
		
		info += userList.get(index).getIdUser()  + "\n";
		info += userList.get(index).getFirstName()  + "\n";
		info += userList.get(index).getLastName()  + "\n";
		info += userList.get(index).getGender()  + "\n";
		info += userList.get(index).getEmail() + "\n";
		info += userList.get(index).getCel() + "\n";
		info += userList.get(index).getAddressUser() + "\n";
		info += userList.get(index).getUsername() + "\n";
		info += userList.get(index).getPassword() + "\n";
		info += userList.get(index).getUserRole().getRole() + "\n";
		
		if(info == "" || info == null) {
			System.out.println("There is no data to show!");
		}
		
		return info;
	}
	
	
	
	@Override
	public boolean isIdUnique(ArrayList<User> userList, int id) {
		for(int i = 0; i<userList.size(); i++) {
			if(userList.get(i).getIdUser() == id) {
				return false;
			}
		}
		return true;
	}
	
	
	
	@Override
	public void addIdUnique(ArrayList<User> userList, int id, User user) {
		if(isIdUnique(userList, id)) {
			user.setIdUser(id);
		}
		else {
			System.out.println("Your id is used by another user! Please put a unique, a different id that is not used before: ");
			id = input.nextInt();
			addIdUnique(userList, id, user);
		}
	}
	
	
	
	@Override
	public boolean isValidEmail(String email) {
		
		String pattern = "[a-zA-Z]+[0-9]*[.-_]?@[a-z]+[.][a-z]+";
		boolean isMatch = Pattern.matches(pattern, email);
		
		if(isMatch) {
			return true;
		}
		return false;	
	}
	
	
	
	@Override
	public void addValidEmail(String email, User user) {
		if(isValidEmail(email)) {
			user.setEmail(email);
		}
		else {
			System.out.println("Your email is not valid! Please put a valid email: ");
			email = input.next();
			addValidEmail(email, user);
		}
	}
}
