
public abstract class Piece {
	private boolean isWhite = true;
	private boolean isAlive = true;
	private String representingChars;
	
	public Piece(boolean isWhite, String representingChars) {
		this.setWhite(isWhite);
		this.representingChars=representingChars;
	}
	
	public boolean isWhite() {
		return isWhite;
	}
	private void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public String getRepresentingChars() {
		return representingChars;
	}
	
}
