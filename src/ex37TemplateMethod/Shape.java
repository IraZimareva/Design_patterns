package ex37TemplateMethod;

import java.awt.*;

public abstract class Shape {

    public final int DEFAULT_WIDTH = 580;//Ширина игрового поля
    public final int DEFAULT_HEIGHT = 320; //Высота игрового поля
    public final int RADIUS = 30;

    public int x = DEFAULT_WIDTH - RADIUS; //начальные координаты
    public int y = DEFAULT_HEIGHT - RADIUS;

    private int dx = 3; //приращение/скорость
    private int dy = 1;

    public Graphics2D g2;

    public Shape(Graphics2D g2) {
        this.g2 = g2;
    }

    public abstract void reDwaw();

    public void draw() {
        reDwaw();

        x += dx;
        y += dy;
        if (x <= RADIUS) {
            x = RADIUS;
            dx = -dx;
        }
        if (x >= DEFAULT_WIDTH - RADIUS) {
            x = DEFAULT_WIDTH - RADIUS;
            dx = -dx;
        }
        if (y <= RADIUS) {
            y = RADIUS;
            dy = -dy;
        }
        if (y >= DEFAULT_HEIGHT - RADIUS) {
            y = DEFAULT_HEIGHT - RADIUS;
            dy = -dy;
        }
    }
}


