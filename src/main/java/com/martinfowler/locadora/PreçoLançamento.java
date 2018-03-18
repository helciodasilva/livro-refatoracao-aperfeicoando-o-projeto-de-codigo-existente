package com.martinfowler.locadora;

class PreçoLançamento extends Preço {
	int lerCódigoPreço() {
		return Filme.LANÇAMENTO_NOVO;
	}
}