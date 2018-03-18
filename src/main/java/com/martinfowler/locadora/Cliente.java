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
			double estaQuantia = 0;
			Locação cada = (Locação) locações.nextElement();

			estaQuantia = quantiaDe(cada);

			//adicionar os pontos do locador freqüente
			pontosLocadorFreqüente++;
			//adicionar bônus para uma locação de lançamentos por dois dias
			if ((cada.lerFilme().lerCódigoPreço() == Filme.LANÇAMENTO_NOVO) && cada.lerDiasAlugados() > 1)
				pontosLocadorFreqüente++;

			//mostrar valores para esta locação
			resultado += "\t" + cada.lerFilme().lerTítulo() + "\t" + String.valueOf(estaQuantia) + "\n";
			quantiaTotal += estaQuantia;
		}
		//adicionar linhas de rodapé
		resultado += "O valor devido é " + String.valueOf(quantiaTotal) + "\n";
		resultado += "Você ganhou " + String.valueOf(pontosLocadorFreqüente) + " pontos de locador freqüente";
		return resultado;
	}

	private double quantiaDe(Locação umaLocação) {
		double resultado = 0;
		//determinar quantias para cada linha
		switch (umaLocação.lerFilme().lerCódigoPreço()) {
		case Filme.NORMAL:
			resultado += 2;
			if (umaLocação.lerDiasAlugados() > 2)
				resultado += (umaLocação.lerDiasAlugados() - 2) * 1.5;
			break;
		case Filme.LANÇAMENTO_NOVO:
			resultado += umaLocação.lerDiasAlugados() * 3;
			break;
		case Filme.INFANTIL:
			resultado += 1.5;
			if (umaLocação.lerDiasAlugados() > 3)
				resultado += (umaLocação.lerDiasAlugados() - 3) * 1.5;
			break;
		}
		return resultado;
	}

}