import java.io.File;
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
	
			try { // Try to write to the text file
				Formatter f = new Formatter(file_path);
				f.format("%s, %s, %s, %s, %s, %s, %s, %s, ", Project_Number, Project_Name, Building_Type, Address, ERF_Number, Fee_Charged, Total_Amount, Deadline);
				f.format("%s, %s, ", finalization, completion);
				f.format("%s, %s, %s, %s, %s, %s, %s, ", Name1, Surname1, Stakeholder1, Telephone_Num1, Email1, Address1);
				f.format("%s, %s, %s, %s, %s, %s, %s, ", Name2, Surname2, Stakeholder2, Telephone_Num2, Email2, Address2);
				f.format("%s, %s, %s, %s, %s, %s, %s, %s", Name3, Surname3, Stakeholder3, Telephone_Num3, Email3, Address3, "\r\n");
			}
			catch (Exception e) { // If writing to the file fails then print the string
				System.out.print("Error, the details were not written to the file");
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
			
			String[] updates; //Create an array
			try { // Try to read the file
				File f = new File(file_path + "\\CompletedProject.txt"); // Initialize the file
				Scanner sc = new Scanner(f); // Create the scanner to read the text file
				while(sc.hasNext()) { // Iterate through the text file
					String OldLine = sc.nextLine(); //Save each file to the variable
					StringBuffer buffer = new StringBuffer(); // Create a String buffer
					updates = OldLine.split(","); // Split the line and have each element to the array
					//If the first element equals the project number entered or the project name equals the project name then 
					// then replace each element with the corresponding detail
					if((updates[0].equals(option_U)) || (updates[1].equals(option_U)))
						updates[7] = updates[7].replace(updates[7], update_deadline);
						updates[6] = updates[6].replace(updates[6], update_total2);
						updates[19] = updates[19].replace(updates[19], update_telephone);
						updates[20] = updates[20].replace(updates[20], update_email);
						updates[9] = updates[9].replace(updates[9], update_completion);
						updates[8] = updates[8].replace(updates[8], update_finalization);
						String NewLine = updates[0] + ", "; // Save the details of the project in a string by using iteration
						for(int i = 1; i < updates.length; i++) {
							NewLine += updates[i] + ", ";
							if (i == (updates.length - 1)) 
								NewLine += updates[i];
						}
						// Replace the variable OldLine with the NewLine variable
						buffer.append(sc.nextLine()+System.lineSeparator());
						String filecontents = buffer.toString();
						filecontents.replaceAll(OldLine, NewLine);
						FileWriter writer = new FileWriter(file_path + "\\CompletedProject.txt");
						writer.append(filecontents);
						writer.flush();				
				}
				sc.close(); // Close the scanner
			}
			catch (Exception e) { // Catch if there is an error  updating the information
				System.out.print("Error, Was not able to update information!");
			}
			{
	if (option.equals("SU")) { // If option equals See uncompleted tasks
			String completed_word[];  // create an array each of the values
			try { // Try block
				File f = new File(file_path + "\\CompletedProject.txt"); // Initialize the opening of the text file
				Scanner sc = new Scanner(f); //Initialize the scanner
				while(sc.hasNext()) { // Reiterate through the text file
					String line = sc.next();// Save the line to a string
					completed_word = line.split(","); //Split the string
					if (completed_word[8].equals("No")) // If the element equals to No Then print out the details
							System.out.print("Project Number: " + completed_word[0]);
							System.out.print("\nProject Name: " + completed_word[1]);
							System.out.print("\nBuilding Type: " + completed_word[2]);
							System.out.print("\nAddress: " + completed_word[3]);
							System.out.print("\nERF Number: " + completed_word[4]);
							System.out.print("\nFee Charged: " + completed_word[5]);
							System.out.print("\nTotal Amount: " + completed_word[6]);
							System.out.print("\nDeadline: " + completed_word[7]);
							System.out.print("\n");
							System.out.print("\nFinalization: " + completed_word[8]);
							System.out.print("\nCompletion Date: " + completed_word[9]);
							System.out.print("\n");
							System.out.print("\nArchitect's Name: " + completed_word[10]);
							System.out.print("\nArchitect's Surname: " + completed_word[11]);
							System.out.print("\nArchitect's Telephone Number: " + completed_word[13]);
							System.out.print("\nArchitect's Email: " + completed_word[14]);
							System.out.print("\nArchitect's Physical Address: " + completed_word[15]);
							System.out.print("\n");
							System.out.print("\nContractor's Name: " + completed_word[16]);
							System.out.print("\nContractor's Surname: " + completed_word[17]);
							System.out.print("\nContractor's Telephone Number: " + completed_word[19]);
							System.out.print("\nContractor's Email: " + completed_word[20]);
							System.out.print("\nContractor's Physical Address: " + completed_word[21]);
							System.out.print("\n");
							System.out.print("\nCustomer's Name: " + completed_word[22]);
							System.out.print("\nCustomer's Surname: " + completed_word[23]);
							System.out.print("\nCustomer's Telephone Number: " + completed_word[25]);
							System.out.print("\nCustomer's Email: " + completed_word[26]);
							System.out.print("\nCustomer's Address: " + completed_word[27]);
		}
				sc.close(); // Close the scanner
		}
		catch (Exception e) { // catch exception, if there is an error
			System.out.print("Error, cannot read file and print from file");
		}
	}
	if (option.equals("SDD")) { // If option equals See all the projects which are past their due dates
			
			String due_word[]; { // Create an array
		
				try { // Try block
					File f = new File(file_path + "\\CompletedProject.txt"); // Initialize the text file
					Scanner sc = new Scanner(f); // Create a new scanner
					while(sc.hasNext()) { // While loop to iterate over the text file
						String line = sc.nextLine(); // Save the string to the variable
						due_word = line.split(","); // split the line
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // create a new formmater for dates
						Date date = new Date(); // create the date variable containing today's date
						Date finishing_date = formatter.parse(due_word[7]); // Convert the string into a date
						if(date.compareTo(finishing_date) < 0) { // Compare the dates and if the finishing_date has passed, it will be less than 0 it must print the details of the project
							System.out.print("Project Number: " + due_word[0]);
							System.out.print("\nProject Name: " + due_word[1]);
							System.out.print("\nBuilding Type: " + due_word[2]);
							System.out.print("\nAddress: " + due_word[3]);
							System.out.print("\nERF Number: " + due_word[4]);
							System.out.print("\nFee Charged: " + due_word[5]);
							System.out.print("\nTotal Amount: " + due_word[6]);
							System.out.print("\nDeadline: " + due_word[7]);
							System.out.print("\n");
							System.out.print("\nFinalization: " + due_word[8]);
							System.out.print("\nCompletion Date: " + due_word[9]);
							System.out.print("\n");
							System.out.print("\nArchitect's Name: " + due_word[10]);
							System.out.print("\nArchitect's Surname: " + due_word[11]);
							System.out.print("\nArchitect's Telephone Number: " + due_word[13]);
							System.out.print("\nArchitect's Email: " + due_word[14]);
							System.out.print("\nArchitect's Physical Address: " + due_word[15]);
							System.out.print("\n");
							System.out.print("\nContractor's Name: " + due_word[16]);
							System.out.print("\nContractor's Surname: " + due_word[17]);
							System.out.print("\nContractor's Telephone Number: " + due_word[19]);
							System.out.print("\nContractor's Email: " + due_word[20]);
							System.out.print("\nContractor's Physical Address: " + due_word[21]);
							System.out.print("\n");
							System.out.print("\nCustomer's Name: " + due_word[22]);
							System.out.print("\nCustomer's Surname: " + due_word[23]);
							System.out.print("\nCustomer's Telephone Number: " + due_word[25]);
							System.out.print("\nCustomer's Email: " + due_word[26]);
							System.out.print("\nCustomer's Address: " + due_word[27]);
							}
						}
					sc.close(); // Close the scanner
					}
				catch (Exception e1) { // Catch exception to catch errors
					System.out.print("Error, Cannot read from file and print from file"); // Print string if there is an error
				}
			}
			}
		}
		if (option.equals("F")) { // If user selects Find a project
			System.out.print("Please enter a Project Number or Project Name: "); // Print the string
			String option_F = input.next(); // Allow user to input 
			String find[]; // Create an array
			try { // Try block to read text file
				File f = new File(file_path + "\\CompletedProject.txt"); // Initialize the text file
				Scanner sc = new Scanner(f); // Initialize the text file
				while(sc.hasNext()) { // while loop to reiterate through the text file
					String line = sc.nextLine(); // Store string line
					find = line.split(","); // Split the line 
					if ((option_F.equals(find[0]) || (option_F.equals(1)))) { // If the project number or project name is in the line then print the details
						System.out.print("Project Number: " + find[0]);
						System.out.print("\nProject Name: " + find[1]);
						System.out.print("\nBuilding Type: " + find[2]);
						System.out.print("\nAddress: " + find[3]);
						System.out.print("\nERF Number: " + find[4]);
						System.out.print("\nFee Charged: " + find[5]);
						System.out.print("\nTotal Amount: " + find[6]);
						System.out.print("\nDeadline: " + find[7]);
						System.out.print("\n");
						System.out.print("\nFinalization: " + find[8]);
						System.out.print("\nCompletion Date: " + find[9]);
						System.out.print("\n");
						System.out.print("\nArchitect's Name: " + find[10]);
						System.out.print("\nArchitect's Surname: " + find[11]);
						System.out.print("\nArchitect's Telephone Number: " + find[13]);
						System.out.print("\nArchitect's Email: " + find[14]);
						System.out.print("\nArchitect's Physical Address: " + find[15]);
						System.out.print("\n");
						System.out.print("\nContractor's Name: " + find[16]);
						System.out.print("\nContractor's Surname: " + find[17]);
						System.out.print("\nContractor's Telephone Number: " + find[19]);
						System.out.print("\nContractor's Email: " + find[20]);
						System.out.print("\nContractor's Physical Address: " + find[21]);
						System.out.print("\n");
						System.out.print("\nCustomer's Name: " + find[22]);
						System.out.print("\nCustomer's Surname: " + find[23]);
						System.out.print("\nCustomer's Telephone Number: " + find[25]);
						System.out.print("\nCustomer's Email: " + find[26]);
						System.out.print("\nCustomer's Address: " + find[27]);
					}
					
				}
				sc.close(); // Close the scanner
			}
			catch (Exception e) { // Catch block if there is an error reading and printing from the line
				System.out.print("Error, was not able to read and print from file");
			}
		}
	}
}
