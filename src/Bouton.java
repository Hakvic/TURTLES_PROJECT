import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JButton;


public class Bouton extends JButton implements MouseListener {
    private Image img;

    public Bouton() {
        super();
        this.addMouseListener(this);
    }

    // Mettre les boutons tranparents
    @Override
    public void updateUI() {
        super.updateUI();
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
        setForeground(Color.BLUE);
    }
    // Definir le background du bouton
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    public void setImg(String path_img){
        try {
            img = ImageIO.read(new File(path_img));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void mouseClicked(MouseEvent event) {

    }

    @Override
    public void mousePressed(MouseEvent event) {

    }

    @Override
    public void mouseReleased(MouseEvent event) {

    }

    @Override
    public void mouseEntered(MouseEvent event) {
     }

    @Override
    public void mouseExited(MouseEvent event) {

    }
}