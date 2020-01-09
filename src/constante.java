public class constante {
	public enum  TUILE{
	    murPierre,
	    murGlace,
	    caisse,
	    tortue,
	    joyau,
	    vide
	}
	
	public enum  DIRECTION{
	    NORD,EST,SUD,OUEST,;
		private static DIRECTION[] vals = values();
	    public DIRECTION suivant()
	    {
	        return vals[(this.ordinal()+1) % vals.length];
	    }
	    
	    public DIRECTION precedent()
	    {
	        return vals[(this.ordinal()+3) % vals.length];
	    }
	}
	
	
}
