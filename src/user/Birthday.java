package user;

import java.util.GregorianCalendar;

public class Birthday {
	
	private GregorianCalendar date;

	public Birthday(int day, int month, int year) {
		this.setDate(day, month, year);
	}
	
	public GregorianCalendar getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Birthday [date=" + date + "]";
	}

	public void setDate(int day, int month, int year) {
		this.date = new GregorianCalendar(year, month, day);
	}

}
