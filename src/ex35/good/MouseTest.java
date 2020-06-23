package ex35.good;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;


    public class MouseTest extends JFrame {

        public MouseTest() {
            super("Mouse motion test");
            JPanel cp = new JPanel(new BorderLayout());
            setContentPane(cp);
            cp.add(new MainPanel(), BorderLayout.CENTER);
            setSize(600, 500);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

        public static void main(String[] args) {
            new MouseTest().setVisible(true);
        }


        static class MainPanel extends JPanel {

            private static final Color out = Color.blue;
            private static final Color in = Color.red;
            private boolean inShape = false;
            private Shape shape;


            public MainPanel() {
                TextLayout layout = new TextLayout("AWS", new Font("dialog", Font.BOLD, 120),
                        new FontRenderContext(new AffineTransform(), false, false));
                shape = layout.getOutline(AffineTransform.getTranslateInstance(100, 200));
                setBackground(Color.white);
                addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent e) {
                        boolean inS = shape.contains(e.getX(), e.getY());
                        if (inS != inShape) {
                            inShape = inS;
                            repaint();
                        }
                    }
                });
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Paint p = g2d.getPaint();
                g2d.setPaint(inShape ? in : out);
                g2d.fill(shape);
                g2d.setPaint(p);
            }
        }
    }
