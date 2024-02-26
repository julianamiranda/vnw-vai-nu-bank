package br.com.vainaweb;

public class ContaCorrente extends Conta {

    private static final double LIMITE_DE_CREDITO_PADRAO = 1000.0;
    private double limiteDeCredito;

    public ContaCorrente(String nomeCliente, String cpfCliente, String numeroConta, String tipoConta, double saldo) {
        super(nomeCliente, cpfCliente, numeroConta, tipoConta, saldo);
        this.limiteDeCredito = LIMITE_DE_CREDITO_PADRAO;
    }

    public double getLimiteDeCredito() {
        return limiteDeCredito;
    }

    public void setLimiteDeCredito(double limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
    }

    @Override
    public void sacar(double valor) {
        if (valor > (getSaldo() + limiteDeCredito)) {
            System.out.println("Saldo e limite de crédito insuficientes para o saque.");
        } else if (valor > getSaldo()) {
            double valorExcedente = valor - getSaldo();
            setLimiteDeCredito(getLimiteDeCredito() - valorExcedente);
            setSaldo(0);
            System.out.println("Saque de R$ " + valor + " realizado. Novo saldo: R$ 0.0. Novo limite de crédito: R$ " + getLimiteDeCredito());
        } else {
            super.sacar(valor);
        }
    }

}
