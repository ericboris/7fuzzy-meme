import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;

/**
 * handle displaying window
 * 
 * @author Eric Boris
 * @version 12/1/2018
 */
public class Display extends JPanel implements Observer {
    /** subject                 this display's subject */
    private Subject subject;
    
    private static final String TITLE = "Calls";
    private static final Dimension DIM = new Dimension(600, 400);

    /**
     * construct a display
     * 
     * @param   subject         the subject to register this display with
     * @param   dimension       the displays dimensions
     */
    public Display(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Argument must not be null");
        }
        this.subject = subject;
        this.subject.register(this);

        setLayout(null);

        JFrame df = new JFrame(TITLE);
        df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        df.getContentPane().add(this);
        df.pack();
        df.setLocation(270, 0);
        df.setVisible(true);
        df.setResizable(false);
    }

    /**
     * update the contents of the display
     */
    public void update() {
        //elements = subject.getData();
        repaint();
    }

    // /**
     // * paint the elements to the display
     // * 
     // * @param   g               the graphics object to paint onto
     // */
    // @Override 
    // protected void paintComponent(Graphics g) {
        // super.paintComponent(g);
        // for (Drawable element : elements) {
            // element.draw(g);
        // }
    // }

    /**
     * return the preffered size of the display
     * 
     * @return                  the preferred size of the display
     */
    @Override
    public Dimension getPreferredSize() {
        return DIM;
    }
}
