package gov.nasa;


public class IllegalPositionException extends Exception {
    
    
	private static final long serialVersionUID = 8495246299794781523L;
	
    public String toString() {
        return "La position du rover est incorrecte";
    }
}
