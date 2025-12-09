import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai15_CheckBox extends JFrame {
    private JLabel lblText;
    private JCheckBox chkBold, chkItalic;
    public Bai15_CheckBox() {
        setTitle("Font Style");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        lblText = new JLabel("Nội dung mẫu");
        lblText.setFont(new Font("Arial", Font.PLAIN, 20));
        add(lblText);
        chkBold = new JCheckBox("Bold");
        chkItalic = new JCheckBox("Italic");
        add(chkBold);
        add(chkItalic);
        ItemListener changeFont = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int style = Font.PLAIN;
                if (chkBold.isSelected()) style |= Font.BOLD;
                if (chkItalic.isSelected()) style |= Font.ITALIC;
                lblText.setFont(new Font("Arial", style, 20));
            }
        };
        chkBold.addItemListener(changeFont);
        chkItalic.addItemListener(changeFont);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Bai15_CheckBox();
    }
}
