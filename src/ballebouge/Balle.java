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
 * @author ZiLong
 */
public class Balle extends JComponent{
    private int posx;
    private int posy;
    private boolean droite=true;
    private boolean bas=true;
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.MAGENTA);
       g.fillOval(0, 0, 50, 50);
    }
    
    public Balle(int x, int y)
    {
        posx=x;
        posy=y;
        this.setSize(55,55);
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public boolean isDroite() {
        return droite;
    }

    public void setDroite(boolean droite) {
        this.droite = droite;
    }

    public boolean isBas() {
        return bas;
    }

    public void setBas(boolean bas) {
        this.bas = bas;
    }
    

    public void bougeX()
    {
        if (droite) {
            posx=posx+1;
        }
        else
            posx=posx-1;
    }
    public void bougeY()
    {   
        if (bas) {
            posy=posy+1;
        }
        else
              posy=posy-1;
    }
    
    public void bouger()
    {
        bougeX();
        bougeY();
    }
    }


