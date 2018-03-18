package com.martinfowler.locadora;

abstract class Preço {
	abstract int lerCódigoPreço();

	abstract double lerPreço(int diasAlugados);

	int lerPontosLocadorFreqüente(int diasAlugados) {
		if ((lerCódigoPreço() == Filme.LANÇAMENTO_NOVO) && (diasAlugados > 1))
			return 2;
		else
			return 1;
	}
}