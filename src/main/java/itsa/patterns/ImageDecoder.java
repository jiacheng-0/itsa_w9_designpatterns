package itsa.patterns;

// Use this interface and method skeleton. You still need to provide the methods.
interface ImageReader {
	DecodedImage getDecodeImage();

}

// Use this factory class and createImageReader method skeleton. You still need to provide the implementation.
class ImageDecoderFactory {

	public ImageReader createImageReader(String image) {
		return null;
	}
}

class DecodedImage {
    private String image;

    public DecodedImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return image + ": is decoded";
    }
}
class GifReader implements ImageReader{
    private DecodedImage decodedImage;

    public GifReader(String image) {
        this.decodedImage = new DecodedImage(image);
    }

    public DecodedImage getDecodeImage() {
        return decodedImage;
    }
}

public class ImageDecoder {
    public static void main(String[] args) {
        DecodedImage decodedImage;
        GifReader reader = null;
        String image = args[0];
        String format = image.substring(image.indexOf('.') + 1, (image.length()));
        if (format.equals("gif")) {
            reader = new GifReader(image);
        }
        assert reader != null;
        decodedImage = reader.getDecodeImage();
        System.out.println(decodedImage);
    }
}