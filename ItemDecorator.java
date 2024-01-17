import java.awt.*;
import java.util.List;

public class ItemDecorator implements IItem{
    private IItem wrapee;

    public ItemDecorator(IItem item) {
        this.wrapee = item;
    }

    @Override
    public void draw(Graphics g) {
        wrapee.draw(g);
        List<Point> boundingBox = wrapee.getBoundingBox();
        int width = boundingBox.get(1).getX() - boundingBox.get(0).getX();
        int height = boundingBox.get(2).getY() - boundingBox.get(1).getY();
        new Rect(boundingBox.get(0), false, width, height).draw(g);
    }

    @Override
    public List<Point> getBoundingBox() {
        return wrapee.getBoundingBox();
    }
}
