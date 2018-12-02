import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 * Display and manage a settings jpanel
 *
 * @author Eric Boris
 * @version 12/1/2018
 */
public class Settings extends JPanel {
    CallCenter callCenter;
    
    private JLabel waitLabel;
    private JSlider waitSlider;
    private JLabel waitCurrent;
    private JLabel delayLabel;
    private JSlider delaySlider;
    private JLabel delayCurrent;
    private JLabel callsLabel;
    private JSlider callsSlider;
    private JLabel callsCurrent;
    private JButton simButton;

    private static final String WAIT_LABEL = "Wait";
    private static final int WAIT_MAX = 40;
    private static final int WAIT_INIT = WAIT_MAX / 2;
    private static final String DELAY_LABEL = "Delay";
    private static final int DELAY_MAX = 4;
    private static final int DELAY_INIT = DELAY_MAX / 2;
    private static final String CALLS_LABEL = "Calls";
    private static final int CALLS_MAX = 40;
    private static final int CALLS_INIT = CALLS_MAX / 2;
    private static final String SIM_LABEL = "Simulate!";    

    private static final Dimension INIT_DIM = new Dimension(270, 150);

    public Settings(CallCenter callCenter){
        if (callCenter == null) {
            throw new IllegalArgumentException("Argument must not be null");
        }
        this.callCenter = callCenter;
        
        setLayout(new FlowLayout());

        // wait list settings
        waitLabel = new JLabel(WAIT_LABEL, JLabel.CENTER);
        waitSlider = new JSlider(JSlider.HORIZONTAL, 0, WAIT_MAX, WAIT_INIT);
        waitSlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    waitCurrent.setText(String.valueOf(waitSlider.getValue()));
                }
            });
        waitCurrent = new JLabel(String.valueOf(WAIT_INIT), JLabel.CENTER);
        this.add(waitLabel);
        this.add(waitSlider);
        this.add(waitCurrent);

        // delay list settings
        delayLabel = new JLabel(DELAY_LABEL, JLabel.CENTER);
        delaySlider = new JSlider(JSlider.HORIZONTAL, 0, DELAY_MAX, DELAY_INIT);
        delaySlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    delayCurrent.setText(String.valueOf(delaySlider.getValue()));
                }
            });
        delayCurrent = new JLabel(String.valueOf(DELAY_INIT), JLabel.CENTER);
        this.add(delayLabel);
        this.add(delaySlider);
        this.add(delayCurrent);

        // calls to make settings
        callsLabel = new JLabel(CALLS_LABEL, JLabel.CENTER);
        callsSlider = new JSlider(JSlider.HORIZONTAL, 0, CALLS_MAX, CALLS_INIT);
        callsSlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    callsCurrent.setText(String.valueOf(callsSlider.getValue()));
                }
            });
        callsCurrent = new JLabel(String.valueOf(CALLS_INIT), JLabel.CENTER);
        this.add(callsLabel);
        this.add(callsSlider);
        this.add(callsCurrent);
        
        simButton = new JButton(SIM_LABEL);
        simButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });
        this.add(simButton);

        // create a settings jframe and add the settings panel to it
        JFrame sf = new JFrame("Settings");
        sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sf.getContentPane().add(this);
        sf.pack();
        sf.setVisible(true);
        sf.setResizable(false);
    }
    
    private void update() {
        callCenter.setData();
    }
    
    /**
     * get the preferred window dimensions
     * 
     * @return              the prefered window dimensions
     */
    @Override
    public Dimension getPreferredSize() {
        return INIT_DIM;
    }
}
