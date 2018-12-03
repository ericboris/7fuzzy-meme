/**
 * Create an employee
 *
 * @author Eric Boris
 * @version 12/1/2018
 */
public class Employee extends Person {
    /** userName                the employee user name */ 
    private String userName;
    /** dayOff                  the day of the week the employee has off */
    private int dayOff;
    
    /**
     * Create a basic employee 
     * 
     * @param   id              the employee id number
     * @param   firstName       the employee first name
     * @param   lastName        the employee last name
     */
    public Employee(String id, String firstName, String lastName) {
        this(id, firstName, lastName, null, null);
    }
    
    /**
     * Create an employee 
     * 
     * @param   id              the employee id number
     * @param   firstName       the employee first name
     * @param   lastName        the employee last name
     * @param   userName        the employee user name  
     * @param   dayOff          the employee day off
     */
    public Employee(String id, String firstName, String lastName, String userName, String dayOff) {
        super(id, firstName, lastName);
        this.userName = userName;
        this.dayOff = Integer.parseInt(dayOff);
    }
    
    /**
     * get the employee day off
     * 
     * @return                  the day of the week off
     */
    public int getDayOff() {
        return dayOff;
    }
    
    /**
     * convert the number of the day of the week off to a string of days working
     * 
     * @param   dayOff          the employee day off
     * @return                  the employee schedule
     */
    private String dayOffToSchedule(int dayOff) {
        String schedule = "";
        for (int dayNum = 1; dayNum <= 7; dayNum++) {
            if (dayNum != dayOff) {
                schedule += DayOfWeek.byNumber(dayNum) + " ";
            }
            else {
                schedule += "___ ";
            }
        }
        return schedule;
    }
    
    /**
     * get this employee's data
     * 
     * @return                  a string array of employee data
     */
    @Override
    public String[] getData() {
        return new String[] {getId(), getFirstName(), getLastName(), userName, dayOffToSchedule(dayOff)};
    }
}
