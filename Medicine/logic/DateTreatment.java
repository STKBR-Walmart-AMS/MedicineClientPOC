
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTreatment {

	private GregorianCalendar gc;
	
	public DateTreatment(Date date){
		gc = new GregorianCalendar();
		gc.setLenient(true);
		gc.setTime(date);
	}
	
	public DateTreatment addYearsToDate(int years){
		gc.add(GregorianCalendar.YEAR, years);
		return this;
	}
	
	public DateTreatment addMonthsToDate(int months){
		gc.add(GregorianCalendar.MONTH, months);
		return this;
	}
	
	public DateTreatment addDaysToDate(int days){
		gc.add(GregorianCalendar.DAY_OF_MONTH, days);
		return this;
	}
	
	public DateTreatment addHoursToDate(int hours){
		gc.add(GregorianCalendar.HOUR_OF_DAY, hours);
		return this;
	}
	
	public DateTreatment addMinutesToDate(int minutes){
		gc.add(GregorianCalendar.MINUTE, minutes);
		return this;
	}
	
	public DateTreatment addSecondsToDate(int seconds){
		gc.add(GregorianCalendar.SECOND, seconds);
		return this;
	}
	
	
	
	public Date returnDate(){
		return this.gc.getTime();
	}
	
	
}
