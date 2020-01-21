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

public class Fenetre {
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

    private int nombre_joueur;
    private String joueur1;
    private String joueur2;
    private String joueur3;
    private String joueur4;


    private int compteur = 0;

    public Fenetre(){
        // definiton des caracteristiques de la fenetre
        frame.setTitle("Choix du nombre de Joueur");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
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
        frame.setContentPane(container);
        frame.setVisible(true);
    }

    public int getNombre_joueur() {
        return this.nombre_joueur;
    }

    private void setNombre_joueur(int nombre_joueur) {
        this.nombre_joueur = nombre_joueur;
    }

    private void setJoueur1(String joueur1) {
        this.joueur1 = joueur1;
    }

    private void setJoueur2(String joueur2) {
        this.joueur2 = joueur2;
    }

    private void setJoueur3(String joueur3) {
        this.joueur3 = joueur3;
    }

    private void setJoueur4(String joueur4) {
        this.joueur4 = joueur4;
    }

    public String getJoueur(int joueur) {
        String nom_joueur;
        switch (joueur){
            case 0: nom_joueur = this.joueur1;
               break;
            case 1: nom_joueur = this.joueur2;
                break;
            case 2: nom_joueur = this.joueur3;
                break;
            case 3: nom_joueur = this.joueur4;
                break;
            default:
                nom_joueur = null;
        }
        return nom_joueur;
    }

    //Classe écoutant notre premier bouton
    class BoutonListener implements ActionListener{
        //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent arg0) {
            // Mettre l'action de l'on souhaite
            setNombre_joueur(2);
            JOptionPane jop = new JOptionPane();
            String nom1 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du premier joueur", JOptionPane.QUESTION_MESSAGE);
            String nom2 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du joueur du deuxième joueur", JOptionPane.QUESTION_MESSAGE);
            setJoueur1(nom1);
            System.out.println(nom1);
            setJoueur2(nom2);
            System.out.println(nom2);
            frame.dispose();

        }
    }

    class Bouton2Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JOptionPane jop = new JOptionPane();
            String nom1 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du premier joueur", JOptionPane.QUESTION_MESSAGE);
            String nom2 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du joueur du dexième joueur", JOptionPane.QUESTION_MESSAGE);
            String nom3 = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Nom du joueur du troisème joueur", JOptionPane.QUESTION_MESSAGE);
            setNombre_joueur(3);
            setJoueur1(nom1);
            setJoueur2(nom2);
            setJoueur3(nom3);
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
            setNombre_joueur(4);
            setJoueur1(nom1);
            setJoueur2(nom2);
            setJoueur3(nom3);
            setJoueur4(nom4);
            frame.dispose();
        }
    }
}





