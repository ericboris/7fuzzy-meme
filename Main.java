import java.io.File;

/**
 * Display and run the simulation
 *
 * @author Eric Boris   
 * @version 12/1/2018
 */
public class Main {
    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter(new File("mock_customers.csv"), new File("mock_employees.csv"));
        Settings settings = new Settings(callCenter);
        Display display = new Display(callCenter);
    }
}
