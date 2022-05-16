package br.com.fourpark;

public class Aplicacao {
	public static void main(String[] args) {
		Vaga[] vaga = new Vaga[50];
		Menu menu = new Menu(vaga);
		menu.menuPrincipal();
	}
}
