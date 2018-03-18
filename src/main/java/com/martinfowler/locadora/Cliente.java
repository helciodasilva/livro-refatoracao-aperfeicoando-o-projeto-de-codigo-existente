package com.martinfowler.locadora;

import java.util.Enumeration;
import java.util.Vector;

class Cliente {
	private String _nome;
	private Vector _locações = new Vector();

	public Cliente(String nome) {
		_nome = nome;
	};

	public void adicionarLocação(Locação arg) {
		_locações.addElement(arg);
	}

	public String lerNome() {
		return _nome;
	}

	public String conta() {
		Enumeration locações = _locações.elements();
		String resultado = "Registro de locação de " + lerNome() + "\n";
		while (locações.hasMoreElements()) {
			Locação cada = (Locação) locações.nextElement();
			//mostrar valores para esta locação
			resultado += "\t" + cada.lerFilme().lerTítulo() + "\t" + String.valueOf(cada.lerPreço()) + "\n";
		}

		//adicionar linhas de rodapé
		resultado += "O valor devido é " + String.valueOf(lerPreçoTotal()) + "\n";
		resultado += "Você ganhou " + String.valueOf(lerTotalPontosLocadorFreqüente()) + " pontos de locador freqüente";
		return resultado;
	}

	private double lerPreçoTotal() {
		double resultado = 0;
		Enumeration locações = _locações.elements();
		while (locações.hasMoreElements()) {
			Locação cada = (Locação) locações.nextElement();
			resultado += cada.lerPreço();
		}
		return resultado;
	}

	private int lerTotalPontosLocadorFreqüente() {
		int resultado = 0;
		Enumeration locações = _locações.elements();
		while (locações.hasMoreElements()) {
			Locação cada = (Locação) locações.nextElement();
			resultado += cada.lerPontosLocadorFreqüente();
		}
		return resultado;
	}

}