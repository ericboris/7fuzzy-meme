 /**
 * Create an customer
 *
 * @author Eric Boris
 * @version 12/1/2018
 */
public class Customer extends Person {
    private String phone;
    private String email;
    
    public Customer(String id, String firstName, String lastName) {
        this(id, firstName, lastName, null, null);
    }
    
    public Customer(String id, String firstName, String lastName, String phone, String email) {
        super(id, firstName, lastName);
        this.phone = phone;
        this.email = email;
    }
    
    @Override
    public String[] getData() {
        return new String[] {getId(), getFirstName(), getLastName(), phone, email};
    }
}