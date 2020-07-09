
public class Project {
	// Attributes
	String Project_Number;
	String Project_Name;
	String Building_Type;
	String Address;
	String ERF_Number;
	double Fee_Charged;
	double Total_Amount;
	String Deadline;
    // Methods
	public String getProject_Number() {
		return Project_Number;
	}
	public String getProject_Name() {
		return Project_Name;
	}
	public String getBuilding_Type() {
		return Building_Type;
	}
	public String getAddress() {
		return Address;
	}
	public String getERF_Number() {
		return ERF_Number;
	}
	public double getFee_Charged() {
		return Fee_Charged;
	}
	public double getTotal_Amount() {
		return Total_Amount; 
	}
	public String getDeadline() {
		return Deadline;
	}
	//Constructor
	public Project (String Project_Number, String Project_Name, String Building_Type, String Address, String ERF_Number, double Fee_Charged, double Total_Amount, String Deadline) {
		this.Project_Number = Project_Number;
		this.Project_Name = Project_Name;
		this.Building_Type = Building_Type;
		this.Address =  Address;
		this.ERF_Number = ERF_Number;
		this.Fee_Charged = Fee_Charged;
		this.Total_Amount = Total_Amount;
		this.Deadline = Deadline;
	}
	// Method to print out data, which saved in the variable output 
	public String toString() {
		String output = "The Project Number is: " + Project_Number;
		output += "\nThe Project Name is: " + Project_Name;
		output += "\nThe Building Type is: " + Building_Type;
		output += "\nThe Address is: " + Address;
		output += "\nThe ERF Number is: " + ERF_Number;
		output += "\nThe total fee being charged is: " + Fee_Charged;
		output += "\nThe total amount paid is: " + Total_Amount;
		output += "\nThe Deadline is: " + Deadline;
		output += "\nThe total amount that's still due is: " + (Total_Amount - Fee_Charged);
		return output;
	}
}

