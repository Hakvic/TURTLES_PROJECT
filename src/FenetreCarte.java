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

public class FenetreCarte {
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
    private JButton button4 = new JButton();
    private JButton button5 = new JButton();


    private int commande;


    public FenetreCarte(){
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



    //Classe écoutant notre premier bouton
    class BoutonListener implements ActionListener {
        //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent arg0) {
            // Mettre l'action de l'on souhaite
            setCommande(1);

            JOptionPane jop = new JOptionPane();
            String nom1 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du premier joueur", JOptionPane.QUESTION_MESSAGE);
            String nom2 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du joueur du dexième joueur", JOptionPane.QUESTION_MESSAGE);
            frame.dispose();

        }
    }

    class Bouton2Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JOptionPane jop = new JOptionPane();
            String nom1 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du premier joueur", JOptionPane.QUESTION_MESSAGE);
            String nom2 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du joueur du dexième joueur", JOptionPane.QUESTION_MESSAGE);
            String nom3 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du joueur du troisème joueur", JOptionPane.QUESTION_MESSAGE);
            setCommande(2);
            frame.dispose();
        }
    }

    class Bouton3Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JOptionPane jop = new JOptionPane();
            String nom1 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du joueur du premier joueur", JOptionPane.QUESTION_MESSAGE);
            String nom2 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du joueur du deuxième joueur", JOptionPane.QUESTION_MESSAGE);
            String nom3 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du joueur du troisèmejoueur", JOptionPane.QUESTION_MESSAGE);
            String nom4 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du joueur du quatrième joueur", JOptionPane.QUESTION_MESSAGE);
            setCommande(3);
            frame.dispose();
        }
    }
}





