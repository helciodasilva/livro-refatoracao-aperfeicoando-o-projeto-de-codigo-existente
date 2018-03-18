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

	public String contaHtml() {
		Enumeration locações = _locações.elements();
		String resultado = "<H1>Locações de <EM>" + lerNome() + "</EM></H1><P>\n";
		while (locações.hasMoreElements()) {
			Locação cada = (Locação) locações.nextElement();
			//mostrar valores para cada locação
			resultado += cada.lerFilme().lerTítulo() + ": " + String.valueOf(cada.lerPreço()) + "<BR>\n";
		}
		//adicionar linhas de rodapé
		resultado += "<P>Você deve <EM>" + String.valueOf(lerPreçoTotal()) + "</EM><P>\n";
		resultado += "Nesta locação você ganhou <EM>" + String.valueOf(lerTotalPontosLocadorFreqüente())
				+ "</EM> pontos de locador freqüente<P>";
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