package MainPackage;

// Import the Scanner
import java.util.Scanner;

public class Tuition {
	// Private attributes with getters and setters
	private int Initial_Tuition;

	public int getInitial_Tuition() {
		return Initial_Tuition;
	}

	public void setInitial_Tuition(int Initial_Tuition) {
		this.Initial_Tuition = Initial_Tuition;
	}

	private double Increase_In_Tuition;

	public double getIncrease_In_Tuition() {
		return Increase_In_Tuition;
	}

	public void setIncrease_In_Tuition(double Increase_In_Tuition) {
		this.Increase_In_Tuition = Increase_In_Tuition;
	}

	private int Repayment_Schedule;

	public int getRepayment_Schedule() {
		return Repayment_Schedule;
	}

	public void setRepayment_Schedule(int Repayment_Schedule) {
		this.Repayment_Schedule = Repayment_Schedule;
	}

	private double APR;

	public double getAPR() {
		return APR;
	}

	public void setAPR(double APR) {
		this.APR = APR;
	}

	// Method to Calculate total cost of tuition
	public double Total_Tuition() {
		// Set up some variables.
		int i;
		double total_tuition = 0;
		double new_tuition;
		double Initial_Tuition;
		// getIncrease_In_Tuition() is divided by 100 to get the decimal value
		double annual_increase_in_tuition = 1 + (getIncrease_In_Tuition() / 100);
		/*
		 * Set up the Initial_Tuition variable equal to the initial tuition
		 * entered by the user.
		 */
		Initial_Tuition = getInitial_Tuition();
		// Using a for loop to calculate the total tuition cost
		for (i = 0; i < 4; i++) {
			new_tuition = Initial_Tuition * annual_increase_in_tuition;
			total_tuition = total_tuition + new_tuition;
			Initial_Tuition = new_tuition;
		}
		// Get a double value with 2 decimal places
		total_tuition = (int) (total_tuition * 100);
		total_tuition = total_tuition / 100;

		// Return the total tuition cost
		return total_tuition;

	}

	// Method to calculate the monthly payment
	public double Monthly_Payment(double total_tuition, int Repayment_Schedule, double APR) {
		double monthly_payment;
		double monthly_rate = (APR / 100) / 12;
		int number_of_payments = 12 * Repayment_Schedule;
		monthly_payment =  (total_tuition * monthly_rate) / (1 - Math.pow(1 + monthly_rate, -number_of_payments));
		
		// Get a double value with 2 decimal places
		monthly_payment = (int) (monthly_payment * 100);
		monthly_payment = monthly_payment / 100;
		
		// Return the monthly payment
		return monthly_payment;
	}

	// Main method
	public static void main(String[] args) {
		// Create a scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user for the initial tuition
		System.out.print("Enter the initial cost of tuition: $");
		int Initial_Tuition = input.nextInt();

		// Prompt the user for the increase in tuition
		System.out.print("Enter the percentage increase in tuition (Ex: " 
		+ "10% entered as 10): ");
		double Increase_In_Tuition = input.nextDouble();

		// Prompt the user for the number of years that the loan will be paid
		System.out.print("Enter in how many years the loan will be paid: ");
		int Repayment_Schedule = input.nextInt();

		// Prompt the user for the annual payment rate
		System.out.print("Enter the annual payment rate (Ex: 3.5% "
				+ "entered as 3.5): ");
		double APR = input.nextDouble();
		input.close();

		// Create an instance
		Tuition student = new Tuition();

		// Change the private fields
		student.Initial_Tuition = Initial_Tuition;
		student.Increase_In_Tuition = Increase_In_Tuition;
		student.Repayment_Schedule = Repayment_Schedule;
		student.APR = APR;

		// Print out the total tuition cost and the monthly payment
		
		System.out.print("The total cost of tuition: ");
		System.out.printf("$%.2f", student.Total_Tuition());
		
		// Make a variable for the total tuition cost
		double cost_of_tuition = student.Total_Tuition();
		System.out.print("\nThe monthly payment would be: ");
		System.out.printf("$%.2f", student.Monthly_Payment
				(cost_of_tuition, Repayment_Schedule, APR));
		}

}
