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
	};
}