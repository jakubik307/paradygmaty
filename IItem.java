import java.awt.*;
import java.util.List;

public interface IItem {
    void draw(Graphics g);
    List<Point> getBoundingBox();
}
