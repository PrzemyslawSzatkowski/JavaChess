
public class Pawn extends Piece{
	private boolean doubledMoveAvible = true;
	
	public Pawn(boolean isWhite) {
		super(isWhite, "P");
	}

	public boolean isDoubledMoveAvible() {
		return doubledMoveAvible;
	}

	public void setDoubledMoveAvible(boolean doubledMoveAvible) {
		this.doubledMoveAvible = doubledMoveAvible;
	}
	
}
