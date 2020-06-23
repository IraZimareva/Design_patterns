package ex35;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.util.*;

import javax.swing.JPanel;

    public class MyPanel extends JPanel  {

        private Map <String, Shape> shapes = new HashMap <String, Shape>();
        private Shape current = null;
        private ObservableMy <MouseAdapter> listObservable = new ObservableMy <MouseAdapter>();

        private Color colorNose = Color.BLUE;
        private boolean isMouthOpen = true;
        private boolean isEyeROpen = true;
        private boolean isEyeLOpen = true;

        public MyPanel() {
            shapes.put( "head", new Ellipse2D.Double(300, 150, 230, 300));
            shapes.put( "nose", new Ellipse2D.Double(400, 300, 30, 30));
            shapes.put("mouth"  ,new Arc2D.Double(350, 270, 150, 150, 210, 90.0, Arc2D.CHORD));
            shapes.put( "eyeR", new Ellipse2D.Double(360, 210, 40, 50));
            shapes.put("pointR" ,new Ellipse2D.Double(370, 235, 20, 20));
            shapes.put("eyeL" ,new Ellipse2D.Double(440, 210, 40, 50));
            shapes.put("pointL" ,new Ellipse2D.Double(450, 235, 20, 20));

            setBackground(Color.WHITE);
            setPreferredSize(new Dimension(800, 600));

            listObservable.addListener(new MouseHandlerNose());
            listObservable.addListener(new MouseHandlerMouth());
            listObservable.addListener(new MouseHandlerEyeRight());
            listObservable.addListener(new MouseHandlerEyeLeft());
            for (MouseAdapter listener: listObservable.getListeners()){
                addMouseListener(listener);
            }

            //addMouseListener(new MouseHandlerNose());
            //addMouseListener(new MouseHandlerMouth());
            //addMouseListener(new MouseHandlerEyeRight());
            //addMouseListener(new MouseHandlerEyeLeft());
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g); //стереть
            Graphics2D g2 = (Graphics2D) g;
            //for (Shape tmp: shapes.values()){
            for (Map.Entry <String, Shape> tmp: shapes.entrySet()){
                //System.out.println(entry.getKey() + " = " + entry.getValue());
                if (tmp.getKey().equals("pointR") || tmp.getKey().equals("pointL")  ) {
                    g2.setColor(Color.BLACK);
                    g2.fill(tmp.getValue());
                }
                if (tmp.getKey().equals("nose")) {
                    g2.setColor(colorNose);
                    g2.fill(tmp.getValue());
                }
                g2.draw(tmp.getValue());
                g2.setColor(Color.BLACK);
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

        private class MouseHandlerNose extends MouseAdapter implements ObserverMy{
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    current = shapes.get("nose");
                    //cursor = find(e.getPoint());
                    if (current.contains(e.getPoint()) == true){
                    //if (current != null){
                        update();
                        repaint();
                    }
                }

                public void update (){
                    if (colorNose.equals(Color.BLUE)){
                        colorNose = Color.MAGENTA;
                    }
                    else colorNose = Color.BLUE;
                }


        }

        private class MouseHandlerMouth extends MouseAdapter implements ObserverMy{
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                current = shapes.get("mouth");
                if (current.contains(e.getPoint()) == true){
                    update();
                    repaint();
                }
            }
            public void update (){
                if (isMouthOpen){
                    shapes.remove("mouth");
                    shapes.put("mouth",new Arc2D.Double(350, 370, 150, 50, 210, 90.0, Arc2D.CHORD));
                    isMouthOpen = false;
                }
                else {
                    shapes.remove("mouth");
                    shapes.put("mouth" ,new Arc2D.Double(350, 270, 150, 150, 210, 90.0, Arc2D.CHORD));
                    isMouthOpen = true;
                }
            }
        }

        private class MouseHandlerEyeRight extends MouseAdapter implements ObserverMy{
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                current = shapes.get("eyeR");
                if (current.contains(e.getPoint()) == true){
                    update();
                    repaint();
                }
            }
            public void update (){
                if (isEyeROpen){
                    shapes.remove("pointR");
                    isEyeROpen = false;
                }
                else {
                    shapes.put("pointR" ,new Ellipse2D.Double(370, 235, 20, 20));
                    isEyeROpen = true;
                }
            }
        }

        private class MouseHandlerEyeLeft extends MouseAdapter implements ObserverMy{
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                current = shapes.get("eyeL");
                if (current.contains(e.getPoint()) == true){
                    update();
                    repaint();
                }
            }
            public void update (){
                if (isEyeLOpen){
                    shapes.remove("pointL");
                    isEyeLOpen = false;
                }
                else {
                    shapes.put("pointL" ,new Ellipse2D.Double(450, 235, 20, 20));
                    isEyeLOpen = true;
                }
            }
        }
    }
