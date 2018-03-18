package com.martinfowler.locadora;

abstract class Pre�o {
	abstract int lerC�digoPre�o();

	double lerPre�o(int diasAlugados) {
		double resultado = 0;
		switch (lerC�digoPre�o()) {
		case Filme.NORMAL:
			resultado += 2;
			if (diasAlugados > 2)
				resultado += (diasAlugados - 2) * 1.5;
			break;
		case Filme.LAN�AMENTO_NOVO:
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