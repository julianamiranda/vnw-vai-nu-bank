package br.com.vainaweb;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarContaCorrente(scanner, banco);
                    break;
                case 2:
                    cadastrarContaPoupanca(scanner, banco);
                    break;
                case 3:
                    operacoesBancarias(scanner, banco);
                    break;
                case 4:
                    banco.getTodasContas();
                    break;
                case 0:
                    System.out.println("Saindo do Menu. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
    
    private static void exibirMenu() {
        System.out.println("---------------- Vai nu Bank ---------------- ");
        System.out.println("1. Cadastrar Conta Corrente");
        System.out.println("2. Cadastrar Conta Poupança");
        System.out.println("3. Operações Bancárias");
        System.out.println("4. Listar Contas");
        System.out.println("0. Sair do Menu");
        System.out.print("Informe a opção desejada: ");
    }
    
    
    private static void cadastrarContaCorrente(Scanner scanner, Banco banco) {
        System.out.print("\nNome do Cliente: ");
        String nomeCliente = scanner.next();

        System.out.print("CPF do Cliente: ");
        String cpfCliente = scanner.next();

        System.out.print("Número da Conta: ");
        String numeroConta = scanner.next();

        System.out.print("Saldo Inicial: ");
        double saldoInicial = scanner.nextDouble();

        ContaCorrente contaCorrente = new ContaCorrente(nomeCliente, cpfCliente, numeroConta,"Corrente", saldoInicial);
        banco.adicionarConta(contaCorrente);
    }

    private static void cadastrarContaPoupanca(Scanner scanner, Banco banco) {
        System.out.print("\nNome do Cliente: ");
        String nomeCliente = scanner.next();

        System.out.print("CPF do Cliente: ");
        String cpfCliente = scanner.next();

        System.out.print("Número da Conta: ");
        String numeroConta = scanner.next();

        System.out.print("Saldo Inicial: ");
        double saldoInicial = scanner.nextDouble();

        ContaPoupanca contaPoupanca = new ContaPoupanca(nomeCliente, cpfCliente, numeroConta, "Poupança", saldoInicial);
        banco.adicionarConta(contaPoupanca);
    }

    private static void operacoesBancarias(Scanner scanner, Banco banco) {
        System.out.print("\nDigite o número da conta: ");
        String numeroConta = scanner.next();

        Conta conta = banco.pesquisarConta(numeroConta);
        
        if (conta != null) {
        	System.out.println("\n----------- Bem vindo, " + conta.getNomeCliente() + "! -----------");
        	System.out.println("	 Saldo: R$ " + conta.getSaldo());
            
        	int op;

            do {
                System.out.println("\n--------- Operações Bancárias ---------");
                System.out.println("1. Resumo da Conta");
                System.out.println("2. Sacar");
                System.out.println("3. Depositar");
                System.out.println("4. Transferir");
                System.out.println("0. Voltar ao Menu Principal");
                System.out.print("Informe a opção desejada: ");

                op = scanner.nextInt();

                switch (op) {
                    case 1:
                        conta.resumoDaConta();
                        break;
                    case 2:
                        System.out.print("Digite o valor a ser sacado: ");
                        double valorSaque = scanner.nextDouble();
                        conta.sacar(valorSaque);
                        break;
                    case 3:
                        System.out.print("Digite o valor a ser depositado: ");
                        double valorDeposito = scanner.nextDouble();
                        conta.depositar(valorDeposito);
                        break;
                    case 4:
                    	System.out.print("Digite o número da conta de destino: ");
                        int numeroContaDestino = scanner.nextInt();
                        System.out.print("Digite o valor a ser transferido: ");
                        double valorTransferencia = scanner.nextDouble();
                        conta.transferir(numeroContaDestino, valorTransferencia);
                        break;
                    case 0:
                        System.out.println("Voltando ao Menu Principal. \n");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

            } while (op != 0);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }


}
