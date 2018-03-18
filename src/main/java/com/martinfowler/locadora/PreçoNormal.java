package com.martinfowler.locadora;

class Pre�oNormal extends Pre�o {
	int lerC�digoPre�o() {
		return Filme.NORMAL;
	}

	double lerPre�o(int diasAlugados) {
		double resultado = 2;
		if (diasAlugados > 2)
			resultado += (diasAlugados - 2) * 1.5;
		return resultado;
	}
}