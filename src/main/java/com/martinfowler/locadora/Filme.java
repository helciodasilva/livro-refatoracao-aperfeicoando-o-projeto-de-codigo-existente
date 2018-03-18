package com.martinfowler.locadora;

public class Filme {
	public static final int INFANTIL = 2;
	public static final int NORMAL = 0;
	public static final int LANÇAMENTO_NOVO = 1;

	private String _título;
	private int _codigoPreço;

	public Filme(String título, int codigoPreço) {
		_título = título;
		_codigoPreço = codigoPreço;
	}

	public int lerCódigoPreço() {
		return _codigoPreço;
	}

	public void gravarCódigoPreço(int arg) {
		_codigoPreço = arg;
	}

	public String lerTítulo() {
		return _título;
	}

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