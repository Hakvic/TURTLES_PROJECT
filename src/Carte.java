public class Carte {

    public constante.CARTE couleur;

    public Carte(constante.CARTE couleur){
        this.couleur = couleur;
    }

    public String fichierImage(){
        return "./images/cards/" + this.couleur + ".png";
    }
}


