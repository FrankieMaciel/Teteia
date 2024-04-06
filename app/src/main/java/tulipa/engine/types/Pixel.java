package tulipa.engine.types;

public class Pixel {
  public int red;
  public int green;
  public int blue;
  public int alpha;

  public Pixel(int pixel) {
    red = (pixel >> 16) & 0xff;
    green = (pixel >> 8) & 0xff;
    blue = pixel & 0xff;
    alpha = (pixel >> 24) & 0xff;
  }
}
