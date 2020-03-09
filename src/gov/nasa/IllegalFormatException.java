package gov.nasa;


public class IllegalFormatException extends Exception {
    
    
	private static final long serialVersionUID = 8495246299794781523L;
	
	private String ligne;
    
    public IllegalFormatException(String errorMessage) {
        ligne = errorMessage;
    }
    
    public String toString() {
        return "Le format de la ligne " + ligne + " est incorrecte";
    }
}
