public class Joyaux extends Tuile {
    private String couleur;

    public Joyaux(String couleur){
        // appeler le constructeur de la classe mere
        this.type = "Joyaux";
        this.couleur = couleur;
    }

    public String getCouleur(){
        return couleur;
    }
}


