public class Tortue extends Tuile {
    public String couleur;
    public constante.DIRECTION direction;
    public int numeroTortue;
    public int posi;
    public int posj;
    
    public int initi;
    public int initj;
    
    public boolean retournerPositionInit;

    public Tortue(String couleur, constante.DIRECTION direction){
        // appeler le constructeur de la classe mere
        this.type = constante.TUILE.tortue;
        this.couleur = couleur;
        this.direction = direction;
    }
    
    public Tortue(int numero){
        // appeler le constructeur de la classe mere
        this.type = constante.TUILE.tortue;
        
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
        this.direction = constante.DIRECTION.NORD;
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
}
