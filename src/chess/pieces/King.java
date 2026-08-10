package chess.pieces;

import boardgame.Board;
import boardgame.Piece;

public class King extends Piece{

	public King(Board board) {
		super(board);
	}
	
	@Override
	public String toString() {
		return "K";
	}
}
