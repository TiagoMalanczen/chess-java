package boardgame;

public class Board {

	private int linhas;
	private int colunas;
	private Piece [][] pieces;
	
	public Board(int linhas, int colunas) {
		if(linhas < 1 || colunas < 1) {
			throw new BoardException("Erro na cricao do tabuleiro, é necessário conter ao menos 1 linha/coluna");
		}
		
		this.linhas = linhas;
		this.colunas = colunas;
		pieces = new Piece[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}
	public int getColunas() {
		return colunas;
	}
	
	public Piece piece(int linha, int coluna) {
		if(!positionExists(linha, coluna)) {
			throw new BoardException("Posicao nao encontrada");
		}
		return pieces[linha][coluna];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posicao nao encontrada");
		}
		return pieces[position.getLinha()][position.getColuna()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Ja existe uma peca na posicao " + position);
		}
		pieces[position.getLinha()][position.getColuna()] = piece;
		piece.position = position; 
	}
	
	//Verifica posicao existente
	private boolean positionExists(int row, int column){
		return row >= 0 && row < linhas && column >=0 && column < colunas;
	}
	public boolean positionExists(Position position) {
		return positionExists(position.getLinha(), position.getColuna());
	}
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posicao nao encontrada");
		}
		return piece(position) != null;
	}
}
