import java.io.File;

/**
 * Display and run the simulation
 *
 * @author Eric Boris   
 * @version 12/1/2018
 */
public class Main {
    /**
     * run the simulation
     * 
     * @param   args            the command line arguments
     */
    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter(new File("mock_customers.csv"), 
                                               new File("mock_employees.csv"));
        Settings settings = new Settings(callCenter);
    }
}
