import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class FenetreMain {
    private JFrame frame = new JFrame();
    private JPanel container = new JPanel() ;
    private JPanel container_button = new JPanel() ;
    private JLabel titre = new JLabel();
    public Bouton [] bouton = new Bouton[5];
    private JButton ok = new JButton();
    private Boolean close = false;
    private volatile int[] position = new int[2];
    private Integer[] choix = new Integer[5];

    public FenetreMain(){
        // definiton des caracteristiques de la fenetre
        frame.setTitle("Commande");
        frame.setSize(800, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        container.setLayout(new BorderLayout());
        container_button.setLayout((new GridLayout(1, 5)));

        // Mise en place de container du titre
        Font police = new Font("Tahoma", Font.BOLD, 16);
        titre.setFont(police);
        titre.setText("Quelles cartes choisissez-vous ? ");
        titre.setHorizontalAlignment(JLabel.CENTER);


        for(int x=0; x<5; x++){
            this.bouton[x] = new Bouton(0, x);
            this.container_button.add(bouton[x]);
        }

        ok.addActionListener(new okListener());
        ok.setText("OK");

        // ajout du panel bouton dans le panel general
        this.container.add(titre, BorderLayout.NORTH);
        this.container.add(container_button, BorderLayout.CENTER);
        this.container.add(ok, BorderLayout.SOUTH);
        frame.setContentPane(container);
        frame.setVisible(true);
    }

    public void setCarteCouleur(String couleur, int position_carte){
        this.bouton[position_carte].setImg(couleur);
    }

    public Integer[] getPosBouton(){
        for(int i = 0; i<5; i++) {
            position = this.bouton[i].getPosition();
            if (this.position[1] != 100) {
                this.bouton[i].setVisible(false);
                this.choix[i] = this.position[1];
            }else {
                this.choix[i] = 100;
            }
        }
        return this.choix;
    }

    public boolean getClose(){
        return close;
    }

    class okListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            close = true;
            frame.dispose();
        }
    }
}












