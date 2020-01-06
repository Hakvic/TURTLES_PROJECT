import java.util.*;


public class Joueur {

    private String nom;

    private boolean gagnant;
    private ArrayDeque<Carte> main_joueur;
    private ArrayDeque<Carte> jeu_carte;
    private ArrayDeque<Carte> defausse;
    private ArrayDeque<Carte> programme;
    private ArrayDeque<Obstacle> obstacles;
    private Tortue tortue;
    private int numero; // Gonzague


    public Joueur(String nom, boolean gagnant, int numero){
        this.nom = nom;
        this.gagnant = gagnant;
        this.numero = numero;
        this.tortue = new Tortue(numero);

    }

    //Celui utilise par Gonzague
    public Joueur(String nom, int numero){
        this.nom = nom;
        this.numero = numero;
        this.tortue = new Tortue(numero);
    }

    public String getNom(){
        return nom;
    }

    public Boolean getGagnant(){
        return gagnant;
    }

    public Tortue getTortue(){
        return tortue;
    }

    public ArrayDeque<Carte> getJeuCarte(){
        return jeu_carte;
    }

    public ArrayDeque<Carte> getMain(){
        return main_joueur;
    }

    public void initJeuCarte(){
        ArrayList<Carte> jeu_carte_list = new ArrayList<Carte>();

        for (int i = 0; i<18; i++){
            jeu_carte_list.add(new Carte("Bleue", "avancer"));
        }
        for(int i=0; i<8; i++){
            jeu_carte_list.add(new Carte("Jaune", "90° anti-horraire"));
        }
        for(int i=0; i<8; i++){
            jeu_carte_list.add(new Carte("violette", "90° horraire"));
        }
        for(int i=0; i<3; i++){
            jeu_carte_list.add(new Carte("laser", "laser"));
        }
        Collections.shuffle(jeu_carte_list);
        jeu_carte = new ArrayDeque<Carte>(jeu_carte_list);
    }

    public void initMainJoueur(){
        main_joueur = new ArrayDeque<Carte>();
        for(int i=0; i<5; i++){
            main_joueur.add(jeu_carte.pollFirst());
        }
    }

    public void initObstacles(){
        obstacles = new ArrayDeque<Obstacle>();
        for(int i = 0; i<3; i++){
            obstacles.add(new Obstacle("murs"));
        }
        for(int i = 0; i<2; i++){
            obstacles.add(new Obstacle("glaces"));
        }

    }

}
