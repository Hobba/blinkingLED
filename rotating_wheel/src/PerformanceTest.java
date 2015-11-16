
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PerformanceTest {

    public static void main(String[] args) throws IOException {

        BufferedImage hugeImage = ImageIO.read(PerformanceTest.class.getResource("pacman2.jpg"));
        int[][] result = convertTo2DWithoutUsingGetRGB(hugeImage);
        
        System.out.printf("Height: %d \n Width: %d \n", hugeImage.getHeight(), hugeImage.getWidth());

        for (int i = 0; i < hugeImage.getHeight(); i++) {

            for (int j = 0; j < hugeImage.getWidth(); j++) {

                System.out.printf("%d ", result[i][j]);

            }

            System.out.printf("\n");
        }

    }

    private static int[][] convertTo2DWithoutUsingGetRGB(BufferedImage image) {

        final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        final int width = image.getWidth();
        final int height = image.getHeight();
        final boolean hasAlphaChannel = image.getAlphaRaster() != null;

        int[][] result = new int[height][width];
        if (hasAlphaChannel) {
            final int pixelLength = 4;
            for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
                int argb = 0;
                argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
                argb += ((int) pixels[pixel + 1] & 0xff); // blue
                argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
                argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red

                if (argb == -1) {
                    result[col][row] = 0;
                } else {
                    result[col][row] = 1;
                }

                col++;
                if (col == width) {
                    col = 0;
                    row++;
                }
            }
        } else {
            final int pixelLength = 3;
            for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
                int argb = 0;
                argb += -16777216; // 255 alpha
                argb += ((int) pixels[pixel] & 0xff); // blue
                argb += (((int) pixels[pixel + 1] & 0xff) << 8); // green
                argb += (((int) pixels[pixel + 2] & 0xff) << 16); // red
                //result[row][col] = argb;
                
                    result[row][col] = argb;
                
                col++;
                if (col == width) {
                    col = 0;
                    row++;
                }
            }
        }

        return result;
    }

}
