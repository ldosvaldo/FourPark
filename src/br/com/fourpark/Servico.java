package br.com.fourpark;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Servico {
	
	private static Double faturamento = 0.00;
	private static Double valorHora = 5.00;
	private static ArrayList<String> logVeiculo = new ArrayList<String>();

	
	public static Double getValorHora() {
	return Servico.valorHora;
	}
	
	public static void setValorHora(Double novoValor) {
		Servico.valorHora = novoValor;
	}

	public Double getFaturamento() {
		return Servico.faturamento;
	}
	
	public static void addLogVeiculo(Vaga vaga) {
		String retorno;
		retorno = vaga.getVeiculo() 
				+ " hora de entreda: " 
				+ vaga.getHorarioEntrada() 
				+ "\n hora de saída: " 
				+ vaga.getHorarioSaida();
		
		Servico.logVeiculo.add(retorno);
	}
	
	public static ArrayList<String> getLogVeiculo() {
		return Servico.logVeiculo;
	}
	
	public ArrayList<String> exibirLogVeiculo() {
		return Servico.getLogVeiculo();
	}
	
	public static Double calcularValorPagar(String horarioEntrada, String horarioSaida) {	
		Double horasEntrada = Double.parseDouble(horarioEntrada.replace(':','.'));
		Double horasSaida =  Double.parseDouble(horarioSaida.replace(':','.'));
		Double horas = (horasSaida - horasEntrada);
		horas -= ((horasSaida%1) - (horasEntrada%1));
		horas += ((horasSaida%1) - (horasEntrada%1))/0.6;
		horas = Math.round(horas*100.0)/100.0;
		
		Double faturadoPorHora = horas * (Servico.getValorHora());
		Servico.faturamento += faturadoPorHora;
		return faturadoPorHora;
	}

	public String listarVagasDisponiveis(Vaga[] vaga) {
		String retorno = "";
		for (Vaga vagas:vaga) {
			if(vagas.getDisponivel()) {
			retorno = retorno +	" vaga " + vagas.getPosicao() + " disponivel!	\n";				
			} 
		}
		return retorno;
	}

	public String listarVagasOcupadas(Vaga[] vaga) {
		String retorno = "";
		for (Vaga vagas:vaga) {
			if(!vagas.getDisponivel()) {
			retorno = retorno +	" vaga " + vagas.getPosicao() + " ocupada! \n";
			retorno += vagas.getVeiculo().toString();
			} 
		}
		return retorno;
	}

	public boolean validarVaga(Integer posicaoVaga) {
		if(posicaoVaga < 1 || posicaoVaga > 50) {
			return  false;
		}
		return true;
	}
	
	public boolean verificarVagaOcupada(Vaga vaga) {
		boolean resposta = vaga.getDisponivel();
		return resposta;
	}

	public String popularVaga( Vaga vaga, Veiculos veiculo, String horaentrada) {
		vaga.setVeiculo(veiculo);
		vaga.setHorarioEntrada(horaentrada);
		vaga.setDisponivel(false);
		String retorno =  "======================="
				+ "\n Carro inserido na vaga com sucesso!"
				+ "\n=======================";

		return retorno;
	}

	public String desocuparPorVaga(String saida, Vaga vaga) {
		String retorno = "Vaga desocupada com sucesso\n "
				+ "Valor a pagar: R$";
		vaga.setDisponivel(true);
		vaga.setHorarioSaida(saida);
		Servico.addLogVeiculo(vaga);
		retorno += Servico.calcularValorPagar(vaga.getHorarioEntrada(), vaga.getHorarioSaida());
		return retorno;
	}

	public boolean desocuparPorPlaca(String placa, String saida, Vaga[] vaga) {
		Boolean retorno = false;
		for (Vaga vagas:vaga) {
			if(!this.verificarVagaOcupada(vagas)) {
				if((vagas.getVeiculo().getPlaca()).equals(placa)) {
					this.desocuparPorVaga(saida, vaga[vagas.getPosicao()-1]);
					retorno = true;
				}
			}
		}
		return retorno;
	}

	public void modificaValorHora(Double valorHora2) {
		Servico.setValorHora(valorHora2);
	}

}
