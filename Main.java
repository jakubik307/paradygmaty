import javax.swing.*;
import java.util.List;

public class Main {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Vector Graphics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);

        Scene scene = new Scene();
        scene.addItem(new Segment(new Point(100, 250), new Point(200, 200)));
        scene.addItem(new Circle(new Point(300, 75), false, 50));

        Triangle triangle = new Triangle(true, new Point(400, 420), new Point(510, 370), new Point(420, 300));
        scene.addItem(triangle);
//        drawBoundingBox(scene, triangle.getBoundingBox());

        ComplexItem complexItem = new ComplexItem(new Point(0, 0), List.of(
                new Circle(new Point(0, 200), false, 100),
                new Circle(new Point(10, 120), false, 80),
                new Circle(new Point(20, 60), false, 60)
        ));
        scene.addItem(complexItem);
        complexItem.translate(new Point(600, 200));

        ItemDecorator triangleDecorator = new ItemDecorator(triangle);
        scene.addItem(triangleDecorator);

        TextItem textItem = new TextItem(new Point(200, 400), "Wesołych świąt xD");
        scene.addItem(textItem);

        // Add path to frame
        Path path = new Path(new Point(0, 0), List.of(
                new Point(500, 100),
                new Point(550, 120),
                new Point(500, 140),
                new Point(550, 160),
                new Point(500, 180),
                new Point(550, 200),
                new Point(500, 220),
                new Point(550, 240)
        ));
        scene.addItem(path);

        frame.add(scene);
        frame.setVisible(true);
    }

    private static void drawBoundingBox(Scene scene, List<Point> boundingBox) {
        int width = boundingBox.get(1).getX() - boundingBox.get(0).getX();
        int height = boundingBox.get(2).getY() - boundingBox.get(1).getY();
        scene.addItem(new Rect(boundingBox.get(0), false, width, height));
    }
}