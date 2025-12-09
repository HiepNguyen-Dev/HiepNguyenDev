import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai17a_BasicComponents extends JFrame {
    private JTextField txtName, txtAge;
    private JRadioButton rMale, rFemale;
    private JCheckBox cbMusic, cbSport, cbCode;
    private JList<String> listDept;
    private JButton btnShow;
    public Bai17a_BasicComponents() {
        setTitle("Bài 17a - Basic Components");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 320);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8,8));
        JPanel pTop = new JPanel(new GridLayout(3, 2, 6, 6));
        pTop.setBorder(BorderFactory.createTitledBorder("Thông tin cơ bản"));
        pTop.add(new JLabel("Họ tên:"));
        txtName = new JTextField();
        pTop.add(txtName);
        pTop.add(new JLabel("Tuổi:"));
        txtAge = new JTextField();
        pTop.add(txtAge);
        JPanel pGender = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pGender.add(new JLabel("Giới tính:"));
        rMale = new JRadioButton("Nam");
        rFemale = new JRadioButton("Nữ");
        ButtonGroup g = new ButtonGroup();
        g.add(rMale); g.add(rFemale);
        pGender.add(rMale); pGender.add(rFemale);
        pTop.add(pGender);
        add(pTop, BorderLayout.NORTH);
        JPanel pCenter = new JPanel(new GridLayout(1,2,8,8));
        JPanel pHobby = new JPanel(new GridLayout(3,1));
        pHobby.setBorder(BorderFactory.createTitledBorder("Sở thích"));
        cbMusic = new JCheckBox("Nghe nhạc");
        cbSport = new JCheckBox("Thể thao");
        cbCode  = new JCheckBox("Lập trình");
        pHobby.add(cbMusic); pHobby.add(cbSport); pHobby.add(cbCode);
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("CNTT");
        model.addElement("Kinh tế");
        model.addElement("Thiết kế");
        model.addElement("Cơ khí");
        listDept = new JList<>(model);
        listDept.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane sp = new JScrollPane(listDept);
        sp.setBorder(BorderFactory.createTitledBorder("Chọn khoa"));
        pCenter.add(pHobby); pCenter.add(sp);
        add(pCenter, BorderLayout.CENTER);
        btnShow = new JButton("Hiển thị");
        add(btnShow, BorderLayout.SOUTH);
        btnShow.addActionListener(e -> {
            String name = txtName.getText().trim();
            String ageS = txtAge.getText().trim();
            if (name.isEmpty() || ageS.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nhập đầy đủ họ tên và tuổi!");
                return;
            }
            int age;
            try { age = Integer.parseInt(ageS); }
            catch(Exception ex) { JOptionPane.showMessageDialog(this, "Tuổi phải là số"); txtAge.requestFocus(); return; }
            String gender = rMale.isSelected() ? "Nam" : rFemale.isSelected() ? "Nữ" : "Chưa chọn";
            StringBuilder hobby = new StringBuilder();
            if (cbMusic.isSelected()) hobby.append("Nghe nhạc, ");
            if (cbSport.isSelected()) hobby.append("Thể thao, ");
            if (cbCode.isSelected()) hobby.append("Lập trình, ");
            if (hobby.length()>0) hobby.setLength(hobby.length()-2);
            else hobby.append("Không");
            String dept = listDept.getSelectedValue();
            if (dept==null) dept = "Không chọn";
            String info = String.format("Họ tên: %s\nTuổi: %d\nGiới tính: %s\nSở thích: %s\nKhoa: %s",
                    name, age, gender, hobby.toString(), dept);
            JOptionPane.showMessageDialog(this, info, "Kết quả", JOptionPane.INFORMATION_MESSAGE);
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Bai17a_BasicComponents::new);
    }
}
