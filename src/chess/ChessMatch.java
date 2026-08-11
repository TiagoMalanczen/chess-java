package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;
	private int turn;
	private Color currentPlayer;

	public ChessMatch() {
		super();
		turn = 1;
		currentPlayer = Color.WHITE;
		this.board = new Board(8, 8);
		initialSetup();
	}
	public Board getBoard() {
		return board;
	}
	public int getTurn() {
		return turn;
	}
	public Color getCurrentPlayer() {
		return currentPlayer;
	}


	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getLinhas()][board.getColunas()];

		for (int i = 0; i < board.getLinhas(); i++) {
			for (int j = 0; j < board.getColunas(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}

	public boolean[][] possivelMoves(ChessPostion sourcePosition){
		Position position = sourcePosition.toPosition();
		validadeSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	public ChessPiece performChessMove(ChessPostion sourcePosition, ChessPostion targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validadeSourcePosition(source);
		validadeTargetPosition(source,target);
		Piece capturedPiece = makeMove(source, target);
		nextTurn();
		return (ChessPiece) capturedPiece;
	}
	
	public void validadeSourcePosition(Position position) {
		if(!board.thereIsAPiece(position)) {
			throw new ChessException("Nao existe peça na posição de origem");
		}
		if(currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
			throw new ChessException("Nao é a sua vez de jogar");
		}
		if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("Nao existe movimentos possiveis para peca");
		}
	}
	
	public void validadeTargetPosition(Position source, Position target) {
		if(!board.piece(source).possivelMove(target)) {
			throw new ChessException("A peca escolhida nao pode se mover para possicao de destino");
		}
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece	= board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece; 
	}
	private void nextTurn() {
		turn ++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPostion(column, row).toPosition());
	}

	private void initialSetup() {
		placeNewPiece('e', 1, new Rook(board, Color.WHITE));
		placeNewPiece('e', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 5, new King(board, Color.BLACK));
	}
	
	
}
