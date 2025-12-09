import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai19_Calculator extends JFrame {
    private JTextField txtA, txtB, txtResult;
    private JRadioButton rAdd, rSub, rMul, rDiv;
    private JButton btnSolve, btnClear, btnExit;
    public Bai19_Calculator() {
        setTitle("Cộng - Trừ - Nhân - Chia");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(420, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8,8));
        JPanel top = new JPanel(new GridLayout(3,2,6,6));
        top.setBorder(BorderFactory.createEmptyBorder(10,10,0,10));
        top.add(new JLabel("Nhập a:"));
        txtA = new JTextField();
        top.add(txtA);
        top.add(new JLabel("Nhập b:"));
        txtB = new JTextField();
        top.add(txtB);
        top.add(new JLabel("Kết quả:"));
        txtResult = new JTextField();
        txtResult.setEditable(false);
        top.add(txtResult);
        add(top, BorderLayout.CENTER);
        JPanel pOps = new JPanel(new GridLayout(2,2));
        pOps.setBorder(BorderFactory.createTitledBorder("Chọn phép toán"));
        rAdd = new JRadioButton("Cộng (+)");
        rSub = new JRadioButton("Trừ (-)");
        rMul = new JRadioButton("Nhân (*)");
        rDiv = new JRadioButton("Chia (:)");
        ButtonGroup g = new ButtonGroup();
        g.add(rAdd); g.add(rSub); g.add(rMul); g.add(rDiv);
        pOps.add(rAdd); pOps.add(rSub); pOps.add(rMul); pOps.add(rDiv);
        add(pOps, BorderLayout.WEST);
        JPanel pBtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 12));
        btnSolve = new JButton("Giải");
        btnClear = new JButton("Xóa");
        btnExit  = new JButton("Thoát");
        pBtn.add(btnSolve); pBtn.add(btnClear); pBtn.add(btnExit);
        add(pBtn, BorderLayout.SOUTH);
        btnSolve.addActionListener(e -> {
            String sa = txtA.getText().trim(), sb = txtB.getText().trim();
            double a, b;
            try {
                a = Double.parseDouble(sa); b = Double.parseDouble(sb);
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(this, "Nhập a, b phải là số!");
                return;
            }
            Double res = null;
            if (rAdd.isSelected()) res = a + b;
            else if (rSub.isSelected()) res = a - b;
            else if (rMul.isSelected()) res = a * b;
            else if (rDiv.isSelected()) {
                if (Math.abs(b) < 1e-12) {
                    JOptionPane.showMessageDialog(this, "Không thể chia cho 0!");
                    return;
                } else res = a / b;
            } else {
                JOptionPane.showMessageDialog(this, "Chọn phép toán!");
                return;
            }
            txtResult.setText(String.format("%.6f", res));
        });
        btnClear.addActionListener(e -> {
            txtA.setText(""); txtB.setText(""); txtResult.setText("");
            rAdd.setSelected(false); rSub.setSelected(false); rMul.setSelected(false); rDiv.setSelected(false);
            txtA.requestFocus();
        });
        btnExit.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(this, "Thoát chương trình?", "Thoát", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                System.exit(0);
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Bai19_Calculator::new);
    }
}
