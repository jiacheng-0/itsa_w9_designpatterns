package itsa.patterns;

import java.util.*;

import static org.junit.Assert.*;
import org.junit.*;

public class FacadeExampleTest {
	@Test
	public void testFacade() {
      ShapeMaker shapeMaker = new ShapeMaker();
 
      String message = shapeMaker.draw();
	  assert message.equals("Circle::draw()Rectangle::draw()Square::draw()") : "Message does not matched";

	}
}
