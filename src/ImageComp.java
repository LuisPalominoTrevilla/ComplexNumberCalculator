import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageComp {

    public static void main(String[] args) throws IOException {
        File f = new File("paco.jpg");
        BufferedImage biA = ImageIO.read(f);
        Image second = biA.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        int sum = 0;
        

    }

}
