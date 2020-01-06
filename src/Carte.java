public class Carte {

    private String couleur;
    private String type;

    public Carte(String couleur, String type){
        this.couleur = couleur;
        this.type = type;
    }

    public String getCouleur(){
        return couleur;
    }

    public String getType(){
        return type;
    }
}
