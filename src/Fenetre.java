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

public class Fenetre extends JFrame {
    // creation panel general
    private JPanel container = new JPanel() ;
    // creation du panel bouton
    private JPanel container_button = new JPanel() ;
    // creation du label titre
    JLabel titre = new JLabel();
    private JButton button1 = new JButton();
    private JButton button2 = new JButton();
    private JButton button3 = new JButton();

    private int compteur = 0;

    public Fenetre(){
        // definiton des caracteristiques de la fenetre
        this.setTitle("Choix du nombre de Joueur");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        container.setLayout(new BorderLayout());

        // Mise en place de container du titre
        Font police = new Font("Tahoma", Font.BOLD, 16);
        titre.setFont(police);
        titre.setText("Combien de Joueurs voulez-vous ?");
        titre.setHorizontalAlignment(JLabel.CENTER);
        this.container.add(titre, BorderLayout.NORTH);

        // ecoute de l'action du bouton 1
        button1.addActionListener(new BoutonListener());
        button1.setText("2 Joueurs");
        // ajout du bouton 1 dans le panel bouton
        this.container_button.add(button1);

        button2.addActionListener( new Bouton2Listener());
        button2.setText("3 Joueurs");
        this.container_button.add(button2);

        button3.addActionListener( new Bouton3Listener());
        button3.setText("4 Joueurs");
        this.container_button.add(button3);

        // ajout du panel bouton dans le panel general
        this.container.add(container_button);
        this.setContentPane(container);
        this.setVisible(true);
    }

    //Classe écoutant notre premier bouton
    class BoutonListener implements ActionListener{
        //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent arg0) {
            // Mettre l'action de l'on souhaite
            JOptionPane jop = new JOptionPane();
            String nom1 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du premier joueur", JOptionPane.QUESTION_MESSAGE);
            String nom2 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du joueur du dexième joueur", JOptionPane.QUESTION_MESSAGE);
            System.out.println(nom1);
            System.out.println(nom2);
            System.exit(0);
        }
    }

    class Bouton2Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JOptionPane jop = new JOptionPane();
            String nom1 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du premier joueur", JOptionPane.QUESTION_MESSAGE);
            String nom2 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du joueur du dexième joueur", JOptionPane.QUESTION_MESSAGE);
            String nom3 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du joueur du troisème joueur", JOptionPane.QUESTION_MESSAGE);
            System.out.println(nom1);
            System.exit(0);
        }
    }

    class Bouton3Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JOptionPane jop = new JOptionPane();
            String nom1 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du joueur du premier joueur", JOptionPane.QUESTION_MESSAGE);
            String nom2 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du joueur du deuxième joueur", JOptionPane.QUESTION_MESSAGE);
            String nom3 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du joueur du troisèmejoueur", JOptionPane.QUESTION_MESSAGE);
            String nom4 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du joueur du quatrième joueur", JOptionPane.QUESTION_MESSAGE);
            System.out.println(nom4);
            System.exit(0);
        }
    }
}





