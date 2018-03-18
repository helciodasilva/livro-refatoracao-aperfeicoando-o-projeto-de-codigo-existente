package com.martinfowler.locadora;

import java.util.Enumeration;
import java.util.Vector;

class Cliente {
	private String _nome;
	private Vector _loca��es = new Vector();

	public Cliente(String nome) {
		_nome = nome;
	};

	public void adicionarLoca��o(Loca��o arg) {
		_loca��es.addElement(arg);
	}

	public String lerNome() {
		return _nome;
	}

	public String conta() {
		double quantiaTotal = 0;
		int pontosLocadorFreq�ente = 0;
		Enumeration loca��es = _loca��es.elements();
		String resultado = "Registro de loca��o de " + lerNome() + "\n";
		while (loca��es.hasMoreElements()) {
			double estaQuantia = 0;
			Loca��o cada = (Loca��o) loca��es.nextElement();

			estaQuantia = cada.lerPre�o();

			//adicionar os pontos do locador freq�ente
			pontosLocadorFreq�ente++;
			//adicionar b�nus para uma loca��o de lan�amentos por dois dias
			if ((cada.lerFilme().lerC�digoPre�o() == Filme.LAN�AMENTO_NOVO) && cada.lerDiasAlugados() > 1)
				pontosLocadorFreq�ente++;

			//mostrar valores para esta loca��o
			resultado += "\t" + cada.lerFilme().lerT�tulo() + "\t" + String.valueOf(estaQuantia) + "\n";
			quantiaTotal += estaQuantia;
		}
		//adicionar linhas de rodap�
		resultado += "O valor devido � " + String.valueOf(quantiaTotal) + "\n";
		resultado += "Voc� ganhou " + String.valueOf(pontosLocadorFreq�ente) + " pontos de locador freq�ente";
		return resultado;
	}

}