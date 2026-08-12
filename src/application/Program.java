package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPostion;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch match = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();

		while (!match.getCheckMate()) {
			try {
				UI.clean();
				UI.printMatch(match, captured);

				System.out.println();

				System.out.println("Print source");
				ChessPostion source = UI.readChessPostion(sc);

				boolean[][] possivelMoves = match.possivelMoves(source);
				UI.clean();
				UI.printBoard(match.getPieces(), possivelMoves);

				System.out.println();

				System.out.println("Print target");
				ChessPostion target = UI.readChessPostion(sc);

				ChessPiece capturePiece = match.performChessMove(source, target);

				if (capturePiece != null) {
					captured.add(capturePiece);
				}
				
				if(match.getPromoved() != null) {
					System.out.println("Digite a peca que deseja promover (B/Q/T/R)");
					String type = sc.nextLine().toUpperCase();
					while (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
						System.out.println("Valor invalido, digite novamente");
						type = sc.nextLine().toUpperCase();
					}
					match.replacePromoterPiece(type);
				}

			} catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clean();
		UI.printMatch(match, captured);
	}

}
