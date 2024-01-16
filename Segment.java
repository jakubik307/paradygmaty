import java.awt.*;
import java.util.List;

public class Segment extends Primitive{
    private final double length;
    private final Point start;
    private final Point end;

    public Segment(Point start, Point end) {
        super(new Point(Math.min(start.getX(), end.getX()), Math.min(start.getY(), end.getY())));
        this.start = start;
        this.end = end;
        this.length = start.distance(end);
    }

    public double getLength() {
        return length;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    List<Point> getBoundingBox() {
        Point p1 = new Point(position.getX(), position.getY());
        Point p2 = new Point(position.getX() + Math.max(start.getX(), end.getX()), position.getY());
        Point p3 = new Point(position.getX() + Math.max(start.getX(), end.getX()), position.getY() + Math.max(start.getY(), end.getY()));
        Point p4 = new Point(position.getX(), position.getY() + Math.max(start.getY(), end.getY()));
        return List.of(p1, p2, p3, p4);
    }

    @Override
    void draw(Graphics g) {
        g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
    }
}
