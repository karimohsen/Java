
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * paintbrush.java
 *
 * Created on Jan 16, 2015, 8:33:18 PM
 */
/**
 *
 * @author Karim
 */
public class paintbrush extends java.applet.Applet {

    String flag = "";
    Panel p;
    String color = "black";
    Button black;
    Button green;
    Button yellow;
    Button red;
    Button erase;
    Checkbox ch;
    Button line;
    Button circle;
    Button rect;
    Button freepencil;
    int index = 0;
    points point = new points();
    ArrayList<line> arrayline = new ArrayList<line>();
    ArrayList<circle> arraycircle = new ArrayList<circle>();
    ArrayList<rect> arrayrect = new ArrayList<rect>();
    ArrayList<ArrayList<points>> listOfLists = new ArrayList<ArrayList<points>>();
    ArrayList<points> arraypoint = new ArrayList<points>();
    
    @Override
    public void paint(Graphics g) {
        for (List<points> l : listOfLists) {

            for (points poin : l) {

                if (poin.getcol().equals("black")) {
                    g.setColor(Color.black);
                } else if (poin.getcol().equals("red")) {
                    g.setColor(Color.red);
                } else if (poin.getcol().equals("yellow")) {
                    g.setColor(Color.yellow);
                } else if (poin.getcol().equals("green")) {
                    g.setColor(Color.green);
                }
                if (ch.getState()) {
                    g.fillRect(poin.getx1(), poin.gety1(), 3, 1);
                } else {
                    g.drawRect(poin.getx1(), poin.gety1(), 3, 1);
                }
                /*if(l.size()!=1){
                    for (int i = 0;i<l.size()-2;i++) {
                        g.drawLine(l.get(l.size()-2-i).getx1(), l.get(l.size()-2-i).gety1(), l.get(l.size()-1-i).getx1(), l.get(l.size()-1-i).gety1());
                    }
                }*/
                
            }
        }


        for (line l : arrayline) {

            if (l.col.equals("black")) {
                g.setColor(Color.black);
            } else if (l.col.equals("red")) {
                g.setColor(Color.red);
            } else if (l.col.equals("yellow")) {
                g.setColor(Color.yellow);
            } else if (l.col.equals("green")) {
                g.setColor(Color.green);
            }
            g.drawLine(l.getx1(), l.gety1(), l.getx2(), l.gety2());
        }
        for (circle c : arraycircle) {

            if (c.col.equals("black")) {
                g.setColor(Color.black);
            } else if (c.col.equals("red")) {
                g.setColor(Color.red);
            } else if (c.col.equals("yellow")) {
                g.setColor(Color.yellow);
            } else if (c.col.equals("green")) {
                g.setColor(Color.green);
            }
            if (c.flag) {
                g.fillOval(c.getx1(), c.gety1(), c.getwidth(), c.getheight());
            } else {
                g.drawOval(c.getx1(), c.gety1(), c.getwidth(), c.getheight());
            }
        }

        for (rect r : arrayrect) {
            if (r.col.equals("black")) {
                g.setColor(Color.black);
            } else if (r.col.equals("red")) {
                g.setColor(Color.red);
            } else if (r.col.equals("yellow")) {
                g.setColor(Color.yellow);
            } else if (r.col.equals("green")) {
                g.setColor(Color.green);
            }
            if (r.flag) {
                g.fillRect(r.getx1(), r.gety1(), r.getwidth(), r.getheight());
            } else {
                g.drawRect(r.getx1(), r.gety1(), r.getwidth(), r.getheight());
            }
        }
    }

    /** Initializes the applet paintbrush */
    @Override
    public void init() {
        try {

            java.awt.EventQueue.invokeAndWait(new Runnable() {

                public void run() {
                    initComponents();
                    drawpanel();
                    addtoparent();


                }
            });

            addbuttonslistener();
            checklistner();
            colorlistner();
        } catch (Exception ex) {
            System.out.println("Unable to intialize Applet");
        }
    }

