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
		double quantiaTotal = 0;
		int pontosLocadorFreqüente = 0;
		Enumeration locações = _locações.elements();
		String resultado = "Registro de locação de " + lerNome() + "\n";
		while (locações.hasMoreElements()) {
			Locação cada = (Locação) locações.nextElement();

			pontosLocadorFreqüente = cada.lerPontosLocadorFreqüente();

			//mostrar valores para esta locação
			resultado += "\t" + cada.lerFilme().lerTítulo() + "\t" + String.valueOf(cada.lerPreço()) + "\n";
			quantiaTotal += cada.lerPreço();
		}
		//adicionar linhas de rodapé
		resultado += "O valor devido é " + String.valueOf(quantiaTotal) + "\n";
		resultado += "Você ganhou " + String.valueOf(pontosLocadorFreqüente) + " pontos de locador freqüente";
		return resultado;
	}


}