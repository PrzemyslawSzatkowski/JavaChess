import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	private Player[] players = new Player[2];
	private Board board;
	private boolean whiteTurn = true;
	private Player currentPlayer;
	private GameStatus gameStatus;
	private List<Move> movesPlayedList = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);
	
	Game(){
		this.players[0] = new Player(true);
		this.players[1] = new Player(!players[0].isWhiteOperator());
		this.board = new Board();
		this.setGameStatus(GameStatus.ACTIVE);
		
		if(players[0].isWhiteOperator()) {
			setCurrentPlayer(players[0]);
		}
		else {
			setCurrentPlayer(players[1]);
		}
				
		GameSequention();
	}

	public boolean isWhiteTurn() {
		return whiteTurn;
	}

	public void setWhiteTurn(boolean whiteTurn) {
		this.whiteTurn = whiteTurn;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public GameStatus getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}
	
	private void GameSequention() {
		int[] inputXY;
		
		while(gameStatus==GameStatus.ACTIVE) {
			board.writeBoard();
			if(whiteTurn==true) {
				System.out.println("White turn. ");
			}
			else {
				System.out.println("Black turn. ");
			}
			System.out.println("Type starting square");
			inputXY=promptMove();
			Square startSquare = board.getSquare(inputXY[0],inputXY[1]);
			System.out.println("Type destination square");
			inputXY=promptMove();
			Square endSquare = board.getSquare(inputXY[0],inputXY[1]);
			if(Move.canMove(board, startSquare, endSquare, whiteTurn)) {
				Move.makeMove(board, startSquare, endSquare);
				movesPlayedList.add(new Move(currentPlayer, startSquare, endSquare));
				nextTurn();
			}
			
		
		}
		
		
	}
		
	private int[] promptMove() {
		List<Character> avibleColumns = List.of('A','B','C','D','E','F','G','H');
		List<Character> avibleRows = List.of('0','1','2','3','4','5','6','7');
		String input;
		
		while(true) {
			input = scanner.next().toUpperCase();
			if(input.length()!=2 || !avibleColumns.contains(input.charAt(0)) || !avibleRows.contains(input.charAt(1))) {
				System.out.println("Ivalid square");
				continue;
			}
			return new int[] {
					avibleColumns.indexOf(input.charAt(0)),
					avibleRows.indexOf(input.charAt(1))};
		}
	}
	
	private void nextTurn() {
		whiteTurn=!whiteTurn;
	}
	
}
