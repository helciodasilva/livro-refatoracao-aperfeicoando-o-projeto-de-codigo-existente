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
		Enumeration loca��es = _loca��es.elements();
		String resultado = "Registro de loca��o de " + lerNome() + "\n";
		while (loca��es.hasMoreElements()) {
			Loca��o cada = (Loca��o) loca��es.nextElement();
			//mostrar valores para esta loca��o
			resultado += "\t" + cada.lerFilme().lerT�tulo() + "\t" + String.valueOf(cada.lerPre�o()) + "\n";
		}

		//adicionar linhas de rodap�
		resultado += "O valor devido � " + String.valueOf(lerPre�oTotal()) + "\n";
		resultado += "Voc� ganhou " + String.valueOf(lerTotalPontosLocadorFreq�ente()) + " pontos de locador freq�ente";
		return resultado;
	}

	public String contaHtml() {
		Enumeration loca��es = _loca��es.elements();
		String resultado = "<H1>Loca��es de <EM>" + lerNome() + "</EM></H1><P>\n";
		while (loca��es.hasMoreElements()) {
			Loca��o cada = (Loca��o) loca��es.nextElement();
			//mostrar valores para cada loca��o
			resultado += cada.lerFilme().lerT�tulo() + ": " + String.valueOf(cada.lerPre�o()) + "<BR>\n";
		}
		//adicionar linhas de rodap�
		resultado += "<P>Voc� deve <EM>" + String.valueOf(lerPre�oTotal()) + "</EM><P>\n";
		resultado += "Nesta loca��o voc� ganhou <EM>" + String.valueOf(lerTotalPontosLocadorFreq�ente())
				+ "</EM> pontos de locador freq�ente<P>";
		return resultado;
	}

	private double lerPre�oTotal() {
		double resultado = 0;
		Enumeration loca��es = _loca��es.elements();
		while (loca��es.hasMoreElements()) {
			Loca��o cada = (Loca��o) loca��es.nextElement();
			resultado += cada.lerPre�o();
		}
		return resultado;
	}

	private int lerTotalPontosLocadorFreq�ente() {
		int resultado = 0;
		Enumeration loca��es = _loca��es.elements();
		while (loca��es.hasMoreElements()) {
			Loca��o cada = (Loca��o) loca��es.nextElement();
			resultado += cada.lerPontosLocadorFreq�ente();
		}
		return resultado;
	}

}