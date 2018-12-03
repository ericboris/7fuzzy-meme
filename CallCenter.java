import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Graphics;

/**
 * Generate call center data
 *
 * @author Eric Boris
 * @version 12/1/2018
 */
public class CallCenter {
    /** customers               the array of all customers */
    private ArrayList<Customer> customers;
    /** employees               the array of all employees */
    private ArrayList<Employee> employees;

    /** customerQueue           the queue of customer calls */
    private HashSetQueue<Customer> customerQueue;
    /** employeeQueue           the queue of employees available to take calls */
    private HashSetQueue<Employee> employeeQueue;

    /** waitQueueSize           the starting number of calls in waiting in queue */
    private int waitQueueSize;
    /** delayAmount             the amount of delay between answering calls */
    private int delayAmount;
    /** numCalls                the total number of calls to take */
    private int numCalls;
    /** techDayOff              the day of the week that techs have off */
    private int techDayOff;

    /** displayTimer            the timer that delays displaying calls */
    private Timer displayTimer;
    /** callCounter             the number of calls taken */
    private int callCounter;

    /**
     * create a call center
     * 
     * @param   customerFile    the file of customer data
     * @param   employeeFile    the file of employee data
     */
    public CallCenter(File customerFile, File employeeFile) {
        if (customerFile == null || employeeFile == null) {
            throw new IllegalArgumentException("Argument must not be null");
        }
        customers = new ArrayList<Customer>();
        employees = new ArrayList<Employee>();
        fillCustomersFromFile(customerFile);
        fillEmployeesFromFile(employeeFile);

        customerQueue = new HashSetQueue<Customer>();
        employeeQueue = new HashSetQueue<Employee>();
    }

    /**
     * fill the customer array from a file
     * 
     * @param   file            the file of customer data
     */
    private void fillCustomersFromFile(File file) {
        BufferedReader br = null;
        String line = "";
        String splitOn = ",";

        try {
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                String[] csvData = line.split(splitOn);
                Customer c = new Customer(csvData[0], 
                        csvData[1], 
                        csvData[2], 
                        csvData[3], 
                        csvData[4]);
                customers.add(c);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /**
     * fill the employee array from a file
     * 
     * @param   file            the file of the employee data
     */
    private void fillEmployeesFromFile(File file) {
        BufferedReader br = null;
        String line = "";
        String splitOn = ",";

        try {
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                String[] csvData = line.split(splitOn);
                Employee e = new Employee(csvData[0], 
                        csvData[1], 
                        csvData[2], 
                        csvData[3], 
                        csvData[4]);
                employees.add(e);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /** 
     * set the updated call center data and display the calls
     * 
     * @param   waitQueueSize       the starting number of calls in waiting in queue
     * @param   delayAmount         the amount of delay between answering calls 
     * @param   numCalls            the total number of calls to take 
     * @param   techDayOff          the day of the week that techs have off
     */
    public void setData(int waitQueueSize, int delayAmount, int numCalls, int techDayOff) {
        this.waitQueueSize = waitQueueSize;
        this.delayAmount = delayAmount;
        this.numCalls = numCalls;
        this.techDayOff = techDayOff;

        customerQueue.clear();
        employeeQueue.clear();
        fillCustomerQueue(waitQueueSize);
        fillEmployeeQueue(techDayOff);

        display(numCalls, delayAmount);
    }

    /**
     * fill the customer queue to the queue size
     * 
     * @param   queueSize           the desired size of the queue
     */
    private void fillCustomerQueue(int queueSize) {
        Random rand = new Random();
        while (customerQueue.size() < queueSize) {
            customerQueue.add(customers.get(rand.nextInt(customers.size())));
        }
    }

    /**
     * fill the employee queue with all available techs
     * 
     * @param   techDayOff          the techs to exclude
     */
    private void fillEmployeeQueue(int techDayOff) {
        for (Employee employee : employees) {
            if (employee.getDayOff() == techDayOff) {
                employeeQueue.add(employee);
            }
        }
    }

    /**
     * display the call center calls
     * 
     * @param   numCalls            the number of calls to display
     * @param   delayAmount         the amount of time to delay between calls
     */
    public void display(int numCalls, int delayAmount) { 
        System.out.print('\u000c');
        System.out.println("Begin simulation.\n");
        System.out.println("Today there are " + waitQueueSize + " customers waiting,");
        System.out.println(employeeQueue.size() + " employees are working,");
        System.out.println("and " + numCalls + " calls will be simulated.\n");

        Timer displayTimer = new Timer();
        callCounter = 0;
        class DisplayTask extends TimerTask{
            public void run() {
                System.out.println("Call " + (callCounter + 1));

                Employee e = (Employee) employeeQueue.remove();
                String[] employeeData = e.getData();
                System.out.println("\tEmployee data");
                System.out.println("\t\tId:\t\t" + employeeData[0]);
                System.out.println("\t\tName:\t\t" + employeeData[1] + " " + employeeData[2]);
                System.out.println("\t\tHandle:\t\t" + employeeData[3]);
                System.out.println("\t\tSchedule:\t" + employeeData[4]); 
                employeeQueue.add(e);

                Customer c = (Customer) customerQueue.remove();
                String[] customerData = c.getData();
                System.out.println("\tCustomer data");
                System.out.println("\t\tId:\t\t" + customerData[0]);
                System.out.println("\t\tName:\t\t" + customerData[1] + " " + customerData[2]);
                System.out.println("\t\tPhone Number:\t" + customerData[3]);
                System.out.println("\t\tEmail:\t\t" + customerData[4]);
                System.out.println("\n");
                fillCustomerQueue(waitQueueSize);

                callCounter++;
                if (callCounter >= numCalls) {
                    displayTimer.cancel();
                    System.out.println("Simulation complete!");
                }
            }
        }
        displayTimer.schedule(new DisplayTask(), 0, delayAmount * 1000);

    }
}
