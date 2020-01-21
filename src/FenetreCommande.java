import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
import javax.swing.JOptionPane;

public class FenetreCommande {
    JFrame frame = new JFrame();
    // creation panel general
    private JPanel container = new JPanel() ;
    // creation du panel bouton
    private JPanel container_button = new JPanel() ;
    // creation du label titre
    JLabel titre = new JLabel();
    private JButton button1 = new JButton();
    private JButton button2 = new JButton();
    private JButton button3 = new JButton();

    private int commande;
    private int rang_mur = 10;


    public FenetreCommande(){
        // definiton des caracteristiques de la fenetre
        frame.setTitle("Commande");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        container.setLayout(new BorderLayout());

        // Mise en place de container du titre
        Font police = new Font("Tahoma", Font.BOLD, 16);
        titre.setFont(police);
        titre.setText("Que voulez vous faire ?");
        titre.setHorizontalAlignment(JLabel.CENTER);
        this.container.add(titre, BorderLayout.NORTH);

        // ecoute de l'action du bouton 1
        button1.addActionListener(new BoutonListener());
        button1.setText("Construire le programmme");
        // ajout du bouton 1 dans le panel bouton
        this.container_button.add(button1);

        button2.addActionListener( new Bouton2Listener());
        button2.setText("Construire un mur");
        this.container_button.add(button2);

        button3.addActionListener( new Bouton3Listener());
        button3.setText("Executer le programme");
        this.container_button.add(button3);

        // ajout du panel bouton dans le panel general
        this.container.add(container_button);
        frame.setContentPane(container);
        frame.setVisible(true);
    }

    public int getCommande() {
        return this.commande;
    }

    private void setCommande(int commande) {
        this.commande = commande;
    }

    private void setRang_mur(int ran_mur){
        this.rang_mur = ran_mur;
    }

    public int getRang_mur() {
        return rang_mur;
    }


    //Classe écoutant notre premier bouton
    class BoutonListener implements ActionListener {
        //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent arg0) {
            // Mettre l'action de l'on souhaite
            setCommande(1);
            frame.dispose();

        }
    }

    class Bouton2Listener  implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            setCommande(2);
            String[] mur = {"mur de pierre", " mur de glace", "caisse en bois"};
            JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
            int rang_mur = jop.showOptionDialog(null,
                    "Veuillez indiquer le mur choisi",
                    "Choix du mur !",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    mur,
                    mur[2]);
            setRang_mur(rang_mur);
            frame.dispose();
        }
    }

    class Bouton3Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            setCommande(3);
            frame.dispose();
        }
    }
}





