package chess;

import boardgame.Position;

public class ChessPostion {

	private char column;
	private int row;
	
	public ChessPostion(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row >8) {
			throw new ChessException("Erro ao instaciar posicao, valores valido de a1 a h8.");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	public Position toPosition() {
	    return new Position(8 - row, column - 'a');
	}
	public static ChessPostion fromChessPosition(Position position) {
		return new ChessPostion((char)( 'a' + position.getColuna()), 8 - position.getLinha());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
}
