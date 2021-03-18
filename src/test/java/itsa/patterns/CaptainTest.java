package itsa.patterns;

import java.util.*;

import static org.junit.Assert.*;
import org.junit.*;

public class CaptainTest {
	@Test
	public void testSingleton() {
        Captain captain1 = Captain.getCaptain();
        Captain captain2 = Captain.getCaptain();
		assertEquals(captain1,captain2);
	}
}
