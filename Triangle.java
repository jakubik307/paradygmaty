import java.awt.*;
import java.util.List;

public class Triangle extends Shape {
    protected Point p1;
    protected Point p2;
    protected Point p3;

    public Triangle(boolean filled, Point p1, Point p2, Point p3) {
        super(new Point(Math.min(Math.min(p1.getX(), p2.getX()), p3.getX()), Math.min(Math.min(p1.getY(), p2.getY()), p3.getY())), filled);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    @Override
    List<Point> getBoundingBox() {
        Point p1 = new Point(position.getX(), position.getY());
        Point p2 = new Point(Math.max(Math.max(this.p1.getX(), this.p2.getX()), this.p3.getX()), position.getY());
        Point p3 = new Point(Math.max(Math.max(this.p1.getX(), this.p2.getX()), this.p3.getX()), Math.max(Math.max(this.p1.getY(), this.p2.getY()), this.p3.getY()));
        Point p4 = new Point(position.getX(), Math.max(Math.max(this.p1.getY(), this.p2.getY()), this.p3.getY()));
        return List.of(p1, p2, p3, p4);
    }

    @Override
    void draw(Graphics g) {
        if (filled) g.fillPolygon(new int[]{p1.getX(), p2.getX(), p3.getX()}, new int[]{p1.getY(), p2.getY(), p3.getY()}, 3);
        else g.drawPolygon(new int[]{p1.getX(), p2.getX(), p3.getX()}, new int[]{p1.getY(), p2.getY(), p3.getY()}, 3);
    }
}
