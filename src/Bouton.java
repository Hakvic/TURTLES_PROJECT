import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JButton;


public class Bouton extends JButton implements ActionListener {
    private Image img;
    private int[] position = new int[2];
    private int j;
    private int i;

    public Bouton(int j, int i) {
        super();
        this.j = j;
        this.i = i;
        this.position[0] = 100;
        this.position[1] = 100;
        addActionListener(this);
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

    public int[] getPosition() {
        return position;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.position[0] = this.j;
        this.position[1] = this.i;
    }
}