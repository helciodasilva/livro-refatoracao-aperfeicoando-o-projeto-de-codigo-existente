package com.martinfowler.locadora;

class Loca��o {
	private Filme _filme;
	private int _diasAlugados;

	public Loca��o(Filme filme, int diasAlugados) {
		_filme = filme;
		_diasAlugados = diasAlugados;
	}

	public int lerDiasAlugados() {
		return _diasAlugados;
	}

	public Filme lerFilme() {
		return _filme;
	}

	double lerPre�o() {
		double resultado = 0;
		switch (lerFilme().lerC�digoPre�o()) {
		case Filme.NORMAL:
			resultado += 2;
			if (lerDiasAlugados() > 2)
				resultado += (lerDiasAlugados() - 2) * 1.5;
			break;
		case Filme.LAN�AMENTO_NOVO:
			resultado += lerDiasAlugados() * 3;
			break;
		case Filme.INFANTIL:
			resultado += 1.5;
			if (lerDiasAlugados() > 3)
				resultado += (lerDiasAlugados() - 3) * 1.5;
			break;
		}
		return resultado;
	}

	public int lerPontosLocadorFreq�ente() {
		if ((lerFilme().lerC�digoPre�o() == Filme.LAN�AMENTO_NOVO) && lerDiasAlugados() > 1)
			return 2;
		else
			return 1;
	}
}