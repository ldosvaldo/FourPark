package br.com.fourpark;

public class Veiculos {
	private Proprietario propetario;
	private String placa;
	private String modelo;
	private String tipo;
	
	
	public Veiculos(String placa, String modelo, String tipo, Proprietario p1) {
		this.placa = placa;
		this.modelo = modelo;
		this.tipo = tipo;
		this.propetario = p1;
		
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Proprietario getPropetario() {
		return propetario;
	}
	public void setPropetario(Proprietario propetario) {
		this.propetario = propetario;
	}
	
	@Override
	public String toString() {
		return "Proprietario: " + this.propetario.getNome() + "\n Placa: " + this.getPlaca()
		+ "\n Modelo: " + this.getModelo() + "\n Tipo: " + this.getTipo() + "\n";
	}

}
