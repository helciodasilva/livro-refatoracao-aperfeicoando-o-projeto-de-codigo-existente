package com.martinfowler.locadora;

public class Filme {
	public static final int INFANTIL = 2;
	public static final int NORMAL = 0;
	public static final int LANÇAMENTO_NOVO = 1;

	private String _título;
	private Preço _preço;

	public Filme(String título, int codigoPreço) {
		_título = título;
		gravarCódigoPreço(codigoPreço);
	}

	public int lerCódigoPreço() {
		return _preço.lerCódigoPreço();
	}

	public void gravarCódigoPreço(int arg) {
		switch (arg) {
		case NORMAL:
			_preço = new PreçoNormal();
			break;
		case INFANTIL:
			_preço = new PreçoInfantil();
			break;
		case LANÇAMENTO_NOVO:
			_preço = new PreçoLançamento();
			break;
		default:
			throw new IllegalArgumentException("Código de Preço Incorreto");
		}
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

	int lerPontosLocadorFreqüente(int diasAlugados) {
		if ((lerCódigoPreço() == Filme.LANÇAMENTO_NOVO) && diasAlugados > 1)
			return 2;
		else
			return 1;
	}
}