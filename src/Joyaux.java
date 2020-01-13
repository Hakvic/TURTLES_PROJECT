public class Joyaux extends Tuile {
	private String couleur;
	private int numero;

	public Joyaux() {
		// appeler le constructeur de la classe mere
		this.type = constante.TUILE.joyau;
	}

	public Joyaux(int num) {
		// appeler le constructeur de la classe mere
		this.type = constante.TUILE.joyau;
		this.numero = num;
	}

	public constante.COULEUR couleur() {
		return constante.COULEUR.values()[numero];
	}

	public boolean isJoyau() {
		return true;
	}

}
