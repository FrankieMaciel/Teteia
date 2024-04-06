package tulipa.game;

import tulipa.engine.Window;
import tulipa.engine.render.Sprite2D;
import tulipa.engine.types.Texture;
import tulipa.game.scenes.*;
import java.awt.*;

public class Game {


  public void run() {

    Window window = new Window();
    Texture t = new Texture("ty7.png");
    Sprite2D s = new Sprite2D(t);

    Texture t2 = new Texture("teste2.png");
    Sprite2D s2 = new Sprite2D(t2);
    s2.x = 15;
    s.pixelSize = 3;

    s.render(window);
    s2.render(window);

    // float[] point1 = {0f, 0f};
    // float[] point2 = {100f, 100f};

    // window.drawLine(point1, point2, Color.BLUE);

  }
}
