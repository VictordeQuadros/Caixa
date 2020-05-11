package br.com.compasso.caixa.model;

public class Nota {

//	private long id;

	private int valor;

	private int quantidade;

	public Nota(int valor) {
		this.valor = valor;
	}
	
	public Nota(int valor, int quantidade) {
		this.valor = valor;
		this.quantidade = quantidade;
	}

//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Nota [valor=" + valor + ", quantidade=" + quantidade + "]";
	}
	
	
}
