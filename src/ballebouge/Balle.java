/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private final int ballSize = 50;

    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(ballColor);
        g.fillOval(0, 0, ballSize, ballSize);
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
        this.setSize(ballSize,ballSize);
        ballColor = randomColor();
    }

    public int getPosX(int screenWidth) {
        int sw = screenWidth - ballSize;
        if (sw <= 0) sw=1;
        return (posx = (posx + 1) % (2 * sw)) > sw ? (sw << 1) - posx : posx;
    }

    public int getPosY(int screenHeight) {
      int sh = screenHeight - ballSize - 30; //30 pixel for the win title bar
      if (sh <= 0) sh=1;
      return (posy = (posy + 1) % (2 * sh)) > sh ? (sh << 1) - posy : posy;
    }
}
