package gov.nasa;

public class InputParser {

	private static String REGEX_FIRST_LINE = "\\d+\\s\\d+";
	private static String REGEX_LINE_COORD = "\\d+\\s\\d+\\s[NESW]";
	private static String REGEX_LINE_MOVE = "[LRM]*";

	private static InputParser inputParser;
	
	private InputParser() { 
		
	}
	
	/*
	 * Créer ou Retourner l'instance unique du singleton InputParser
	 */
	public static InputParser getInstance() {
		if (inputParser == null) {
			inputParser = new InputParser();
		}
		return inputParser;
	}
	
	/*
	 * Controle du format de la premiere ligne qui contient la taille du plateau
	 */
	public void controlFormatFirstLine(String line) throws IllegalFormatException{
		if(line == null || !line.matches(REGEX_FIRST_LINE))
			throw new IllegalFormatException("qui contient la taille du plateau \"" + line + "\"");
		
	}
	
	/*
	 * Controle du format de la premire ligne qui contient la position du rover
	 */
	public void controlFormatLineCoord(String line) throws IllegalFormatException{
		if(line == null || !line.matches(REGEX_LINE_COORD))
			throw new IllegalFormatException("qui contient la position du rover \"" + line + "\"");
	}
	
	/*
	 * Controle du format de la premire ligne qui contient les mouvements du rover
	 */
	public void controlFormatLineMove(String line) throws IllegalFormatException{
		if(line == null || !line.matches(REGEX_LINE_MOVE))
			throw new IllegalFormatException("qui contient les mouvements du rover \"" + line + "\"");
	}

}
