import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

import sun.management.counter.Variability;

import javax.swing.*;

public class Jeu {
	// liste des joueurs de la partie
	public static ArrayList<Joueur> joueurs = new ArrayList<>();

	public static ArrayList<Joueur> gagnants = new ArrayList<>();

	// Partie console
	public static Scanner scanner = new Scanner(System.in);

	public static Plateau plateauJeu = new Plateau();

	// Partie graphique
	public static FenetrePlateau affiche_plateau;
	public static Fenetre affiche_menu_joueur;
	public static FenetreCommande affiche_commande;
	public static FenetreDefausse affiche_defausse;
	public static FenetreMain affiche_main;

    private volatile int choice;
    private volatile String nomJoueurString;
    private volatile int commande;
    private volatile int rangMur;
    private volatile int defausse;
    private volatile Integer[] choix = new Integer[5];
    private volatile int[] position_mur = new int[2];

	public void initialiserPartie() {
		initialiserJoueurs();
        affiche_plateau = new FenetrePlateau();
		plateauJeu = new Plateau(joueurs, affiche_plateau);
		plateauJeu.initialiser(joueurs);

		int numeroJoueur = 0;
		do {
			Joueur leJoueur = joueurs.get(numeroJoueur);
			etapesTour(leJoueur);

			if (leJoueur.gagnant) {
				joueurs.remove(leJoueur);
				gagnants.add(leJoueur);
			}

			if (gagnants.size() > 0) {
				System.out.println("Ordre des gagnants");
				for (int i = 0; i < gagnants.size(); i++) {
					System.out.println(i + ". " + gagnants.get(i).nom);
					//graphique gagnant
					switch (i){
						case 0 : affiche_plateau.setPremier(gagnants.get(i).nom);
							break;
						case 1 : affiche_plateau.setDeuxieme(gagnants.get(i).nom);
							break;
						case 2 : affiche_plateau.setTroisieme(gagnants.get(i).nom);
							break;
						case 3 : affiche_plateau.setQuatrieme(gagnants.get(i).nom);
							break;
					}
				}
				System.out.println("");

			}
			numeroJoueur++;
			if (numeroJoueur >= joueurs.size())
				numeroJoueur = 0;

		} while (joueurs.size() > 1);

	}

	public void initialiserJoueurs() {
		affiche_menu_joueur = new Fenetre();
		// graphique nombre joueur
		do {
			choice = affiche_menu_joueur.getNombre_joueur();
		} while (choice < 2 || choice > 4);

		switch (choice) {
			case 2:
			case 3:
			case 4:
				initialiserNJoueurs(choice);
				break;
			default:
				System.out.println("Erreur de saisie");
		}
	}

	private void initialiserNJoueurs(int n) {
		int numeroJoueur;
		for (int i = 0; i < n; i++) {
			numeroJoueur = i;
            do{
            	// graphique nom joueur
                this.nomJoueurString = affiche_menu_joueur.getJoueur(i);
            }while (this.nomJoueurString == null);
			System.out.println("Nom du joueur " + numeroJoueur + " " + this.nomJoueurString);

			Joueur newJoueur = new Joueur(this.nomJoueurString, numeroJoueur);
			joueurs.add(newJoueur);
		}
	}

	private static void executerProgramme(Joueur leJoueur) {
		for (Carte carteProgrammeCarte : leJoueur.programme) {
			switch (carteProgrammeCarte.couleur) {
			case BLEUE:
				plateauJeu.avancerTortueJoueur(leJoueur);
				break;
			case JAUNE:
				leJoueur.tortue.pivoterGauche();
				break;
			case VIOLETTE:
				leJoueur.tortue.pivoterDroite();
				break;
			case LASER:
				plateauJeu.laser(leJoueur);
				break;
			default:
				break;
			}
			leJoueur.defausserCarteExecute(carteProgrammeCarte);
			plateauJeu.afficher();
		}
	}

