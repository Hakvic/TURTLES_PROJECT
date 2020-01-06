public class Tortue extends Tuile {
    private String couleur;
    public String direction;

    public Tortue(String couleur, String direction){
        // appeler le constructeur de la classe mere
        this.type = "tortue";
        this.couleur = couleur;
        this.direction = direction;
    }

    public String getCouleur(){
        return couleur;
    }
}
