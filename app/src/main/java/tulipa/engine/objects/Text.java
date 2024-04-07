package tulipa.engine.objects;

import java.util.ArrayList;
import java.util.List;

import tulipa.engine.Window;
import tulipa.engine.render.Sprite2D;
import tulipa.engine.types.RenderObject;
import java.awt.Color;

public class Text implements RenderObject {
  
  protected List<Sprite2D> characters = new ArrayList<Sprite2D>();
  protected List<Color> colors = new ArrayList<Color>();

  public int x = 0;
  public int y = 0;
  public int z = 0;
  public int spacing = 5;

  public void render(Window w, int x, int y) {
    for (int i = 0; i < characters.size(); i++) {

      Sprite2D myChar = characters.get(i);
      Color myColor = colors.get(i);
      myChar.render(w, x + (i * spacing), y, myColor);
    }
  }

  public void changeText(String text) {
    characters.clear();
    colors.clear();

    for (int i = 0; i < text.length(); i++) {

      

    }
  }
}
