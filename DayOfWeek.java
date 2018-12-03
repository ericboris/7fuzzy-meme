/**
 * The days of the week
 *
 * @author Eric Boris
 * @version 12/1/2018
 */
public enum DayOfWeek {
    /** MONDAY */
    MONDAY(1, "Mon"), 
    /** TUESDAY */
    TUESDAY(2, "Tue"), 
    /** WEDNESDAY */
    WEDNESDAY(3, "Wed"), 
    /** THURSDAY */
    THURSDAY(4, "Thu"), 
    /** FRIDAY */
    FRIDAY(5, "Fri"), 
    /** SATURDAY */
    SATURDAY(6, "Sat"), 
    /** SUNDAY */
    SUNDAY(7, "Sun");
    
    /** dayNumber               the number of the day of the week */
    private final int dayNumber;
    /** dayName                 the name of the day of the week */
    private final String dayName;
    
    /**
     * create the day of the week enum
     * 
     * @param   dayNumber       the number of the day of the week
     * @param   dayName         the name of the day of the wek
     */
    private DayOfWeek(int dayNumber, String dayName) {
        this.dayNumber = dayNumber;
        this.dayName = dayName;
    }
    
    /**
     * change this object to a string
     * 
     * @return                  a string of this object
     */
    public String toString() {
        return dayName;
    }
    
    /**
     * get the day of the week name by day of the week number
     * 
     * @param   dayNumber          the day of the week to get
     * @return                  the day of the week
     */
    public static DayOfWeek byNumber(int dayNumber) {
        return DayOfWeek.values() [dayNumber-1];
    }
}
