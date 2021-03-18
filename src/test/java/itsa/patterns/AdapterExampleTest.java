package itsa.patterns;

import java.util.*;

import static org.junit.Assert.*;
import org.junit.*;

public class AdapterExampleTest {
	@Test
	public void testAdapter() {
        Shape[] shapes = {new RectangleAdapter(new Rectangle()),
                          new LineAdapter(new Line())};
        int x1 = 1, y1 = 1;
        int x2 = 3, y2 = 6;
        for (Shape shape : shapes) {
            String message = shape.draw(x1, y1, x2, y2);
			assert message.equals("Line from point A(1;1), to point B(3;6)") || message.equals("Rectangle with starting left lowest point (1;1), width: 2, height: 5") : "Message does not matched";;
        }
	}
}
