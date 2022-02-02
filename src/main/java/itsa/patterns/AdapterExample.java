package itsa.patterns;

class Line {
    public String draw(int x1, int y1, int x2, int y2) {
        return "Line from point A(" + x1 + ";" + y1 + "), to point B(" + x2 + ";" + y2 + ")";
    }
}

class Rectangle {
    public String draw(int x, int y, int width, int height) {
        return "Rectangle with starting left lowest point (" + x + ";" + y + "), width: " + width + ", height: " + height;
    }
}

interface Shape {
    String draw(int x, int y, int z, int j);
}

class LineAdapter implements Shape {

    private final Line adaptee;

    public LineAdapter(Line line) {
        this.adaptee = line;
    }

    @Override
    public String draw(int x1, int y1, int x2, int y2) {
        return adaptee.draw(x1, y1, x2, y2);
    }
}

class RectangleAdapter implements Shape {
    private Rectangle adaptee;

    public RectangleAdapter(Rectangle rectangle) {
        this.adaptee = rectangle;
    }

    @Override
    public String draw(int x1, int y1, int x2, int y2) {
        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        int width = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);
        return adaptee.draw(x, y, width, height);
    }
}

public class AdapterExample {
    public static void main(String[] args) {
        // The following codes are checking the object type and typecast to the appropriate object.
        // If you try to refactor these codes using adapter pattern, the main method should work like this instead
        Shape[] shapes = {new RectangleAdapter(new Rectangle()), new LineAdapter(new Line())};
        int x1 = 1, y1 = 1;
        int x2 = 3, y2 = 6;
        for (Shape shape : shapes) {
            System.out.println(shape.draw(x1, y1, x2, y2));
        }

        // Object[] shapes = {new Line(), new Rectangle()};
        // for (Object shape: shapes) {
        //     String message = "";
        //     if (shape.getClass().getSimpleName().equals("Line")) {
        //         message = ((Line) shape).draw(x1, y1, x2, y2);
        //     } else if (shape.getClass().getSimpleName().equals("Rectangle")) {
        //         message = ((Rectangle) shape).draw(x1, y1, width, height);
        //     }
        //     // System.out.println(message);
        //     assert message.equals("Line from point A(1;1), to point B(3;6)") || message.equals("Rectangle with starting left lowest point (1;1), width: 2, height: 5") : "Message does not matched";
        // }
    }
}
