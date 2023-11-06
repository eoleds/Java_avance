package TD3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Frame2 {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("Counter App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel counterLabel = new JLabel("Counter: 0");
        counterLabel.setPreferredSize(new Dimension(175, 100));
        counterLabel.setHorizontalAlignment(SwingConstants.CENTER);

        frame.getContentPane().add(counterLabel, BorderLayout.CENTER);

        // Create a JPanel for the buttons and place it at the bottom
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Create "-" button
        JButton decrementButton = new JButton("-");
        decrementButton.addActionListener(new ActionListener(){
            //@Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("MINUS");
            }

        });
        buttonPanel.add(decrementButton);


        // Create "+" button
        JButton incrementButton = new JButton("+");
        incrementButton.addActionListener(new ActionListener(){
            //@Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("PLUS");
            }

        });
        buttonPanel.add(incrementButton);


        // Make window's dimension fit its content
        frame.pack();

        // Display the window.
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

