package com.martinfowler.locadora;

class Pre�oLan�amento extends Pre�o {
	int lerC�digoPre�o() {
		return Filme.LAN�AMENTO_NOVO;
	}

	double lerPre�o(int diasAlugados) {
		return diasAlugados * 3;
	}

	int lerPontosLocadorFreq�ente(int diasAlugados) {
		return (diasAlugados > 1) ? 2 : 1;
	}
}