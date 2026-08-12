package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	private ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "♙";
	}

	public boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getLinhas()][getBoard().getColunas()];

		Position p = new Position(0, 0);

		if (getColor() == Color.WHITE) {
			// acima 1
			p.setValues(position.getLinha() - 1, position.getColuna());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			// acima 2
			p.setValues(position.getLinha() - 2, position.getColuna());
			Position p2 = new Position(position.getLinha() - 1, position.getColuna());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)
					&& !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			// Tomar esquerda
			p.setValues(position.getLinha() - 1, position.getColuna() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			// Tomar direita
			p.setValues(position.getLinha() - 1, position.getColuna() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			// En passant
			if (position.getLinha() == 3) {
				Position left = new Position(position.getLinha(), position.getColuna() - 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left)
						&& getBoard().piece(left) == chessMatch.getEnPassant()) {
					mat[left.getLinha() - 1][left.getColuna()] = true;
				}
				Position rigth = new Position(position.getLinha(), position.getColuna() + 1);
				if (getBoard().positionExists(rigth) && isThereOpponentPiece(rigth)
						&& getBoard().piece(rigth) == chessMatch.getEnPassant()) {
					mat[rigth.getLinha() - 1][rigth.getColuna()] = true;
				}
			}
		} else {
			// Abaixo 1
			p.setValues(position.getLinha() + 1, position.getColuna());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			// Abaixo 2
			p.setValues(position.getLinha() + 2, position.getColuna());
			Position p2 = new Position(position.getLinha() + 1, position.getColuna());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)
					&& !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			// Tomar direita
			p.setValues(position.getLinha() + 1, position.getColuna() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			// Tomar esquerda
			p.setValues(position.getLinha() + 1, position.getColuna() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			// En passant
			if (position.getLinha() == 4) {
				Position left = new Position(position.getLinha(), position.getColuna() - 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left)
						&& getBoard().piece(left) == chessMatch.getEnPassant()) {
					mat[left.getLinha() + 1][left.getColuna()] = true;
				}
				Position rigth = new Position(position.getLinha(), position.getColuna() + 1);
				if (getBoard().positionExists(rigth) && isThereOpponentPiece(rigth)
						&& getBoard().piece(rigth) == chessMatch.getEnPassant()) {
					mat[rigth.getLinha() + 1][rigth.getColuna()] = true;
				}
			}
		}

		return mat;
	}
}