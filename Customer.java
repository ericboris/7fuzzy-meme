 /**
 * Create a customer
 *
 * @author Eric Boris
 * @version 12/1/2018
 */
public class Customer extends Person {
    /** phone                   a phone number */
    private String phone;
    /** email                   an email address */
    private String email;
    
    /**
     * Create a basic customer 
     * 
     * @param   id              the customer id number
     * @param   firstName       the customer first name
     * @param   lastName        the customer last name
     */
    public Customer(String id, String firstName, String lastName) {
        this(id, firstName, lastName, null, null);
    }
    
    /**
     * Create a customer 
     * 
     * @param   id              the customer id number
     * @param   firstName       the customer first name
     * @param   lastName        the customer last name
     * @param   phone           the customer phone number
     * @param   email           the customer email
     */
    public Customer(String id, String firstName, String lastName, String phone, String email) {
        super(id, firstName, lastName);
        this.phone = phone;
        this.email = email;
    }
    
    /**
     * get this customer's data
     * 
     * @return                  a string array of customer data
     */
    @Override
    public String[] getData() {
        return new String[] {getId(), getFirstName(), getLastName(), phone, email};
    }
}