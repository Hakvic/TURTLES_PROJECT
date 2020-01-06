import java.util.ArrayList;
import java.util.Scanner;


public class Jeu {
    //liste des joueurs de la partie
    public static ArrayList<Joueur> joueurs = new ArrayList<>();

    //Partie console
    public static Scanner scanner = new Scanner(System.in);

    public static void initialiserPartie() {
        initialiserJoueurs();
        Plateau plateauJeu= new Plateau();
        plateauJeu.initialiser(joueurs);
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
            Joueur newJoueur = new Joueur(nomJoueurString, false, numeroJoueur);
            // initialise le jeu de carte du joueur
            newJoueur.initJeuCarte();
            // initialise la main du joueur 5 cartes
            newJoueur.initMainJoueur();
            // initialise les obstacles du joueurs 3 pierres et 2 glaces
            newJoueur.initObstacles();
            joueurs.add(newJoueur);
        }
    }

}
