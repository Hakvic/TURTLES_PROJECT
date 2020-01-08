import java.util.ArrayList;
import java.util.Scanner;

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
		
		System.out.println("Next");
		scanner.nextInt();
		
		joueurs.get(0).tortue.type = "turtule";
		plateauJeu.afficher();
		
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
