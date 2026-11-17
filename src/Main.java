import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int emprestimosAtivosMembro = 2;
        int limiteEmprestimos = 3;
        int prazoPadrao = 14;
        double valorMultaDia = 2.50;

        boolean exemplarDisponivel = true;
        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE GESTÃO DE BIBLIOTECA (TP1) ===");
            System.out.println("1 - Simular Empréstimo");
            System.out.println("2 - Simular Devolução e Cálculo de Multa");
            System.out.println("3 - Simular Reserva de Exemplar");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Novo Empréstimo ---");
                    if (emprestimosAtivosMembro >= limiteEmprestimos) {
                        System.out.println("Bloqueado: Membro já atingiu o limite de " + limiteEmprestimos + " empréstimos ativos.");
                    } else if (!exemplarDisponivel) {
                        System.out.println("Bloqueado: Este exemplar já está emprestado no momento.");
                    } else {
                        emprestimosAtivosMembro++;
                        exemplarDisponivel = false;
                        System.out.println("Empréstimo realizado! Prazo de devolução: " + prazoPadrao + " dias.");
                        System.out.println("Total de empréstimos ativos do membro: " + emprestimosAtivosMembro);
                    }
                break;

                case 2:
                    System.out.println("\n--- Devolução de Exemplar ---");
                     if (exemplarDisponivel) {
                         System.out.println("Aviso: Este exemplar já consta no acervo (não está emprestado).");
                     } else {
                         System.out.print("Informe o total de dias corridos com o livro: ");
                         int diasComLivro = scanner.nextInt();

                         if (diasComLivro > prazoPadrao) {
                             int diasAtraso = diasComLivro - prazoPadrao;
                             double multaTotal = diasAtraso * valorMultaDia;
                             System.out.printf("Devolução com atraso de %d dia(s). Multa a pagar: R$ %.2f%n", diasAtraso, multaTotal);
                         } else {
                             System.out.println("Devolução dentro do prazo. Nenhuma multa aplicada.");
                         }

                         exemplarDisponivel = true;
                         if (emprestimosAtivosMembro > 0) {
                             emprestimosAtivosMembro--;
                         }
                     }
                break;

                case 3:
                    System.out.println("\n--- Reserva de Exemplar ---");
                    if (exemplarDisponivel) {
                        System.out.println("Reserva negada: O exemplar está disponível na estante. Realize o empréstimo direto.");
                    } else {
                        System.out.println("Reserva confirmada! Você entrou na fila para este exemplar.");
                    }
                break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}