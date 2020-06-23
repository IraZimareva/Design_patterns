package ex37TemplateMethod;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Star extends Shape {

    public Star(Graphics2D g2) {
        super(g2);
    }

    int xPoints[] = {15, 25, 0, 30, 5};
    int yPoints[] = {0, 30, 10, 10, 30};

    public GeneralPath getStar(){
        GeneralPath star = new GeneralPath();

        star.moveTo(xPoints[0] + x, yPoints[0] + y);
        for (int i = 1; i < xPoints.length; i++) {
            star.lineTo(xPoints[i] + x, yPoints[i] + y);
        }
        star.closePath();
        return star;
    }

    @Override
    public void reDwaw() {
        g2.setPaint(Color.RED);
        g2.fill(getStar());
    }
}
