package application;

public class Record {
	private int seatNumber;
	private double average;//Record data=new Record(12345,12.3,"hi
	private String branch;
	public Record(int seatNumber, double d, String branch) {
		
		this.seatNumber = seatNumber;
		this.average = d;
		this.branch = branch;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Record [seatNumber=" + seatNumber + ", average=" + average + ", branch=" + branch + "]";
	}
	
}
