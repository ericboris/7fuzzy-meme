/**
 * Create an employee
 *
 * @author Eric Boris
 * @version 12/1/2018
 */
public class Employee extends Person {
    private String userName;
    private int dayOff;
    
    public Employee(String id, String firstName, String lastName) {
        this(id, firstName, lastName, null, null);
    }
    
    public Employee(String id, String firstName, String lastName, String userName, String dayOff) {
        super(id, firstName, lastName);
        this.userName = userName;
        this.dayOff = Integer.parseInt(dayOff);
    }
    
    public int getDayOff() {
        return dayOff;
    }
    
    private String dayOffToSchedule(int dayOff) {
        String schedule = "";
        for (int dayNum = 1; dayNum <= 7; dayNum++) {
            if (dayNum != dayOff) {
                schedule += DayOfWeek.byNumber(dayNum);
            }
        }
        return schedule;
    }
    
    @Override
    public String[] getData() {
        return new String[] {getId(), getFirstName(), getLastName(), userName, dayOffToSchedule(dayOff)};
    }
}
