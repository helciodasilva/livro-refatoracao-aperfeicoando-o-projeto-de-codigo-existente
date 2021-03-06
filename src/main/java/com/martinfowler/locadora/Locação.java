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

	int lerPontosLocadorFreq�ente() {
		return _filme.lerPontosLocadorFreq�ente(_diasAlugados);
	}
}