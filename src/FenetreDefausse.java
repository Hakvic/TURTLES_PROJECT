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

public class FenetreDefausse {
    JFrame frame = new JFrame();
    // creation panel general
    private JPanel container = new JPanel() ;
    // creation du panel bouton
    private JPanel container_button = new JPanel() ;
    // creation du label titre
    JLabel titre = new JLabel();
    private JButton button1 = new JButton();
    private JButton button2 = new JButton();

    private int defausse = 0;

    public FenetreDefausse(){
        // definiton des caracteristiques de la fenetre
        frame.setTitle("Défausse");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        container.setLayout(new BorderLayout());

        // Mise en place de container du titre
        Font police = new Font("Tahoma", Font.BOLD, 16);
        titre.setFont(police);
        titre.setText("Voulez-vous défauser votre main");
        titre.setHorizontalAlignment(JLabel.CENTER);
        this.container.add(titre, BorderLayout.NORTH);

        // ecoute de l'action du bouton 1
        button1.addActionListener(new BoutonListener());
        button1.setText("OUI");
        // ajout du bouton 1 dans le panel bouton
        this.container_button.add(button1);

        button2.addActionListener( new Bouton2Listener());
        button2.setText("NON");
        this.container_button.add(button2);

        // ajout du panel bouton dans le panel general
        this.container.add(container_button);
        frame.setContentPane(container);
        frame.setVisible(true);
    }

    public int getDefausse() {
        return defausse;
    }

    public void setDefausse(int defausse) {
        this.defausse = defausse;
    }


    //Classe écoutant notre premier bouton
    class BoutonListener implements ActionListener {
        //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent arg0) {
            // Mettre l'action de l'on souhaite
            setDefausse(1);
            frame.dispose();
        }
    }

    class Bouton2Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            setDefausse(2);
            frame.dispose();
        }
    }
}





