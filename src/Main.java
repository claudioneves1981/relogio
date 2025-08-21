import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Color On = Color.RED;
    private static final Color Off = Color.CYAN;
    private static final JFrame frame = new JFrame("Relógio");
    private static final JPanel panel = new JPanel();
    private static final Color[][]  digitColors ={{On},
            {On},
            {On},
            {On},
            {On},
            {On},
            {On},
            {On},
            {On},
            {On}
    };



    public static void main(String[] args) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        panel.setLayout(new FlowLayout());
        panel.setVisible(true);

        frame.add(panel);
        frame.setVisible(true);

        JLabel H1Segments = Create7Segment();
        JLabel H2Segments = Create7Segment();
        //AddColon();
        JLabel M1Segments = Create7Segment();
        JLabel M2Segments = Create7Segment();
        //AddColon();
        JLabel S1Segments = Create7Segment();
        JLabel S2Segments = Create7Segment();


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
                DisplayDigit(H1Segments, h1);
                DisplayDigit(H2Segments, h2);
                //AddColon();
                DisplayDigit(M1Segments, m1);
                DisplayDigit(M2Segments, m2);
                //AddColon();
                DisplayDigit(S1Segments, s1);
                DisplayDigit(S2Segments, s2);

            }
        });

        swingTimer.start();

    }

    public static JLabel Create7Segment() {

        JLabel segment = new JLabel();
        segment.setBackground(On);
        panel.add(segment);
        return segment;

    }

   public static void DisplayDigit(JLabel segment, int digit) {
       var lit = digitColors[digit];
       for (int j = 0;j<1; j++){
           segment.setText(String.valueOf(digit));
           segment.setFont(new Font("Tahoma",Font.BOLD,100));
           segment.setForeground(lit[j]);
           panel.add(segment);
      }
   }

    public static void AddColon() {

        JLabel dot1 = new JLabel(":");
        dot1.setFont(new Font("Tahoma",Font.BOLD,100));
        dot1.setForeground(On);
        panel.add(dot1);

    }
}