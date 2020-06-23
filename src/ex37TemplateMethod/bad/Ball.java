package ex37TemplateMethod.bad;

import java.util.ArrayList;
import java.util.List;

public class Ball {
        private int x;
        private int y;
        public static List<Ball> balls = new ArrayList<>();

        public Ball(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void addBall(Ball b) {
            balls.add(b);
        }

        public void removeBall(Ball b) {
            balls.remove(b);
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public  void move(Ball ball) {
            ball.setX(x+1);
            ball.setY(y+1);
        }
    }
