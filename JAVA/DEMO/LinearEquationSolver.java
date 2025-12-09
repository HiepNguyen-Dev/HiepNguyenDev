package DEMO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent; // For ActionEvent (when a button is clicked)
import java.awt.event.ActionListener; // For ActionListener (to handle button clicks)

public class LinearEquationSolver extends JFrame {
    // Declare UI components as instance variables so they can be accessed by action listeners
    private JTextField txtA;
    private JTextField txtB;
    private JLabel lblResult;

    /**
     * Constructor for the LinearEquationSolver class.
     * Sets up the GUI for the application.
     */
    public LinearEquationSolver() {
        // --- Frame Setup ---
        setTitle("Linear Equation Solver: ax + b = 0"); // Set the title of the window
        setSize(400, 200);                  // Set the initial size of the window (width, height)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define behavior when the close button is clicked (exit application)
        setLocationRelativeTo(null);                    // Center the window on the screen
        //setResizable(false);

        // --- Layout Manager ---
        // Using GridLayout to arrange components in a grid.
        // GridLayout(rows, cols, hgap, vgap)
        // 4 rows, 2 columns, with 10 pixels horizontal and vertical gap between components.
        setLayout(new GridLayout(4, 2, 10, 10));

        // --- Component Creation ---
        JLabel lblA = new JLabel("Enter a:");
        txtA = new JTextField(10); // 10 is the preferred column width, not a strict limit

        JLabel lblB = new JLabel("Enter b:");
        txtB = new JTextField(10);

        JButton btnSolve = new JButton("Solve");
        lblResult = new JLabel("Result: "); // Label to display the solution

        // --- Add Components to the Frame ---
        // Components are added row by row, column by column according to GridLayout
        add(lblA);
        add(txtA);
        add(lblB);
        add(txtB);
        add(new JLabel()); // Empty label for spacing/alignment in the grid
        add(btnSolve);
        //add(new JLabel()); // Another empty label for spacing
        add(lblResult);

        // --- Event Handling ---
        // Add an ActionListener to the "Solve" button.
        // When the button is clicked, the actionPerformed method will be executed.
        btnSolve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solveEquation();
            }
        });
    }
    /**
     * This method reads the input values for 'a' and 'b',
     * solves the equation ax + b = 0, and displays the result.
     */
    private void solveEquation() {
        try {
            // Get text from JTextFields and parse them to double
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());

            String resultText;

            // Logic to solve the linear equation ax + b = 0
            if (a == 0) {
                if (b == 0) {
                    resultText = "Result: Infinite solutions (0x + 0 = 0)";
                } else {
                    resultText = "Result: No solution (0x + " + b + " = 0)";
                }
            } else {
                double x = -b / a;
                resultText = "Result: x = " + String.format("%.2f", x); // Format x to 2 decimal places
            }
            lblResult.setText(resultText); // Update the result label
        } catch (NumberFormatException ex) {
            // Handle cases where the user inputs non-numeric data
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numbers for 'a' and 'b'.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            lblResult.setText("Result: Invalid Input"); // Clear or reset result label
        }
    }
    /**
     * The main method is the entry point for the application.
     * It ensures the GUI is created and updated on the Event Dispatch Thread (EDT).
     */
    public static void main(String[] args) {
        // SwingUtilities.invokeLater ensures that GUI creation and updates
        // are performed on the Event Dispatch Thread (EDT), which is crucial
        // for thread safety in Swing applications.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create an instance of our JFrame and make it visible
                new LinearEquationSolver().setVisible(true);
            }
        });
    }
}