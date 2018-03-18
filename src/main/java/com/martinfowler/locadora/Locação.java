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
		return _filme.lerPre�o(_diasAlugados);
	}

	public int lerPontosLocadorFreq�ente() {
		if ((lerFilme().lerC�digoPre�o() == Filme.LAN�AMENTO_NOVO) && lerDiasAlugados() > 1)
			return 2;
		else
			return 1;
	}
}