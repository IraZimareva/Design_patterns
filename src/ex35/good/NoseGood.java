package ex35.good;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.*;

public class NoseGood extends JPanel {

    private Color color = Color.BLUE;
    private Shape shape;

            public NoseGood() {
                setBackground(Color.WHITE);
                shape = new Ellipse2D.Double(400, 300, 30, 30);

                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                            //super.mouseClicked(e);
                            if (shape.contains(e.getPoint()) == true){
                                update(shape);
                                repaint();
                            }
                    }
            });
            }

            public void update (Shape shape){
                if (color.equals(Color.BLUE)){
                    color = Color.MAGENTA;
                }
                else color = Color.BLUE;
            }



            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                //g2d.setColor(Color.BLACK);
                //Paint p = g2d.getPaint();
                //g2d.setPaint(inShape ? first : second);
                g2d.setColor(color);
                g2d.fill(shape);
                //g2d.setPaint(p);
            }
        }
