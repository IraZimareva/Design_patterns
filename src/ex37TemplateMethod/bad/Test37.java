package ex37TemplateMethod.bad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Test37 extends JFrame {

    public Test37() {
        super("MOON>MOONS");
        initComponents();
        timer.start();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        initBalls();
    }

    private void initBalls() {
        Random random = new Random();
        for(int i = 0; i < 7; i++) {
            Ball ball = new Ball(random.nextInt(200), 200);
            Ball.balls.add(ball);
        }
    }
    public void paint(Graphics g) {
        for (Ball ball : Ball.balls) {
            g.drawOval(ball.getX(), ball.getY(), 60, 60);
            //g.clearRect(ball.getX(), ball.getY(), 60, 60);
        }
    }

    Timer timer = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Ball ball : Ball.balls) {
                ball.move(ball);
                repaint();
            }
        }
    });
}
