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
		double resultado = 0;
		switch (lerFilme().lerCódigoPreço()) {
		case Filme.NORMAL:
			resultado += 2;
			if (lerDiasAlugados() > 2)
				resultado += (lerDiasAlugados() - 2) * 1.5;
			break;
		case Filme.LANÇAMENTO_NOVO:
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

	public int lerPontosLocadorFreqüente() {
		if ((lerFilme().lerCódigoPreço() == Filme.LANÇAMENTO_NOVO) && lerDiasAlugados() > 1)
			return 2;
		else
			return 1;
	}
}