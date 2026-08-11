package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.BoardException;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPostion;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch match = new ChessMatch();
		
		while(true) {
			try {
			UI.clean();
			UI.printBoard(match.getPieces() );
			
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
			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}

}
