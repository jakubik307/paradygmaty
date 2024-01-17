import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Scene extends JPanel {
    private final List<IItem> items;

    public Scene ()
    {
        items = new ArrayList<>();
    }

    void addItem (IItem item) {
        items.add(item);
    }

    public List<IItem> getItems() {
        return items;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (IItem item : items) {
            item.draw(g);
        }
    }
}
