package com.martinfowler.locadora;

public class Filme {
	public static final int INFANTIL = 2;
	public static final int NORMAL = 0;
	public static final int LAN�AMENTO_NOVO = 1;

	private String _t�tulo;
	private int _codigoPre�o;

	public Filme(String t�tulo, int codigoPre�o) {
		_t�tulo = t�tulo;
		_codigoPre�o = codigoPre�o;
	}

	public int lerC�digoPre�o() {
		return _codigoPre�o;
	}

	public void gravarC�digoPre�o(int arg) {
		_codigoPre�o = arg;
	}

	public String lerT�tulo() {
		return _t�tulo;
	}

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