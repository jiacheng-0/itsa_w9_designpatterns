package itsa.patterns;

class Rect {

   public String draw() {
      System.out.println("Rectangle::draw()");
	  return "Rectangle::draw()";
   }
}

 class Square {

   public String draw() {
      System.out.println("Square::draw()");
	  return "Square::draw()";
   }
}

 class Circle {

   public String draw() {
      System.out.println("Circle::draw()");
	  return "Circle::draw()";
   }
}

public class FacadeExample {
   public static void main(String[] args) {

      // You are supposed to hide the following implementation in the ShapeMaker (facade) and
      // just call the ShapeMaker to draw
      Circle circle = new Circle();
      Rect rectangle = new Rect();
      Square square = new Square();
	  String message = circle.draw()+rectangle.draw()+square.draw();
	  System.out.println(message);
	  assert message.equals("Circle::draw()Rectangle::draw()Square::draw()") : "Message does not matched";

   }
}

Skeleton codes
 class ShapeMaker {
	 public String draw() {
		 return "";
	}
}

