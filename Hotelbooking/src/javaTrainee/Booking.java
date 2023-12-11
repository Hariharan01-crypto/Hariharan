package javaTrainee;



import java.util.Scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;


public class Booking {

	ArrayList<Index1> index = new ArrayList<Index1>();
	ArrayList<Booking> bookings = new ArrayList<Booking>();

	Scanner scanner = new Scanner(System.in);

	public String name;
	public int hotelNo;
	public Date date;
	public int age;
	public long phoneNo;
	public int regs;
	public String address;

	public Booking display(Booking booking) {

		System.out.println("\t\t\t***from Customer details***\n\n");

		try {
			System.out.println("eligibile! checking please  enter the age :");
			age = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println(" You are input mismatch !! please check input Type ");
			age = booking.handling(booking);
		} catch (NullPointerException e) {
			System.out.println("alread delete");

		}

		if (18 <= age) {
			System.out.println("you are eligibile! \n\nEnter register No: ");

			try {
				regs = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(" You are input mismatch !! please check input Type ");
				regs = booking.handling(booking);
			}
			System.out.println("Enter name: ");
			name = scanner.next();
			try {
				System.out.println("Enter phone no: ");
				phoneNo = scanner.nextLong();
			} catch (InputMismatchException e) {
				System.out.println(" You are input mismatch !! please check input Type ");
				phoneNo = booking.handlingLong(booking);
			}
			System.out.println("Enter address no: ");
			address = scanner.next();
		} else {
			System.out.println("soory !not eligibile ");
		}

		System.out.println("------------------------------------------------------------------------");
		return booking;
	}

	public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Index1> index, Booking booking) {

		try {
			try {
			System.out.println("Enter hotelNo no: ");
			hotelNo = scanner.nextInt();
			}catch (InputMismatchException e) {
				System.out.println(" You are input mismatch !! please check input Type ");
				hotelNo  = booking.handling(booking);
			}
			System.out.println("Enter date dd-mm-yyyy");
			scanner = new Scanner(System.in);
			String dateInput = scanner.next();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {

			System.out.println("checking you are date formate");
		}  catch (Exception e) {
			System.out.println(" You are input mismatch ! please check input Type ");
		}

		int capacity = 0;
		for (Index1 bus : index) {
			if (bus.getNo() == hotelNo)
				capacity = bus.getCapacity();
		}

		int booked = 0;
		for (Booking b : bookings) {
			if (b.hotelNo == hotelNo && b.date.equals(date)) {
				booked++;
			}
		}

		return booked < capacity ? true : false;

	}

	public int stayingDays() {

		System.out.println("per day amount : 1000rs \n\nEnter the days");
		int result = scanner.nextInt();
		return result = result * 1000;
	}

	public int playingArea() {

		System.out.println("\t\t\t*footBall ---> enter the playing time \n\nper hour 100rs \n\nenter playing hours :");
		int footBall = scanner.nextInt();
		int num = footBall * 100;

		return num;

	}

	public int partyArea() {

		System.out.println(
				"\t\t\t*enter no 1 From Marriage \t\t\t\t* enter no 2 From Brithday celebration \n\nper hour 1000rs \n\nEnter No 0 From Exit :");
		int mar = scanner.nextInt();
		if (mar == 1) {
			System.out.println("enthe the party hours :");

			int num1 = scanner.nextInt();
			num1 = num1 * 1000;
			return num1;
		} else if (mar == 2) {
			System.out.println("enthe the party hours :");

			int num1 = scanner.nextInt();
			num1 = num1 * 1000;
			return num1;
		} else {
			System.out.println("");
		}
		return 0;

	}

	private int handling(Booking booking) {
		scanner = new Scanner(System.in);
		System.out.println("Enter again No: ");
		int sum = scanner.nextInt();
		return sum;
	}

	private long handlingLong(Booking booking) {
		scanner = new Scanner(System.in);
		System.out.println("Enter phone No: ");
		long sum = scanner.nextInt();
		return sum;
	}

	public void totall(Booking booking) {
		System.out.println("--------------------------------------------------------");

		System.out.println("name :" + booking.name + "\n regsiter Number :" + booking.regs + "\n phone number :"
				+ booking.phoneNo + "\n booking date :" + booking.date);

		System.out.println("--------------------------------------------------------");

	}

	public int offer(Booking booking, int reg1) {
		if (reg1 == booking.regs) {
			System.out.println("\t\t\t***HDFC CARD ONLY OFFER*** \n\nEnter you are card name :");
			String offer = "HDFC";
			String offer1 = scanner.next();
			if (offer.equalsIgnoreCase(offer1)) {
				System.out.println("100rs offer");
				int result = 100;
				return result;
			} else {
				System.out.println("this card  not offer");
			}

		}
		return 0;
	}

	public boolean Search(Booking booking, int reg1) {
		if (reg1 == booking.regs) {
			return true;

		}

		return false;
	}
}
