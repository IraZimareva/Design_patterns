package ex37TemplateMethod;

import java.awt.*;

public class SquareM extends Shape {

    public SquareM(Graphics2D g2) {
        super(g2);
    }

    @Override
    public void reDwaw() {
        g2.setPaint(Color.BLUE);
        g2.fillRect(x,y,RADIUS,RADIUS);
    }


}
