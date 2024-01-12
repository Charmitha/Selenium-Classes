package p1;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean repeat = true;
		
		
		while(repeat) {
			System.out.println("\n***MENU***");
			System.out.println("1.Insert data for ID");
			System.out.println("2.Verify data");
			System.out.println("3.EXIT");
			System.out.println("\nProvide key: ");
			int key = sc.nextInt();
			switch (key) {
			case 1:
				String ack = skill7.insert();
				System.out.println(ack);
				break;
			case 2:
				System.out.println("Provide ID: ");
				int id = sc.nextInt();
				System.out.println("Provide name for verification: ");
				String name = sc.next();
				System.out.println("Provide email for verification: ");
				String email = sc.next();
				System.out.println("Provide dob(dd/mm/yyyy) for verification: ");
				String dob = sc.next();
				String ack1 = DataVerification.verify(id, name, email, dob);
				System.out.println(ack1);
				break;
			case 3:
				System.out.println("Exiting....");
				repeat = false;
				break;
			default:
				System.out.println("Chose correction option\n");
				break;	
			}
		}

	}

}
