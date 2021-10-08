import java.util.*;
public class PasswordChecker {

	static Character[] special = new Character[]{'#','$','@','!','^','*','+','%','&'};
	static Set<Character> specials = new HashSet<Character>(Arrays.asList(special));
	public static boolean isValid(String s) {
		char[] c = s.toCharArray();
		int size = c.length - 1;
		if (containsNumber(s) && containsSpecial(s) && containsUppercase(s) && containsLowercase(s) && size >= 8) {
			return true;
		}
		else {
			System.out.println("Invalid password");
			if (size < 8) {
				System.out.println("\tThis password must be more than 8 characters");
			}
			if (!containsNumber(s)) {
				System.out.println("\tThis password must include at least one number");
			}
			if (!containsSpecial(s)) {
				System.out.print("\tThis password must include at least one of the following special characters: ");
				for (Character m: specials) {
					System.out.print(m + " ");
				}
				System.out.println();
			}
			if (!containsLowercase(s)) {
				System.out.println("\tThis password must include at least one lowercase letter");
			}
			if (!containsUppercase(s)) {
				System.out.println("\tThis password must include at least one upppercase letter");
			}
			return false;
		}
	}
	
	public static boolean containsNumber(String s) {
		char[] c = s.toCharArray();
		for (char m: c) {
			if (m > '0' && m < '9') {
				return true;
			}
			else {
				continue;
			}
		}
		return false;
	}
	
	public static boolean containsSpecial(String s) {
		char[] c = s.toCharArray();
		Character[] special = new Character[]{'#','$','@','!','^','*','+','%','&'};
		Set<Character> specials = new HashSet<Character>(Arrays.asList(special));
		for (char m: c) {
			if (specials.contains(m)) {
				return true;
			}
			else {
				continue;
			}
		}
		return false;
	}
	
	public static boolean containsUppercase(String s) {
		char[] c = s.toCharArray();
		for (char m: c) {
			if (m > 'A' && m < 'Z') {
				return true;
			}
			else {
				continue;
			}
		}
		return false;
	}
	
	public static boolean containsLowercase(String s) {
		char[] c = s.toCharArray();
		for (char m: c) {
			if (m > 'a' && m < 'z') {
				return true;
			}
			else {
				continue;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a password to be saved: ");
		String password = scan.next();
		while (!isValid(password)) {
			System.out.print("Try the password again: ");
			password = scan.next();
		}
		System.out.println("Your password has been saved!");
	}

}