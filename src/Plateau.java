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
	
	public static void afficher() {
		for (int i = 0; i < 8; i++) {
			System.out.print("\n");
            for (int j = 0; j < 8; j++) {
            	if(plateau[i][j].type == "tortue")
            		System.out.print("t|");
            	if(plateau[i][j].type == "vide")
            		System.out.print(" |");
            	if(plateau[i][j].type == "joyau")
            		System.out.print("j|");
            	if(plateau[i][j].type == "caisse")
            		System.out.print("c|");
            }
        }
	}
}
