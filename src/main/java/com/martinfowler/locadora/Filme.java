package com.martinfowler.locadora;

public class Filme {
	public static final int INFANTIL = 2;
	public static final int NORMAL = 0;
	public static final int LAN�AMENTO_NOVO = 1;

	private String _t�tulo;
	private Pre�o _pre�o;

	public Filme(String t�tulo, int codigoPre�o) {
		_t�tulo = t�tulo;
		gravarC�digoPre�o(codigoPre�o);
	}

	public int lerC�digoPre�o() {
		return _pre�o.lerC�digoPre�o();
	}

	public void gravarC�digoPre�o(int arg) {
		switch (arg) {
		case NORMAL:
			_pre�o = new Pre�oNormal();
			break;
		case INFANTIL:
			_pre�o = new Pre�oInfantil();
			break;
		case LAN�AMENTO_NOVO:
			_pre�o = new Pre�oLan�amento();
			break;
		default:
			throw new IllegalArgumentException("C�digo de Pre�o Incorreto");
		}
	}

	public String lerT�tulo() {
		return _t�tulo;
	}

	double lerPre�o(int diasAlugados) {
		return _pre�o.lerPre�o(diasAlugados);
	}

	int lerPontosLocadorFreq�ente(int diasAlugados) {
		if ((lerC�digoPre�o() == Filme.LAN�AMENTO_NOVO) && diasAlugados > 1)
			return 2;
		else
			return 1;
	}
}