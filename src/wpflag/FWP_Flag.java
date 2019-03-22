/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wpflag;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JFrame;

public class FWP_Flag extends JFrame {

    // Constructor
    public FWP_Flag() {
        
        // window property
        setTitle("Morning Star Flag");
        setSize(600, 400);
        setLocation(400, 150);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // main method
    public static void main(String[] args) {
        new FWP_Flag();
    }

    /*
        paint the Morning Star Flag
    */
    @Override
    public void paint(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        
        // background color
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 600, 400);
        
        // draw string "The Morning Star Flag"
        g.setColor(Color.GREEN);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        g.drawString("The Morning Star Flag", 165, 75);
        
        // round rectangle
        g.setColor(Color.WHITE);
        g.drawRoundRect(10, 40, 580, 350, 5, 5);

        // draw red rectangle
        g.setColor(Color.red);
        g.fillRect(50, 100, 200, 200);

        // draw blue rectangle
        g.setColor(Color.BLUE);
        g.fillRect(250, 100, 300, 200);

        // draw star
        g.setColor(Color.WHITE);
        fillStar(g, 150, 205, 80, 5, .3); 
        
        // loop for white line in the midle of morning star flag
        
        for (int i = 0; i < 6; i++) {
            g.setColor(Color.WHITE);
            
            //g.drawLine(550, 80 + i * 30 + 50, 250, 80 + i * 30 + 50);
            g2.setStroke(new BasicStroke(15));
            g2.draw(new Line2D.Float(542, 80 + i * 30 + 45, 257, 80 + i * 30 + 45));
        }
        
        // draw string "WEST PAPUA"
        g.setColor(Color.WHITE);
        g.setFont(new Font("Lato Black", Font.BOLD, 30));
        g.drawString("WEST", 200, 350);
        
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        g.drawString("PAPUA", 320, 350);
                
    }

    // method to draw the star
    public static void fillStar(Graphics g, int ctrX, int ctrY, int radius, int nPoints, double spikiness) {
        double xDouble[] = new double[2 * nPoints];
        double yDouble[] = new double[2 * nPoints];

        int xPoint[] = new int[2 * nPoints];
        int yPoint[] = new int[2 * nPoints];

        nPoints = (int) (nPoints * 2);

        int randomStars = (int) (Math.random() * 25 + 1); // Variable for 25 Random Stars

        for (int i = 0; i < nPoints; i++) {
            double iRadius = (i % 2 == 0) ? radius : (radius * spikiness);
            double angle = (270) + (i * 360.0) / (nPoints);

            xPoint[i] = (int) (ctrX + iRadius * Math.cos(Math.toRadians(angle)));
            yPoint[i] = (int) (ctrY + iRadius * Math.sin(Math.toRadians(angle)));
        }
        g.fillPolygon(xPoint, yPoint, nPoints); // Creates polygon
    }
}
