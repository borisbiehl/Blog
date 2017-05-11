import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class GrowingTree {
	
	private static final char FLOOR = '.';
	private static final char WALL = '#';
	
	private static char[][] generateMaze(int width, int height) {
		char[][] map = new char[height][width];
		Tile[][] tiles = new Tile[height][width];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[y][x] = new Tile();
				tiles[y][x].setPosX(x);
				tiles[y][x].setPosY(y);
				tiles[y][x].setType(WALL);
			}
		}
		
		ArrayDeque<Tile> workStack = new ArrayDeque<>();
		int startX = (int)(Math.random() * width - 2) + 1;
		int startY = (int)(Math.random() * height - 2) + 1;
		
		// Create Entrance
		switch((int)(Math.random() * 4)) {
		case 0:
			startX = 1;
			tiles[startY][0].setType(FLOOR);
			tiles[startY][0].setVisited(true);
		break;
		case 1:
			startX = width - 2;
			tiles[startY][width - 1].setType(FLOOR);
			tiles[startY][width - 1].setVisited(true);
		break;
		case 2:
			startY = 1;
			tiles[0][startX].setType(FLOOR);
			tiles[0][startX].setVisited(true);
		break;
		case 3:
			startY = height - 2;
			tiles[height - 1][startX].setType(FLOOR);
			tiles[height - 1][startX].setVisited(true);
		break;
		}
		
		workStack.push(tiles[startY][startX]);
		Tile curr;
		while(workStack.size() > 0) {
			curr = workStack.pop();
			if (isValidTile(tiles, curr)) {
				curr.setVisited(true);
				curr.setType(FLOOR);
				Tile[] neigbors = getValidNeigborTilesInRandomOrder(tiles, curr.getPosX(), curr.getPosY());
				for (int i = 0; i < neigbors.length; i++) {
					workStack.push(neigbors[i]);
				}
			}
		}
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				map[y][x] = tiles[y][x].getType();
			}
		}
		return map;
	}
	
	private static Tile[] getValidNeigborTilesInRandomOrder(Tile[][] tiles, int posX, int posY) {
		ArrayList<Tile> neigbors = new ArrayList<>();
		if (posX > 1 && isValidTile(tiles, tiles[posY][posX - 1])) {
			neigbors.add(tiles[posY][posX - 1]);
		}
		if (posX < tiles[0].length - 2 && isValidTile(tiles, tiles[posY][posX + 1])) {
			neigbors.add(tiles[posY][posX + 1]);
		}
		if (posY > 1 && isValidTile(tiles, tiles[posY - 1][posX])) {
			neigbors.add(tiles[posY - 1][posX]);
		}
		if (posY < tiles.length - 2 && isValidTile(tiles, tiles[posY + 1][posX])) {
			neigbors.add(tiles[posY + 1][posX]);
		}
		Tile[] neigborsArray = new Tile[neigbors.size()];
		neigborsArray = neigbors.toArray(neigborsArray);
		shuffleArray(neigborsArray);
		return neigborsArray;
	}
	
	private static boolean isValidTile(Tile[][] tiles, Tile tile) {
		if (tile.isVisited()) {
			return false;
		}
		int posX = tile.getPosX();
		int posY = tile.getPosY();
		int openCount = 0;
		if (posX > 0 && tiles[posY][posX - 1].getType() == FLOOR) {
			openCount++;
		}
		if (posX < tiles[0].length - 1 && tiles[posY][posX + 1].getType() == FLOOR) {
			openCount++;
		}
		if (posY > 0 && tiles[posY - 1][posX].getType() == FLOOR) {
			openCount++;
		}
		if (posY < tiles.length - 1 && tiles[posY + 1][posX].getType() == FLOOR) {
			openCount++;
		}
		if (openCount > 1) {
			return false;
		}
		return true;
	}
	
	// Implementing Fisher–Yates shuffle
	private static void shuffleArray(Tile[] array) {
		Random random = new Random();
		for (int i = array.length - 1; i > 0; i--) {
			int index = random.nextInt(i + 1);
			// Simple swap
			Tile t = array[index];
			array[index] = array[i];
			array[i] = t;
		}
	}
	
	private static void printMap(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			System.out.println(new String(map[i]));
		}
	}
	
	public static void main(String [] args) {
		char[][] map = generateMaze(51, 25);
		printMap(map);
	}
}