import java.awt.Graphics;

/**
 * Create a parent object
 *
 * @author Eric Boris
 * @version 12/1/2018
 */
public class Person{
    private String id;
    private String firstName;
    private String lastName;
    
    public Person(String id, String firstName, String lastName) {
        if (id == null || firstName == null || lastName == null) {
            throw new IllegalArgumentException("Argument must not be null");
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getId() {
        if (id == null) {
            return "";
        }
        return id;
    }

    public String getFirstName() {
        if (firstName == null) {
            return "";
        }
        return firstName;
    }

    public String getLastName() {
        if (lastName == null) {
            return "";
        }
        return lastName;
    }
    
    // public void setSchedule(int dayOff) {
        // if (dayOff < 1 || dayOff > 7) {
            // throw new IndexOutOfBoundsException("dayOff :" + dayOff);
        // }
        // setDayOff(dayOff);
        // schedule = "";
        // for (int dayNum = 1; dayNum <= 7; dayNum++) {
            // if (dayNum != dayOff) {
                // schedule += DayOfWeek.byNumber(dayNum);
            // }
        // }
    // }

    public String[] getData() {
        return new String[] {id, firstName, lastName};
    }
}
