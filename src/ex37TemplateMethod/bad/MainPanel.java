package ex37TemplateMethod.bad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class MainPanel extends JPanel {

    private int x = 400;
    private int y = 300;
    private int width = 30;
    private int height = 30;

    public MainPanel() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(800, 600));
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //стереть
        Graphics2D g2 = (Graphics2D) g;
        Shape ball = new Ellipse2D.Double(x, y, width, height);
        g2.setColor(Color.BLUE);
        g2.fill(ball);
        //repaint();

        }

        Timer timer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //for (Ball ball : Ball.balls) {
                //ball.move(ball);
                if (x==800 || y==600){

                }
                x++;
                y++;
                repaint();
            //}
        }
    });
}


/*
            super.paintComponent(g); //стереть
            Graphics2D g2 = (Graphics2D) g;
            //Shape line = new Line2D.Double(3, 3, 303, 303);
            //Shape rect = new Rectangle(3, 3, 303, 303);
            Shape head = new Ellipse2D.Double(300, 150, 230, 300);
            Shape nose = new Ellipse2D.Double(400, 300, 30, 30);
            Shape eyeR = new Ellipse2D.Double(360, 210, 40, 50);
            Shape pointR = new Ellipse2D.Double(370, 235, 20, 20);
            Shape eyeL = new Ellipse2D.Double(440, 210, 40, 50);
            Shape pointL = new Ellipse2D.Double(450, 235, 20, 20);
            //QuadCurve2D.Double
            Shape mouth = new Arc2D.Double(350, 270, 150, 150, 210, 90.0, Arc2D.CHORD);

            g2.draw(head);
            g2.draw(eyeR);
            g2.draw(eyeL);
            g2.draw(mouth);
            g2.setColor(Color.MAGENTA);
            //g2.draw(nose);
            g2.fill(nose);

            g2.setColor(Color.BLACK);
            //g2.draw(pointR);
            //g2.draw(pointL);
            g2.fill(pointR);
            g2.fill(pointL);
*/

/*
        public Shape find (Point point) {
            for (Shape tmp: shapes.values()){
                //System.out.println(hashmap.get(key));
            //for (Shape tmp : shapes) {
                if (tmp.contains(point)) return tmp;
            }
            return null;
        }
        */