import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai17c_MenuDemo extends JFrame {
    private JTextArea area;
    private JPopupMenu popup;
    public Bai17c_MenuDemo() {
        setTitle("Bài 17c - Menu & Popup");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 360);
        setLocationRelativeTo(null);
        // Menu bar
        JMenuBar mb = new JMenuBar();
        JMenu mFile = new JMenu("File");
        JMenuItem miNew = new JMenuItem("New");
        JMenuItem miExit = new JMenuItem("Exit");
        mFile.add(miNew); mFile.addSeparator(); mFile.add(miExit);
        JMenu mEdit = new JMenu("Edit");
        JMenuItem miCut = new JMenuItem("Cut");
        JMenuItem miCopy = new JMenuItem("Copy");
        JMenuItem miPaste = new JMenuItem("Paste");
        mEdit.add(miCut); mEdit.add(miCopy); mEdit.add(miPaste);
        JMenu mHelp = new JMenu("Help");
        JMenuItem miAbout = new JMenuItem("About");
        mHelp.add(miAbout);
        mb.add(mFile); mb.add(mEdit); mb.add(mHelp);
        setJMenuBar(mb);
        area = new JTextArea();
        add(new JScrollPane(area), BorderLayout.CENTER);
        // popup menu for right-click
        popup = new JPopupMenu();
        popup.add(miCut = new JMenuItem("Cut"));
        popup.add(miCopy = new JMenuItem("Copy"));
        popup.add(miPaste = new JMenuItem("Paste"));
        area.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) { showIfPopup(e); }
            public void mouseReleased(MouseEvent e) { showIfPopup(e); }
            private void showIfPopup(MouseEvent e) {
                if (e.isPopupTrigger()) popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
        // Actions
        miNew.addActionListener(e -> area.setText(""));
        miExit.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(this, "Thoát chương trình?","Exit",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
                System.exit(0);
        });
        miAbout.addActionListener(e -> JOptionPane.showMessageDialog(this, "Demo Menu & Popup\nBy Lab Java"));
        // clipboard-like simple actions using selection
        miCut.addActionListener(e -> {
            area.cut();
        });
        miCopy.addActionListener(e -> area.copy());
        miPaste.addActionListener(e -> area.paste());
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Bai17c_MenuDemo::new);
    }
}
