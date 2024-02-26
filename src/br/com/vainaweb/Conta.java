package br.com.vainaweb;

public abstract class Conta implements OperacaoBancaria {
	private String nomeCliente;
	private String cpfCliente;
	private String numeroConta;
	private String tipoConta;
	private double saldo;
	
	public Conta(String nomeCliente, String cpfCliente, String numeroConta, String tipoConta, double saldo) {
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.numeroConta = numeroConta;
		this.tipoConta = tipoConta;
        this.saldo = saldo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public String getNumeroConta() {
		return numeroConta;
	}
	
	public String getTipoConta() {
		return tipoConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public void sacar(double valor) {
		double saldoAtual = getSaldo();
		if (valor > saldoAtual) {
	        System.out.println("Saldo insuficiente para o saque.");
		} else {
			setSaldo(saldoAtual - valor);
			System.out.println("Operação realizada. Saldo: " + getSaldo());
		}
	}

	@Override
	public void depositar(double valor) {
		double saldoAtual = getSaldo();
		setSaldo(saldoAtual + valor);
		System.out.println("Deposito realizado. Saldo atual: " + getSaldo());
	}

	@Override
	public void transferir(int contaDestino, double valor) {
		double saldoAtual = getSaldo();
		if (valor > saldoAtual) {
	        System.out.println("Saldo insuficiente para a transferência.");
		} else {
			setSaldo(saldoAtual - valor);
            System.out.println("Transferência de R$ " + valor + " realizada para " + contaDestino + ". Saldo Atual: " + getSaldo());
		}				
	}
	
	public void resumoDaConta(){
		System.out.println("\n---------------------------------------------");
		System.out.println("Titular: " + getNomeCliente() + " CPF: " + getCpfCliente());
		System.out.println("Conta " + getTipoConta() + ": " + getNumeroConta());
		System.out.println("Saldo: " + getSaldo());
		System.out.println("---------------------------------------------");
	}

}
