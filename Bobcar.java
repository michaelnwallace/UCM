

import java.util.Scanner;
public class Bobcar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		Scanner input = new Scanner(System.in);
		
		int car; String name = "";
		System.out.println("Available Cars: Choose 1 for Economy, 2 for Compact, and 3 for Standard");
		
		System.out.print("Please choose which rental car you want: ");
		car = input.nextInt();
		
		int price = 0;
		int base = 0;
		System.out.println();
		if (car == 1){
			price = 25;
			name = "Economy";
		  
		   
		} else if (car == 2) {
			price = 55;
			name = "Compact";
			//base = (price * days);
			//System.out.println("Base: " + ((int)days) + " days for Compact at $55 per day " + "=" + (int)base);
		} else if (car == 3) {
			price = 100;
			name = "Standard";
			//base = (price * days);
			//System.out.println("Base: " + ((int)days) + " days for Standard at $100 per day " + "=" + (int)base);
		}else {
		System.out.println("Wrong input.");
		System.exit(0);
	}
		int days;
		System.out.print("Please choose how many days you want to rent the car: ");
		days = input.nextInt();
		  base = (price * days);
		  
		int club;
		System.out.println("Are you a club member? Choose 1 for yes, and 0 for no: ");
		club = input.nextInt();
		
		int platinum = 0;
		
		if (club == 1) {
		System.out.println("Platinum Executive Package? Choose 1 for yes, and 0 for no: ");
		platinum = input.nextInt();
		} else {
			System.out.println("Wrong input.");
		}
		
		
		
		
		
		
		
		int discount = 0;
		if (club == 1) {
			discount = ((days/5) * price);
			System.out.println("Base: " + ((int)days) + " days for "+ name+ " at $"+price+" per day " + "=" + (int)base);
			System.out.println("Club Member Discount: " + "-" + "$ " + (int)discount);
		} else
			club = 0;
		int platpackage = 0;
		if (platinum == 1) {
			platpackage = (int)(price * days * (.2));
			System.out.println("Platinum Executive Package: " + "$ " + (int)platpackage);
			System.out.print("Total Estimate for Rental: " + "$ " + (int)(base + platpackage - discount));
		} else if (platinum == 0) {
			
		System.out.println();
		System.out.print("Total Estimate for Rental: " + "$ " + (int)(base + platpackage - discount));
		
		}else {
			System.out.println("Wrong input");
		}
		
		
		
		
		

	}

}
