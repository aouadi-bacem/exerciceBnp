package gov.nasa;

public class Rover {
	

	private int width;
	private int heigth;
	
	private int coordX;
	private int coordY;
	private char orientation;
	
	public Rover(String line) {
		 width = Integer.parseInt(line.split(" ")[0]); 
		 heigth = Integer.parseInt(line.split(" ")[1]);
	}
	
	
	public String getPosition() {
			return(coordX + " " + coordY + " " + orientation);
	}

	public void initRover(String line) throws IllegalFormatException, IllegalPositionException {
		try {
			coordX = Integer.parseInt(line.split(" ")[0]); 
			if (coordX > width) {
				throw new IllegalPositionException();
			}
			coordY = Integer.parseInt(line.split(" ")[1]); 
			if (coordY > heigth) {
				throw new IllegalPositionException();
			}
			orientation = line.split(" ")[2].charAt(0);
		}catch(StringIndexOutOfBoundsException e) {
			throw new IllegalFormatException(line);
		}
	}
	
	public void moveRover(String line) {
		for(int i =0; i<line.length(); i++) {
			move(line.charAt(i));
		}
	}

	private void turnLeft() {
		switch (orientation) {
			case 'N':
				orientation = 'W';
				break;
			case 'E':
				orientation = 'N';
				break;
				
			case 'S':
				orientation = 'E';
				break;	
				
			case 'W':
				orientation = 'S';
		}
	}
	
	private void turnRight() {
		switch (orientation) {
		case 'N':
			orientation = 'E';
			break;
		case 'E':
			orientation = 'S';
			break;
		case 'S':
			orientation = 'W';
			break;	
		case 'W':
			orientation = 'N';
		}
	}
	
	private void move(char c)  {
		switch (c) {
		case 'L':
			turnLeft();
			break;
		case 'R':
			turnRight();
			break;
		case 'M':
			switch (orientation) {
			case 'N':
				coordY = Math.min(coordY + 1, heigth);
				break;
			case 'E':
				coordX = Math.min(coordX + 1, width);
				break;
			case 'S':
				coordY = Math.max(coordY - 1, 0);
				break;	
			case 'W':
				coordX = Math.max(coordX - 1, 0);
			}
		}
	}
}