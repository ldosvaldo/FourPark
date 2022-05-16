package br.com.fourpark;

public class Vaga {
	private Integer posicao;
	private Veiculos veiculo;
	private String horarioEntrada;
	private String horarioSaida;
	private Boolean disponivel;
	
	
	public Vaga() {
		this.disponivel = true;
	}
	
	public Vaga(Integer posicao) {
		this.posicao = posicao;
		this.disponivel  = true;
	}
	
	
	public String getHorarioEntrada() {
		return horarioEntrada;
	}
	
	public void setHorarioEntrada(String horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}
	
	public String getHorarioSaida() {
		return horarioSaida;
	}
	
	public void setHorarioSaida(String horarioSaida) {
		this.horarioSaida = horarioSaida;
	}
	
	public Integer getPosicao() {
		return posicao;
	}
	
	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}
	
	public Boolean getDisponivel() {
		return this.disponivel;
	}
	
	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Veiculos getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculos veiculo) {
		this.veiculo = veiculo;
	}
	
	

}
