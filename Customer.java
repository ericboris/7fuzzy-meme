/**
 * Create an customer
 *
 * @author Eric Boris
 * @version 12/1/2018
 */
public class Customer extends Person {
    public void setData(String id, String firstName, String lastName, String phone, String email) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setEmail(email);
    }
    
    @Override
    public String[] getData() {
        return new String[] {getId(), getFirstName(), getLastName(), getEmail(), getPhone()};
    }
}