/**
 * Create an employee
 *
 * @author Eric Boris
 * @version 12/1/2018
 */
public class Employee extends Person {
    private String userName;
    private String dayOff;
    
    public Employee(String id, String firstName, String lastName, String userName, String dayOff) {
        super(id, firstName, lastName);
        if (userName == null || dayOff == null) {
            throw new IllegalArgumentException("Argument must not be null");
        }
        this.userName = userName;
        this.dayOff = dayOff;
    }
    
    @Override
    public String[] getData() {
        return new String[] {getId(), getFirstName(), getLastName(), userName, dayOff};
    }
}
