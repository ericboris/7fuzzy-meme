/**
 * Provide a Subject interface
 *
 * @author Eric Boris
 * @version 12/1/2018
 */
public interface Subject {
    /**
     * register a new observer
     * 
     * @param   observer        the new observer to register
     */
    public void register(Observer observer);
    /**
     * remove an existing observer
     *
     * @param   observer        the observer to remove
     */
    public void remove(Observer observer);
    /**
     * notify each existing observer of changes
     */
    public void notifyObservers();
    /**
     * get all the subject's data
     * 
     * @return              an array of all the subject's data
     */
    public void getData();
}
