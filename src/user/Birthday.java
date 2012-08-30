package user;

import java.util.GregorianCalendar;

/**
 * Class representing a Birthday.
 * @author andreluiz
 *
 */
public class Birthday {
	
	/**
	 * Attribute that will hold the actual date.
	 */
	private GregorianCalendar date;

	/**
	 * Default constructor of Birthday class.
	 * @param day day of birth.
	 * @param month month of birth.
	 * @param year year of birth.
	 */
	public Birthday(int day, int month, int year) {
		this.setDate(day, month, year);
	}
	
	/**
	 * 
	 * @return Date of birth represented by a GregorianCalendar object.
	 */
	public GregorianCalendar getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Birthday [date=" + date + "]";
	}

	/**
	 * Sets the date attribute to a new GregorianCalendar object with the given parameters.
	 * @param day day of birth of the new object.
	 * @param month month of birth of the new object.
	 * @param year year of birth of the new object.
	 */
	public void setDate(int day, int month, int year) {
		this.date = new GregorianCalendar(year, month, day);
	}

}
