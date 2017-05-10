public class RandomWalkerCavegen {
	
	private static final int MAX_ITERATIONS = 50000;
	private static final char WALL = '#';
	private static final char FLOOR = '.';
	
	private static char[][] createCave(int width, int height) {
		return createCave(width, height, Math.min((width * height)/5, 5000));
	}
	
	private static char[][] createCave(int width, int height, int requiredFloorTiles) {
		final char[][] map = new char[height][width];
		int walkerX = width / 2;
		int walkerY = height / 2;
		int floorcount = 1;
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				map[y][x] = WALL;
			}
		}
		
		map[walkerY][walkerX] = FLOOR;
		
		int iterationCount = 0;
		while (floorcount < requiredFloorTiles && iterationCount < MAX_ITERATIONS) {
			iterationCount++;
			switch ((int)(Math.random() * 4)) {
			case 0:
				if (walkerX > 0) {
					walkerX--;
					if (map[walkerY][walkerX] == WALL) {
						map[walkerY][walkerX] = FLOOR;
						floorcount++;
					}
				}
			break;
			case 1:
				if (walkerX < width - 1) {
					walkerX++;
					if (map[walkerY][walkerX] == WALL) {
						map[walkerY][walkerX] = FLOOR;
						floorcount++;
					}
				}
			break;
			case 2:
				if (walkerY > 0) {
					walkerY--;
					if (map[walkerY][walkerX] == WALL) {
						map[walkerY][walkerX] = FLOOR;
						floorcount++;
					}
				}
			break;
			case 3:
				if (walkerY < height - 1) {
					walkerY++;
					if (map[walkerY][walkerX] == WALL) {
						map[walkerY][walkerX] = FLOOR;
						floorcount++;
					}
				}
			break;
			}
		}
		
		if (iterationCount == MAX_ITERATIONS) {
			System.out.println("Random walker finished early - iterationcount hit iteration limit.");
		}
		
		return map;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			char[][] mymap = RandomWalkerCavegen.createCave(50, 50);
			CavePrinter.saveCave(mymap, "caveExamples/randomWalker/randomWalkerCave" + (i + 1) + ".txt");
		}
	}
}