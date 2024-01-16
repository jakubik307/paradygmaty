import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Scene extends JPanel {
    private final List<Item> items;

    public Scene ()
    {
        items = new ArrayList<>();
    }

    void addItem (Item item) {
        if (item instanceof Singleton) {
            Iterator<Item> iterator = items.iterator();
            while (iterator.hasNext()) {
                Item i = iterator.next();
                if (i instanceof Singleton) {
                    if (i.getClass().equals(item.getClass())) {
                        iterator.remove();
                    }
                }
            }
        }
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Item item : items) {
            item.draw(g);
        }
    }
}
