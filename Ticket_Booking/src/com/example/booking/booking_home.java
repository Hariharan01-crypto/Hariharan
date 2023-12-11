package com.example.booking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class booking_home {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		movie_class obj=new movie_class();
		
	
		String movie_select,total_amount1;
		int seat=0,GST=10,Ac_Tax=20,avail,promo_bal=0,snackst,total_amount, seat_amount,iter=0;
		while(iter<5){	
			Scanner sc=new Scanner(System.in);
			String state=null,district=null,theatre=null,language=null;
			System.out.println("\t\t\t -----WELCOME TO BOOKMYSHOW----- \t\t\t");
			String[] loco=obj.location();						
			state=loco[0];
			district=loco[1];
			theatre=loco[2];
			System.out.println("\nEnter the language \n 1.hindi \t2.tamil \t3.telugu \t4.english");
			try {
			language = obj.language_choose();
			}catch(InputMismatchException ii) {
				System.out.println("You have entered wrong input...please enter a valid number value...\n");
				System.out.println("\nEnter the language \n 1.hindi \t2.tamil \t3.telugu \t4.english");
				try {
				language = obj.language_choose();
				}
				catch(InputMismatchException i2) {
				System.out.println("enough chance is given, now you can only enter input from first...");
				System.out.println("\n\n\n\n================redo==================");
				System.out.println("\n\n");
				continue;
				}
			}
			System.out.println("the language is: "+language);
			
			
			obj.Movie_choose(language);
			try {
			movie_select=obj.movie_selections(language);
			}catch(InputMismatchException ii) {
				System.out.println("You have entered wrong input...please enter a valid number value...\n");
				try {
				obj.Movie_choose(language);
				movie_select=obj.movie_selections(language);
				}
				catch(InputMismatchException i2) {
					System.out.println("enough chance is given, now you can only enter input from first...");
					System.out.println("\n\n\n\n================redo==================");
					System.out.println("\n\n");
					continue;
					}
			}
			System.out.println("The move name is: "+movie_select);
			System.out.println();
		    avail=iter;
		    try {
		    seat=obj.seat_selection(avail); 
		    }catch(InputMismatchException i1) {
		    	try {
		    	System.out.println("You have entered wrong input...please enter a valid number value...\n");
			    seat=obj.seat_selection(avail); 
		    	}
		    	catch(InputMismatchException i2) {
					System.out.println("enough chance is given, now you can only enter input from first...");
					System.out.println("\n\n\n\n================redo==================");
					System.out.println("\n\n");
					continue;
					}
		    }
			iter=seat+iter;
			if(iter==5) {
				System.out.println("Seats are full, cant book anymore");
			}
			
			  if(iter>5) { break; }
			 
			seat_amount=seat*120;
			total_amount=(seat*120)+(GST+Ac_Tax*seat);
			System.out.println("=============================================================================================\n");
			System.out.println("The Gst is: "+GST*seat+" and AC_Tax: "+Ac_Tax*seat);
			System.out.println("The total seat cost is: "+seat*120);
			System.out.println("Total amount including gst: "+total_amount);
			System.out.println("\n\n=============================================================================================\n");
			try {
			System.out.println("You have entered wrong input...please enter a valid number value...\n");
			snackst=obj.snacks();}
			catch(InputMismatchException ii) {
				try {
				System.out.println("You have entered wrong input...please enter a valid number value...\n");
				snackst=obj.snacks();
				}
				catch(InputMismatchException i2) {
					System.out.println("enough chance is given, now you can only enter input from first...");
					iter=Math.abs(iter-seat);
					System.out.println("\n\n\n\n================redo==================");
					System.out.println("\n\n");
					continue;
					}
			}
			if(snackst==0) {
				System.out.println("your missing a osm snacks, but its okay to skip");
			}else {
			total_amount=total_amount+snackst;
			System.out.println("After buying snacks: "+total_amount);
			}
						
			try {
			System.out.println("You have entered wrong input...please enter a valid number value...\n");
			total_amount1=obj.promo_selections(total_amount);
			}catch(InputMismatchException ii){
				try {
				System.out.println("You have entered wrong input...please enter a valid number value...\n");
				total_amount1=obj.promo_selections(total_amount);
				}catch(InputMismatchException i2) {
					System.out.println("enough chance is given, now you can only enter input from first...");
					iter=Math.abs(iter-seat);
					System.out.println("\n\n\n\n================redo==================");
					System.out.println("\n\n");
					continue;
					}
			}
			if(total_amount1=="Win") {
				System.out.println("Promo Code is activited...");
				promo_bal=20;
				total_amount=total_amount-promo_bal;
			}
			else if(total_amount1=="nothing") {
			}
			else {
				System.out.println(total_amount1);
			}
			
			
			obj.billing(promo_bal,state,district,theatre,language,movie_select,seat,seat_amount,GST,Ac_Tax,snackst,total_amount);
			try {
			System.out.println("You have entered wrong input...please enter a valid number value...\n");
		int[] cancelling=obj.cancelletion(total_amount,seat,iter);
			 total_amount=cancelling[0];
		     iter=cancelling[1];
			}catch(InputMismatchException i5) {
				try {
				int[] cancelling1=obj.cancelletion(total_amount,seat,iter);
				total_amount=cancelling1[0];
			     iter=cancelling1[1];}
				catch(InputMismatchException i9) {
					System.out.println("enough chance is given, now you can only enter input from first...");
					iter=Math.abs(iter-seat);
					System.out.println("\n\n\n\n================redo==================");
					System.out.println("\n\n");
					continue;
					}
			}
		
			
						System.out.println("-------Thank You for Visiting our Website-------\n\n\n");
						
		}
		
		    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("\t\t\t\t\t\tthe show is house full...");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}



}
