
package nguyen_lab4;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class Nguyen_Lab4 implements ItemListener {
    JPanel cards; //a panel that uses CardLayout
    final static String[] states = {"alabama",
"alaska",
"arizona",
"arkansas",
"california",
"colorado",
"connecticut",
"delaware",
"florida",
"georgia",
"hawaii",
"idaho",
"illinois",
"indiana",
"iowa",
"kansas",
"kentucky",
"louisiana",
"maine",
"maryland",
"massachusetts",
"michigan",
"minnesota",
"mississippi",
"missouri",
"montana",
"nebraska",
"nevada",
"new-hampshire",
"new-jersey",
"new-mexico",
"new-york",
"north-dakota",
"ohio",
"oklahoma",
"oregon",
"pennsylvania",
"rhode-island",
"south-carolina",
"tennessee",
"texas",
"utah",
"vermont",
"virginia",
"washington",
"west-virginia",
"wisconsin",
"wyoming"};
     
    public void addComponentToPane(Container pane) throws MalformedURLException {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        JComboBox cb = new JComboBox(states);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
         
        //Create the "cards".
        cards = new JPanel(new CardLayout());
        JPanel[] card = new JPanel[states.length];
        JButton[] button = new JButton[states.length];
        for ( int i =0; i < states.length; i++ ) {
           card[i] = new JPanel();
           String url = "https://cdn.civil.services/us-states/flags/"+states[i]+"-large.png";
           button[i] = new JButton(new ImageIcon(new URL(url)));
           card[i].add(button[i]);
           cards.add(card[i], states[i]);
        }
         
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }
     
    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
     
   
    private static void createAndShowGUI() throws MalformedURLException {
        //Create and set up the window.
        JFrame frame = new JFrame("Nguyen_Lab4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        Nguyen_Lab4 demo = new Nguyen_Lab4();
        demo.addComponentToPane(frame.getContentPane());
         
        //Display the window.
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
     
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(() -> {
            try {
                createAndShowGUI();
            } catch (MalformedURLException ex) {
                Logger.getLogger(Nguyen_Lab4.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
