package tulipa.engine;

import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Window extends JPanel 
{
  public BufferedImage image;
  private Graphics2D g;
  public int width = 400;
  public int heigth = 400;
  private int lineThickness = 5;

  public Window() 
  {
    image = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
    setPreferredSize(new Dimension(width, heigth));

    JFrame frame = new JFrame("Teteia Engine");
    frame.setSize(width, heigth);
    frame.add(this);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
          width = getWidth();
          heigth = getHeight();
          BufferedImage canvas = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
          g = canvas.createGraphics();
          g.drawImage(image, 0, 0, width, heigth, null);
          // g.setColor(Color.WHITE);
          // g.fillRect(0, 0, width, heigth);
          g.dispose();
          image = canvas;
          setPreferredSize(new Dimension(width, heigth));
          revalidate();
          repaint();
      }
    });
  }

  @Override
  protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(image, 0, 0, this);
  }

  public void drawPixel(int x, int y, int size, Color cor) {
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            if (x + i >= 0 && x + i < width && y + j >= 0 && y + j < heigth) {

              if (cor.getAlpha() >= 255) {
                image.setRGB(x + i, y + j, cor.getRGB());
                continue;
              }

              Color bgColor = new Color(image.getRGB(x + i, y + j));
              Color transparentColor = blendColors(cor, bgColor);

              image.setRGB(x + i, y + j, transparentColor.getRGB());
            }
          }
        }
    repaint();
  }

  private Color blendColors(Color color1, Color color2) {
    float alpha = (float) color1.getAlpha() / 255.0f;
    float beta = 1.0f - alpha;

    int red = (int) (color1.getRed() * alpha + color2.getRed() * beta);
    int green = (int) (color1.getGreen() * alpha + color2.getGreen() * beta);
    int blue = (int) (color1.getBlue() * alpha + color2.getBlue() * beta);

    return new Color(red, green, blue);
  }

  public void drawLine(
    float[] v1,
    float[] v2,
    Color color
  ) {

    float dx = v2[0] - v1[0];
    float dy = v2[1] - v1[1];
    System.out.println(dx);

    float length = (float) Math.sqrt(dx * dx + dy * dy);
    float angle = (float) Math.atan2(dy, dx);

    int dist = (int)Math.floor(Math.sqrt(Math.pow(lineThickness, 2) + Math.pow(lineThickness, 2)));

    for (int i = 0; i < length; i+=dist) {

      System.out.println(i);
      int nx = (int) (v1[0] + Math.cos(angle) * i);
      int ny = (int) (v1[1] + Math.sin(angle) * i);

      drawPixel(nx, ny, lineThickness, color);
    }
  }
}