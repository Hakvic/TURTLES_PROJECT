public class Tortue extends Tuile {
	public constante.COULEUR couleur;
	public constante.DIRECTION direction;
	public int posi;
	public int posj;

	public int initi;
	public int initj;

	public boolean retournerPositionInit;

	public Tortue(int numero) {
		// appeler le constructeur de la classe mere
		this.type = constante.TUILE.tortue;
		this.couleur = constante.COULEUR.values()[numero];
		this.direction = constante.DIRECTION.SUD;
		this.retournerPositionInit = false;
	}

	public void pivoterDroite() {
		this.direction = direction.suivant();
	}

	public void setPos(int i, int j) {
		this.posi = i;
		this.posj = j;
	}

	public void setInitPos(int i, int j) {
		this.initi = i;
		this.initj = j;
	}

	public void pivoterGauche() {
		this.direction = direction.precedent();
	}

	public void demiTour() {
		this.pivoterDroite();
		this.pivoterDroite();

	}

	public String fichierImage(){
		return "./images/turtles/" + this.couleur + this.direction + ".jpg";
	}
}
