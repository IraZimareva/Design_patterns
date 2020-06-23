package ex37TemplateMethod;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JComponent;

public class DrawArea extends JComponent {
    private Image image;
    private Graphics2D g2;

    private ArrayList<Shape> shapes= new ArrayList<>();

    public DrawArea() {
        setDoubleBuffered(false); //должен ли компонент использовать буфер для рисования вне экрана
    }

    public void paintComponent(Graphics g) {
       if (image == null) {
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//включить сглаживание всех отрисовываемых в дальнейшем фигур.

            new Thread(() -> {
                try {
                    while (true){ //бесконечный игровой цикл
                        Thread.sleep(10); //остановка потока
                        clear(); //очистка старой версии фигуры (репейнт)
                        for (Shape shape: shapes){
                            shape.draw();
                        }
                        repaint();
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        g.drawImage(image, 0, 0, null);
    }

    public void clear() {
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, getSize().width, getSize().height);
    } //перерисовка


    public void addSquare() {
        shapes.add(new SquareM(g2));
    }

    public void addBall() {
        shapes.add(new Ball(g2));
    }

    public void addStar() {
        shapes.add(new Star(g2));
    }

}