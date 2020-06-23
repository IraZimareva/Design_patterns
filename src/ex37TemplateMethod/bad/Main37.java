package ex37TemplateMethod.bad;

import javax.swing.*;
import java.awt.*;

public class Main37 {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Template Method");
                //JFrame frame = new Test37();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                //frame.setContentPane(new MainPanel());
                frame.add(new MainPanel());
                frame.setVisible(true);
            }
        });
    }
}
