package ex35.good;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;

public class MouthGood extends JPanel {
    private Shape shape;

    public MouthGood() {
        setBackground(Color.WHITE);
        shape = new Arc2D.Double(350, 270, 150, 150, 210, 90.0, Arc2D.CHORD);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e);
                if (shape.contains(e.getPoint()) == true){
                    //update(shape);
                    repaint();
                }
            }
        });
    }
/*
    public void update (Shape shape){
        if (color.equals(Color.BLUE)){
            color = Color.MAGENTA;
        }
        else color = Color.BLUE;
    }
*/


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.fill(shape);
    }

}
