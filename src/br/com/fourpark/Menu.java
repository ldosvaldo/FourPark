package br.com.fourpark;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {
	static Scanner scanner = new Scanner(System.in);
	static SimpleDateFormat horaFormatada = new SimpleDateFormat("HH:mm");
	static Vaga[] vaga;
	static Servico servicos = new Servico();
	

	public Menu(Vaga[] vaga) {
		for(int i = 1; i <= 50; i++) {
			vaga[i-1] = new Vaga(i);
		}
		Menu.vaga = vaga;
	}

	public void menuPrincipal() {
		
		
		int opcao = -1;
		
		while(opcao != 0) {
			System.out.println("\n\n==================================");
			System.out.println("==========FOURPARK==============||");
			System.out.println("1 - Verificar vagas disponíveis ||");
			System.out.println("2 - Verificar vagas ocupadas    ||");
			System.out.println("3 - Registrar Entrada           ||");
			System.out.println("4 - Registrar Saída             ||");
			System.out.println("5 - Histórico de serviços       ||");
			System.out.println("6 - Valor recebido durante o dia||");
			System.out.println("7 - Modificar valor/hora        ||");
			System.out.println("0 - Sair do sistema             ||");
			System.out.println("================================||");
			System.out.println("==================================");
			System.out.print("Insira uma opção: ");
			opcao = scanner.nextInt();
			System.out.println("----------------------------------\n");


			switch(opcao) {
				case 0:
					System.out.println("\nSistema encerrado");
					break;
				case 1:
					System.out.println(servicos.listarVagasDisponiveis(vaga));
					break;
				case 2:
					System.out.println(servicos.listarVagasOcupadas(vaga));
					break;
				case 3:
					this.menuRegistrarEntrada();
					break;
				case 4:
					this.menuRegistrarSaida();
					break;
				case 5:
					System.out.println(servicos.exibirLogVeiculo()); 
					break;
				case 6:
					System.out.println(servicos.getFaturamento()); 
					break;
				case 7:
					System.out.println("Qual o novo valor/hora do estacionamento? Exemplo: x,xx");
					Double valorHora = scanner.nextDouble();
					servicos.modificaValorHora(valorHora);
					System.out.println("Valor da hora modificado com sucesso"); 
					break;
				default:
					System.out.println("\nOpção inválida. Tente novamente.\n");
			}
		}
	}

	public void menuRegistrarEntrada() {
		String placa;
		 String modelo;
		 String marca;
		 String nomeProprietario;
		 String documentoProprietario;
		 String contatoProprietario;
		 String horaEntrada = null;
		 Integer posicaoVaga;
		 
		 System.out.print("Placa do veículo: ");
		 placa = scanner.next();
		
		 System.out.print("Modelo do veículo: ");
		 modelo = scanner.next();
		
		 System.out.print("Marca do veículo: ");
		 marca = scanner.next();
		
		 System.out.print("Nome do proprietario: ");
		 nomeProprietario = scanner.next();
		 
		 System.out.print("Documento do proprietario: ");
		 documentoProprietario = scanner.next();
		 
		 System.out.print("Contato do proprietario: ");
		 contatoProprietario = scanner.next();
		 
		 System.out.println("Horário de entrada. Utilize o formato hh:mm");
		 horaEntrada = scanner.next();
				 
		 Proprietario proprietario = new Proprietario (nomeProprietario, documentoProprietario, contatoProprietario);
		 Veiculos veiculo = new Veiculos(placa, modelo, marca, proprietario);
			
		 while(true) {
			 System.out.print("Selecione a vaga:");
			 posicaoVaga = scanner.nextInt();
			 if(servicos.validarVaga(posicaoVaga) && servicos.verificarVagaOcupada(vaga[posicaoVaga-1])) {
				 	
					String retorno = servicos.popularVaga(vaga[posicaoVaga-1], veiculo, horaEntrada);
					System.out.println(retorno);
					
					break;
				}
				else {
					 System.out.println("nao possivel utilizar a vaga selecionada;");
				}
	 	}
	}
	
	public void menuRegistrarSaida() {
		int opcao = -1;
		
		while(opcao != 0) {
			System.out.println("==========================================");
			System.out.println("1 - Registrar saída pelo número da vaga   ||");
			System.out.println("2 - Registrar saída pela placa do veículo ||");
			System.out.println("0 - Voltar ao menu anterior               ||");
			System.out.println("==========================================");
			System.out.print("Insira uma opção: ");
			opcao = scanner.nextInt();
			System.out.println("----------------------------------\n\n");
			
			switch(opcao) {
				case 1:
					menuRegistrarSaidaPorVaga();
					break;
				case 2:
					menuRegistrarSaidaPorPlaca();

					break;
				default:
					if(opcao != 0) {
						System.out.println("\nOpção inválida. Tente novamente.\n");
					}
			}	
		}
	}


	public void menuRegistrarSaidaPorVaga() {
		Integer posicaoVaga;

		 while(true) {
			 System.out.println("Selecione a vaga a ser desocupada ou 0 "
			 					+ "para retornar ao menu anterior:");
			 posicaoVaga = scanner.nextInt();
			 
			 if(servicos.validarVaga(posicaoVaga) && !servicos.verificarVagaOcupada(vaga[posicaoVaga-1])) {
					System.out.println("Insira o horário de saida");
					String saida = scanner.next();
					System.out.println(servicos.desocuparPorVaga( saida, vaga[posicaoVaga-1]));
				} else {
					 System.out.println("nao possivel utilizar a vaga selecionada;");
				}
				break;
		 }
	}
	
	public void menuRegistrarSaidaPorPlaca() {
		String placa;
		String horarioSaida = null;
		
		System.out.println("Horário de saída. Utilize o formato hh:mm");
		horarioSaida = scanner.next();

		while(true) {
			System.out.println("Selecione a placa do veículo para registrar a "
			 					+ "saída ou 0 para retornar ao menu anterior:");
			placa = scanner.next();
			if(placa.equals("0")) {
				break;
			}
			if(servicos.desocuparPorPlaca(placa, horarioSaida, vaga)) {
				break;
			} else {
					System.out.println("Placa não encontrada, tente novamente");
			}
		 }
	}
}
