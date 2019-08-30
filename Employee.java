
public class Employee {
	// Stores and manages basic data for an employee
	private String firstNameField;
	private String lastNameField;
	private double salaryField;
	
	Employee(String firstName, String lastName, double initialSalary){
		setFirst(firstName);
		setLast(lastName);
		setMonthlySalary(initialSalary);
	}
	
	public String getFirst() {
		return firstNameField;
	}

	public void setFirst(String firstName) {
		// firstName should not be null or empty.
		if (firstName == null || firstName.isEmpty()) {
			System.out.println("First name field should not be set to null or empty.");
			firstNameField = null;
		} else {
			firstNameField = firstName;
		}
	}

	public String getLast() {
		return lastNameField;
	}

	public void setLast(String lastName) {
		// lastName should not be null or empty
		if (lastName == null || lastName.isEmpty()) {
			System.out.println("Last name field should not be set to null or empty.");
			lastNameField = null;
		} else {
			lastNameField = lastName;
		}
	}

	public double getMonthlySalary() {
		return salaryField;
	}

	public void setMonthlySalary(double salary) {
		if (salary < 0) {
			salaryField = 0;
			System.out.println("Employee cannot have a negative salary, their monthly salary was set to 0.");
		} else {
			salaryField = salary;
		}
		
	}
	
	public String toString() {
		// Converts Employee object to a string.
		return getClass().getName()+"@"+Integer.toHexString(hashCode()) + " " + getFirst() + " " + getLast();
	}
	
	public void displayValues() {
		// Displays employee's data.
		String employeeName = "";
		String monthlySalary = String.format("%.2f", getMonthlySalary());
		String annualSalary = String.format("%.2f", getMonthlySalary()*12.0);
		
		if (getFirst() != null) {
			employeeName += getFirst();
		} else {
			employeeName += "<Invalid first name>";
		}
		if (getLast() != null) {
			employeeName += " " + getLast();
		} else {
			employeeName += " <Invalid last name>";
		}
		System.out.println("Employee: " + employeeName + "; Monthly Salary: " + monthlySalary + "; Annual Salary: " + annualSalary);
	}

}
