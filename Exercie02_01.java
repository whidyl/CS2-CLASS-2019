/* 2.1 (Convert Celsius to Fahrenheit) Write a program that reads a Celsius degree 
 * in a double value from the console, then converts it to Fahrenheit, and displays 
 * the result. */

import java.util.Scanner;
public class Exercie02_01 {
	public static void main(String[] args) {
		// get input
		System.out.println("Please enter a degree in celsius to be converted to fahrenheit: ");
		Scanner input = new Scanner(System.in);
		
		// calculate conversion and display
		double celsius = input.nextDouble();
		double fahrenheit = (9.0/5) * celsius + 32;
		System.out.println(celsius + " degrees C is " + fahrenheit + " degrees F.");
		input.close();
	}
}
