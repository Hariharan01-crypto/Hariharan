package javaTrainee;

public class Index1 {
	private int roomNo;
	private boolean ac;
	private int capacity;

	Index1() {
		System.out.println(" \t\t\t***HOTEL BOOKING***");
		System.out.println(
				"Enter 1 from Customer details : \nEnter 2 from Booking : \nEnter 3 from Staying days : \nEnter 4 from playingArea  : \nEnter 5 from Offer : \nEnter 6 from partyArea  : \nEnter 7 from Total amount : \nEnter 8 from  Booking cancel : \nEnter 9 from Total Booking List : \nEnter the NUMBER :");

	}

	Index1(int no, boolean ac, int cap) {
		this.roomNo = no;
		this.ac = ac;
		this.capacity = cap;
	}

	public int getNo() {
		return roomNo;
	}

	public boolean isAc() {
		return ac;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setAc(boolean val) {
		ac = val;
	}

	public void setCapacity(int cap) {
		capacity = cap;
	}

	public void displayInfo() {

		System.out.println("Hotal:" + roomNo + " Ac:" + ac + " Total Capacity: " + capacity);
	}

	public int getCapacity1() {

		return 0;
	}

	public int getNo1() {

		return 0;
	}
}
