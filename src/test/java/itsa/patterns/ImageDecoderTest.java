package itsa.patterns;

import java.util.*;

import static org.junit.Assert.*;
import org.junit.*;

public class ImageDecoderTest {
	@Test
	public void testImageDecoder() {
        DecodedImage decodedImage;
        ImageReader reader = null;
		
		ImageDecoderFactory factory = new ImageDecoderFactory();
		reader = factory.createImageReader("sample.gif");		
        assert reader != null : "Reader is null";

		reader = factory.createImageReader("sample.jpg");
		assert reader != null : "Reader is null";
		
        decodedImage = reader.getDecodeImage();
        System.out.println(decodedImage);
	}
}
