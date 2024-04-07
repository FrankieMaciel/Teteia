package tulipa.game.objects;

import tulipa.engine.render.Sprite2D;
import tulipa.engine.types.Object;
import tulipa.engine.types.SplitedTexture;
import tulipa.engine.types.Texture;

public class TestSprite2D extends Object {

  int frame = 0;
  Texture t;
  SplitedTexture st;
  Sprite2D s;
  
  public void createObject() {
    t = new Texture("get_down_d.png");
    st = new SplitedTexture(t, 320, 228);
    s = new Sprite2D(st.textures.get(frame));
    s.pixelSize = 1;
    parts.add(s);
  }

  public void onTick() {
    x += 1;
    frame++;
    if (frame >= st.textures.size()) frame = 0;
    s.changeTexture(st.textures.get(frame));
  }
}
