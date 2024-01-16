import java.awt.*;
import java.util.List;

public class TextItem extends Item {
    private String text;

    public TextItem(Point position, String text) {
        super(position);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    List<Point> getBoundingBox() {
        Point p1 = new Point(position.getX() - 5, position.getY() - 15);
        Point p2 = new Point(position.getX() - 5 + text.length() * 7, position.getY() - 15);
        Point p3 = new Point(position.getX() + text.length() * 7, position.getY() + 5);
        Point p4 = new Point(position.getX(), position.getY() + 5);

        return List.of(p1, p2, p3, p4);
    }

    @Override
    void draw(Graphics g) {
        g.drawString(text, position.getX(), position.getY());
    }
}
