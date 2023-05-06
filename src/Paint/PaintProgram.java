package Paint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class PaintProgram extends JFrame {
    private int x, y;
    private Color color = Color.BLACK;
    private JButton colorButton, clearButton, easearButton, fillButton, circleButton, squareButton;
    private JSlider widthPen;
    private int widthLine = 1;
    private JPanel doska;
    public PaintProgram() {
        setTitle("Paint Program");
        setSize(2500, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        colorButton = new JButton("Color");
        colorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                color = JColorChooser.showDialog(PaintProgram.this, "Vyberitte Svet", color);

            }
        });
        easearButton = new JButton("lastik");
        easearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                color = Color.WHITE;
            }
        });

        clearButton = new JButton("Ochistka");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Graphics g = doska.getGraphics();
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, doska.getWidth(), doska.getHeight());
            }
        });
        fillButton = new JButton("Zalivka");
        fillButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                color = JColorChooser.showDialog(PaintProgram.this, "Vyberitte Svet", color);
                Graphics g = doska.getGraphics();
                g.setColor(color);
                g.fillRect(0, 0, doska.getWidth(), doska.getHeight());
            }
        });
        widthPen = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);
        widthPen.setMajorTickSpacing(1);
        widthPen.setPaintTicks(true);
        widthPen.setPaintLabels(true);
        widthPen.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                widthLine = widthPen.getValue();
            }
        });
        doska = new JPanel();
        doska.setBackground(Color.WHITE);
        doska.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            }
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
        });
        doska.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Graphics g = doska.getGraphics();
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(widthLine));
                g2.setColor(color);
                g2.drawLine(x, y, e.getX(), e.getY());
                x = e.getX();
                y = e.getY();
            }
        });
        circleButton = new JButton("Oval");
        circleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Graphics g = doska.getGraphics();
                g.setColor(color);
                g.fillOval(x, y, widthLine, widthLine);
            }
        });
        squareButton = new JButton("Square");
        squareButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Graphics g = doska.getGraphics();
                g.setColor(color);
                g.fillRect(x, y,widthLine+x, widthLine+y);
            }
        });


        Container knopkaOryndary = getContentPane();
        JPanel knopka = new JPanel(new GridLayout(3, 3));
        knopka.add(colorButton);
        knopka.add(clearButton);
        knopka.add(easearButton);
        knopka.add(fillButton);
        knopka.add(circleButton);
        knopka.add(squareButton);
        knopka.add(new JLabel("Line Width:"));
        knopka.add(widthPen);
        knopkaOryndary.add(knopka, BorderLayout.NORTH);
        knopkaOryndary.add(doska, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        PaintProgram paintProgram = new PaintProgram();
    }
}
