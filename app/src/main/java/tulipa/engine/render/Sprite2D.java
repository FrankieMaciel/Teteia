package tulipa.engine.render;

import java.awt.Color;

import tulipa.engine.Window;
import tulipa.engine.types.Pixel;
import tulipa.engine.types.Texture;

public class Sprite2D {

  public int pixelSize = 10;
  public int x = 10;
  public int y = 10;
  Texture texture;

  public Sprite2D(Texture t) {
    texture = t;
  }
  
  public void render(Window w) {
    int textureSize = texture.width * texture.height;
    for (int i = 0; i < textureSize; i++) {
      int px = i % texture.width;
      int py = i / texture.width;
      
      int nx = (px * pixelSize) + (x * pixelSize);
      int ny = (py * pixelSize) + (y * pixelSize);

      Pixel p = texture.getPixelIn(px, py);
      if (p.alpha == 0) continue;
      Color cor = new Color(p.red, p.green, p.blue, p.alpha);
      w.drawPixel(nx, ny, pixelSize, cor);
    }
  }
}