    public void colorlistner() {
        black.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                color = "black";
            }
        });
        red.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                color = "red";
            }
        });
        yellow.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                color = "yellow";
            }
        });
        green.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                color = "green";
            }
        });
    }

    public void checklistner() {
        this.addMouseListener(new mousemove());
        this.addMouseMotionListener(new mousemotion());
    }

    public void addtoparent() {
        Panel parent = (Panel) this.getParent();
        parent.setSize(1000, 400);
        parent.setFocusable(true);
        parent.setMinimumSize(new Dimension(1000, 400));
        parent.add(p, BorderLayout.NORTH);
        parent.setVisible(true);
    }

    public void addbuttonslistener() {
        line.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                flag = "line";
            }
        });
        circle.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                flag = "circle";
            }
        });
        rect.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                flag = "rectangle";
            }
        });
        freepencil.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                flag = "free";
            }
        });
        erase.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                flag = "erase";
            }
        });
    }

    public void drawpanel() {

        p = new Panel();
        p.setLayout(new GridLayout(1, 10, 10, 10));
        black = new Button();
        black.setBackground(Color.BLACK);
        green = new Button();
        green.setBackground(Color.GREEN);
        yellow = new Button();
        yellow.setBackground(Color.yellow);
        red = new Button();
        red.setBackground(Color.red);
        ch = new Checkbox("Fill");
        line = new Button("Line");
        circle = new Button("Circle");
        rect = new Button("Rectangle");
        freepencil = new Button("FreeLine");
        erase = new Button("Eraser");
        p.add(ch);
        p.add(erase);
        p.add(line);
        p.add(circle);
        p.add(rect);
        p.add(freepencil);
        p.add(black);
        p.add(green);
        p.add(yellow);
        p.add(red);

        p.setVisible(true);
    }

    public class mousemove extends MouseAdapter {

        @Override
        public void mouseReleased(MouseEvent e) {
            if (flag.equals("free")) {
                index++;
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            point.setx1(e.getX());
            point.sety1(e.getY());
            point.setx2(e.getX());
            point.sety2(e.getY());
            if (flag.equals("line")) {
                arrayline.add(new line(point.getx1(), point.gety1(), point.getx2(), point.gety2(), color));
            }
            if (flag.equals("erase")) {
                int test = 0;
                if (test == 0) {
                    for (int i = arrayrect.size() - 1; i >= 0; i--) {
                        if (arrayrect.get(i).getx1() <= point.getx1() && point.getx1() <= (arrayrect.get(i).getx1() + arrayrect.get(i).getwidth()) && arrayrect.get(i).gety1() <= point.gety1() && point.gety1() <= (arrayrect.get(i).gety1() + arrayrect.get(i).getheight())) {
                            arrayrect.remove(i);
                            repaint();
                            test = 1;
                            break;
                        }
                    }
                }
                if (test == 0) {
                    for (int i = arraycircle.size() - 1; i >= 0; i--) {
                        if (arraycircle.get(i).getx1() <= point.getx1() && point.getx1() <= (arraycircle.get(i).getx1() + arraycircle.get(i).getwidth()) && arraycircle.get(i).gety1() <= point.gety1() && point.gety1() <= (arraycircle.get(i).gety1() + arraycircle.get(i).getheight())) {
                            arraycircle.remove(i);
                            repaint();
                            test = 1;
                            break;
                        }
                    }
                }
                if (test == 0) {
                    for (int i = arrayline.size() - 1; i >= 0; i--) {
                        if (arrayline.get(i).getx1() <= point.getx1() && point.getx1() <= arrayline.get(i).getx2() && arrayline.get(i).gety1() <= point.gety1() && point.gety1() <= arrayline.get(i).gety2()) {
                            arrayline.remove(i);
                            repaint();
                            test = 1;
                            break;
                        }
                    }
                }
                if (test == 0) {
                    for (int i = listOfLists.size() - 1; i >= 0; i--) {
                        for (int j = listOfLists.get(i).size() - 1; j >= 0; j--) {
                            if (listOfLists.get(i).get(j).getx1() <= point.getx1() && point.getx1() <= (listOfLists.get(i).get(j).getx2() + 3) && listOfLists.get(i).get(j).gety1() <= point.gety1() && point.gety1() <= (listOfLists.get(i).get(j).gety2() + 1)) {
                                listOfLists.remove(i);
                                repaint();
                                test = 1;
                                break;
                            }
                        }
                    }
                }

            }
            if (flag.equals("circle")) {
                if (ch.getState()) {
                    arraycircle.add(new circle(point.getx1(), point.gety1(), point.getx2(), point.gety2(), true, color));
                } else {
                    arraycircle.add(new circle(point.getx1(), point.gety1(), point.getx2(), point.gety2(), false, color));
                }
            }
            if (flag.equals("rectangle")) {
                if (ch.getState()) {
                    arrayrect.add(new rect(point.getx1(), point.gety1(), point.getx2(), point.gety2(), color, true));
                } else {
                    arrayrect.add(new rect(point.getx1(), point.gety1(), point.getx2(), point.gety2(), color, false));
                }
            }
            if (flag.equals("free")) {
                arraypoint.add(new points(point.getx1(), point.gety1(), point.getx2(), point.gety2(), color));
                listOfLists.add(index, arraypoint);
            }
        }
    }

    public class mousemotion implements MouseMotionListener {

        public void mouseDragged(MouseEvent e) {
            point.setx2(e.getX());
            point.sety2(e.getY());

            if (flag.equals("free")) {
                point.setx1(point.getx2());
                point.sety1(point.gety2());
                arraypoint.add(new points(point.getx1(), point.gety1(), point.getx2(), point.gety2(), color));
                listOfLists.add(index, arraypoint);
                repaint();
            }
            if (flag.equals("line")) {
                arrayline.remove(arrayline.size() - 1);
                arrayline.add(new line(point.getx1(), point.gety1(), point.getx2(), point.gety2(), color));
                repaint();
            }
            if (flag.equals("circle")) {
                arraycircle.remove(arraycircle.size() - 1);
                if (ch.getState()) {
                    if (point.getx1() > point.getx2() || point.gety1() > point.gety2()) {
                        arraycircle.add(new circle(point.getx2(), point.gety2(), Math.abs(point.getx1() - point.getx2()), Math.abs(point.getx1() - point.getx2()), true, color));
                    } else {
                        arraycircle.add(new circle(point.getx1(), point.gety1(), Math.abs(point.getx1() - point.getx2()), Math.abs(point.getx1() - point.getx2()), true, color));
                    }
                } else {
                    if (point.getx1() > point.getx2()|| point.gety1() > point.gety2()) {
                        arraycircle.add(new circle(point.getx2(), point.gety2(), Math.abs(point.getx1() - point.getx2()), Math.abs(point.getx1() - point.getx2()), false, color));
                    } else {
                        arraycircle.add(new circle(point.getx1(), point.gety1(), Math.abs(point.getx1() - point.getx2()), Math.abs(point.getx1() - point.getx2()), false, color));
                    }
                }
                repaint();
            }

            if (flag.equals("rectangle")) {
                arrayrect.remove(arrayrect.size() - 1);
                if (ch.getState()) {
                    if (point.getx1() > point.getx2()|| point.gety1() > point.gety2()) {
                        arrayrect.add(new rect(point.getx2(), point.gety2(), Math.abs(point.gety1() - point.gety2()), Math.abs(point.getx1() - point.getx2()), color, true));
                    } else {
                        arrayrect.add(new rect(point.getx1(), point.gety1(), Math.abs(point.gety1() - point.gety2()), Math.abs(point.getx1() - point.getx2()), color, true));
                    }
                } else {
                    if (point.getx1() > point.getx2()|| point.gety1() > point.gety2()) {
                        arrayrect.add(new rect(point.getx2(), point.gety2(), Math.abs(point.gety1() - point.gety2()), Math.abs(point.getx1() - point.getx2()), color, false));
                    } else {
                        arrayrect.add(new rect(point.getx1(), point.gety1(), Math.abs(point.gety1() - point.gety2()), Math.abs(point.getx1() - point.getx2()), color, false));
                    }
                }
                repaint();
            }
        }

        public void mouseMoved(MouseEvent e) {
        }
    }

    /** This method is called from within the init() method to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
