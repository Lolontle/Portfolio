import java.io.File;
import java.sql.*;
import java.sql.Date;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*; // Import module so we are able to the scanner function
public class Poised { // The class 

	public static void main(String[] args) throws ParseException { // The main method
		Scanner input = new Scanner(System.in); // Initialization of the scanner
		Path path = Paths.get(System.getProperty("user.dir"), "CompletedProject.txt" );
		String file_path = path.toString();
		// Print out list of options
		System.out.print("Welcome to the Poised Project Management System\n");
		System.out.print("Please choose an option: \n");
		System.out.print("AP - Add new project \n");
		System.out.print("U - Update details of a project: \n");
		System.out.print("SU - See a list of uncompleted projects \n");
		System.out.print("SDD - See a list of projects which are past their due date \n");
		System.out.print("F - Find and select a project by entering a project name or project number ");
		String option = input.nextLine(); // User input
		if (option.equals("AP"))  // If statement, if the the Add new project is chosen
			System.out.print("Please enter the project details"); // Print out the string
			System.out.print("\nPlease enter a project number: \n"); // Print out the string
			String Project_Number = input.nextLine(); // Ask the user for input for the project number attribute
		
			System.out.print("\nPlease enter project name: \n"); // Print the string
			String Project_Name = input.nextLine(); // Ask the user for input for the attribute Project name
		
			System.out.print("\nPlease enter your building type: (e.g house): \n"); // Print the string
			String Building_Type = input.nextLine(); // Ask the user for input for the attribute
		
			System.out.print("\nPlease enter your address: \n"); //Print the string
			String Address = input.nextLine(); // Ask the user for input for the attribute
		
			System.out.print("\nPlease enter your ERF number: \n"); // Print the string
			String ERF_Number = input.nextLine(); // Ask the user for input for the attribute
		
			System.out.print("\nPlease enter the total fee being charged R"); // Print the string
			double Fee_Charged = input.nextFloat();  // Ask the user for input for the attribute
		
			System.out.print("\nPlease enter the total amount which has been paid R"); // Print the string
			double Total_Amount = input.nextFloat(); // Ask the user for input for the attribute
		
			System.out.print("\nPlease enter the deadline for the project: (e.g 15/07/2020)");// Print the string
			String Deadline = input.nextLine(); // Ask the user for input for the attribute
		 
			Project project1 = new Project(Project_Number, Project_Name, Building_Type, Address, ERF_Number, Fee_Charged, Total_Amount, Deadline); // The creation of a new object and its arguments
		
			System.out.print("\nPlease enter the architect's details"); // Print the string
			System.out.print("\nPlease enter architect name: "); // Print the String
			String Name1 = input.nextLine(); // Ask the user for input for the attribute
		
			System.out.print("\nPlease enter archtect surname: "); // Print the string
			String Surname1 = input.nextLine(); // Ask the user for input for the attribute
		
			String Stakeholder1 = "architect"; // Assign the attribute
		
			System.out.print("\nPlease enter architect telephone number: ");// Print the string
			String Telephone_Num1 = input.nextLine(); // Ask the user for input for the attribute
		
			System.out.print("\nPlease enter architect email address: ");// Print the string
			String Email1 = input.nextLine(); // Ask the user for input for the attribute
		
			System.out.print("\nPlease enter architect physical address: ");// Print the string
			String Address1 = input.nextLine(); // Ask the user for input for the attribute
		
			Person architect = new Person(Name1, Surname1, Stakeholder1, Telephone_Num1, Email1, Address1); // The creation of a new object and its arguments
		
			System.out.print("\nPlease enter the contractor's details"); // Print the string
			System.out.print("\nPlease enter contractor's name: ");// Print the string
			String Name2 = input.nextLine(); // Ask the user for input for the attribute
		
			System.out.print("\nPlease enter the contractor's surname: "); // Print the string
			String Surname2 = input.nextLine();  // Ask the user for input for the attribute
		
			String Stakeholder2 = "contractor"; // Assign the attribute
		
			System.out.print("Please enter the contractor's telephone number: "); // Print the string
			String Telephone_Num2 = input.nextLine(); // Ask the user for input for the attribute
		
			System.out.print("Please enter the contractor's email address: ");// Print the string
			String Email2 = input.nextLine(); // Ask the user for input for the attribute
		
			System.out.print("Please enter the contractor's physical address: ");// Print the string
			String Address2 = input.nextLine(); // Ask the user for input for the attribute
		
			Person contractor = new Person(Name2, Surname2, Stakeholder2, Telephone_Num2, Email2, Address2); // The creation of a new object and its arguments
		
			System.out.print("Please enter the customer's details \n");// Print the string
			System.out.print("Please enter the customer's name: \n");// Print the string
			String Name3 = input.nextLine(); // Ask the user for input for the attribute
		
			System.out.print("Please enter the customer's surname: \n");// Print the string
			String Surname3 = input.nextLine(); // Ask the user for input for the attribute
		
			String Stakeholder3 = "customer"; // Assign the attribute
		
			System.out.print("Please enter the customer's telephone number: \n");// Print the string
			String Telephone_Num3 = input.nextLine(); // Ask the user for input for the attribute
		
			System.out.print("Please enter the customer's email address: \n");// Print the string
			String Email3 = input.nextLine(); // Ask the user for input for the attribute
		
			System.out.print("Please enter the customer's physical address: \n");// Print the string
			String Address3 = input.nextLine(); // Ask the user for input for the attribute
		
			Person customer = new Person(Name3, Surname3, Stakeholder3, Telephone_Num3 ,Email3, Address3); // The creation of a new object and its arguments
			System.out.print("\nIs the project finalized? (Please enter Yes -'Y' or No -'N'): ");
			String finalization = input.nextLine();
			if(finalization.equals("Yes"))
				System.out.print(project1.toString() + "\n"); // Call the toString method to print if the project is finalized
				System.out.print(architect.toString() + "\n"); 
				System.out.print(contractor.toString() + "\n");
				System.out.print(customer.toString() + "\n");
		
			if (Project_Name == " ") // If statement, if the user's input for the attribute Project Name  is an empty string
				Project_Name = Building_Type + " " + Surname3; // Then it should be this string
			String completion = "No";
			
			try {
				Connection connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/poisepms","otheruser", "swordfish");
				Statement statement = connection.createStatement();
				ResultSet results;
				int rowsAffected;
				
				rowsAffected = statement.executeUpdate("INSERT INTO project_details VALUES(" + Project_Number +
						", " + Project_Name + ", " + Building_Type + ", " + Address + ", " + ERF_Number + ", "
						+ Fee_Charged + ", " + Total_Amount + ", " + Deadline + ", " + finalization + ")");
				System.out.println("Query complete, " + rowsAffected + " row added.");
				results.close();
				statement.close();
				connection.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		if (option.equals("U")) // If the update option is chosen
			System.out.print("\nPlease enter the projects name or project number: "); // Print the string
			String option_U = input.nextLine(); // Ask for user input
			System.out.print("\nPlease update the deadline of the project: (e.g. 15/07/2020)");// Print the string
			String update_deadline = input.nextLine(); // Ask the user for input for the update of the deadline
			
		
			System.out.print("\nPlease update the total amount paid of the fee to date: ");// Print the string
			float update_total = input.nextFloat(); // Ask the user for input for the update of the total amount
			String update_total2 = String.valueOf(update_total); // Convert float into string
		
			System.out.print("\nPlease update the contractor's contact details ");// Print the string
			System.out.print("\nPlease update the contractor's telephone number: ");// Print the string
			String update_telephone = input.nextLine(); // Ask the user for the update for the telephone number 

			System.out.print("\nPlease update the contractor's email address: ");// Print the string
			String update_email = input.nextLine(); // Ask the user
			Email2 = update_email; // Update the email attribute
			
			System.out.print("\nIs the project completed? (Please enter 'Y'- Yes or 'N'- No): "); //Print the string
			String update_completion = input.nextLine(); // Ask for the users input
			
			System.out.print("\nIs the project finalized? (Please enter 'Y'- Yes or 'N'- No): "); // Print the string
			String update_finalization = input.nextLine(); // Ask for users input
			
			try {
				Connection connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/poisepms","otheruser", "swordfish");
				Statement statement = connection.createStatement();
				ResultSet results;
				int rowsAffected;
				
				rowsAffected = statement.executeUpdate("UPDATE project_details SET deadline = " + update_deadline + "WHERE project_name = " + option_U);
				rowsAffected = statement.executeUpdate("UPDATE project_details SET total_amount_paid = " + update_total + "WHERE project_name = " + option_U);
				rowsAffected = statement.executeUpdate("UPDATE contractor_details SET contractor_telephone = " + update_telephone + "WHERE project_name = " + option_U);
				rowsAffected = statement.executeUpdate("UPDATE contractor_details SET contractor_email = " + update_email + "WHERE project_name = " + option_U);
				rowsAffected = statement.executeUpdate("UPDATE project_details SET completion = " + update_completion + "WHERE project_name = " + option_U);
				rowsAffected = statement.executeUpdate("UPDATE project_details SET finalization = " + update_finalization + "WHERE project_name = " +  option_U);
				
				System.out.println("Queries complete, rows updated.");
				
				results.close();
				statement.close();
				connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	if (option.equals("SU")) { // If option equals See uncompleted tasks
		try {
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/poisepms","otheruser", "swordfish");
			Statement statement = connection.createStatement();
			ResultSet results;
			int rowsAffected;
			
			results = statement.executeQuery("SELECT * FROM project_details WHERE completion = No");
			while (results.next()) {
				System.out.println(results.getString("project_details"));
		}
			results.close();
			statement.close();
			connection.close();
	}
		catch (SQLException e) {
			e.printStackTrace();
		}
	if (option.equals("SDD")) {// If option equals See all the projects which are past their due dates
		try {
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/poisepms","otheruser", "swordfish");
			Statement statement = connection.createStatement();
			ResultSet results;
			int rowsAffected;
			
			results = statement.executeQuery("SELECT deadline FROM project_details");
			
			java.util.Date today = Calendar.getInstance().getTime();
			while(results.next()) {
				String date = format.parse(results);
				Date date1 = format.parse(date);
				if(today.compareTo(date1))
					System.out.print(results.getString("deadline"));
			}
			results.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			}
			}
	{
		if (option.equals("F")) { // If user selects Find a project
			String option_f = input.next();
			try {
				Connection connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/poisepms","otheruser", "swordfish");
				Statement statement = connection.createStatement();
				ResultSet results;
				int rowsAffected;
			
				results = statement.executeQuery("SELECT * FROM project_details WHERE project_name = " + option_f);	
				
				results.close();
				statement.close();
				connection.close();
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
}
}