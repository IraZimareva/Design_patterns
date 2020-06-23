package ex35;

import javax.swing.*;
import java.awt.*;

public class MainTest35 {
    public static void main(String[]args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Smile");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                //frame.setContentPane(new MyPanel());
                frame.add(new MyPanel());
                //frame.add(new MyPanelNEW());
                //frame.add(new NoseGood());
                //frame.add(new MouthGood());
                frame.setVisible(true);
            }
        });
    }
}
