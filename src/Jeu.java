import java.util.ArrayList;
import java.util.Scanner;

import sun.management.counter.Variability;

public class Jeu {
	//liste des joueurs de la partie
	public static ArrayList<Joueur> joueurs = new ArrayList<>();
	
	//Partie console
	public static Scanner scanner = new Scanner(System.in);
	
	
	public static Plateau plateauJeu= new Plateau();
	
	public static void initialiserPartie() {
		initialiserJoueurs();
		plateauJeu= new Plateau();
		plateauJeu.initialiser(joueurs);
		plateauJeu.afficher();
		
		System.out.println("Next\n");
		
		scanner.nextInt();
		joueurs.get(0).tortue.pivoterDroite();
		plateauJeu.avancerTortueJoueur(joueurs.get(0));
		joueurs.get(0).tortue.pivoterDroite();
		plateauJeu.avancerTortueJoueur(joueurs.get(0));
		plateauJeu.avancerTortueJoueur(joueurs.get(0));
		
		plateauJeu.afficher();
		
		do {
			Joueur leJoueur = joueurs.get(0);
			plateauJeu.afficher();
			System.out.println("\n1. avancer\n"
					+ "2. pivoter droite\n"
					+ "3. pivoter gauche\n"
					+ "4. poser un mur");
			switch (scanner.nextInt()) {
			case 1:
				plateauJeu.avancerTortueJoueur(leJoueur);
				break;
			case 2:
				leJoueur.tortue.pivoterDroite();
				break;
			case 3:
				leJoueur.tortue.pivoterGauche();
			case 4:
				System.out.println("posI?\n");
				int posI = scanner.nextInt();
				
				System.out.println("posJ?\n");
				int posJ = scanner.nextInt();
				
				plateauJeu.construireMurPierre(posI, posJ);
					
			default:
				break;
			}
			
			
		}while(!joueurs.get(0).gagnant);
		
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
	
}
