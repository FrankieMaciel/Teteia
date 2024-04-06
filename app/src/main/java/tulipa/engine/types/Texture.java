package tulipa.engine.types;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Texture {

  public String defaultPathDir = "src/main/java/tulipa/game/textures/";
  public String textureDir;
  public Pixel[] pixels;
  public int width;
  public int height;

  public Texture(String dir) {
    textureDir = dir;
    BufferedImage texture = loadTexture(defaultPathDir + textureDir);

    width = texture.getWidth();
    height = texture.getHeight();
    pixels = new Pixel[width * height];

    for (int i = 0; i < width * height; i++) {
      int x = i % width;
      int y = i / width;

      int p = texture.getRGB(x, y);
      Pixel pixel = new Pixel(p);
      pixels[i] = pixel;
    }
  }

  public static BufferedImage loadTexture(String filePath) {
    try {
        BufferedImage image = ImageIO.read(new File(filePath));
        return image;
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
  }

  public Pixel getPixelIn(int x, int y) {
    int index = (y * width) + x;
    return pixels[index];
  }
}
