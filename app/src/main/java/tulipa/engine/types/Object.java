package tulipa.engine.types;

import java.util.ArrayList;
import java.util.List;

import tulipa.engine.Window;

public class Object {

  protected List<RenderObject> parts = new ArrayList<RenderObject>();
  protected int x = 0;
  protected int y = 0;
  protected int z = 0;

  public Object() {
    createObject();
  }

  public void render(Window w) {
    for (int i = 0; i < parts.size(); i++) {
      RenderObject obj = parts.get(i);
      obj.render(w, x, y);
    }
  }

  public void onTick() {
    
  }

  public void createObject() {

  }
}
