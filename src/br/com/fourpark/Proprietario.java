package br.com.fourpark;

public class Proprietario {
	private String nome;
	private String documento;
	private String telefone;
	
	public Proprietario(String nome, String documento, String telefone) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
		this.documento = documento;
		this.telefone = telefone;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
