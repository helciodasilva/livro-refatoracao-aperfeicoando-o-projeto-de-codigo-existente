package com.martinfowler.locadora;

abstract class Pre�o {
	abstract int lerC�digoPre�o();

	abstract double lerPre�o(int diasAlugados);

	int lerPontosLocadorFreq�ente(int diasAlugados) {
		return 1;
	}
}