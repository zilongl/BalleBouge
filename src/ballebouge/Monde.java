package ballebouge;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Thread;
import java.util.ArrayList;

/**
 *
 * @author ZiLong Ismael
 */
public class Monde extends JFrame {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)screenSize.getWidth()-100;
    int height = (int)screenSize.getHeight()-100;

    JPanel pan = new JPanel();
    Balle b = new Balle(width/3, height/2);
    ArrayList<Balle> listeBalle = new ArrayList();
    JLabel ballcount = new JLabel("Number of balls: 1");
    CreateBallThread thread = new CreateBallThread(pan, listeBalle);
    JFrame frame = this;

    public Monde() {
        thread.start();
        pan.add(b);
        b.setLocation(b.getPosX(width), b.getPosY(height));
        pan.setLayout(null);
        pan.setBackground(Color.green);
        pan.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
              thread.addBalls(e);
            }
            public void mouseReleased(MouseEvent e) {
              thread.stopAddingBalls();
            }
        });
        pan.addMouseMotionListener(new MouseMotionAdapter() {
          public void mouseDragged(MouseEvent e) {
            thread.changeMouseEvent(e);
          }
        });
        this.addComponentListener(new ComponentAdapter() {
          public void componentResized(ComponentEvent e) {
            Rectangle r = frame.getBounds();
            width = r.width;
            height = r.height;
          }
        });
        pan.add(ballcount);
        ballcount.setLocation(0,0);
        ballcount.setSize(150,10);
        this.add(pan);
        this.setVisible(true);
        this.setSize(width, height);
        this.setTitle("Ballos II");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        t.start();

    }

    Thread t = new Thread() {
        @Override
        public void run() {

            try {
                while (true) {
                    sleep(1);
                    ballcount.setText("Number of balls: " + Integer.toString(listeBalle.size() + 1));
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
