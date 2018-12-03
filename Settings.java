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
import javax.swing.JComboBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 * Display and manage a settings jpanel
 *
 * @author Eric Boris
 * @version 12/1/2018
 */
public class Settings extends JPanel {
    /** callCenter                  the call center this panel modifies */
    CallCenter callCenter;

    /** waitLabel                   the label for the wait slider */
    private JLabel waitLabel;
    /** waitSlider                  the slider for number of waiting customers */
    private JSlider waitSlider;
    /** waitCurrent                 the number of waiting customers to simulate */
    private JLabel waitCurrent;
    /** delayLabel                  the label for the delay slider */
    private JLabel delayLabel;
    /** delaySlider                 the slider for the amount of dely */
    private JSlider delaySlider;
    /** delayCurrent                the amount of delay between calls to simulate */
    private JLabel delayCurrent;
    /** callsLabel                  the label for the calls slider */
    private JLabel callsLabel;
    /** callsSlider                 the slider for the number of calls to take */
    private JSlider callsSlider;
    /** callsCurrent                the number of calls to simulate */
    private JLabel callsCurrent;
    /** dayLabel                    the label for the day off dropdown */
    private JLabel dayLabel;
    /** dayList                     the list of possible days off */
    private JComboBox dayList;
    /** simButton                   run the simulation */
    private JButton simButton;

    /** WAIT_LABEL                  the wait label text */
    private static final String WAIT_LABEL = "Wait Queue";
    /** WAIT_MAX                    the max size of the wait queue */
    private static final int WAIT_MAX = 40;
    /** WAIT_INIT                   the initial value of the wait slider */
    private static final int WAIT_INIT = WAIT_MAX / 2;
    /** DELAY_LABEL                 the delay label text */
    private static final String DELAY_LABEL = "Delay Amount";
    /** DELAY_MAX                   the max amount of delay time */
    private static final int DELAY_MAX = 5;
    /** DELAY_INIT                  the initial value of the delay slider */
    private static final int DELAY_INIT = DELAY_MAX / 2;
    /** CALLS_LABEL                 the calls label text */
    private static final String CALLS_LABEL = "Calls to Take";
    /** CALLS_MAX                   the max number of calls to take */
    private static final int CALLS_MAX = 40;
    /** CALLS_INIT                  the initial value of the calls slider */
    private static final int CALLS_INIT = CALLS_MAX / 2;
    /** DAYS_LABEL                  the days label text */
    private static final String DAYS_LABEL = "Employee Day Off";
    /** DAYS_ARRAY                  the options for the days off dropdown */
    private static final String[] DAYS_ARRAY = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    /** SIM_LABEL                   the text for the simulation run button */
    private static final String SIM_LABEL = "Simulate!";    

    /** INIT_DIM                    the default dimensions for the window */
    private static final Dimension INIT_DIM = new Dimension(310, 175);

    /**
     * create a settings window
     * 
     * @param   callCenter          the callCenter this window modifies
     */
    public Settings(CallCenter callCenter){
        if (callCenter == null) {
            throw new IllegalArgumentException("Argument must not be null");
        }
        this.callCenter = callCenter;

        setLayout(new FlowLayout());

        // wait list settings
        waitLabel = new JLabel(WAIT_LABEL, JLabel.CENTER);
        waitSlider = new JSlider(JSlider.HORIZONTAL, 1, WAIT_MAX, WAIT_INIT);
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
        delaySlider = new JSlider(JSlider.HORIZONTAL, 1, DELAY_MAX, DELAY_INIT);
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
        callsSlider = new JSlider(JSlider.HORIZONTAL, 1, CALLS_MAX, CALLS_INIT);
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

        // day off settings
        dayLabel = new JLabel(DAYS_LABEL, JLabel.CENTER);
        dayList = new JComboBox<String>(DAYS_ARRAY);
        this.add(dayLabel);
        this.add(dayList);

        // simulation button
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

    /**
     * notify the call center of updates
     */
    private void update() {
        callCenter.setData(waitSlider.getValue(), delaySlider.getValue(), 
            callsSlider.getValue(), dayList.getSelectedIndex() + 1);
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
