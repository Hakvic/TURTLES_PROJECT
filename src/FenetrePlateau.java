import com.sun.deploy.ui.AboutDialog;
import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FenetrePlateau extends JFrame {
    private JPanel container = new JPanel() ;
    private Plateau plateau = new Plateau();
    private Bouton [][] tabBouton = new Bouton[8][8];

    public FenetrePlateau(){
        // definiton des caracteristiques de la fenetre
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // set layout of the principal container and plateau
        this.container.setLayout(new BorderLayout());
        this.plateau.setLayout(new GridLayout(8,8));
        this.plateau.setOpaque(false);

        // creation du tableau de case
        for(int y=0; y<8; y++){
            for(int x=0; x<8; x++){
                this.tabBouton[y][x] = new Bouton();
            }
        }

        // ajout de case dans le plateau
        for(int x=0; x<8; x++){
            for(int y=0; y<8; y++){
                this.plateau.add(this.tabBouton[y][x],BorderLayout.CENTER);
            }
        }

        // ajout du container plateau au container
        this.container.add(plateau, BorderLayout.CENTER);
        this.setContentPane(container);
        this.setVisible(true);
    }

    private class Plateau extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            try {
                Image img = ImageIO.read(new File("./images/background.jpeg"));
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setButton(int x, int y, String path_icon){
        this.tabBouton[y][x].setImg(path_icon);
    }

}





