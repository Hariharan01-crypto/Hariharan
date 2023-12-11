package electricity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.text.DateFormat;

public class Electricity{
	public static int unit1;
	public static long billToPay;
	public static String name;
					
	public static long getId() {
		return id;
	}

	public static  void setId(long id) {
		Electricity.id = id;
	}




	static public long id;
	  static public Date date;  
	  static public Date date1;
	  static public  String dateInput;
      static long penalty;
	  static long total;
	  static int pel; 
	
	 void getEletricityBillForVillage( int unit1) {
		  if(unit1>=0) {
			  billToPay= unit1*5;
			  
			  System.out.println("The bill you have to pay is"+billToPay);
				
		  }          
		  else {
			  System.out.println("please enter the valid Units");
		  }
			
		}
	
   public void getEletricityBillForSlum(int unit1) {
	  if(unit1>=0) {
		  billToPay= unit1*10;
		  System.out.println("The bill you have to pay is"+billToPay);
			
	  }
	  else {
		  System.out.println("please enter the valid Units");
	  }
		  
	}
	public void getEletricityBillForCity(int unit1) {
		  if(unit1>=0) {
			  billToPay= unit1*20;
			  System.out.println("The bill you have to pay is"+billToPay);
				
		  }
		  else {
			  System.out.println("please enter the valid Units");
		  }
		
	}
	 
	
	public void penaltyForLatePay() {
		
		
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
		   LocalDate now = LocalDate.now();
		    String var =dtf.format(now);
		   System.out.println(var);  

	       SimpleDateFormat dateFormat = new  SimpleDateFormat("dd-MM-yyyy");
	       try {
	    	   date=dateFormat.parse(dateInput);
	       }catch(ParseException r) {
	    	   System.out.println("please enter the valid date");
	       }
	       try {
	    	   date1=dateFormat.parse(var);
	       }catch(ParseException r) {
	    	   System.out.println("please enter the valid date");
	       }
	    
	        if(date.after(date1)) {
	        	 pel=500;
	        	 penalty= billToPay+pel;
	        	  System.out.println("Penalty Amount is "+ penalty);
	        }
	       
	}
	     
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Electricity e = new Electricity();
		List<String> NameList=new LinkedList<String>();
	    List<Long> IdList=new LinkedList<Long>();
		List<Long> BillList=new LinkedList<Long>();
		List<Long> TotalList=new LinkedList<Long>();
		List<Long> PenaltyList=new LinkedList<Long>();
		
		
			
			int option = 0;
			do {
				Scanner input1 = new Scanner(System.in);
				
				try {
					
					
				 
		  System.out.println("********Enter the name**********");
		  String name=input1.nextLine();
		
		  
		 System.out.println("***********Enter the customer id************ ");
		setId(input1.nextLong());
	
		  System.out.println("************Enter the date dd-MM-yyy*********** ");
		    dateInput  = input1.next();
	
			 long n=e.getId();
			 for(int ii=0;ii<IdList.size();ii++) {
				 if(IdList.get(ii)==n) {
					 System.out.println("ALready paid....");
					 break;
					 }
			 }
					 
		
		System.out.println("Welcome:"+name+"\t"+ "your ID is:"+id); 
		System.out.println("press 1 for Electricity bill for Village candidates \n 1 unit=5");
		System.out.println("press 2 for Electricity bill for city candidates \n 1 unit=20"); 
		System.out.println("press 3 for Electricity bill for slum candidates \n 1 unit=10");
		System.out.println("press 4 for Bill recipt");
		System.out.println("press 5 for exit");
         option =input.nextInt();
         int unit1;
		switch( option){  
         
         case 1:{ System.out.println("Electricity type is village");
                    System.out.println("Enter the units");
         
                    unit1=input1.nextInt();
                    e.getEletricityBillForVillage(unit1);
                     e.penaltyForLatePay();
         break; 
         }
         case 2: {System.out.println("Electricity type is city");  
                  System.out.println("Enter the units");
                     unit1=input1.nextInt();
                    e.getEletricityBillForCity(unit1);
                    e.penaltyForLatePay();
                  
         break;  }
         
         case 3:{ System.out.println("Electricity type is slum");  
                     System.out.println("Enter the units");
                    unit1=input1.nextInt();
                    e.getEletricityBillForSlum(unit1);
                    e.penaltyForLatePay();
         break;  
         }
         
         case 4:{ 
        	 
        	 System.out.println("Bill Recipt");
         
 		System.out.println("=====================================================================");
 		  System.out.println("Name:"+name+"\t"+"ID:"+id+"\t"+
 				  "Amount paid:"+billToPay+"\t"+"PenaltyAmt:"+penalty+"\t"+"Total:"+total);
 		  System.out.println("====================================================================");
         break;  }
         
         case 5:{ System.out.println("Exited");  
         break;  }
      
         default:System.out.println("Thank you for visiting us");  
         }  
		 total=pel+billToPay;
    	 NameList.add(name);
		    IdList.add(id);
		    BillList.add(billToPay);
		    TotalList.add(total);
		    PenaltyList.add(penalty);
		
			switch(option) {
			
			
			case 1: {
   
	        	 System.out.println("Name:"+NameList+"\t"+"id"+IdList+"bill"+ BillList+"total"+ TotalList+"penalty"+PenaltyList);
	        
	         break;
	         }
		

			case 2: {
   
	        	 System.out.println("Name:"+NameList+"\t"+"id"+IdList+"bill"+ BillList+"total"+ TotalList+"penalty"+PenaltyList);
	        
	         break;
	         }

			case 3: {
   
	        	 System.out.println("Name:"+NameList+"\t"+"id"+IdList+"bill"+ BillList+"total"+ TotalList+"penalty"+PenaltyList);
	        
	         break;
	         }
			
			default:System.out.println("Thank you for visiting us");  
			
			}
			}catch(Exception r){
				System.out.println("Please enter the valid value ");
			}
			 }while(option<=5);
	
		
}
	
	
	}



