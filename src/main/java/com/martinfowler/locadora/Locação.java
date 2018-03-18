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

	public int lerPontosLocadorFreqüente() {
		if ((lerFilme().lerCódigoPreço() == Filme.LANÇAMENTO_NOVO) && lerDiasAlugados() > 1)
			return 2;
		else
			return 1;
	}
}