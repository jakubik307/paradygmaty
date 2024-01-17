import java.awt.*;
import java.util.List;

public class Circle extends Shape{
    private final int radius;

    public Circle(Point position, boolean filled, int radius) {
        super(position, filled);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public List<Point> getBoundingBox() {
        Point p1 = new Point(position.getX(), position.getY());
        Point p2 = new Point(position.getX() + radius, position.getY());
        Point p3 = new Point(position.getX() + radius, position.getY() + radius);
        Point p4 = new Point(position.getX(), position.getY() + radius);
        return List.of(p1, p2, p3, p4);
    }

    @Override
    public void draw(Graphics g) {
        if (filled) g.fillOval(position.getX(), position.getY(), radius, radius);
        else g.drawOval(position.getX(), position.getY(), radius, radius);
    }
}
