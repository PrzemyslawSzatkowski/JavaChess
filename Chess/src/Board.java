
public class Board {
	private Square[][] board = new Square[8][8];
	
	public Board() {
		this.resetBoard();
	}
	
	private void resetBoard() {
		int x=0;
		int y=0;
		board[x][y] = new Square(x++, y, new Rook(true));
		board[x][y] = new Square(x++, y, new Knight(true));
		board[x][y] = new Square(x++, y, new Bishop(true));
		board[x][y] = new Square(x++, y, new Queen(true));
		board[x][y] = new Square(x++, y, new King(true));
		board[x][y] = new Square(x++, y, new Bishop(true));
		board[x][y] = new Square(x++, y, new Knight(true));
		board[x][y] = new Square(x++, y, new Rook(true));
		x=0; y++;
		board[x][y] = new Square(x++, y, new Pawn(true));
		board[x][y] = new Square(x++, y, new Pawn(true));
		board[x][y] = new Square(x++, y, new Pawn(true));
		board[x][y] = new Square(x++, y, new Pawn(true));
		board[x][y] = new Square(x++, y, new Pawn(true));
		board[x][y] = new Square(x++, y, new Pawn(true));
		board[x][y] = new Square(x++, y, new Pawn(true));
		board[x][y] = new Square(x++, y, new Pawn(true));
		x=0; y++;
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		x=0; y++;
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		x=0; y++;
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		x=0; y++;
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		board[x][y] = new Square(x++, y, null);
		x=0; y++;
		board[x][y] = new Square(x++, y, new Pawn(false));
		board[x][y] = new Square(x++, y, new Pawn(false));
		board[x][y] = new Square(x++, y, new Pawn(false));
		board[x][y] = new Square(x++, y, new Pawn(false));
		board[x][y] = new Square(x++, y, new Pawn(false));
		board[x][y] = new Square(x++, y, new Pawn(false));
		board[x][y] = new Square(x++, y, new Pawn(false));
		board[x][y] = new Square(x++, y, new Pawn(false));
		x=0; y++;
		board[x][y] = new Square(x++, y, new Rook(false));
		board[x][y] = new Square(x++, y, new Knight(false));
		board[x][y] = new Square(x++, y, new Bishop(false));
		board[x][y] = new Square(x++, y, new Queen(false));
		board[x][y] = new Square(x++, y, new King(false));
		board[x][y] = new Square(x++, y, new Bishop(false));
		board[x][y] = new Square(x++, y, new Knight(false));
		board[x][y] = new Square(x++, y, new Rook(false));
	}
	
	public Square getSquare(int x, int y) {
		return this.board[x][y];
	}

	public void writeBoard() {
		for(int y=7; y>=0; y--) {
			System.out.print(" "+y+" ");
			for(int x=0; x<8; x++) {
				if(board[x][y].getPiece() == null) {
					System.out.print("---");
				}
				else if(board[x][y].getPiece().isWhite()) {
				System.out.print("("+board[x][y].getPiece().getRepresentingChars()+")");
				}
				else {
					System.out.print("["+board[x][y].getPiece().getRepresentingChars()+"]");
				}
			}
			System.out.print(System.lineSeparator());
		}
		System.out.println("    A  B  C  D  E  F  G  H ");
	}
	
}
