package com.martinfowler.locadora;

abstract class Preço {
	abstract int lerCódigoPreço();

	double lerPreço(int diasAlugados) {
		double resultado = 0;
		switch (lerCódigoPreço()) {
		case Filme.NORMAL:
			resultado += 2;
			if (diasAlugados > 2)
				resultado += (diasAlugados - 2) * 1.5;
			break;
		case Filme.LANÇAMENTO_NOVO:
			resultado += diasAlugados * 3;
			break;
		case Filme.INFANTIL:
			resultado += 1.5;
			if (diasAlugados > 3)
				resultado += (diasAlugados - 3) * 1.5;
			break;
		}
		return resultado;
	}
}