package com.martinfowler.locadora;

class Pre�oInfantil extends Pre�o {
	int lerC�digoPre�o() {
		return Filme.INFANTIL;
	}

	double lerPre�o(int diasAlugados) {
		double resultado = 1.5;
		if (diasAlugados > 3)
			resultado += (diasAlugados - 3) * 1.5;
		return resultado;
	}
}