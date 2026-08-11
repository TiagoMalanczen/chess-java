package boardgame;

public class Position {

	private int coluna;
	private int linha;
	
	public Position(int linha, int coluna) {
		super();
		this.coluna = coluna;
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	@Override
	public String toString() {
		return "coluna:" + coluna + " linha: " + linha;
	}
	public void setValues(int row, int column) {
		this.linha =  row;
		this.coluna = column;
	}
	
}
