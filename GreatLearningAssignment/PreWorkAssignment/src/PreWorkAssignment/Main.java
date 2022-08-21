package PreWorkAssignment;

import java.util.Scanner;

public class Main {

	Scanner sc = new Scanner(System.in);


	public void checkPalindrome() {
		int rem=0;
		int sum=0;
		int t;    
		int number = 1221;
		  
		  t=number;    
		  while(number>0){    
		   rem=number%10;  
		   sum=(sum*10)+rem;    
		   number=number/10;    
		  }    
		  if(t==sum)    
		   System.out.println("Answer: palindrome number ");    
		  else    
		   System.out.println("Answer: not palindrome"); 
	}


	public void printPattern() {
		int n = 5;
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}


	public void checkPrimeNumber() {
		int n = 91;
		boolean temp = false;
	    for (int i = 2; i <= n / 2; ++i) {
	      if (n % i == 0) {
	        temp = true;
	        break;
	      }
	    }

	    if (!temp)
	      System.out.println(n + " is prime number.");
	    else
	      System.out.println(n + " is prime number.");

	}


	public void printFibonacciSeries() {


		int first = 0, second = 1;
		int third,i,temp=10;   
		 
		 System.out.print("Fibonacci: "+first+" "+second);
		    
		 for(i=2;i<temp;++i)
		 {    
		  third=first+second;    
		  System.out.print(" "+third);    
		  first=second;    
		  second=third;    
		 }  

	}


	public static void main(String[] args) {

		Main obj = new Main();

		int choice;

		Scanner sc = new Scanner(System.in);

		do {

			System.out.println("Enter your choice from below list.\n" + "1. Find palindrome of number.\n"

					+ "2. Print Pattern for a given no.\n" + "3. Check whether the no is a  prime number.\n"

					+ "4. Print Fibonacci series.\n" + "--> Enter 0 to Exit.\n");

			System.out.println();

			choice = sc.nextInt();

			switch (choice) {

			case 0:

				choice = 0;

				break;

			case 1: {

				obj.checkPalindrome();

			}

				break;

			case 2: {

				obj.printPattern();

			}

				break;

			case 3: {

				obj.checkPrimeNumber();

			}

				break;

			case 4: {

				obj.printFibonacciSeries();

			}

				break;

			default:

				System.out.println("Invalid choice. Enter a valid no.\n");

			}

		} while (choice != 0);

		System.out.println("Exited Successfully!!!");

		sc.close();

	}

}
