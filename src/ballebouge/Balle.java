package ballebouge;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author ZiLong Ismael
 */
public class Balle extends JComponent{
    private int posx;
    private int posy;
    private Color ballColor;
    private final boolean ballSizeRandom = true;
    private final boolean ballIsCircle = true;
    private final boolean ballSpeedRandom = true;
    private final boolean ballDirectionRandom = true;

    private int ballSizeX = ballSizeRandom ? (int) ((Math.random()+0.2)*100) : 50;
    private int ballSizeY = ballIsCircle ? ballSizeX : ballSizeRandom ? (int) ((Math.random()+0.2)*100) : 50;
    private int ballDirectionX = ballDirectionRandom ? (Math.random()>0.5?1:-1) : 1;
    private int ballDirectionY = ballDirectionRandom ? (Math.random()>0.5?1:-1) : 1;
    private int ballSpeedX = ballSpeedRandom ? (int) ((Math.random()+0.1)*8) * ballDirectionX : 5;
    private int ballSpeedY = ballSpeedRandom ? (int) ((Math.random()+0.1)*8) * ballDirectionY : 5;

    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(ballColor);
        g.fillOval(0, 0, ballSizeX, ballSizeY);
    }

    public static Color randomColor() {
      return new Color(getInt255(), getInt255(), getInt255());
    }

    public static int getInt255() {
      return (int) (Math.random()*255);
    }

    public Balle(int x, int y)
    {
        posx=x;
        posy=y;
        this.setSize(ballSizeX,ballSizeY);
        ballColor = randomColor();
    }

    public int getPosX(int screenWidth) {
      if ((posx += ballSpeedX) <= 0 || posx >= (screenWidth - this.ballSizeX)) {
        ballSpeedX *= -1;
      }
      return posx;
    }


    public int getPosY(int screenHeight) {
      if ((posy += ballSpeedY) <= 0 || posy >= (screenHeight - this.ballSizeY)) {
        ballSpeedY *= -1;
      }
      return posy;
    }
}
