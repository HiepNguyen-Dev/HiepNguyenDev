import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai18_QuadraticSolver extends JFrame {
    private JTextField txtA, txtB, txtC, txtResult;
    private JButton btnSolve, btnClear, btnExit;
    public Bai18_QuadraticSolver() {
        setTitle("Giải Phương Trình Bậc 2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(420, 250);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(6,6,6,6);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx=0; g.gridy=0; add(new JLabel("a:"), g);
        g.gridx=1; txtA = new JTextField(); add(txtA, g);
        g.gridx=0; g.gridy=1; add(new JLabel("b:"), g);
        g.gridx=1; txtB = new JTextField(); add(txtB, g);
        g.gridx=0; g.gridy=2; add(new JLabel("c:"), g);
        g.gridx=1; txtC = new JTextField(); add(txtC, g);
        g.gridx=0; g.gridy=3; add(new JLabel("Kết quả:"), g);
        g.gridx=1; txtResult = new JTextField(); txtResult.setEditable(false); add(txtResult, g);
        JPanel pBtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));
        btnSolve = new JButton("Giải");
        btnClear = new JButton("Xóa trắng");
        btnExit  = new JButton("Thoát");
        pBtn.add(btnSolve); pBtn.add(btnClear); pBtn.add(btnExit);
        g.gridx=0; g.gridy=4; g.gridwidth=2; add(pBtn, g);
        btnSolve.addActionListener(e -> {
            String sa = txtA.getText().trim(), sb = txtB.getText().trim(), sc = txtC.getText().trim();
            double a,b,c;
            try {
                a = Double.parseDouble(sa); b = Double.parseDouble(sb); c = Double.parseDouble(sc);
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(this, "Nhập a, b, c đúng định dạng số!");
                return;
            }
            if (Math.abs(a) < 1e-12) {
                // bx + c = 0
                if (Math.abs(b) < 1e-12) {
                    txtResult.setText(Math.abs(c) < 1e-12 ? "Vô số nghiệm" : "Vô nghiệm");
                } else {
                    double x = -c / b;
                    txtResult.setText(String.format("Phương trình bậc 1, x = %.6f", x));
                }
                return;
            }
            double delta = b*b - 4*a*c;
            if (delta < 0) {
                txtResult.setText("Vô nghiệm (delta < 0)");
            } else if (Math.abs(delta) < 1e-12) {
                double x = -b / (2*a);
                txtResult.setText(String.format("Nghiệm kép: x = %.6f", x));
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2*a);
                double x2 = (-b - Math.sqrt(delta)) / (2*a);
                txtResult.setText(String.format("x1 = %.6f ; x2 = %.6f", x1, x2));
            }
        });
        btnClear.addActionListener(e -> {
            txtA.setText(""); txtB.setText(""); txtC.setText(""); txtResult.setText("");
            txtA.requestFocus();
        });
        btnExit.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(this, "Thoát chương trình?", "Thoát", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                System.exit(0);
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Bai18_QuadraticSolver::new);
    }
}
