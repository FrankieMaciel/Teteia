package tulipa.engine.render;

import java.awt.Color;

import tulipa.engine.Window;
import tulipa.engine.types.RenderObject;
import tulipa.engine.types.Pixel;
import tulipa.engine.types.Texture;

public class Sprite2D implements RenderObject{

  public int pixelSize = 10;
  public int x = 0;
  public int y = 0;
  public int z = 0;
  Texture texture;

  public Sprite2D(Texture t) {
    texture = t;
  }
  
  public void render(Window w, int ox, int oy) {
    int textureSize = texture.width * texture.height;
    for (int i = 0; i < textureSize; i++) {
      int px = i % texture.width;
      int py = i / texture.width;
      
      int nx = (px * pixelSize) + x;
      int ny = (py * pixelSize) + y;

      Pixel p = texture.getPixelIn(px, py);

      if (p.alpha == 0) continue;

      Color cor = new Color(p.red, p.green, p.blue, p.alpha);
      w.drawPixel(nx + ox, ny + oy, pixelSize, cor);
    }
  }

  public void render(Window w, int ox, int oy, Color ocor) {
    int textureSize = texture.width * texture.height;
    for (int i = 0; i < textureSize; i++) {
      int px = i % texture.width;
      int py = i / texture.width;
      
      int nx = (px * pixelSize) + x;
      int ny = (py * pixelSize) + y;

      Pixel p = texture.getPixelIn(px, py);

      if (p.alpha == 0) continue;

      w.drawPixel(nx + ox, ny + oy, pixelSize, ocor);
    }
  }

  public void changeTexture(Texture nt) {
    texture = nt;
  }
}
