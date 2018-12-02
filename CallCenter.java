import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Generate call center data
 *
 * @author Eric Boris
 * @version 12/1/2018
 */
public class CallCenter implements Subject{
    private ArrayList<Person> people;
    private ArrayList<Observer> observers;
    
    private int waitQueueSize;
    private int delayAmount;
    private int numCalls;
    private int techQueueSize;
    
    public CallCenter(File file) {
        if (file == null) {
            throw new IllegalArgumentException("Argument must not be null");
        }
        people = new ArrayList();
        fillPeopleFromFile(file);
    }
    
    private void fillPeopleFromFile(File file) {
        BufferedReader br = null;
        String line = "";
        String splitOn = ",";
        
        try {
            br = new BufferedReader(new FileReader(file));
            
            while ((line = br.readLine()) != null) {
                String[] personData = line.split(splitOn);
                Person p = new Person();
                p.setData(personData[0], 
                          personData[1], 
                          personData[2], 
                          personData[3], 
                          personData[4], 
                          personData[5], 
                          Integer.parseInt(personData[6]));
                people.add(p);
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
    
    public void setData(int waitQueueSize, int delayAmount, int numCalls, int techQueueSize) {
        this.waitQueueSize = waitQueueSize;
        this.delayAmount = delayAmount;
        this.numCalls = numCalls;
        this.techQueueSize = techQueueSize;
        notifyObservers();
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
