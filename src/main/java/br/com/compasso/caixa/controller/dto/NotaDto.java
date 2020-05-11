package br.com.compasso.caixa.controller.dto;

import br.com.compasso.caixa.model.Nota;

public class NotaDto {

//	private long id;

	private int valor;

	private int quantidade;

	public NotaDto(Nota nota) {
		this.valor = nota.getValor();
		this.quantidade = nota.getQuantidade();
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
}
