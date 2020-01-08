import java.util.ArrayList;

public class Plateau {
	public static Tuile[][] plateau;
	
	public Plateau() {
		plateau = new Tuile[8][8];
	}
	public static void initialiser(ArrayList<Joueur> listeJoueurs)
	{
		for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                plateau[i][j] = new Tuile();
            }
        }
		
		
		if(listeJoueurs.size() == 2)
		{
			plateau[0][1] = listeJoueurs.get(0).tortue;
			listeJoueurs.get(0).tortue.posX = 0;
			listeJoueurs.get(0).tortue.posX = 1;
			plateau[0][5] = listeJoueurs.get(1).tortue;
			plateau[7][3] = new Joyaux();
			
			for (int i = 0; i < 8; i++) {
				plateau[i][7] = new Caisse();
	        }
			
		}
		
		if(listeJoueurs.size() == 3)
		{
			plateau[0][0] = listeJoueurs.get(0).tortue;
			plateau[0][3] = listeJoueurs.get(1).tortue;
			plateau[0][6] = listeJoueurs.get(2).tortue;
			
			//TODO configurer la correspondance entre joyau et tortue
			plateau[7][0] = new Joyaux();
			plateau[7][3] = new Joyaux();
			plateau[7][6] = new Joyaux();
			
			for (int i = 0; i < 8; i++) {
				plateau[i][7] = new Caisse();
	        }
			
		}
		
		if(listeJoueurs.size() == 4)
		{
			plateau[0][0] = listeJoueurs.get(0).tortue;
			plateau[0][2] = listeJoueurs.get(1).tortue;
			plateau[0][5] = listeJoueurs.get(2).tortue;
			plateau[0][7] = listeJoueurs.get(3).tortue;		
			plateau[7][1] = new Joyaux();
			plateau[7][6] = new Joyaux();
			
		}
		
		
	}
	
	//affiche le plateau dans la console
	public static void afficher() {
		for (int i = 0; i < 8; i++) {
			System.out.print("\n");
            for (int j = 0; j < 8; j++) {
            	if(plateau[i][j].type == "tortue")
            		System.out.print("t|");
            	else if(plateau[i][j].type == "vide")
            		System.out.print(" |");
            	else if(plateau[i][j].type == "joyau")
            		System.out.print("j|");
            	else if(plateau[i][j].type == "caisse")
            		System.out.print("c|");
            	else if(plateau[i][j].type == "turtule")
            		System.out.print("T|");
            	
            }
        }
	}
	
	public static void avancerTortueJoueur(Joueur leJoueur) {
		Boolean error = false;
		int i,j;
		for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                
            }
        }
		switch (leJoueur.tortue.direction) {
		case 'N':
			break;
		case 'S':
			break;
		case 'O':
			break;
		case 'E':
			break;

		default:
			break;
		}
		
	}
}
