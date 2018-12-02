import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Generate call center data
 *
 * @author Eric Boris
 * @version 12/1/2018
 */
public class CallCenter implements Subject{
    private ArrayList<Person> people;
    private ArrayList<Customer> customers;
    private ArrayList<Employee> employees;
    private ArrayList<Observer> observers;
    
    private HashSetQueue<Customer> customerQueue;
    private HashSetQueue<Employee> employeeQueue;
    
    private int waitQueueSize;
    private int delayAmount;
    private int numCalls;
    private int techQueueSize;
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
        
        observers = new ArrayList();
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
    
    public void setData(int waitQueueSize, int delayAmount, int numCalls, int techQueueSize, int techDayOff) {
        this.waitQueueSize = waitQueueSize;
        this.delayAmount = delayAmount;
        this.numCalls = numCalls;
        this.techQueueSize = techQueueSize;
        this.techDayOff = techDayOff;
        
        customerQueue.clear();
        employeeQueue.clear();
        fillCustomerQueue(waitQueueSize);
        fillEmployeeQueue(techQueueSize);
        
        notifyObservers();
    }
    
    private void fillCustomerQueue(int queueSize) {
        Random rand = new Random();
        while (customerQueue.size() < queueSize) {
            customerQueue.add(customers.get(rand.nextInt(customers.size())));
        }
    }
    
    private void fillEmployeeQueue(int queueSize) {
        Random rand = new Random();
        while (employeeQueue.size() < queueSize) {
            employeeQueue.add(employees.get(rand.nextInt(employees.size())));
        }
    }
    
    public void register(Observer observer) {
        observers.add(observer);
    }
    
    public void remove(Observer observer) {
        observers.remove(observers.indexOf(observer));
    }
    
    public void notifyObservers() {
        if (observers != null) {
            for (Observer observer : observers) {
                observer.update();
            }
        }
    }
    
    public void getData() {}
}
