package br.com.vainaweb;

public class ContaPoupanca extends Conta{
	
    private static final double TAXA_JUROS_SAQUE = 0.02; // 2%

	public ContaPoupanca(String nomeCliente, String cpfCliente, String numeroConta, String tipoConta, double saldo) {
		super(nomeCliente, cpfCliente, numeroConta, tipoConta, saldo);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void sacar(double valor) {
	    double saldoAtual = getSaldo();
	    if (valor > saldoAtual) {
	        System.out.println("Saldo insuficiente para o saque.");
	    } else {
	        double juros = valor * TAXA_JUROS_SAQUE;
	        double novoSaldo = saldoAtual - valor - (valor - juros);
	        if (novoSaldo < 0) {
	            System.out.println("Operação não realizada. Saldo não pode ficar negativo.");
	        } else {
	            setSaldo(novoSaldo);
	            System.out.println("Operação realizada. Saldo: " + getSaldo());
	            System.out.println("Juros de R$ " + juros + " aplicados ao saque.");
	        }
	    }
	}
	
}

