import java.util.ArrayList;
import java.util.Scanner;

import sun.management.counter.Variability;

public class Jeu {
	//liste des joueurs de la partie
	public static ArrayList<Joueur> joueurs = new ArrayList<>();
	
	public static ArrayList<Joueur> gagnants = new ArrayList<>();
	
	//Partie console
	public static Scanner scanner = new Scanner(System.in);
	
	
	public static Plateau plateauJeu= new Plateau();
	
	public static void initialiserPartie() {
		initialiserJoueurs();
		plateauJeu= new Plateau();
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
					System.out.println(i + ". " + gagnants.get(i).nom );
				}
				System.out.println("");
			}
			numeroJoueur++;
			if(numeroJoueur >= joueurs.size() )
				numeroJoueur = 0;
				
			
		}while(joueurs.size() > 1);
		
	}
	private static void initialiserJoueurs(){
		
		System.out.println("Nombre de joueurs");
        
		int choice;
		do
		{
			choice = scanner.nextInt();
			System.out.println(choice);
		}while(choice < 2 || choice > 4);
        
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
	
	private static void initialiserNJoueurs(int n)
	{
		String nomJoueurString;
		int numeroJoueur;
		scanner.nextLine();
		for(int i=0; i<n; i++)
    	{
			numeroJoueur = i;
    		System.out.println("Nom du joueur " + numeroJoueur);
            
            nomJoueurString = scanner.nextLine(); // parsing voir tp
            Joueur newJoueur = new Joueur(nomJoueurString, numeroJoueur);
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
			leJoueur.programme.remove(carteProgrammeCarte);
			plateauJeu.afficher();
		}
	}
	private static boolean completerProgramme(Joueur leJoueur) {
		System.out.println("Le programme a " + leJoueur.programme.size() + "instruction(s)");
		for (Carte carteProgrammeCarte : leJoueur.programme) {
			System.out.print(carteProgrammeCarte.couleur + " ");
		}
		
		System.out.println("Main : ");
		int i=0;
		for (Carte carteMainCarte : leJoueur.main_joueur) {
			System.out.print(i +"." +carteMainCarte.couleur + " ");
			i++;
		}
		
		System.out.println("\nQuelle carte de la main voulez-vous ajouter au programme ?");
		int choix = scanner.nextInt();
		if(choix > i)
		{
			System.out.println("la main ne contient que " + i + " carte(s), veuillez réessayer");
			completerProgramme(leJoueur);
			return false;
		}
		else {
			leJoueur.programme.add(leJoueur.main_joueur.get(choix));
			System.out.println("La carte " + leJoueur.main_joueur.get(choix).couleur + " a été ajouté au programme");
			leJoueur.main_joueur.remove(choix);
			System.out.println("Voulez-vous ajouter une autre carte ?"
					+ "\n1. Oui"
					+ "\n2 . Non");
			if (scanner.nextInt() == 1) {
				return completerProgramme(leJoueur);
			}
			else {
				return false;
			}
			
		}
		
		
	}
	
	
	private static void construireMur(Joueur leJoueur) {
		System.out.println(
				"Quel type d'obstacle voulez-vous poser?"
				+ "1. poser un mur de p\n"
				+ "2. poser un mur de g\n"
				+ "3. lacher une caisse\n"
				);
		switch (scanner.nextInt()) {
		case 1:
			System.out.println("posI?");
			int posI = scanner.nextInt();
			System.out.println("posJ?");
			int posJ = scanner.nextInt();
			plateauJeu.construireMurPierre(posI, posJ);
			break;
		case 2:
			System.out.println("posI?");
			int posi = scanner.nextInt();
			System.out.println("posJ?");
			int posj = scanner.nextInt();
			plateauJeu.construireMurGlace(posi, posj);
			break;
		case 3 :
			System.out.println("posI?");
			int posa = scanner.nextInt();
			System.out.println("posJ?");
			int posb = scanner.nextInt();
			plateauJeu.construireCaisse(posa, posb);
			break;
		}
	}
	
	private static void etapesTour(Joueur leJoueur) {
		System.out.println("Au tour de " + leJoueur.nom);
		
		plateauJeu.afficher();
		
		System.out.print("Main : ");
		for (Carte carteMainCarte : leJoueur.main_joueur) {
			System.out.print(carteMainCarte.couleur + " ");
		}
		System.out.println(""
				+ "\n1. completer le programme"
				+ "\n2. Construire un mur"
				+ "\n3. Executer le programme");
		switch (scanner.nextInt()) {
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
		System.out.println("Dernière étapes, voulez-vous défaussez votre main?"
				+ "\n1. non et piocher les cartes manquantes pour compléter la main"
				+ "\n2. Oui défausser ma main");
		switch (scanner.nextInt()) {
		case 2: 
			leJoueur.defausserMain();
		default :
			leJoueur.piocherCartes();
			break;
		
		}
		plateauJeu.afficher();
		System.out.println("Main : ");
		int i=0;
		for (Carte carteMainCarte : leJoueur.main_joueur) {
			System.out.print(i +"." +carteMainCarte.couleur + " ");
			i++;
		}
		
	}
	

}
