public class Move {
	private Player player;
	private Square startSquare;
	private Square endSquare;
	private Piece pieceMoved;
	private Piece pieceKilled;
	private boolean specialMove = false;
	
	public Move(Player player, Square start, Square end) {
		this.player = player;
		this.startSquare = start;
		this.endSquare = end;
		this.pieceMoved = start.getPiece();
	}
	
	
	public static void makeMove(Board board, Square start, Square end) {
		if(start.getPiece() instanceof Pawn) {
			Pawn pawn = (Pawn) start.getPiece();
			pawn.setDoubledMoveAvible(false);
		}
		end.setPiece(start.getPiece());
		start.setPiece(null);
	}
	
	public static boolean canMove(Board board, Square start, Square end, boolean whiteTurn) {
		Piece startPiece = start.getPiece();
		Piece endPiece = end.getPiece();
		
		//System.out.println(startPiece+" "+endPiece);
		if(startPiece==null) {
			System.out.println("Thats not piece");
			return false;
		}
		if(endPiece==null) {
			
		}
		else if(startPiece.isWhite() == endPiece.isWhite()) {
			System.out.println("COLOR CONFLICT!");
			return false;
		}
		
		if (startPiece.isWhite()!=whiteTurn) {
			System.out.println("Thats not your piece");
			return false;
		}
		
		if(start==end) {
			System.out.println("THAT'S THE SAME POSITION!");
			return false;
		}
		
		if(startPiece instanceof Pawn) {
			if(!canMovePawn(board, start, end)) {
				return false;
			};
		}
		else if(startPiece instanceof Rook) {
			if(!canMoveRook(board, start, end)) {
				return false;
			};
		}
		else if(startPiece instanceof Knight) {
			if(!canMoveKnight(board, start, end)) {
				System.out.println("Koniem jedziesz debilu");
				return false;
			};
		}
		else if(startPiece instanceof Bishop) {
			if(!canMoveBishop(board, start, end)) {
				return false;
			};
		}
		else if(startPiece instanceof King) {
			if(!canMoveKing(board, start, end)) {
				return false;
			};
		}
		else if(startPiece instanceof Queen) {
			if(!canMoveQueen(board, start, end)) {
				return false;
			};
		}
		
		return true;
	}
	
	private static boolean canMovePawn(Board board, Square start, Square end) {
		int deltaX = Math.abs(start.getX() - end.getX());
		int deltaY = Math.abs(start.getY() - end.getY());
		Pawn pawn = (Pawn) start.getPiece();
		
		if(!pawn.isDoubledMoveAvible() && deltaY>1) {
			System.out.println("Doubled move isnt avible"+pawn.isDoubledMoveAvible());
			return false;
		}
		else if(deltaX>0 && (deltaX!=1 && deltaY!=1 && end.getPiece()!=null)) {
			System.out.println("Invalid move!3  "+deltaX+" "+deltaY);
			return false;
		}
		else if(deltaY>2) {
			System.out.println("Invalid move!4");
			return false;
		}
		else if((start.getPiece().isWhite() && (start.getY() - end.getY())>0) || (!start.getPiece().isWhite() && (start.getY() - end.getY())<0)) {
			System.out.println("Wrong way man");
			return false;
		}
		
		return true;
	}
	
	private static boolean canMoveRook(Board board, Square start, Square end) {
		int deltaX = Math.abs(start.getX() - end.getX());
		int deltaY = Math.abs(start.getY() - end.getY());
		
		if((deltaX>0 && deltaY!=0) || (deltaX!=0 && deltaY>0)) {
			return false;
		}
		
		for(int i=1; i<Math.max(deltaY, deltaX); i++) {
			if(deltaX>0) {
				if(board.getSquare(start.getX()+i, start.getY()).getPiece()!=null) {
					System.out.println("Other piece in the way");
					return false;
				}
			}
			if(deltaY>0) {
				if(board.getSquare(start.getX(), start.getY()+i).getPiece()!=null) {
					System.out.println("Other piece in the way"+board.getSquare(start.getX(), start.getY()+i).getPiece());
					return false;
				}
			}
		}
		
		return true;
	}
	
	private static boolean canMoveKnight(Board board, Square start, Square end) {
		int deltaX = Math.abs(start.getX() - end.getX());
		int deltaY = Math.abs(start.getY() - end.getY());
		
		if(deltaX*deltaY!=2) {
			return false;
		}
		
		return true;
	}
	
	private static boolean canMoveBishop(Board board, Square start, Square end) {
		int deltaX = Math.abs(start.getX() - end.getX());
		int deltaY = Math.abs(start.getY() - end.getY());
		
		if(deltaX!=deltaY) {
			return false;
		}
		
		int wayOfX = end.getX() - start.getX()>0 ? 1 : -1;
		int wayOfY = end.getY() - start.getY()>0 ? 1 : -1;
		
		for(int i=1; i<Math.max(deltaY, deltaX); i++) {
			if(board.getSquare(Math.abs(start.getX()+(i*wayOfX)), Math.abs(start.getY()+(i*wayOfY))).getPiece()!=null) {
				System.out.println("Other piece in the way"+
			board.getSquare(Math.abs(start.getX()+(i*wayOfX)), Math.abs(start.getY()+(i*wayOfY))).getPiece()+
			" "+
			board.getSquare(Math.abs(start.getX()+(i*wayOfX)), Math.abs(start.getY()+(i*wayOfY))).getX()+" "+
			board.getSquare(Math.abs(start.getX()+(i*wayOfX)), Math.abs(start.getY()+(i*wayOfY))).getY()
			+" "+wayOfX+" "+wayOfY);
				return false;
			}
		}
		
		return true;
	}
		
	private static boolean canMoveKing(Board board, Square start, Square end) {
		int deltaX = Math.abs(start.getX() - end.getX());
		int deltaY = Math.abs(start.getY() - end.getY());
		
		if(deltaX>1 || deltaY>1) {
			return false;
		}
		
		return true;
	}
	
	private static boolean canMoveQueen(Board board, Square start, Square end) {
		if(!canMoveRook(board, start, end) && !canMoveBishop(board, start, end)) {
			System.out.println("Error1");
			return false;
		}
		
		return true;
	}
		
}
