package tklibs;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by huynq on 5/11/17.
 */
public class SpriteUtils {

    public static BufferedImage loadImage(String url) {
        try {
            return ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // dirUrl == "assets/images/players/straight"
    public static ArrayList<BufferedImage> loadImages(String dirUrl) {
        ArrayList<BufferedImage> images = new ArrayList<>();
        try {
            String[] fileNames = new File (dirUrl).list();
            Arrays.sort(fileNames);
            for (int i = 0; i < fileNames.length; i++) {
                String fileName =fileNames[i];
                if (fileName.toLowerCase().endsWith(".png")) {
                    String fileUrl = dirUrl + "/" + fileName;
                    BufferedImage image = loadImage(fileUrl);
                    images.add(image);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            images.clear();
        }
        // TODO: load images
        // [0.png, 1.png, ...]
        return images;
    }

    public static void renderAtCenter(Graphics graphics, BufferedImage image, double x, double y) {
        graphics.drawImage(image, (int)(x - (double)image.getWidth() / 2), (int)(y - (double) image.getHeight() / 2), null);
    }

    public static BufferedImage maskWhite(BufferedImage image) {
        BufferedImage returnImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int color = image.getRGB(x, y);
                int alpha = color & 0xFF000000;
                if (alpha != 0) {
                    returnImage.setRGB(x, y, color | 0x00FFFFFF | alpha);
                } else {
                    returnImage.setRGB(x, y, color);
                }
            }
        }

        return returnImage;
    }

/*    public static void main(String[] args) {
        //class File ~ file || directory
        String url = "assets/images/players/straight";
        File file = new File(url);
        if (file.isFile()) {
            System.out.println("url: " + url + " is file");
        }
        if (file.isDirectory()) {
            String[] fileNames = file.list(); // length = 7
            java.util.List<String> listFileNames = Arrays.asList(fileNames); // length thay doi duoc
            Collections.sort(listFileNames);
//            Arrays.sort(fileNames);
            for (int i = 0; i < fileNames.length; i++) {
                System.out.println(fileNames[i]);
            }
            System.out.println("url: " + url + " is directory");
        }
    }*/
}