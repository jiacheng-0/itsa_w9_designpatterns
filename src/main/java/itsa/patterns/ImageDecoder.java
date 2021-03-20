package itsa.patterns;

// Use this interface and method skeleton. You still need to provide the methods.
interface ImageReader {
    DecodedImage getDecodeImage();
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


class GifReader implements ImageReader {
    private DecodedImage decodedImage;

    public GifReader(String image) {
        this.decodedImage = new DecodedImage(image);
    }

    public DecodedImage getDecodeImage() {
        return decodedImage;
    }
}

class JpegReader implements ImageReader {
    private DecodedImage decodedImage;

    public JpegReader(String image) {
        this.decodedImage = new DecodedImage(image);
    }

    public DecodedImage getDecodeImage() {
        return decodedImage;
    }
}

// Use this factory class and createImageReader method skeleton. You still need to provide the implementation.
class ImageDecoderFactory {
    public ImageReader createImageReader(String image) {
        ImageReader reader = null;
        String format = image.substring(image.indexOf('.') + 1);
        if (format.equals("gif")) {
            reader = new GifReader(image);
        } else if (format.equals("jpg")) {
            reader = new JpegReader(image);
        }
        return reader;
    }
}

public class ImageDecoder {
    public static void main(String[] args) {
        DecodedImage decodedImage;
        ImageReader reader = null;

        // String image = args[0];
        // String image = "sample.gif";
        String image = "sample.jpg";

        ImageDecoderFactory factory = new ImageDecoderFactory();
        reader = factory.createImageReader(image);

        assert reader != null : "Reader is null";

        decodedImage = reader.getDecodeImage();
        System.out.println(decodedImage);
    }
}