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
			listeJoueurs.get(0).tortue.posi = 0;
			listeJoueurs.get(0).tortue.posi= 1;
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
	
	
	public static void avancerTortue(Joueur leJoueur) {
		int i,j;
		for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
            	if(plateau[i][j] == leJoueur.tortue)
            	{
            		plateau[i][j+1] = leJoueur.tortue;
            		plateau[i][j] = new Tuile();
            		return;
            		
            	}
            }
        }
		
	}
	public static void avancerTortueJoueur(Joueur leJoueur) {
		Boolean error = false;
		int i,j;
		for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
            	if(plateau[i][j] == leJoueur.tortue)
            	{
            		leJoueur.tortue.posi = i;
            		leJoueur.tortue.posj = j;
            	}
            }
        }
		
		
		switch (leJoueur.tortue.direction) {
		case 'N':
			if(leJoueur.tortue.posi > 0)
			{
				if(plateau[leJoueur.tortue.posi - 1][leJoueur.tortue.posj].type == "vide")
				{
					plateau[leJoueur.tortue.posi - 1][leJoueur.tortue.posj] = leJoueur.tortue;
		    		plateau[leJoueur.tortue.posi][leJoueur.tortue.posj] = new Tuile();
				}
				
			}
			break;
		case 'S':
			if( leJoueur.tortue.posi < 7)
			{
				if(plateau[leJoueur.tortue.posi + 1][leJoueur.tortue.posj].type == "vide")
				{
					plateau[leJoueur.tortue.posi + 1][leJoueur.tortue.posj] = leJoueur.tortue;
		    		plateau[leJoueur.tortue.posi][leJoueur.tortue.posj] = new Tuile();
				}
				
			}
			else 
			{
				//il ya une erreur
			}
			
			break;
		case 'O':
			if(leJoueur.tortue.posj > 0)
			{
				if(plateau[leJoueur.tortue.posi][leJoueur.tortue.posj - 1].type == "vide")
				{
					plateau[leJoueur.tortue.posi][leJoueur.tortue.posj - 1] = leJoueur.tortue;
		    		plateau[leJoueur.tortue.posi][leJoueur.tortue.posj] = new Tuile();
				}
				
			}
			break;
		case 'E':
			if( leJoueur.tortue.posj < 7)
			{
				if(plateau[leJoueur.tortue.posi][leJoueur.tortue.posj + 1].type == "vide")
				{
					plateau[leJoueur.tortue.posi][leJoueur.tortue.posj + 1] = leJoueur.tortue;
		    		plateau[leJoueur.tortue.posi][leJoueur.tortue.posj] = new Tuile();
				}
				
			}
			break;

		default:
			break;
		}
		
	}
	
	public static void pivoterdroiteTortueJoueur(Joueur leJoueur) {
		if(leJoueur.tortue.direction == 'N')
			leJoueur.tortue.direction = 'E';
		
		else if (leJoueur.tortue.direction == 'E')
			leJoueur.tortue.direction = 'S';
		
		else if (leJoueur.tortue.direction == 'S')
			leJoueur.tortue.direction = 'O';
		
		else if (leJoueur.tortue.direction == 'O')
			leJoueur.tortue.direction = 'N';
	}
	
	public static void pivotergaucheTortueJoueur(Joueur leJoueur)
	{
		//trois pivot à droite équivaut à un pivot à gauche
		for(int i = 0; i < 3; i++)
		{
			pivoterdroiteTortueJoueur(leJoueur);
		}
	}
}
