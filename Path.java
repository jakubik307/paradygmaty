import java.awt.*;
import java.util.List;

public class Path extends Item {
    private List<Point> points;

    public Path(Point position, List<Point> points) {
        super(position);
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public List<Point> getBoundingBox() {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (Point point : points) {
            if (point.getX() < minX) minX = point.getX();
            if (point.getX() > maxX) maxX = point.getX();
            if (point.getY() < minY) minY = point.getY();
            if (point.getY() > maxY) maxY = point.getY();
        }

        Point p1 = new Point(minX, minY);
        Point p2 = new Point(maxX, minY);
        Point p3 = new Point(maxX, maxY);
        Point p4 = new Point(minX, maxY);

        return List.of(p1, p2, p3, p4);
    }

    @Override
    public void draw(Graphics g) {
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        }
    }
}
