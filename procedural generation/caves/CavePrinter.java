import java.io.IOException;
import java.io.FileWriter;
public class CavePrinter {
	public static void saveCave(char[][] map, String filename) {
		final int height = map.length;
		final int width = map[0].length;
		try (FileWriter fileWriter = new FileWriter(filename)){
			char[] flattenedMap = new char[height * (width + 1)];
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					flattenedMap[y * (width + 1) + x] = map[y][x];
				}
				flattenedMap[y * (width + 1) + width] = '\n';
			}
			fileWriter.write(flattenedMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// Testing...
		char[][] mymap = {
			{'#', '#', '#', '#', '#'},
			{'#', '.', '.', '#', '#'},
			{'#', '.', '#', '.', '#'},
			{'#', '.', '.', '#', '#'},
			{'#', '.', '#', '.', '#'},
			{'#', '.', '.', '#', '#'},
			{'#', '#', '#', '#', '#'},
		};
		saveCave(mymap, "caveExamples/testmap.txt");
	}
}