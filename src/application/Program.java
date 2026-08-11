package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPostion;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch match = new ChessMatch();
		
		while(true) {
			UI.printBoard(match.getPieces() );
			
			System.out.println();
			
			System.out.println("Print source");
			ChessPostion source = UI.readChessPostion(sc);
			
			System.out.println();
			
			System.out.println("Print target");
			ChessPostion target = UI.readChessPostion(sc);
			
			ChessPiece capturePiece = match.performChessMove(source, target);
		
		}
	}

}
