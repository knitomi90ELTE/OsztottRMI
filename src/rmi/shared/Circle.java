package rmi.shared;

import java.io.Serializable;

public class Circle implements Serializable {

    public long serialVersionUID = 123456;
    private Point cp;
    private int r;
    private transient Double c = null;

    public Circle(Point cp, int r) {
        this.cp = cp;
        this.r = r;
    }

    public double getC() {
        if (null == c) {
            c = new Double(2 * r * Math.PI);
        }
        return c.doubleValue();
    }

    public String toString() {
        return cp + " r: " + r + " area: " + c;
    }

    public void move(int dx, int dy) {
        cp.move(dx, dy);
    }

}
