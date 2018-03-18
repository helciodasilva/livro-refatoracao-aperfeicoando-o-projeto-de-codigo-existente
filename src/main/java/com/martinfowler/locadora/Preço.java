package com.martinfowler.locadora;

abstract class Preço {
	abstract int lerCódigoPreço();

	abstract double lerPreço(int diasAlugados);
}