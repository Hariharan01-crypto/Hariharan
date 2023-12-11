package javaTrainee;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.time.LocalDateTime;



public class Hotel {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Index1> index = new ArrayList<Index1>();
		ArrayList<Booking> bookings = new ArrayList<Booking>();
	
		index.add(new Index1(1, true, 2));
		index.add(new Index1(2, false, 4));
		index.add(new Index1(3, true, 6));
		Booking cancel = null;
		ArrayList<Booking> book = new ArrayList<Booking>();
		int play = 0, party = 0, result = 0, stay = 0, userOpt = 1, userOpt1 = 0, num = 0, party1 = 0, play1 = 0,
				reg1 = 0;

		Booking booking[] = new Booking[8];
		Integer reg11 = 0;
		boolean found;
		for (int j = 0; j < booking.length; j++) {

			booking[j] = new Booking();
		}

		while (userOpt == 1) {

			do {
				try {
					scanner = new Scanner(System.in);
					Index1 indexs = new Index1();
					userOpt1 = scanner.nextInt();

					switch (userOpt1) {
					case 1:

						cancel = booking[num].display(booking[num]);
						book.add(cancel);
						num++;

						break;

					case 2:
						System.out.println("Enter registar ID");
						scanner = new Scanner(System.in);
						reg1 = scanner.nextInt();
						found = false;
						for (int j = 0; j < booking.length; j++) {
							found = booking[j].Search(booking[j], reg1);
							if (found) {
								for (Index1 b : index) {
									b.displayInfo();

								}
								if (booking[j].isAvailable(bookings, index,booking[j])) {
									bookings.add(booking[j]);

									System.out.println("Your booking is confirmed");
									break;
								}

								else {
									System.out.println("Sorry. room is full. Try another room or date.");
									break;
								}
							}
						}
						if (!found) {
							System.out.println("Search failed! ");
						}
						break;

					case 3:
						scanner = new Scanner(System.in);
						System.out.println("Enter registar ID");
						reg1 = scanner.nextInt();
						found = false;
						for (int j = 0; j < booking.length; j++) {
							found = booking[j].Search(booking[j], reg1);
							if (found) {
								stay = booking[j].stayingDays();
								break;
							}
						}
						if (!found) {
							System.out.println("Search failed! ");
						}
						break;

					case 4:
						scanner = new Scanner(System.in);
						System.out.println("Enter registar ID");
						reg1 = scanner.nextInt();
						found = false;
						for (int j = 0; j < booking.length; j++) {

							found = booking[j].Search(booking[j], reg1);
							if (found) {
								party = booking[j].playingArea();
								party1 = party + stay;
								break;
							}

						}
						if (!found) {
							System.out.println("Search failed!");
						}
						break;

					case 5:

						System.out.println("Enter registar ID");
						reg1 = scanner.nextInt();
						found = false;
						for (int j = 0; j < booking.length; j++) {

							found = booking[j].Search(booking[j], reg1);
							if (found) {
								result = booking[j].offer(booking[j], reg1);
								break;
							}

						}
						if (!found) {
							System.out.println("Search failed! !");
						}
						break;

					case 6:
						scanner = new Scanner(System.in);
						System.out.println("Enter registar ID");

						reg1 = scanner.nextInt();
						found = false;
						for (int j = 0; j < booking.length; j++) {
							found = booking[j].Search(booking[j], reg1);
							if (found) {
								play1 = booking[j].partyArea();
								play = play + party1 + result;
								break;
							}

						}
						if (!found) {
							System.out.println("Search failed! !");
						}
						break;

					case 7:
						scanner = new Scanner(System.in);
						System.out.println("Enter registar ID");

						reg1 = scanner.nextInt();
						found = false;
						for (int j = 0; j < booking.length; j++) {
							found = booking[j].Search(booking[j], reg1);
							if (found) {
								generateReports(booking[j], play, stay, party, result, play1);
								break;
							}
						}
						if (!found) {
							System.out.println("Search failed! !");
						}
						break;

					case 8:

						scanner = new Scanner(System.in);
						System.out.println("Enter registar ID");
						scanner = new Scanner(System.in);
						reg11 = scanner.nextInt();
						found = false;
						for (int j = 0; j < booking.length; j++) {
							found = booking[j].Search(booking[j], reg11);
							if (found) {
								for (int i = 0; i < book.size(); i++) {

									Integer num1 = book.get(i).regs;

									if (reg11.equals(num1)) {
										book.remove(i);
										System.out.println(
												"\t\t\t*** you are Booking cancel SUCCESSFULLY ***  \n* cancel charge 500rs");

									}
								}
								break;
							}
						}
						if (!found) {
							System.out.println("Search failed! !");
						}
						break;
					case 9:
						
							for (int i = 0; i < book.size(); i++) {

								System.out.println("\t\t\t ***Booking List***\n regsiter No :" + book.get(i).regs
										+ "\nName :" + book.get(i).name + "\nPhone number :" + book.get(i).phoneNo
										+ "\nAddress :" + book.get(i).address + "\n Booking date ;" + book.get(i).date);

							}
						

						break;
						default:
							System.out.println("please following option");

					}

				} catch (InputMismatchException k) {
					System.out.println("You are input mismatch ! please check input Type!  TRY AGAIN");
				}
			} while (!(userOpt1 > 0));

			userOpt = 1;
		}
	}

	private static void generateReports(Booking booking, int play, int stay, int party, int result, int play1) {
		System.out.println("------------------------------------------------------------------------");

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatDateTime = now.format(format);
		int nsum = play1 + stay + party + result;
		System.out.println("\t\t\t\t\t***INVOICE***");

		System.out.println("Name :" + booking.name + "\nnaddress number :" + booking.address + "\nPhone No :"
				+ booking.phoneNo + "\nHotel No " + booking.hotelNo);

		System.out.println("booking date :" + booking.date + "\nSTAY CHARGE :" + stay + "\nPLAYING CHARGE :" + play1
				+ "\nRESULT CHARGE :" + result + "\ntotal amount :" + nsum + "\nBooking Date and Time :"
				+ formatDateTime);

		System.out.println("------------------------------------------------------------------------");
	}

}
