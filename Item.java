import java.awt.*;
import java.util.List;

public abstract class Item implements IItem{
    protected Point position;

    public Item(Point position) {
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    void translate(Point p) {
        position.setX(position.getX() + p.getX());
        position.setY(position.getY() + p.getY());
    }


}
