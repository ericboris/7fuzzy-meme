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
    private ArrayList<Person> people;
    private ArrayList<Customer> customers;
    private ArrayList<Employee> employees;
    
    private HashSetQueue<Customer> customerQueue;
    private HashSetQueue<Employee> employeeQueue;
    
    private int waitQueueSize;
    private int delayAmount;
    private int numCalls;
    private int techDayOff;
    
    public CallCenter(File customerFile, File employeeFile) {
        if (customerFile == null || employeeFile == null) {
            throw new IllegalArgumentException("Argument must not be null");
        }
        customers = new ArrayList();
        employees = new ArrayList();
        fillCustomersFromFile(customerFile);
        fillEmployeesFromFile(employeeFile);
        
        customerQueue = new HashSetQueue<Customer>();
        employeeQueue = new HashSetQueue<Employee>();
    }
    
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
    
    public void setData(int waitQueueSize, int delayAmount, int numCalls, int techDayOff) {
        this.waitQueueSize = waitQueueSize;
        this.delayAmount = delayAmount;
        this.numCalls = numCalls;
        this.techDayOff = techDayOff;
        
        customerQueue.clear();
        employeeQueue.clear();
        fillCustomerQueue(waitQueueSize);
        fillEmployeeQueue(techDayOff);
        
        //notifyObservers();
        display(numCalls, delayAmount);
    }
    
    private void fillCustomerQueue(int queueSize) {
        Random rand = new Random();
        while (customerQueue.size() < queueSize) {
            customerQueue.add(customers.get(rand.nextInt(customers.size())));
        }
    }
    
    private void fillEmployeeQueue(int techDayOff) {
        for (Employee employee : employees) {
            if (employee.getDayOff() == techDayOff) {
                employeeQueue.add(employee);
            }
        }
    }
    
    public void display(int numCalls, int delayAmount) { 
        //Timer delayTimer = new Timer();
        for (int i = 0; i < numCalls; i++) {
            System.out.println("Call #: " + (i + 1));
            Employee e = (Employee) employeeQueue.remove();
            for (String s : e.getData()) {
                System.out.print(s + " ");
            } 
            System.out.println("");
            employeeQueue.add(e);
            Customer c = (Customer) customerQueue.remove();
            for (String s : c.getData()) {
                System.out.print(s + " ");
            }
            System.out.println("\n");
            fillCustomerQueue(waitQueueSize);
        }
    }
}
