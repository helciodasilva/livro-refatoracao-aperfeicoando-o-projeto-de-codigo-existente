package com.martinfowler.locadora;

class Locação {
	private Filme _filme;
	private int _diasAlugados;

	public Locação(Filme filme, int diasAlugados) {
		_filme = filme;
		_diasAlugados = diasAlugados;
	}

	public int lerDiasAlugados() {
		return _diasAlugados;
	}

	public Filme lerFilme() {
		return _filme;
	}

	double lerPreço() {
		return _filme.lerPreço(_diasAlugados);
	}

	int lerPontosLocadorFreqüente() {
		return _filme.lerPontosLocadorFreqüente(_diasAlugados);
	}
}