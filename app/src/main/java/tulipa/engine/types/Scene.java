package tulipa.engine.types;

import java.util.ArrayList;
import java.util.List;

import tulipa.engine.Window;

public class Scene {

  List<Object> objects = new ArrayList<Object>();
  Window window;

  public Scene(Window w) {
    window = w;
  }

  public void tick() { 
    window.cleanScreen();
    for (int i = 0; i < objects.size(); i++) {
      Object obj = objects.get(i);
      obj.onTick();
      obj.render(window);
    }
    window.repaintScreen();
  }

  public void addObject(Object obj) {
    objects.add(obj);
  }

  public void runTicks() {
    while (true) {
        tick();
      try {
          Thread.sleep(60);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
    }
  }
}
