import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class Main {

    private static final Color On = Color.RED;
    private static final JFrame frame = new JFrame("Relógio");
    private static final JPanel panel = new JPanel();


    public static void main(String[] args) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        panel.setLayout(new FlowLayout());
        panel.setVisible(true);

        frame.add(panel);
        frame.setVisible(true);

        JLabel H1 = GenerateLabel();
        JLabel H2 = GenerateLabel();
        JLabel Colon1 = new JLabel(":");
        JLabel M1 = GenerateLabel();
        JLabel M2 = GenerateLabel();
        JLabel Colon2 = new JLabel(":");
        JLabel S1 = GenerateLabel();
        JLabel S2 = GenerateLabel();


       Timer swingTimer = new Timer(1000, new ActionListener() {
            final int tick = 0;
            @Override
            public void actionPerformed(ActionEvent e) {

                LocalDateTime now = LocalDateTime.now();
                int h = now.getHour();
                int m = now.getMinute();
                int s = now.getSecond();
                int h1 = h / 10;
                int h2 = h % 10;
                int m1 = m / 10;
                int m2 = m % 10;
                int s1 = s / 10;
                int s2 = s % 10;
                DisplayDigit(H1, h1);
                DisplayDigit(H2, h2);
                AddColon(Colon1);
                DisplayDigit(M1, m1);
                DisplayDigit(M2, m2);
                AddColon(Colon2);
                DisplayDigit(S1, s1);
                DisplayDigit(S2, s2);

            }
        });

        swingTimer.start();

    }

    public static JLabel GenerateLabel() {

        JLabel segment = new JLabel();
        segment.setBackground(On);
        panel.add(segment);
        return segment;

    }

   public static void DisplayDigit(JLabel segment, int digit) {

           segment.setText(String.valueOf(digit));
           segment.setFont(new Font("Tahoma",Font.BOLD,100));
           segment.setForeground(On);
           panel.add(segment);

   }

    public static void AddColon(JLabel dot1) {

        dot1.setFont(new Font("Tahoma",Font.BOLD,100));
        dot1.setForeground(On);
        panel.add(dot1);

    }
}