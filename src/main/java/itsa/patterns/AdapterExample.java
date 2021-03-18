package itsa.patterns;

// adaptee
class Line {
		  
    public String draw(int x1, int y1, int x2, int y2) {
        return "Line from point A(" + x1 + ";" + y1 + "), to point B(" + x2 + ";" + y2 + ")";
    }
}

// adaptee
class Rectangle {
	
    public String draw(int x, int y, int width, int height) {
        return "Rectangle with starting left lowest point (" + x + ";" + y + "), width: " + width
                + ", height: " + height;
    }
}

public class AdapterExample {
    public static void main(String[] args) {
        // The following codes are checking the object type and typecast to the appropriate object.
        // If you try to refactor these codes using adapter pattern, the main method should work like this instead
        // Shape[] shapes = {new RectangleAdapter(new Rectangle()),
        //    new LineAdapter(new Line())};
        // int x1 = 1, y1 = 1;
        // int x2 = 3, y2 = 6;
        // for (Shape shape : shapes) {
        //  shape.draw(x1, y1, x2, y2);
        // } 

        Object[] shapes = {new Line(), new Rectangle()};
        int x1 = 1, y1 = 1;
        int x2 = 3, y2 = 6;
        int width = 2, height = 5;
        
        for (Object shape : shapes) {
			String message = "";
            if (shape.getClass().getSimpleName().equals("Line")) {
                message = ((Line)shape).draw(x1, y1, x2, y2);
            } else if (shape.getClass().getSimpleName().equals("Rectangle")) {
                message = ((Rectangle)shape).draw(x1, y1, width, height);
            }
			System.out.println(message);	
			assert message.equals("Line from point A(1;1), to point B(3;6)") || message.equals("Rectangle with starting left lowest point (1;1), width: 2, height: 5") : "Message does not matched";
        }
    }
}

// Use this classes, interface and method skeleton. You still need to provide the methods in LineAdapter and RectangleAdapter
interface Shape {
    String draw(int x, int y, int z, int j);
}
class LineAdapter implements Shape {
	//Skeleton constructors
	public LineAdapter() {}
	public LineAdapter(Line line) {}
	
	public String draw(int x1, int y1, int x2, int y2) {
        // add your codes
		return "";
    }
}
class RectangleAdapter implements Shape {
	public RectangleAdapter() {}
	public RectangleAdapter(Rectangle rectangle) {}

	public String draw(int x1, int y1, int x2, int y2) {
        // You can use the following conversion codes
		int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        int width = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);
		return "";
    }
}

