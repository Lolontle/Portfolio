
public class Person {
	// Attributes
	String Name;
	String Surname;
	String Stakeholder;
	String Telephone_Num;
	String Email;
	String Address;
    // Methods
	public String getName() {
		return Name;
	}
	public String getSurname() {
		return Surname;
	}
	public String getStakeholder() {
		return Stakeholder;
	}
	public String getTelephone_num() {
		return Telephone_Num;
	}
	public String getEmail() {
		return Email;
	}
	public String getAddress() {
		return Address;
	}
	// Constructor
	public Person (String Name, String Surname,String Stakeholder, String Telephone_Num, String Email, String Address) {
		this.Name = Name;
		this.Surname = Surname; 
		this.Stakeholder = Stakeholder;
		this.Telephone_Num = Telephone_Num;
		this.Email = Email;
		this.Address = Address;
	} // Block of code
	public String toString() {
		String output = "Name: " + Name;
		output += "\nSurname: " + Surname;
		output += "\nStakeholder: " + Stakeholder;
		output += "\nTelephone number: " + Telephone_Num;
		output += "\nEmail Address: " + Email;
		output += "\nPhysical Address: " + Address;
		return output;
	}
}
