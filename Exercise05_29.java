/* **5.29 (Display calendars) Write a program that prompts the 
 * user to enter the year and first day of the year and displays the 
 * calendar table for the year on the console For example, 
 * if the user entered the year 2013, and 2 for Tuesday, January 1, 2013, 
 * your program should display the calendar for each month in the year. */
import java.util.Scanner;

public class Exercise05_29 {
	
	public static void main(String[] args) {
		// receive input
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a year");
		String year = input.next();
		System.out.println("Enter an integer to signify the first day of the year (Sunday = 0, Monday = 1, Saturday = 6, etc)");
		int firstDay = input.nextInt();
		
		// display calanders
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		for (int month = 0; month < 12; month++) {
			System.out.println("       " + months[month] + " " + year);
			System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
			// offset datetable depending on starting day
			for (int offset = 0; offset<firstDay; offset++) {
				System.out.print("    ");
			}
			// display date table
			int numDays = daysInMonth(Integer.parseInt(year), months[month]);
			for(int day = 1; day < numDays+1; day++) {
				System.out.format("%4d", day);
				if ((day+firstDay)%7 == 0)
					System.out.println();
			}
			// update firstDay so that the next month's calander starts on the correct day
			firstDay = (firstDay+numDays)%7;
			
			System.out.println();
			System.out.println();
		}	
		
		input.close();
	}
	
	public static boolean isLeapYear(int year) {
		// Returns whether or not specified year is a leap year.
		boolean leap;
		if(year % 4 == 0) {
			if(year % 100 == 0) {
				if (year % 400 == 0)
					leap = true;
				else
					leap = false;
			}
			else
				leap = true;
		}
		else leap = false;
		return leap;
	}
	
	public static int daysInMonth(int year, String month) {
		// Returns the number of days in specified month (spelled out, first letter capitalized) during specified year
		switch(month) {
			case "January":
			case "March":
			case "May":
			case "July":
			case "October":
			case "December":
			case "August":
				return 31;
			case "April":
			case "June":
			case "September":
			case "November":
				return 30;
			case "February":
				if (isLeapYear(year)) {
					return 29;
				} else {
					return 28;
				}
			
		}
		return 1;
	}
}