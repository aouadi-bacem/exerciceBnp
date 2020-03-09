package gov.nasa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args)  {
		if(args.length != 0) {

			String fileName = args[0];
			InputParser inputParser = InputParser.getInstance();
			Rover rover = null;
			
			try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
				//ligne 1 : taille du plateau 
				String line = reader.readLine();
				//controle du format de la ligne
				inputParser.controlFormatFirstLine(line);
				// Créer un nouveau Rover
				rover = new Rover(line);

				line = reader.readLine();
				while (line != null){
					//line 1 : Coordonnee initial du rover
					inputParser.controlFormatLineCoord(line);
					rover.initRover(line);

					line = reader.readLine();
					//line 2 : mouvement du rover
					inputParser.controlFormatLineMove(line);	
					rover.moveRover(line);
					// afficher la position du rover
					System.out.println(rover.getPosition());
					// passer au rover suivant s'il y'en a 
					line = reader.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch(IllegalFormatException e) {
				System.out.println(e.toString());
			} catch(IllegalPositionException e) {
				System.out.println(e.toString());
			}
		}else { 
			System.out.println("Input File Missing");
		}
	}

}
