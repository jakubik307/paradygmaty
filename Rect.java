import java.awt.*;
import java.util.List;

public class Rect extends Shape{
    private final int width;
    private final int height;

    public Rect(Point position, boolean filled, int width, int height) {
        super(position, filled);
        this.width = width;
        this.height = height;
    }

    @Override
    public List<Point> getBoundingBox() {
        Point p1 = new Point(position.getX(), position.getY());
        Point p2 = new Point(position.getX() + width, position.getY());
        Point p3 = new Point(position.getX() + width, position.getY() + height);
        Point p4 = new Point(position.getX(), position.getY() + height);
        return List.of(p1, p2, p3, p4);
    }

    @Override
    public void draw(Graphics g) {
        if (filled) g.fillRect(position.getX(), position.getY(), width, height);
        else g.drawRect(position.getX(), position.getY(), width, height);
    }
}