	private  void completerProgramme(Joueur leJoueur) {
		System.out.println("Le programme a " + leJoueur.programme.size() + "instruction(s)");
		for (Carte carteProgrammeCarte : leJoueur.programme) {
			System.out.print(carteProgrammeCarte.couleur + " ");
		}

		System.out.println("Main : ");
		affiche_main = new FenetreMain();

		int i = 0;
		for (Carte carteMainCarte : leJoueur.main_joueur) {
			System.out.print(i + "." + carteMainCarte.couleur + " ");
			affiche_main.setCarteCouleur(carteMainCarte.fichierImage(), i);
			i++;
		}

		System.out.println("\nQuelle carte de la main voulez-vous ajouter au programme ?");

		do{
			this.choix = affiche_main.getPosBouton();
		}while (!affiche_main.getClose());
		Arrays.sort(choix, Collections.reverseOrder());
		for (int choi : this.choix){
			if(choi != 100){
				leJoueur.programme.add(leJoueur.main_joueur.get(choi));
				System.out.println("La carte " + leJoueur.main_joueur.get(choi).couleur + " a �t� ajout� au programme");
				leJoueur.main_joueur.remove(choi);
			}
		}

	}

	private void construireMur(Joueur leJoueur) {
		// LUDO on recuperer aussi la position i,j, il faut que tu v�rifie avec ton
		// plateau
		System.out.println("Mur de pierre: "+ leJoueur.nbMurPierre + "\nMur de Glace: " + leJoueur.nbMurGlace + "\nCaisse: "
				+ leJoueur.nbCaisse) ;
		//graphique choix mur et nombre de mur
		String infoMurPierre = "Mur de pierre: "+ leJoueur.nbMurPierre;
		String infoMurGlace = "Mur de Glace: " + leJoueur.nbMurGlace;
		String infoCaisse = "Caisse: "+ leJoueur.nbCaisse ;
		affiche_plateau.setInfoMur(infoMurPierre, infoMurGlace, infoCaisse);

		do {
			this.rangMur = affiche_commande.getRang_mur();
		} while (this.rangMur < 0 || this.rangMur > 2);

		System.out.println(rangMur);

		switch (this.rangMur) {
		case 0:
			if (leJoueur.peutPoserMurPierre()) {
				do{
					this.position_mur = affiche_plateau.getPosBouton();
				}while (position_mur[0] == 100);
				plateauJeu.construireMurPierre(this.position_mur[1], this.position_mur[0]);
			}
			break;
		case 1:
			if (leJoueur.peutPoserMurGlace()) {
				do{
					this.position_mur = affiche_plateau.getPosBouton();
				}while (position_mur[0] == 100);
				plateauJeu.construireMurGlace(this.position_mur[1], this.position_mur[0]);
			}

			break;
		case 2:
			if (leJoueur.peutPoserCaisse()) {
				do{
					this.position_mur = affiche_plateau.getPosBouton();
				}while (position_mur[0] == 100);
				plateauJeu.construireCaisse(this.position_mur[1], this.position_mur[0]);
			}
			break;
		}
	}

	private  void etapesTour(Joueur leJoueur) {
		System.out.println("Au tour de " + leJoueur.nom);
		String tour = ("Au tour de " + leJoueur.nom);
		//graphique a qui le tour
		affiche_commande = new FenetreCommande();
		affiche_plateau.setTourLabel(tour);

		plateauJeu.afficher();

		System.out.print("Main : ");
		for (Carte carteMainCarte : leJoueur.main_joueur) {
			System.out.print(carteMainCarte.couleur + " ");
		}

		System.out
				.println("" + "\n1. completer le programme" + "\n2. Construire un mur" + "\n3. Executer le programme");
		// graphique choix commande
		do {
			this.commande = affiche_commande.getCommande();
		} while (this.commande < 1 || this.commande > 3);
		System.out.println(this.commande);
		switch (this.commande) {
		case 1:
			completerProgramme(leJoueur);
			break;
		case 2:
			construireMur(leJoueur);
			break;
		case 3:
			executerProgramme(leJoueur);
			break;

		}

		// graphique defausse
		affiche_defausse = new FenetreDefausse();
		System.out.println("\nDerni�re �tapes, voulez-vous d�faussez votre main?"
				+ "\n1. non et piocher les cartes manquantes pour compl�ter la main" + "\n2. Oui d�fausser ma main");
		do {
			this.defausse = affiche_defausse.getDefausse();
		} while (this.defausse == 0);

		switch (this.defausse) {
		case 1:
			leJoueur.defausserMain();
		case 2:
			leJoueur.piocherCartes();
			break;

		}
		plateauJeu.afficher();

		// Affiche la main
		System.out.println("Main : ");
		int i = 0;
		for (Carte carteMainCarte : leJoueur.main_joueur) {
			System.out.print(i + "." + carteMainCarte.couleur + " ");
			i++;
		}

	}

}
