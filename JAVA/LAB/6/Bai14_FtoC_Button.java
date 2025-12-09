import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai14_FtoC_Button extends JFrame {
    private JTextField txtF, txtC;
    private JButton btnConvert;
    public Bai14_FtoC_Button() {
        setTitle("Fahrenheit → Celsius");
        setSize(300, 170);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 5, 5));
        add(new JLabel("Nhập độ F:"));
        txtF = new JTextField();
        add(txtF);
        add(new JLabel("Độ C:"));
        txtC = new JTextField();
        txtC.setEditable(false);
        add(txtC);
        btnConvert = new JButton("Chuyển đổi");
        add(btnConvert);
        // hàm chung
        ActionListener convertAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double f = Double.parseDouble(txtF.getText());
                    double c = (f - 32) * 5.0 / 9.0;
                    txtC.setText(String.format("%.2f", c));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Nhập sai!");
                }
            }
        };
        txtF.addActionListener(convertAction);
        btnConvert.addActionListener(convertAction);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Bai14_FtoC_Button();
    }
}
