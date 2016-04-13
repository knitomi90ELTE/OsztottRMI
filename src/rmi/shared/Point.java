package rmi.shared;

import java.io.Serializable;

public class Point implements Serializable {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
