package ex35.good;

import java.awt.*;
import java.awt.geom.*;

public class Nose {
    private static final Color first = Color.MAGENTA;
    private static final Color second = Color.BLUE;
    private Shape nose;
    private boolean inShape = false;

    public Shape getNose() {
        return nose;
    }

    public void setNose(Shape nose) {
        this.nose = nose;
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        nose = new Ellipse2D.Double(400, 300, 30, 30);
        Color curCol = g2.getColor();
        //g2.setColor(inShape ? first : second);
        //g2.setColor((first));
        if (g2.getColor().equals(first)) {
            g2.setColor(second);
        }
        else {g2.setColor(first);}
        g2.fill(nose);
        g2.setColor(curCol);
    }
}


