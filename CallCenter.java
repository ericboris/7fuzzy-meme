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
    
    public void setData() {}
    
    public void register(Observer observer) {}
    
    public void remove(Observer observer) {}
    
    public void notifyObservers() {}
    
    public void getData() {}
}
