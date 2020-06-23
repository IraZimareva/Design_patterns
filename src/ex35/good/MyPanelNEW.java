package ex35.good;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MyPanelNEW extends JPanel  {

    private List<Object> shapes = new ArrayList<>();
    private Shape current = null;


    //private boolean inShape = false;

    public MyPanelNEW() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(800, 600));

        addNose();

        addMouseListener(new MouseHandler());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Object s : shapes) {
            if (s instanceof Nose) {
                ((Nose) s).draw(g);
            } //else if (s instanceof Star) {
            //((Star) s).draw(g);
        }
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


    public Shape find (Point point) {
        for (Object tmp : shapes) {
            if (tmp instanceof Nose) {
                ((Nose) tmp).getNose().contains(point);
                return ((Nose) tmp).getNose();
            }
        }
        return null;
    }




    public void addNose() {
        shapes.add (new Nose());
        repaint();
    }


    private class MouseHandler extends MouseAdapter {
            private boolean inShape = false;

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                current = find(e.getPoint());
                //boolean cursor = current.contains(e.getX(), e.getY());
                //if (cursor != inShape) {
                    //inShape = cursor;
                if (current != null){
                    //g2.setColor(Color.RED);
                    //g2.draw(nose);
                    //g2.fill(nose);
                    repaint();
                }
            }
        }
    }
