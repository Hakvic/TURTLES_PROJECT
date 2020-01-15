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
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FenetrePlateau extends JFrame {
    private JPanel container = new JPanel() ;
    private Plateau plateau = new Plateau();
    private Bouton [][] tabBouton = new Bouton[8][8];
    private JLabel tourLabel = new JLabel();
    private JLabel infoPierre = new JLabel();
    private JLabel infoGlace = new JLabel();
    private JLabel infoCaisse = new JLabel();
    private JPanel east = new JPanel();
    private JLabel premier = new JLabel();
    private JLabel deuxieme = new JLabel();
    private JLabel troisieme = new JLabel();
    private JLabel quatrieme = new JLabel();
    private JPanel west = new JPanel();
    private int positionBoutonX;
    private int positionBoutonY;

    public FenetrePlateau(){
        // definiton des caracteristiques de la fenetre
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // set layout of the principal container and plateau
        this.container.setLayout(new BorderLayout());
        this.plateau.setLayout(new GridLayout(8,8));
        this.plateau.setOpaque(false);
        this.east.setLayout(new GridLayout(3,1));
        this.east.setLayout(new GridLayout(4,1));

        Font police = new Font("Tahoma", Font.BOLD, 16);
        this.tourLabel.setFont(police);
        this.tourLabel.setForeground(Color.blue);
        this.tourLabel.setHorizontalAlignment(JLabel.CENTER);

        this.infoPierre.setFont(police);
        this.infoPierre.setForeground(Color.blue);
        this.infoPierre.setHorizontalAlignment(JLabel.CENTER);

        this.infoGlace.setFont(police);
        this.infoGlace.setForeground(Color.blue);
        this.infoGlace.setHorizontalAlignment(JLabel.CENTER);

        this.infoCaisse.setFont(police);
        this.infoCaisse.setForeground(Color.blue);
        this.infoCaisse.setHorizontalAlignment(JLabel.CENTER);

        this.premier.setFont(police);
        this.premier.setForeground(Color.green);
        this.premier.setHorizontalAlignment(JLabel.CENTER);

        this.deuxieme.setFont(police);
        this.deuxieme.setForeground(Color.blue);
        this.deuxieme.setHorizontalAlignment(JLabel.CENTER);

        this.troisieme.setFont(police);
        this.troisieme.setForeground(Color.red);
        this.troisieme.setHorizontalAlignment(JLabel.CENTER);

        this.quatrieme.setFont(police);
        this.quatrieme.setForeground(Color.black);
        this.quatrieme.setHorizontalAlignment(JLabel.CENTER);

        this.east.add(infoPierre);
        this.east.add(infoGlace);
        this.east.add(infoCaisse);

        this.west.add(premier);
        this.west.add(deuxieme);
        this.west.add(troisieme);
        this.west.add(quatrieme);


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
        this.container.add(this.tourLabel, BorderLayout.NORTH);
        this.container.add(plateau, BorderLayout.CENTER);
        this.container.add(this.east, BorderLayout.EAST);
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
        repaint();
    }

    public void resetButton(int x, int y){
        this.tabBouton[y][x].updateUI();
        repaint();
    }

    public void setTourLabel(String tour){
        this.tourLabel.setText(tour);
    }

    public void setInfoMur(String pierre, String glace, String caisse){
        this.infoPierre.setText(pierre);
        this.infoGlace.setText(glace);
        this.infoCaisse.setText(caisse);
    }

    public void setPremier(String premier){
        this.premier.setText(premier);
    }
    public void setDeuxieme(String deuxieme){
        this.premier.setText(deuxieme);
    }
    public void setTroisieme(String troisieme){
        this.premier.setText(troisieme);
    }
    public void setQuatrieme(String quatrieme){
        this.premier.setText(quatrieme);
    }

    private void getPosBouton(){
        Boolean status = false;
        do {
            for (int y = 0; y < 8; y++) {
                for (int x = 0; x < 8; x++) {
                    if (this.tabBouton[y][x].getBouton()) {
                        this.positionBoutonX = x;
                        this.positionBoutonY = y;
                        status = true;
                    }
                }
            }
        }while (status);
    }

    public int getPositionBoutonX(){
        getPosBouton();
        return this.positionBoutonX;
    }

    public int getPositionBoutonY(){
        return this.positionBoutonY;
    }

}





