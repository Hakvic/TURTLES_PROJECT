import java.util.*;

import jdk.nashorn.internal.codegen.CompilerConstants;


public class Joueur {

    public String nom;

    public boolean gagnant;
    public ArrayList<Carte> main_joueur;
    private ArrayDeque<Carte> jeu_carte;
    public ArrayDeque<Carte> programme;
    
    private int nbMurGlace;
    private int nbMurPierre;
    private int nbCaisse;
    
    private List<MurPierre> pierres;
    public Tortue tortue;
    private Joyaux joyaux;
    private int numero;

    public Joueur(String nom, boolean gagnant){
        this.nom = nom;
        this.gagnant = gagnant;
    }
    
    //Celui utilise par Gonzague
    public Joueur(String nom, int numero){
        this.nom = nom;
        this.numero = numero;
        this.tortue = new Tortue(numero);
        this.jeu_carte = initialiserJeuCarte();
        this.nbCaisse = 2;
        this.nbMurGlace = 2;
        this.nbMurPierre = 3;
        this.programme = new ArrayDeque<Carte>();
        this.main_joueur = new ArrayList<Carte>();
        this.piocherCartes();
    }
    
    public ArrayDeque<Carte> getJeuCarte(){
        return jeu_carte;
    }

    public ArrayList<Carte> getMain(){
        return main_joueur;
    }

    private ArrayDeque<Carte> initialiserJeuCarte(){
        ArrayList<Carte> jeu_carte_list = new ArrayList<Carte>();

        for (int i = 0; i<18; i++){
            jeu_carte_list.add(new Carte(constante.CARTE.BLEUE));
        }
        for(int i=0; i<8; i++){
            jeu_carte_list.add(new Carte(constante.CARTE.JAUNE));
        }
        for(int i=0; i<8; i++){
            jeu_carte_list.add(new Carte(constante.CARTE.VIOLETTE));
        }
        for(int i=0; i<3; i++){
            jeu_carte_list.add(new Carte(constante.CARTE.LASER));
        }
        Collections.shuffle(jeu_carte_list);
        return new ArrayDeque<Carte>(jeu_carte_list);
    }

    public void mainJoueur(){
        main_joueur = new ArrayList<Carte>();
        for(int i=0; i<5; i++){
            main_joueur.add(jeu_carte.pollFirst());
        }
    }
    
    public void defausserMain() {
		main_joueur = new ArrayList<Carte>();
	}
    
    
    //Pioche le nombre de carte manquant dans la main
    public void piocherCartes() {
		for (int i = main_joueur.size(); i < 5; i++) {
			main_joueur.add(jeu_carte.pollFirst());
		}
	}
    
    public void ajouterAuProgramme(Carte uneCarte) {
    	programme.add(uneCarte);
	}

}
