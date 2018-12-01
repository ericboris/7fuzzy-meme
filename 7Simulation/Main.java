/**
 * Display and run the simulation
 *
 * @author Eric Boris   
 * @version 12/1/2018
 */
public class Main {
    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter();
        Settings settings = new Settings(callCenter);
        Display display = new Display(callCenter);
    }
}
