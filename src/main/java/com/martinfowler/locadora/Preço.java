package com.martinfowler.locadora;

abstract class Pre�o {
	abstract int lerC�digoPre�o();

	abstract double lerPre�o(int diasAlugados);

	int lerPontosLocadorFreq�ente(int diasAlugados) {
		if ((lerC�digoPre�o() == Filme.LAN�AMENTO_NOVO) && (diasAlugados > 1))
			return 2;
		else
			return 1;
	}
}