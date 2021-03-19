package itsa.patterns;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CaptainTest {
    @Test
    public void testSingleton() {
        Captain captain1 = Captain.getCaptain();
        Captain captain2 = Captain.getCaptain();
        assertEquals(captain1, captain2);
    }
}
