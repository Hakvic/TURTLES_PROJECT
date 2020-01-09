import java.util.ArrayList;

public class Plateau {
	public static Tuile[][] plateau;
	
	public Plateau() {
		plateau = new Tuile[8][8];
	}
	public static void initialiser(ArrayList<Joueur> listeJoueurs)
	{
		
		//mise de toutes les tuiles comme vide
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
		System.out.print(" 0 1 2 3 4 5 6 7");
		for (int i = 0; i < 8; i++) {
			System.out.print("\n" + i);
            for (int j = 0; j < 8; j++) {
            	if(plateau[i][j].type == constante.TUILE.tortue)
            		System.out.print("t|");
            	else if(plateau[i][j].type == constante.TUILE.vide)
            		System.out.print(" |");
            	else if(plateau[i][j].type == constante.TUILE.joyau)
            		System.out.print("j|");
            	else if(plateau[i][j].type == constante.TUILE.caisse)
            		System.out.print("c|");
            	else if(plateau[i][j].type == constante.TUILE.murPierre)
            		System.out.print("p|");
            	
            }
            
        }
		System.out.print("\n");
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
	public static void miseajourPositionTortue(Joueur leJoueur) {
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
	}
	public static void avancerTortueJoueur(Joueur leJoueur) {
		//faire les algos en cas d'erreur
		Boolean error = false;
		
		
		miseajourPositionTortue(leJoueur);
		switch (leJoueur.tortue.direction) {
		case NORD:
			if(leJoueur.tortue.posi > 0)
			{
				if(plateau[leJoueur.tortue.posi - 1][leJoueur.tortue.posj].type == constante.TUILE.vide)
				{
					plateau[leJoueur.tortue.posi - 1][leJoueur.tortue.posj] = leJoueur.tortue;
		    		plateau[leJoueur.tortue.posi][leJoueur.tortue.posj] = new Tuile();
				}
				else if (plateau[leJoueur.tortue.posi - 1][leJoueur.tortue.posj].type == constante.TUILE.joyau) {
					plateau[leJoueur.tortue.posi][leJoueur.tortue.posj] = new Tuile();
					plateau[leJoueur.tortue.posi - 1][leJoueur.tortue.posj] = new Tuile();
					leJoueur.gagnant = true;
				}
				
			}
			break;
		case SUD:
			if( leJoueur.tortue.posi < 7)
			{
				if(plateau[leJoueur.tortue.posi + 1][leJoueur.tortue.posj].type == constante.TUILE.vide)
				{
					plateau[leJoueur.tortue.posi + 1][leJoueur.tortue.posj] = leJoueur.tortue;
		    		plateau[leJoueur.tortue.posi][leJoueur.tortue.posj] = new Tuile();
				}
				else if (plateau[leJoueur.tortue.posi + 1][leJoueur.tortue.posj].type == constante.TUILE.joyau) {
					plateau[leJoueur.tortue.posi][leJoueur.tortue.posj] = new Tuile();
					plateau[leJoueur.tortue.posi + 1][leJoueur.tortue.posj] = new Tuile();
					leJoueur.gagnant = true;
				}
				
			}
			else 
			{
				//il ya une erreur
			}
			
			break;
		case OUEST:
			if(leJoueur.tortue.posj > 0)
			{
				if(plateau[leJoueur.tortue.posi][leJoueur.tortue.posj - 1].type == constante.TUILE.vide)
				{
					plateau[leJoueur.tortue.posi][leJoueur.tortue.posj - 1] = leJoueur.tortue;
		    		plateau[leJoueur.tortue.posi][leJoueur.tortue.posj] = new Tuile();
				}
				else if (plateau[leJoueur.tortue.posi][leJoueur.tortue.posj - 1].type == constante.TUILE.joyau) {
					plateau[leJoueur.tortue.posi][leJoueur.tortue.posj - 1] = new Tuile();
					plateau[leJoueur.tortue.posi][leJoueur.tortue.posj] = new Tuile();
					leJoueur.gagnant = true;
				}
				
			}
			break;
		case EST:
			if( leJoueur.tortue.posj < 7)
			{
				if(plateau[leJoueur.tortue.posi][leJoueur.tortue.posj + 1].type == constante.TUILE.vide)
				{
					plateau[leJoueur.tortue.posi][leJoueur.tortue.posj + 1] = leJoueur.tortue;
		    		plateau[leJoueur.tortue.posi][leJoueur.tortue.posj] = new Tuile();
				}
				else if (plateau[leJoueur.tortue.posi][leJoueur.tortue.posj + 1].type == constante.TUILE.joyau) {
					plateau[leJoueur.tortue.posi][leJoueur.tortue.posj + 1] = new Tuile();
					plateau[leJoueur.tortue.posi][leJoueur.tortue.posj] = new Tuile();
					leJoueur.gagnant = true;
				}
				
			}
			break;

		default:
			break;
		}
		
	}
	
	public static void construireMurPierre(int posI, int posJ)
	{
		if(posI >= 0 && posI <= 8 && posJ >= 0 && posJ <= 8)
		{
			if (plateau[posI][posJ].type == constante.TUILE.vide) {
				plateau[posI][posJ].type = constante.TUILE.murPierre;
			}
		}
	}
}
