public class Tortue extends Tuile {
    public String couleur;
    public char direction;
    public int numeroTortue;
    public int posi;
    public int posj;

    public Tortue(String couleur, char direction){
        // appeler le constructeur de la classe mere
        this.type = "tortue";
        this.couleur = couleur;
        this.direction = direction;
    }
    
    public Tortue(int numero){
        // appeler le constructeur de la classe mere
        this.type = "tortue";
        switch (numero) {
		//si numero de tor
        case 0:
			this.couleur = "B";
			break;
        case 1:
			this.couleur = "R";
			break;
        case 2:
			this.couleur = "J";
			break;
        case 3:
			this.couleur = "V";
			break;

		default:
			break;
		}
        this.direction = 'N';
    }
}
