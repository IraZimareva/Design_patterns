package ex37TemplateMethod;

import java.awt.*;

public class Ball extends Shape {

    public Ball(Graphics2D g2) {
        super(g2);
    }

    @Override
    public void reDwaw() {
        g2.setPaint(Color.GREEN);
        g2.fillOval(x,y,RADIUS,RADIUS);
    }

}
