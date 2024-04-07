package tulipa.game;

import tulipa.engine.Window;
import tulipa.engine.types.Scene;
import tulipa.game.objects.TestSprite2D;

public class Game {

  public void run() {

    Window window = new Window();
    Scene cena1 = new Scene(window);
    
    TestSprite2D test = new TestSprite2D();

    cena1.addObject(test);
    cena1.runTicks();
  }
}
