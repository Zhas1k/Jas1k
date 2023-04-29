package Paint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintProgram extends JFrame {
    private int x, y;
    private Color color = Color.BLACK;
    private JButton karandashButton, redButton, blueButton, yellowButton, clearButton;
    private JPanel doska;
    public PaintProgram() {
        setTitle("Paint Program");
        setSize(1500, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        karandashButton = new JButton("Karandash");
        karandashButton.setBackground(Color.BLACK);
        karandashButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                color = Color.BLACK;
            }
        });
        redButton = new JButton("Red");
        redButton.setBackground(Color.RED);
        redButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                color = Color.RED;
            }
        });
        blueButton = new JButton("Blue");
        blueButton.setBackground(Color.BLUE);
        blueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                color = Color.BLUE;
            }
        });
        yellowButton = new JButton("Yellow");
        yellowButton.setBackground(Color.YELLOW);
        yellowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                color = Color.YELLOW;
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

        doska = new JPanel();
        doska.setBackground(Color.WHITE);
        doska.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
        });
        doska.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Graphics g = doska.getGraphics();
                g.setColor(color);
                g.drawLine(x, y, e.getX(), e.getY());
                x = e.getX();
                y = e.getY();
            }
        });

        Container knopkaOryndary = getContentPane();
        JPanel knopka = new JPanel(new GridLayout(2, 4));
        knopka.add(karandashButton);
        knopka.add(redButton);
        knopka.add(yellowButton);
        knopka.add(blueButton);
        knopka.add(clearButton);
        knopkaOryndary.add(knopka, BorderLayout.NORTH);
        knopkaOryndary.add(doska, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        PaintProgram paintProgram = new PaintProgram();
    }
}
