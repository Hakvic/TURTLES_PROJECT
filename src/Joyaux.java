public class Joyaux extends Tuile {
    private String couleur;

    public Joyaux(){
        // appeler le constructeur de la classe mere
        this.type = "joyau";
    }

    public String getCouleur(){
        return couleur;
    }
}


