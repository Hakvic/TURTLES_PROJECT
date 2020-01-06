import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

import sun.management.counter.Variability;

public class InitialiserJeu {
    public ArrayList<Joueur> joueurs = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);


    public void displayMenu() {
        System.out.println("Nombre de joueurs");
        int choice = scanner.nextInt();
        System.out.println(choice);
        switch (choice) {
            case 2:
            case 3:
            case 4:
            	for(int i=0; i<choice; i++)
            	{
            		System.out.println("Nom du joueur 1");
            	}
                break;
            default:
                System.out.println("Erreur de saisie");
        }
    }

    public void addJoueur() {
        System.out.println("Saisissez le nom du joueur");
        String empty = scanner.nextLine();
        String name = scanner.nextLine(); // parsing voir tp
        System.out.println(name);
        Joueur joueur = new Joueur(name, false);
        joueurs.add(joueur);
    }

    public void initJoueur(){
        for(Joueur joueur: joueurs){
            joueur.jeuCarte();
            System.out.println(joueur.getJeuCarte());
            System.out.println(joueur.getJeuCarte().size());

            joueur.mainJoueur();
            System.out.println(joueur.getMain().size());
            System.out.println(joueur.getMain());
        }
    }

    public void run() {
        while(true){
            displayMenu();
        }

    }
}
