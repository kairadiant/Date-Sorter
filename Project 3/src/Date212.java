/*
 * Date212 class from Project 1 is used here as the files will be declared as objects and methods are used in the other classes
 * to access the date in its plain form and to display the date in a worded format
 */
public class Date212{
	//private instance variables are declared
	private int day, month, year;
	private String date;
	private String months[]= {"January","February","March","April","May","June","July","August","September","October","November","December"};
	private String days[]= {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
	//constructor
	public Date212(String date) {
		this.date=date;
		year=Integer.parseInt(date.substring(0, 4));
		month=Integer.parseInt(date.substring(4, 6));
		day=Integer.parseInt(date.substring(6,8));
	}
	
	//accessor and mutator methods
	public void setyear(int y){
		year=y;
	}
	
	public void setmonth(int m){
		month=m;	
	}
	
	public void setday(int d){
		day=d;
	}
	
	public int getyear() {
		return year;
	}
	
	public int getmonth() {
		return month;
	}
	
	public int getday() {
		return day;
	}
	
	public String getDate() {
		return date;
	}
	
	
	//method of conversion to string layout of date month/day/year in word format
	public String toString() {
		String full;
		double dayname;
		full=months[month-1]+" "+String.valueOf(day)+", "+String.valueOf(year);
		if(month==1)
			month=13;
		else if(month==2)
			month =14;
		dayname=(day+((26*(month+1))/10)+(year%100)+((year%100)/4)+((year/100)/4)+(5*(year/100)))%7;
		return days[(int)dayname]+", "+full;
	}
	
	//compares if the strings are equal to or bigger/smaller than
	public int compareTo(Date212 different) { //calculates the differences of each value
		int y = this.year - different.year; 
		int m = this.month - different.month;
		int d = this.day - different.day; 
		
		if(y > 0) 
			return 1;
		else if(y < 0)
			return -1;
		else
			if(m > 0 ) 
				return 1;
			else if(m < 0)
				return -1;
			else
				if(d > 0) 
					return 1;
				else if(d < 0) 
					return -1;
				else 
					return 0;
	}
	
	//returns true/false for comparison of objects contents
	public boolean equals(Date212 different) {
		if(this==different) {
			return true;
		}
		if(different!=null && this.getClass().equals(different.getClass())) {
			Date212 dif= (Date212) different;
			if(year==dif.year && month==dif.month && day==dif.day) {
				return true;
			}
			return false;
		}
		return false;
	}
	public boolean isValidDate() { //checks to make sure the string date of the object is a valid length
		if(this.getDate().length()!=8) {
			throw new IllegalArgumentException("The date length must be 8.");
		}
		return true;
	}

}
