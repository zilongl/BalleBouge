/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballebouge;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.lang.Thread;
import java.util.ArrayList;

/**
 *
 * @author ZiLong
 */
public class Monde extends JFrame {

    JPanel pan = new JPanel();
    Balle b = new Balle(700, 500);
    Balle p = new Balle(200, 200);
    ArrayList<Balle> listeBalle = new ArrayList();

    public Monde() {
        pan.add(b);
        pan.add(p);
        p.setLocation(p.getPosx(), p.getPosy());
        b.setLocation(b.getPosx(), b.getPosy());
        pan.setLayout(null);
        pan.setBackground(Color.green);
        pan.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println((int) e.getX());
                System.out.println((int) e.getY());
                Balle temp = new Balle((int) e.getX(), (int) e.getY());
                listeBalle.add(temp);

            }
        });
        this.add(pan);
        this.setVisible(true);
        this.setSize(1500, 1000);
        this.setTitle("Ballos");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        t.run();

    }

    Thread t = new Thread() {
        @Override
        public void run() {

            try {
                while (true) {
                    sleep(1);

                    b.setLocation(b.getPosx(), b.getPosy());
                    b.bouger();
                    if (b.getPosx() >= 1425 || b.getPosx() < 0) {
                        b.setDroite(!b.isDroite());
                    }
                    if (b.getPosy() >= 890 || b.getPosy() < 0) {
                        b.setBas(!b.isBas());
                    }

                    if (!listeBalle.isEmpty()) {
                        for (int i = 0; i < listeBalle.size(); i++) {

                            pan.add(listeBalle.get(i));

                            listeBalle.get(i).setLocation(listeBalle.get(i).getPosx(), listeBalle.get(i).getPosy());
                            listeBalle.get(i).bouger();
                            if (listeBalle.get(i).getPosx() >= 1425 || listeBalle.get(i).getPosx() < 0) {
                                listeBalle.get(i).setDroite(!listeBalle.get(i).isDroite());
                            }
                            if (listeBalle.get(i).getPosy() >= 890 || listeBalle.get(i).getPosy() < 0) {
                                listeBalle.get(i).setBas(!listeBalle.get(i).isBas());
                            }

                        }
                    }

//                 System.out.println(b.getPosx());
//                  System.out.println(b.getPosy());
                    invalidate();
                    repaint();

                }

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    };

}
