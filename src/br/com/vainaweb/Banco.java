package br.com.vainaweb;

import java.util.ArrayList;

public class Banco {

    private ArrayList<Conta> contas = new ArrayList<>();

    public Banco() {}

    public void adicionarConta(Conta conta) {  // ajuda do chatgpt pra estruturar minha lógica
        if (contaJaExiste(conta.getNumeroConta())) {
            System.out.println("Conta com o mesmo número já existe no banco.");
        } else {
            Conta contaExistente = buscarContaPorCPF(conta.getCpfCliente());

            if (contaExistente != null) {
                if (contaExistente.getClass().equals(conta.getClass())) {
                    System.out.println("CPF já possui uma conta do mesmo tipo no banco.");
                } else {
                    contas.add(conta);
                    System.out.println("Conta adicionada com sucesso.");
                    conta.resumoDaConta();
                }
            } else {
                contas.add(conta);
                System.out.println("\nConta cadastrada com sucesso.");
                conta.resumoDaConta();
            }
        }
    }

    private boolean contaJaExiste(String numeroConta) {
        return contas.stream().anyMatch(c -> c.getNumeroConta().equals(numeroConta));
    }

    private Conta buscarContaPorCPF(String cpf) {
        return contas.stream()
                .filter(c -> c.getCpfCliente().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public Conta pesquisarConta(String numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        System.out.println("Conta não encontrada.");
        return null;
    }
    
    public void getTodasContas() {
        for (Conta conta : contas) {
            System.out.println("---------------------------------------------");
            conta.resumoDaConta();
            System.out.println("---------------------------------------------");
        }
    }
}
