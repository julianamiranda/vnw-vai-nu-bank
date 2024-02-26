package br.com.vainaweb;

public interface OperacaoBancaria {

	public void sacar(double valor);

	public void depositar(double valor);

	public void transferir(int contaDestino, double valor);

}
