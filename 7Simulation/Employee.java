/**
 * Create an employee
 *
 * @author Eric Boris
 * @version 12/1/2018
 */
public class Employee extends Person {
    public void setData(String id, String firstName, String lastName, String userName, String schedule) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setUserName(userName);
        setSchedule(schedule);
    }
    
    @Override
    public String[] getData() {
        return new String[] {getId(), getFirstName(), getLastName(), getUserName(), getSchedule()};
    }
}
