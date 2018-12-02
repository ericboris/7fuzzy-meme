import java.awt.Graphics;

/**
 * Create a parent object
 *
 * @author Eric Boris
 * @version 12/1/2018
 */
public class Person implements Drawable{
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String phone;
    private String email;
    private String schedule;  
    
    public void setId(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Argument must not be null");
        }
        this.id = id;
    }
    
    public String getId() {
        if (id == null) {
            return "";
        }
        return id;
    }
    
    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("Argument must not be null");
        }
        this.firstName = firstName;
    }
    
    public String getFirstName() {
        if (firstName == null) {
            return "";
        }
        return firstName;
    }
    
    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("Argument must not be null");
        }
        this.lastName = lastName;
    }
    
    public String getLastName() {
        if (lastName == null) {
            return "";
        }
        return lastName;
    }
    
    public void setUserName(String userName) {
        if (userName == null) {
            throw new IllegalArgumentException("Argument must not be null");
        }
        this.userName = userName;
    }
    
    public String getUserName() {
        if (userName == null) {
            return "";
        }
        return userName;
    }
    
    public void setEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Argument must not be null");
        }
        this.email = email;
    }
    
    public String getEmail() {
        if (email == null) {
            return "";
        }
        return email;
    }
    
    public void setSchedule(String schedule) {
        if (schedule == null) {
            throw new IllegalArgumentException("Argument must not be null");
        }
        this.schedule = schedule;
    }
    
    public String getSchedule() {
        if (schedule == null) {
            return "";
        }
        return schedule;
    }
    
   public void setPhone(String phone) {
        if (phone == null) {
            throw new IllegalArgumentException("Argument must not be null");
        }
        this.phone = phone;
    }
    
    public String getPhone() {
        if (phone == null) {
            return "";
        }
        return phone;
    }
    
    public void setData(String id, String firstName, String lastName, String userName,
                        String phone, String email, String schedule) {
       setId(id);
       setFirstName(firstName);
       setLastName(lastName);
       setUserName(userName);
       setPhone(phone);
       setEmail(email);
       setSchedule(schedule);
    }
    
    public String[] getData() {
        return new String[] {id, firstName, lastName, userName, phone, email, schedule};
    }
    
    public void draw(Graphics g) {
    
    }
}
