import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai17b_ControlsDemo extends JFrame {
    private JComboBox<String> cboClass;
    private JSlider sliderSpeed;
    private JProgressBar progress;
    private JButton btnStart, btnStop;
    private Timer timer;
    public Bai17b_ControlsDemo() {
        setTitle("Bài 17b - Combo, Slider, ProgressBar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(420, 220);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8,8));
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        top.add(new JLabel("Chọn lớp:"));
        cboClass = new JComboBox<>(new String[]{"Lớp A", "Lớp B", "Lớp C"});
        top.add(cboClass);
        add(top, BorderLayout.NORTH);
        JPanel center = new JPanel(new GridLayout(2,1));
        sliderSpeed = new JSlider(0, 100, 30);
        sliderSpeed.setMajorTickSpacing(25);
        sliderSpeed.setPaintTicks(true);
        sliderSpeed.setPaintLabels(true);
        center.add(new JLabel("Tốc độ (càng lớn càng nhanh):"));
        center.add(sliderSpeed);
        add(center, BorderLayout.CENTER);
        JPanel south = new JPanel(new FlowLayout(FlowLayout.LEFT));
        progress = new JProgressBar(0, 100);
        progress.setPreferredSize(new Dimension(250,25));
        south.add(progress);
        btnStart = new JButton("Start");
        btnStop  = new JButton("Stop");
        south.add(btnStart); south.add(btnStop);
        add(south, BorderLayout.SOUTH);
        timer = new Timer(200, e -> {
            int v = progress.getValue() + 1;
            if (v > 100) v = 0;
            progress.setValue(v);
        });
        btnStart.addActionListener(e -> {
            int speed = sliderSpeed.getValue(); // 0..100
            int delay = Math.max(10, 500 - speed*4); // map speed -> delay
            timer.setDelay(delay);
            timer.start();
            btnStart.setEnabled(false);
            btnStop.setEnabled(true);
        });
        btnStop.addActionListener(e -> {
            timer.stop();
            btnStart.setEnabled(true);
            btnStop.setEnabled(false);
        });
        btnStop.setEnabled(false);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Bai17b_ControlsDemo::new);
    }
}
