public class CellularAutomataCavegen {
	private static final char WALL = '#';
	private static final char FLOOR = '.';
	private static final int ITERATIONS = 5;
	
	private static char[][] createCave(int width, int height) {
		return createCave(width, height, 0.60f);
	}
	
	private static char[][] createCave(int width, int height, float initialFloorPercentage) {
		char[][] map = new char[height][width];
		char[][] map2 = new char[height][width];
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				map[y][x] = Math.random() < initialFloorPercentage ? FLOOR : WALL;
			}
		}
		
		for (int it = 0; it < ITERATIONS; it++) {
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					int wallcount = getWallsInRange(map, x, y, 1);
					if (it == 1) {
						if (getWallsInRange(map, x, y, 2) <= 2) {
							wallcount = 9;
						}
					}
					map2[y][x] = wallcount > 4 ? WALL : FLOOR;
				}
			}
			
			char[][] t = map;
			map = map2;
			map2 = t;
		}
		
		return map;
	}
	
	private static int getWallsInRange(char[][] map, int posX, int posY, int range) {
		int width = map[0].length;
		int height = map.length;
		int wallcount = 0;
		for (int i = -range; i <= range; i++) {
			for (int j = -range; j <= range; j++) {
				boolean isOutOfBounds = posY + i < 0 || posY + i > height - 1 || posX + j < 0 || posX + j > width - 1;
				if (isOutOfBounds || map[posY + i][posX + j] == WALL) {
					wallcount++;
				}
			}
		}
		return wallcount;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			char[][] mymap = CellularAutomataCavegen.createCave(50, 50);
			CavePrinter.saveCave(mymap, "caveExamples/CellularAutomata/CellularCave" + (i + 1) + ".txt");
		}
	}
}