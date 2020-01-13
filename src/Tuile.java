public class Tuile {

    public constante.TUILE type;

    public Tuile(){
    	type = constante.TUILE.vide;
    }
    
    public boolean isVide() {
		if(this.type == constante.TUILE.vide)
		{
			return true;
		}
		else {
			return false;
		}
	}
    
    public boolean isJoyau() {
    	return false;
	}
    public boolean isCaisse() {
    	return false;
	}

	public boolean isMur() {
		return false;
	}
    public boolean isMurGlace() {
    	return false;
	}
    
}
