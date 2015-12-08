/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballebouge;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.lang.Thread;
import java.util.ArrayList;


/**
 *
 * @author ZiLong
 */
public class Monde extends JFrame {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)screenSize.getWidth()-100;
    int height = (int)screenSize.getHeight()-100;

    JPanel pan = new JPanel();
    Balle b = new Balle(width/3, height/2);
    ArrayList<Balle> listeBalle = new ArrayList();

    public Monde() {
        pan.add(b);
        b.setLocation(b.getPosX(width), b.getPosY(height));
        pan.setLayout(null);
        pan.setBackground(Color.green);
        pan.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Balle temp = new Balle((int) e.getX(), (int) e.getY());
                listeBalle.add(temp);
                pan.add(temp);

            }
        });
        this.add(pan);
        this.setVisible(true);
        this.setSize(width, height);
        this.setTitle("Ballos II");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        t.run();

    }

    Thread t = new Thread() {
        @Override
        public void run() {

            try {
                while (true) {
                    sleep(5);

                    b.setLocation(b.getPosX(width), b.getPosY(height));

                    if (!listeBalle.isEmpty()) {
                        for (int i = 0; i < listeBalle.size(); i++) {

                            listeBalle.get(i).setLocation(listeBalle.get(i).getPosX(width), listeBalle.get(i).getPosY(height));

                        }
                    }

                    invalidate();
                    repaint();

                }

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    };

}
