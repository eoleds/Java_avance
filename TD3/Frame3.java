package TD3;


import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Frame3 {
    // CounterComponent class
    static class CounterComponent extends JLabel {
        private int counter = 0;

        public CounterComponent() {
            super("Counter: 0", SwingConstants.CENTER);
            setPreferredSize(new Dimension(175, 100));
        }

        void setCounter(int newValue) {
            counter = newValue;
            setText("Counter: " + counter);
        }

        void increase() {
            counter++;
            setText("Counter: " + counter);
        }

        void decrease() {
            counter--;
            setText("Counter: " + counter);
        }
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("Counter App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a CounterComponent and add it to the frame
        CounterComponent counterComponent = new CounterComponent();
        frame.getContentPane().add(counterComponent, BorderLayout.CENTER);

        // Create a JPanel for the buttons and place it at the bottom
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Create "-" button with ActionListener
        JButton decrementButton = new JButton("-");
        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counterComponent.decrease();
            }
        });
        buttonPanel.add(decrementButton);

        // Create "+" button with ActionListener
        JButton incrementButton = new JButton("+");
        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counterComponent.increase();
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

