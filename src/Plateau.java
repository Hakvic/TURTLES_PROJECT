import java.util.ArrayList;

public class Plateau {
	public static Tuile[][] plateau;
	private static ArrayList<Joueur> listeJoueurs = new ArrayList<>();

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	FenetrePlateau affiche_plateau;

	public Plateau() {
		plateau = new Tuile[8][8];
	}

	public Plateau(ArrayList<Joueur> listeJ, FenetrePlateau affiche_plateau) {
		this.affiche_plateau = affiche_plateau;
		plateau = new Tuile[8][8];
		listeJoueurs = listeJ;
	}

	public void initialiser(ArrayList<Joueur> listeJ) {
		listeJoueurs = listeJ;
		// mise de toutes les tuiles comme vide
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				plateau[i][j] = new Tuile();
			}
		}

		if (listeJoueurs.size() == 2) {
			plateau[0][1] = listeJoueurs.get(0).tortue;
			plateau[0][5] = listeJoueurs.get(1).tortue;
			plateau[7][3] = new Joyaux(0);

			for (int i = 0; i < 8; i++) {
				plateau[i][7] = new Caisse();
			}

		}

		if (listeJoueurs.size() == 3) {
			plateau[0][0] = listeJoueurs.get(0).tortue;
			plateau[0][3] = listeJoueurs.get(1).tortue;
			plateau[0][6] = listeJoueurs.get(2).tortue;
			plateau[7][0] = new Joyaux(0);
			plateau[7][3] = new Joyaux(1);
			plateau[7][6] = new Joyaux(2);

			for (int i = 0; i < 8; i++) {
				plateau[i][7] = new Caisse();
			}

		}

		if (listeJoueurs.size() == 4) {
			plateau[0][0] = listeJoueurs.get(0).tortue;
			plateau[0][2] = listeJoueurs.get(1).tortue;
			plateau[0][5] = listeJoueurs.get(2).tortue;
			plateau[0][7] = listeJoueurs.get(3).tortue;
			plateau[7][1] = new Joyaux(0);
			plateau[7][6] = new Joyaux(1);

		}

		int i, j, k;
		for (k = 0; k < listeJoueurs.size(); k++) {
			for (i = 0; i < 8; i++) {
				for (j = 0; j < 8; j++) {
					if (plateau[i][j] == listeJoueurs.get(k).tortue) {
						listeJoueurs.get(k).tortue.setPos(i, j);
						listeJoueurs.get(k).tortue.setInitPos(i, j);

					}
				}
			}
		}

	}

	// affiche le plateau dans la console
	public void afficher() {

		System.out.print(" 0 1 2 3 4 5 6 7");
		for (int i = 0; i < 8; i++) {
			System.out.print("\n" + i);
			for (int j = 0; j < 8; j++) {
				if (plateau[i][j].type == constante.TUILE.tortue) {
					Tortue thisTortue = (Tortue) plateau[i][j];

					// plot tortue graphique
					this.affiche_plateau.setButton(i,j, thisTortue.fichierImage());

					switch (thisTortue.couleur) {
					case BLEU:
						System.out.print(ANSI_BLUE);
						break;
					case ROUGE:
						System.out.print(ANSI_RED);
						break;
					case VERT:
						System.out.print(ANSI_GREEN);
						break;
					case VIOLET:
						System.out.print(ANSI_YELLOW);
						break;

					default:
						break;
					}
					switch (thisTortue.direction) {
					case NORD:
						System.out.print("^");
						break;
					case EST:
						System.out.print(">");
						break;
					case SUD:
						System.out.print("v");
						break;
					case OUEST:
						System.out.print("<");
						break;

					default:
						break;
					}
					System.out.print(ANSI_RESET + "|");
				}

				else if (plateau[i][j].type == constante.TUILE.vide) {
					System.out.print(" |");

					// remove backgroud button graphique
					this.affiche_plateau.resetButton(i,j);
				}
				else if (plateau[i][j].type == constante.TUILE.joyau) {
					Joyaux thisJoyau = (Joyaux) plateau[i][j];

					// plot joyaux graphique
					this.affiche_plateau.setButton(i,j,thisJoyau.fichierImage());

					switch (thisJoyau.couleur()) {
					case BLEU:
						System.out.print(ANSI_BLUE);
						break;
					case ROUGE:
						System.out.print(ANSI_RED);
						break;
					case VERT:
						System.out.print(ANSI_GREEN);
						break;
					case VIOLET:
						System.out.print(ANSI_YELLOW);
						break;

					default:
						break;
					}
					System.out.print("j" + ANSI_RESET + "|");
				}

				else if (plateau[i][j].type == constante.TUILE.caisse)
				{
					System.out.print("c|");
					//plot wood box graphique
					affiche_plateau.setButton(i,j,"./images/WoodBox.png");
				}

				else if (plateau[i][j].type == constante.TUILE.murPierre){
					System.out.print("p|");
					// plot mur pierre graphique
					affiche_plateau.setButton(i,j,"./images/MURPIERRE.png");
				}else if (plateau[i][j].type == constante.TUILE.murGlace){
					System.out.print("g|");
					// plot mur glace graphique
					affiche_plateau.setButton(i,j,"./images/MURGLACE.png");
				}


			}

		}
		System.out.print("\n");
	}

	public static void miseajourPositionTortue() {
		int i, j, k;
		for (k = 0; k < listeJoueurs.size(); k++) {
			for (i = 0; i < 8; i++) {
				for (j = 0; j < 8; j++) {
					if (plateau[i][j] == listeJoueurs.get(k).tortue) {
						listeJoueurs.get(k).tortue.setPos(i, j);

					}
				}
			}
		}
	}

	public static void avancerTortueJoueur(Joueur leJoueur) {
		// faire les algos en cas d'erreur
		Boolean error = false;

		miseajourPositionTortue();
		int differencePosi = 0;
		int differencePosj = 0;
		switch (leJoueur.tortue.direction) {
		case NORD:
			if (leJoueur.tortue.posi > 0) {
				differencePosi = -1;
			}
			break;
		case SUD:
			if (leJoueur.tortue.posi < 7) {
				differencePosi = 1;
			}

			break;
		case OUEST:
			if (leJoueur.tortue.posj > 0) {
				differencePosj = -1;
			}
			break;
		case EST:
			if (leJoueur.tortue.posj < 7) {
				differencePosj = 1;
			}
			break;
		default:
			break;
		}

		switch (plateau[leJoueur.tortue.posi + differencePosi][leJoueur.tortue.posj + differencePosj].type) {
		
		case vide:
			plateau[leJoueur.tortue.posi + differencePosi][leJoueur.tortue.posj + differencePosj] = plateau[leJoueur.tortue.posi][leJoueur.tortue.posj];
			plateau[leJoueur.tortue.posi][leJoueur.tortue.posj] = new Tuile();
			break;

		case joyau:
			plateau[leJoueur.tortue.posi][leJoueur.tortue.posj] = new Tuile();
			leJoueur.gagnant = true;
			break;
		case murGlace:
		case murPierre:
			leJoueur.tortue.demiTour();
			break;
		case tortue:
			if (plateau[leJoueur.tortue.posi + differencePosi][leJoueur.tortue.posj + differencePosj] != leJoueur.tortue) {
				leJoueur.tortue.retournerPositionInit = true;
				if (plateau[leJoueur.tortue.posi + differencePosi][leJoueur.tortue.posj + differencePosj] instanceof Tortue) {
					Tortue autreTortue = (Tortue) plateau[leJoueur.tortue.posi + differencePosi][leJoueur.tortue.posj + differencePosj];
					autreTortue.retournerPositionInit = true;
					plateau[leJoueur.tortue.posi + differencePosi][leJoueur.tortue.posj + differencePosj] = autreTortue;
				}
			}

			break;
		case caisse:
			int tempi = leJoueur.tortue.posi + differencePosi + differencePosi;
			int tempj = leJoueur.tortue.posj + differencePosj + differencePosj;
			if (tempi >= 0 && tempi <= 7 && tempj >= 0 && tempj <= 7) {
				if (plateau[tempi][tempj].isVide()) {
					plateau[tempi][tempj] = plateau[leJoueur.tortue.posi + differencePosi][leJoueur.tortue.posj + differencePosj];
					plateau[leJoueur.tortue.posi + differencePosi][leJoueur.tortue.posj + differencePosj] = plateau[leJoueur.tortue.posi][leJoueur.tortue.posj];
					plateau[leJoueur.tortue.posi][leJoueur.tortue.posj] = new Tuile();
				}
			}
			break;

		default:
			break;
		}
		miseajourPositionTortue();
		retournerPositioninit(leJoueur.tortue);

	}

	public void laser(Joueur leJoueur) {
		miseajourPositionTortue();
		int differencePosi = 0, differencePosj = 0;
		int tempi = leJoueur.tortue.posi;
		int tempj = leJoueur.tortue.posj;

		switch (leJoueur.tortue.direction) {
		case NORD:
			if (leJoueur.tortue.posi > 0) {
				differencePosi = -1;
			}
			break;
		case SUD:
			if (leJoueur.tortue.posi < 7) {
				differencePosi = 1;
			}

			break;
		case OUEST:
			if (leJoueur.tortue.posj > 0) {
				differencePosj = -1;

			}
			break;
		case EST:
			if (leJoueur.tortue.posj < 7) {
				differencePosj = 1;
			}
			break;
		default:
			break;
		}
		int nexti = 0, nextj = 0;
		do {
			tempi += differencePosi;
			tempj += differencePosj;
			nexti = tempi + differencePosi;
			nextj = tempj + differencePosj;

		} while (plateau[tempi][tempj].isVide() && nexti != 8 && nexti != -1 && nextj != 8 && nextj != -1);

		switch (plateau[tempi][tempj].type) {
		case tortue:
			if (listeJoueurs.size() == 2) {
				Tortue autreTortue = (Tortue) plateau[tempi][tempj];
				autreTortue.demiTour();
				plateau[tempi][tempj] = autreTortue;
			} else {
				Tortue autreTortue = (Tortue) plateau[tempi][tempj];
				retournerPositioninit(autreTortue);
			}
			break;
		case joyau:
			if (listeJoueurs.size() == 2) {
				leJoueur.tortue.demiTour();
			} else {
				retournerPositioninit(leJoueur.tortue);
			}
			break;
		case murGlace:
			plateau[tempi][tempj] = new Tuile();
			break;
		case murPierre:
		case caisse:
			break;

		default:
			break;
		}

	}

	public static void construireMurPierre(int posI, int posJ) {
		if (posI >= 0 && posI <= 8 && posJ >= 0 && posJ <= 8) {
			if (plateau[posI][posJ].isVide()) {
				plateau[posI][posJ] = new MurPierre();
			}
		}
	}

	public static void construireMurGlace(int posI, int posJ) {
		if (posI >= 0 && posI <= 8 && posJ >= 0 && posJ <= 8) {
			if (plateau[posI][posJ].isVide()) {
				plateau[posI][posJ] = new MurGlace();
			}
		}
	}

	public static void construireCaisse(int posI, int posJ) {
		if (posI >= 0 && posI <= 8 && posJ >= 0 && posJ <= 8) {
			if (plateau[posI][posJ].isVide()) {
				plateau[posI][posJ] = new Caisse();
			}
		}
	}

	public static void retournerPositioninit(Tortue tortue) {
		miseajourPositionTortue();
		int posi = tortue.initi;
		int posj = tortue.initj;

		if (tortue.retournerPositionInit) {
			if (plateau[posi][posj].isVide()) {
				plateau[posi][posj] = tortue;
				plateau[tortue.posi][tortue.posj] = new Tuile();
				tortue.retournerPositionInit = false;
			} else if (plateau[posi][posj + 1].isVide()) {
				plateau[posi][posj + 1] = tortue;
				plateau[tortue.posi][tortue.posj] = new Tuile();
				tortue.retournerPositionInit = false;
			} else if (plateau[posi][posj - 1].isVide()) {
				plateau[posi][posj - 1] = tortue;
				plateau[tortue.posi][tortue.posj] = new Tuile();
				tortue.retournerPositionInit = false;
			} else if (plateau[posi + 1][posj].isVide()) {
				plateau[posi + 1][posj] = tortue;
				plateau[tortue.posi][tortue.posj] = new Tuile();
				tortue.retournerPositionInit = false;
			}

		}
	}
}
