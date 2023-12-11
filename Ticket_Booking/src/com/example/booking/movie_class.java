package com.example.booking;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class movie_class {
	
	
	String language_choose()     {
		
		Scanner jj=new Scanner(System.in);
		int choose=jj.nextInt();
		
		if(choose==1) {
			return "Hindi";
		}
		else if(choose==2) {
			return "Tamil";
		}
		else if(choose==3) {
			return "Telugu";
		}
		else if(choose==4){
			return "English";
		}
		else {
			throw new InputMismatchException("exception accoured") ;
		}
		}

	
	
	void Movie_choose(String M_choose) {
		if(M_choose=="Hindi") {
			System.out.println("\nchoose the movie \n 1.Brahmastra \t2.Laal Singh chaddha \t3.Villain \t4.The kashmire files");
		}
		else if(M_choose=="Tamil") {
			System.out.println("\nchoose the movie \n 1.Nane Varuvan \t2.Varisu \t3.Thunivu \t4.ponniyan selvan");

		}
		else if(M_choose=="Telugu") {
			System.out.println("\nchoose the movie \n 1.The warrior \t2.RRR \t3.Pushpa \t4.ThankYou");
		}
		else {
			System.out.println("\nchoose the movie \n 1.Thor \t2.SpiderMan \t3.SuperMan \t4.IronMan");
		}
			}
	
	
	
	 String movie_selections(String language)  {
		 Scanner mm=new Scanner(System.in);
		 int movie=mm.nextInt();
		if(movie==1 && language=="Hindi") {
			return"Brahmastra";
		}
		else if(movie==2 && language=="Hindi") {
		return"Laal Singh chaddha";	
		}
		else if(movie==3 && language=="Hindi") {
          return"Villain";
           }
		else  if(movie==4 && language=="Hindi") {
        return"The kashmire files";
          }
		else if(movie==1 && language=="Tamil") {
			return "Nane Varuvan";
        }
		else if(movie==2 && language=="Tamil") {
			return "Varisu";
        }
		else if(movie==3 && language=="Tamil") {
			return "Thunivu";
        }
		else if(movie==4 && language=="Tamil") {
			return "ponniyan selvan";
        }
		else if(movie==1 && language=="English") {
			return "Thor";
		}
		else if(movie==2 && language=="English") {
			return "SpiderMan";
		}
		else if(movie==3 && language=="English") {
			return "SuperMan";
		}
		else if(movie==4 && language=="English") {
			return "IronMan";
		}
		else if(movie==1 && language=="Telugu") {
			return "The warrior";
		}
		else if(movie==2 && language=="Telugu") {
			return "RRR";
		}

		else if(movie==3 && language=="Telugu") {
			return "Pushpa";
		}
		else if(movie==4 && language=="Telugu")  {
			return "ThankYou";
		}
		else {
			throw new InputMismatchException("exception accoured") ;
		}
	}
	 
	 
	 
	 
	String  promo_selections(int amount) {
		Scanner cc=new Scanner(System.in);
		Scanner ll=new Scanner(System.in);
		String bank_name,account_name;
		int year,month,date,promo_choose;		
		System.out.println("\n\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("If you have offer promo code? \n1.Yes  \t2.No");
		promo_choose=ll.nextInt();
		if(promo_choose==1) {
			System.out.println("Enter the bank name: ");
			bank_name=cc.nextLine();
			if (bank_name.equals("Axis") == false /* || bank_name.equals("HDFC")==false */) {
				return "your bank does not have any promo code";
			}
			System.out.println("Enter the bank account: ");
			account_name=cc.nextLine();
			if(account_name.equals("BOOKMYSHOW")==false) {
				return "your account name does not have promocode";
			}	 
			System.out.println("The promo_Code which is allocated for is valid from 01/11/2022 to 30/11/2022");			
			  System.out.println("Enter the year:"); year=cc.nextInt();
			  System.out.println("Enter the month:"); month=cc.nextInt();
			  System.out.println("Enter the date:"); date=cc.nextInt(); 
			  LocalDate now=LocalDate.of(year, month, date); LocalDate from=LocalDate.of(2022, 10,31);
			  LocalDate to=LocalDate.of(2022, 12, 01);	
			  if(now.isAfter(from)==false  ) {
				  return "Your promo code date is not yet started...";
			  }
			  else if(now.isBefore(to)==false) {
				  return "Your promo code is expired";
			  }
			  else { return "Win"; }
			  
	      }
  else if(promo_choose==2) {
			return "nothing";
		}
   else {
			throw new InputMismatchException("exception accoured") ;
		}
	}
	
	
	
	
	int snacks() {
		Scanner vv=new Scanner(System.in);
		int choose;
		System.out.println("If you want to buy snacks: ");
		System.out.println("1.Yes     2.No");
		choose=vv.nextInt();
   if(choose==1) {
		int snacksy;
	System.out.println("Enter the snacks you want: ");
	System.out.println("1.cheese_popcorn= Rps.150\t 2.Cold_coffee= Rps.200");
	snacksy=vv.nextInt();
	    if(snacksy==1) {
		return 150;
	      }
	     else if(snacksy==2) {
		return 200;
	      }
	     else {
				throw new InputMismatchException("exception accoured") ;
			}
		}
    else if(choose==2) {
			return 0;
		}
	else {
			throw new InputMismatchException("exception accoured") ;
		}
	}
	
	
	
	
	
	
	
	public void billing(int promo_bal,String state, String district, String theatre, String language, String movie_select, int seat,
			int seat_amount, int GST, int Ac_Tax, int snackst, int total_amount) {
System.out.println("-----------------------------------------------------------------------------------------------------------");		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("\t\t\t********* ------Bill------ ***********\t\t\t");
		System.out.println("State:              "+state);
		System.out.println("District:           "+district);
		System.out.println("Theate:             "+theatre);
		System.out.println("movie language:     "+language);
		System.out.println("move name:          "+movie_select);
		System.out.println("No of Seats:        "+seat+"\ntotal cost of seats:"+seat_amount+"\nGST:                "+GST+" per person"+"\nAC_Tax:             "+Ac_Tax+" per person"+"\nsnacks amount:      "+snackst+"\npromo code amount:  "+promo_bal+"\ntotal amount:       "+total_amount);
		System.out.println("----------------------------------------------------------------------------------------------");
		
	}



	public int seat_selection(int avail) {
		int seat1;
		Scanner see=new Scanner(System.in);		
		System.out.println("how many seat you want to book, (Seats available: "+(5-avail)+")  [Taxes will be added to the booking]");
		seat1=see.nextInt();
		return seat1;
	}
	
	String[] location() {
		Scanner kk=new Scanner(System.in);
		String state1,district1,theatre1;
		System.out.println("Enter the state name: ");
		state1=kk.nextLine();
		System.out.println("Enter the district name: ");
		district1=kk.nextLine();
		System.out.println("Enter the theatre name: ");
		theatre1=kk.nextLine();
		String arr[]= {state1,district1,theatre1};
		return arr;
	}



	public int[] cancelletion(int total_amount,int seat22,int iter22) {
		int cancel_id;
		int gett[]=new int[2];
		int nott[]=new int[2];
		nott[0]=total_amount;
		nott[1]=iter22;
		Scanner can=new Scanner(System.in);
		System.out.println("If you want to cancel tickets: \n1.yes \n2.no");
		cancel_id=can.nextInt();
		if(cancel_id==1) {
			System.out.println("100Rps has been taken for cancellation");
		gett[0]=total_amount-100;  //total initializing
		gett[1]=iter22-seat22; ///iter initializing
		System.out.println("The cancelled amount: "+gett[0]);
		System.out.println("-------------------------------------------------------------------------------------");
		return gett;
		}
		else {
			System.out.println("you booking is not cancelled...");
			System.out.println("-------------------------------------------------------------------------------------");
         return nott;
		}

	}

}
