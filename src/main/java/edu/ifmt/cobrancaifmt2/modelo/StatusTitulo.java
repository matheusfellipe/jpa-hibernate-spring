package edu.ifmt.cobrancaifmt2.modelo;

public enum StatusTitulo {
	PENDENTE("Pendente"),
	RECEBIDO("Recebido");
	
	private String descricao;
	
	StatusTitulo(String descricao){
		this.descricao=descricao;
	}
	
	public String getDescrica() {
		return descricao;
	}
}
