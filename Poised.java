import java.util.*; // Import module so we are able to the scanner function
public class Poised { // The class 

	public static void main(String[] args) { // The main method
		Scanner input = new Scanner(System.in); // Initialization of the scanner
		
		System.out.print("Please enter the project details"); // Print out the string
		System.out.print("\nPlease enter a project number: "); // Print out the string
		int Project_Number = input.nextInt(); // Ask the user for input for the project number attribute
		
		System.out.print("\nPlease enter project name: "); // Print the string
		 String Project_Name = input.next(); // Ask the user for input for the attribute Project name
		
		System.out.print("\nPlease enter your building type: (e.g house)"); // Print the string
		String Building_Type = input.next(); // Ask the user for input for the attribute
		
		System.out.print("\nPlease enter your address: "); //Print the string
		 String Address = input.next(); // Ask the user for input for the attribute
		
		System.out.print("\nPlease enter your ERF number: "); // Print the string
		int ERF_Number = input.nextInt(); // Ask the user for input for the attribute
		
		System.out.print("\nPlease enter the total fee being charged R"); // Print the string
		double Fee_Charged = input.nextFloat();  // Ask the user for input for the attribute
		
		System.out.print("\nPlease enter the total amount which has been paid R"); // Print the string
		double Total_Amount = input.nextFloat(); // Ask the user for input for the attribute
		
		System.out.print("\nPlease enter the deadline for the project: ");// Print the string
		 String Deadline = input.next(); // Ask the user for input for the attribute
		 
		 Project project1 = new Project(Project_Number, Project_Name, Building_Type, Address, ERF_Number, Fee_Charged, Total_Amount, Deadline); // The creation of a new object and its arguments
		
		System.out.print("\nPlease enter the architect's details"); // Print the string
		System.out.print("\nPlease enter architect name: "); // Print the String
		String Name1 = input.next(); // Ask the user for input for the attribute
		
		System.out.print("\nPlease enter archtect surname: "); // Print the string
		String Surname1 = input.next(); // Ask the user for input for the attribute
		
		String Stakeholder1 = "architect"; // Assign the attribute
		
		System.out.print("Please enter architect telephone number: ");// Print the string
		String Telephone_Num1 = input.next(); // Ask the user for input for the attribute
		
		System.out.print("Please enter architect email address: ");// Print the string
		String Email1 = input.next(); // Ask the user for input for the attribute
		
		System.out.print("Please enter architect physical address: ");// Print the string
		String Address1 = input.next(); // Ask the user for input for the attribute
		
		Person architect = new Person(Name1, Surname1, Stakeholder1, Telephone_Num1, Email1, Address1); // The creation of a new object and its arguments
		
		System.out.print("\nPlease enter the contractor's details"); // Print the string
		System.out.print("\nPlease enter contractor's name: ");// Print the string
		String Name2 = input.next(); // Ask the user for input for the attribute
		
		System.out.print("\nPlease enter the contractor's surname: "); // Print the string
		String Surname2 = input.next();  // Ask the user for input for the attribute
		
		String Stakeholder2 = "contractor"; // Assign the attribute
		
		System.out.print("\nPlease enter the contractor's telephone number:"); // Print the string
		String Telephone_Num2 = input.next(); // Ask the user for input for the attribute
		
		System.out.print("\nPlease enter the contractor's email address: ");// Print the string
		String Email2 = input.next(); // Ask the user for input for the attribute
		
		System.out.print("\nPlease enter the contractor's physical address: ");// Print the string
		String Address2 = input.next(); // Ask the user for input for the attribute
		
		Person contractor = new Person(Name2, Surname2, Stakeholder2, Telephone_Num2, Email2, Address2); // The creation of a new object and its arguments
		
		System.out.print("\nPlease enter the customer's details");// Print the string
		System.out.print("\nPlease enter the customer's name: ");// Print the string
		String Name3 = input.next(); // Ask the user for input for the attribute
		
		System.out.print("\nPlease enter the customer's surname: ");// Print the string
		String Surname3 = input.next(); // Ask the user for input for the attribute
		
		String Stakeholder3 = "customer"; // Assign the attribute
		
		System.out.print("\nPlease enter the customer's telephone number: ");// Print the string
		String Telephone_Num3 = input.next(); // Ask the user for input for the attribute
		
		System.out.print("\nPlease enter the customer's email address: ");// Print the string
		String Email3 = input.next(); // Ask the user for input for the attribute
		
		System.out.print("\nPlease enter the customer's physical address: ");// Print the string
		String Address3 = input.next(); // Ask the user for input for the attribute
		
		Person customer = new Person(Name3, Surname3, Stakeholder3, Telephone_Num3 ,Email3, Address3); // The creation of a new object and its arguments
		
		if (Project_Name == " ") // If statement, if the user's input for the attribute Project Name  is an empty string
			Project_Name = Building_Type + " " + Surname3; // Then it should be this string
		
		System.out.print("Please update the deadline of the project: ");// Print the string
		String update_deadline = input.next(); // Ask the user for input for the update of the deadline
		Deadline = update_deadline;// Update the attribute
		
		System.out.print("Please update the total amount paid of the fee to date: ");// Print the string
		float update_total = input.nextFloat(); // Ask the user for input for the update of the total amount
		Total_Amount = update_total; // Update the total amount attribute
		
		System.out.print("Please update the contractor's contact details");// Print the string
		System.out.print("Please update the contractor's telephone number: ");// Print the string
		String update_telephone = input.next(); // Ask the user for the update for the telephone number 
		Telephone_Num2 = update_telephone; // Update the telephone number 
		System.out.print("Please update the contractor's email address: ");// Print the string
		String update_email = input.next(); // Ask the user
		Email2 = update_email; // Update the email attribute
		
		System.out.print(project1.toString() + "\n"); // Call the toString method to print 
		}
	}
