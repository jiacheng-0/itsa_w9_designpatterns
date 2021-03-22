package itsa.patterns;

interface ShapeType {
    public String draw();
}

class Rect implements ShapeType {

    @Override
    public String draw() {
        // System.out.println("Rectangle::draw()");
        return "Rectangle::draw()";
    }

}

class Square implements ShapeType {

    @Override
    public String draw() {
        // System.out.println("Square::draw()");
        return "Square::draw()";
    }
}

class Circle implements ShapeType {

    @Override
    public String draw() {
        // System.out.println("Circle::draw()");
        return "Circle::draw()";
    }
}

// Skeleton codes
class ShapeMaker {

    // TODO: why not just declare inside a constructor?
    private Circle circle;
    private Rect rectangle;
    private Square square;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rect();
        square = new Square();
    }

    public String draw() {
        // Circle circle = new Circle();
        // Rect rectangle = new Rect();
        // Square square = new Square();
        return circle.draw() + rectangle.draw() + square.draw();
    }
}

public class FacadeExample {
    public static void main(String[] args) {
        // You are supposed to hide the following implementation in the ShapeMaker (facade) and
        // just call the ShapeMaker to draw

        ShapeMaker shapeMaker = new ShapeMaker();
        String message = shapeMaker.draw();
        System.out.println(message);
        assert message.equals("Circle::draw()Rectangle::draw()Square::draw()") : "Message does not matched";
    }
}
