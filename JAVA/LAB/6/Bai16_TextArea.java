import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai16_TextArea extends JFrame {
    private JTextArea txtInput;
    private JTextField txtWords, txtAvg;
    private JButton btnCalc;
    public Bai16_TextArea() {
        setTitle("Thống kê văn bản");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        txtInput = new JTextArea(5, 30);
        add(new JScrollPane(txtInput), BorderLayout.NORTH);
        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.add(new JLabel("Tổng số từ:"));
        txtWords = new JTextField();
        txtWords.setEditable(false);
        panel.add(txtWords);
        panel.add(new JLabel("TB ký tự/từ:"));
        txtAvg = new JTextField();
        txtAvg.setEditable(false);
        panel.add(txtAvg);
        add(panel, BorderLayout.CENTER);
        btnCalc = new JButton("Thống kê");
        add(btnCalc, BorderLayout.SOUTH);
        btnCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = txtInput.getText().trim();
                if (s.isEmpty()) {
                    txtWords.setText("0");
                    txtAvg.setText("0");
                    return;
                }
                String[] words = s.split("\\s+");
                int totalWords = words.length;
                int totalChar = 0;
                for (String w : words) totalChar += w.length();
                txtWords.setText(String.valueOf(totalWords));
                txtAvg.setText(String.format("%.2f", totalChar * 1.0 / totalWords));
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new Bai16_TextArea();
    }
}
