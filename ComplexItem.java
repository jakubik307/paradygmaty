import java.awt.*;
import java.util.Comparator;
import java.util.List;

public class ComplexItem extends Item{
    private final List<Item> children;

    public ComplexItem(Point position, List<Item> children) {
        super(position);
        this.children = children;
    }

    public List<Item> getChildren() {
        return children;
    }

    public void addChild(Item child) {
        children.add(child);
    }

    @Override
    void translate(Point p) {
        super.translate(p);
        children.forEach(child -> child.translate(p));
    }

    @Override
    List<Point> getBoundingBox() {
        int minX = children.stream().min(Comparator.comparingInt(item -> item.getBoundingBox().get(0).getX())).get().getBoundingBox().get(0).getX();
        int minY = children.stream().min(Comparator.comparingInt(item -> item.getBoundingBox().get(0).getY())).get().getBoundingBox().get(0).getY();
        int maxX = children.stream().max(Comparator.comparingInt(item -> item.getBoundingBox().get(2).getX())).get().getBoundingBox().get(2).getX();
        int maxY = children.stream().max(Comparator.comparingInt(item -> item.getBoundingBox().get(2).getY())).get().getBoundingBox().get(2).getY();

        Point p1 = new Point(minX, minY);
        Point p2 = new Point(maxX, minY);
        Point p3 = new Point(maxX, maxY);
        Point p4 = new Point(minX, maxY);

        return List.of(p1, p2, p3, p4);
    }

    @Override
    void draw(Graphics g) {
        for (Item child : children) {
            child.draw(g);
        }
    }
}
