package itsa.patterns;

import org.junit.Test;

public class FacadeExampleTest {
    @Test
    public void testFacade() {
        ShapeMaker shapeMaker = new ShapeMaker();

        String message = shapeMaker.draw();
        assert message.equals("Circle::draw()Rectangle::draw()Square::draw()") : "Message does not match";
    }
}
