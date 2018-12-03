import java.awt.Graphics;

/**
 * Create a parent object
 *
 * @author Eric Boris
 * @version 12/1/2018
 */
public class Person{
    /** id                  the person id */
    private String id;
    /** firstName           the person first name */
    private String firstName;
    /** lastName            the person last name */
    private String lastName;
    
    /**
     * create a person
     * 
     * @param   id          the person id 
     * @param   firstName   the person first name 
     * @param   lastName    the person last name
     */
    public Person(String id, String firstName, String lastName) {
        if (id == null || firstName == null || lastName == null) {
            throw new IllegalArgumentException("Argument must not be null");
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /**
     * get the person id
     * 
     * @return              the id
     */
    public String getId() {
        return id;
    }

    /**
     * get the person first name    
     * 
     * @return              the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * get the person last name
     * 
     * @return              the person last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * get the person data
     * 
     * @return              a string array of person data
     */
    public String[] getData() {
        return new String[] {id, firstName, lastName};
    }
}
