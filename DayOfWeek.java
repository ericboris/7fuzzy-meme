
/**
 * The days of the week
 *
 * @author Eric Boris
 * @version 12/1/2018
 */
public enum DayOfWeek {
    MONDAY(1, "Mon"), 
    TUESDAY(2, "Tue"), 
    WEDNESDAY(3, "Wed"), 
    THURSDAY(4, "Thu"), 
    FRIDAY(5, "Fri"), 
    SATURDAY(6, "Sat"), 
    SUNDAY(7, "Sun");
    
    private final int dayNumber;
    private final String dayName;
    
    private DayOfWeek(int dayNumber, String dayName) {
        this.dayNumber = dayNumber;
        this.dayName = dayName;
    }
    
    public String toString() {
        return dayName;
    }
    
    public static DayOfWeek byNumber(int dayNumber) {
        return DayOfWeek.values() [dayNumber-1];
    }
}
