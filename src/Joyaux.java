public class Joyaux extends Tuile {
	private constante.COULEUR couleur;
	private int numero;

	public Joyaux() {
		// appeler le constructeur de la classe mere
		this.type = constante.TUILE.joyau;
	}

	public Joyaux(int num) {
		// appeler le constructeur de la classe mere
		this.type = constante.TUILE.joyau;
		this.numero = num;
		this.couleur = constante.COULEUR.values()[numero];
	}

	public constante.COULEUR couleur() {
		return constante.COULEUR.values()[numero];
	}

	public boolean isJoyau() {
		return true;
	}

	public String fichierImage(){
		return "./images/joyaux/" + this.couleur + ".jpg";
	}
}

