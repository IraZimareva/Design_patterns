package ex37TemplateMethod;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame {
    JButton closeBtn,  startBtn;
    JComboBox jComboBox;
    DrawArea drawArea;
    ActionListener actionListener = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == closeBtn) {
                System.exit(0);
            }
            else if (e.getSource() == startBtn) {
                int k = jComboBox.getSelectedIndex();
                switch (k){
                    case 0: drawArea.addBall();
                        break;
                    case 1: drawArea.addSquare();
                        break;
                    case 2: drawArea.addStar();
                        break;
                }
            }
        }
    };

    public static void main(String[] args) {
        new MainFrame().init();
    }

    public void init() {
        JFrame frame = new JFrame("Template Method");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());

        drawArea = new DrawArea();
        content.add(drawArea, BorderLayout.CENTER);

        startBtn = new JButton("GO");
        startBtn.addActionListener(actionListener);
        closeBtn = new JButton("Close");
        closeBtn.addActionListener(actionListener);

        JPanel controls = new JPanel();
        content.add(controls, BorderLayout.PAGE_END);
        controls.add(startBtn);
        controls.add(closeBtn);

        jComboBox= new JComboBox();
        jComboBox.addItem("Ball");
        jComboBox.addItem("Square");
        jComboBox.addItem("Star");
        jComboBox.setSelectedIndex(0);;
        controls.add(jComboBox,BorderLayout.AFTER_LAST_LINE);

        frame.setVisible(true);
    }
}
