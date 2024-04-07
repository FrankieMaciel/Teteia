package tulipa.engine.types;

import java.util.ArrayList;
import java.util.List;

public class SplitedTexture {
  
  public List<Texture> textures = new ArrayList<Texture>();

  public SplitedTexture(Texture t, int gridX, int gridY) {

    Pixel[] nPixels = new Pixel[gridX * gridY];
    int numOfGridsX = (int) Math.floor(t.width / gridX);
    int numOfGridsY = (int) Math.floor(t.height / gridY);
    if (numOfGridsX == 0) numOfGridsX = 1;
    if (numOfGridsY == 0) numOfGridsY = 1;
    int numOfGrids = numOfGridsX * numOfGridsY;
    for (int j = 0; j < numOfGrids; j++) {
      for (int i = 0; i < gridX * gridY; i++) {

        int px = i % gridX;
        int py = i / gridX;
        
        int jx = j % gridX;
        int jy = j / gridX;
        
        int tx = px + (jx * gridX);
        int ty = py + (jy * gridX);

        if (tx >= t.width || ty >= t.height) continue;

        Pixel tpixel = t.getPixelIn(tx, ty);
        nPixels[i] = tpixel;

        if (px == gridX - 1 && py == gridY - 1) {
          Texture nt = new Texture(gridX, gridY);
          nt.pixels = nPixels;
          textures.add(nt);
          nPixels = new Pixel[gridX * gridY];
        }
      }
    }
  }
}
