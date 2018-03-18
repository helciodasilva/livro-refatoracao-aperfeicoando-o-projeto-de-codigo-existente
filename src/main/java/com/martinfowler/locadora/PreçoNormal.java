package com.martinfowler.locadora;

class PreçoNormal extends Preço {
	int lerCódigoPreço() {
		return Filme.NORMAL;
	}

	double lerPreço(int diasAlugados) {
		double resultado = 2;
		if (diasAlugados > 2)
			resultado += (diasAlugados - 2) * 1.5;
		return resultado;
	}
}