public class Tile {
	private int posX;
	private int posY;
	private char type;
	private boolean visited = false;
	
	public Tile() {}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public boolean isVisited() {
		return this.visited;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public void setType(char type) {
		this.type = type;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public char getType() {
		return this.type;
	}
}