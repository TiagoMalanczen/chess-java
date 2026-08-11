package boardgame;

public abstract class Piece {

	protected Position position;

	private Board board;

	public Piece(Board board) {
		super();
		this.board = board;
		position = null;
	}

	protected Board getBoard() {
		return board;
	}

	abstract public boolean[][] possibleMoves();

	public boolean possivelMove(Position position) {
		return possibleMoves()[position.getLinha()][position.getColuna()];
	}

	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
	return false;
	}
}
