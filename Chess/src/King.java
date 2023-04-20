
public class King extends Piece{
	private boolean castlingAvible = true;
	
	public King(boolean isWhite) {
		super(isWhite, "K");
	}
	
	public boolean isCastlingAvible() {
		return castlingAvible;
	}
	public void setCastlingAvible(boolean castlingAvible) {
		this.castlingAvible = castlingAvible;
	}
	
}
