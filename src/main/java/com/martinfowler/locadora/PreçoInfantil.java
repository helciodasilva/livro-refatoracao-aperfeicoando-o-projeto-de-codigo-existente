package com.martinfowler.locadora;

class PreçoInfantil extends Preço {
	int lerCódigoPreço() {
		return Filme.INFANTIL;
	}

	double lerPreço(int diasAlugados) {
		double resultado = 1.5;
		if (diasAlugados > 3)
			resultado += (diasAlugados - 3) * 1.5;
		return resultado;
	}
}