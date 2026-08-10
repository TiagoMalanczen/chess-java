package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;

	public ChessMatch() {
		super();
		this.board = new Board(8, 8);
		initialSetup(); 
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getLinhas()][board.getColunas()];
		
		for(int i = 0; i<board.getLinhas(); i++) {
			for(int j = 0; j<board.getColunas(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i,j);
			}
		}
		return mat;
	} 
	
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.BLACK), new Position(0, 0));
		board.placePiece(new Rook(board, Color.BLACK), new Position(7, 0));
		
		board.placePiece(new Rook(board, Color.WHITE), new Position(0, 7));
		board.placePiece(new Rook(board, Color.WHITE), new Position(7, 7));
	}
}
