import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai13_FtoC extends JFrame {
    private JTextField txtF, txtC;
    public Bai13_FtoC() {
        setTitle("Fahrenheit → Celsius");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 5, 5));
        add(new JLabel("Nhập độ F:"));
        txtF = new JTextField();
        add(txtF);
        add(new JLabel("Độ C:"));
        txtC = new JTextField();
        txtC.setEditable(false);
        add(txtC);
        txtF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double f = Double.parseDouble(txtF.getText());
                    double c = (f - 32) * 5.0 / 9.0;
                    txtC.setText(String.format("%.2f", c));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Nhập sai!");
                }
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new Bai13_FtoC();
    }
}
