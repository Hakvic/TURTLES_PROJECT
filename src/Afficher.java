import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Afficher extends JPanel {
    public void paintComponent(Graphics g) {
        //x1, y1, width, height, arcWidth, arcHeight
        g.drawRoundRect(10, 10, 30, 50, 10, 10);
        g.fillRoundRect(55, 65, 55, 30, 5, 5);
    }
}
