package Modelo;

import java.io.IOException;
import java.util.Scanner;
import Modelo.Produto;
import Modelo.Vendas;

public class App {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 99999999;
        Produto[] produtos = new Produto[MAX_ELEMENTOS];
        Vendas vendas = new Vendas();
        int opcao, qtdCadastrados = 0;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("--------------------");
            System.out.println("1 - Incluir Produto");
            System.out.println("2 - Consultar produto");
            System.out.println("3 - Listagem de produtos");
            System.out.println("4 - Vendas por período");
            System.out.println("5 - Realizar venda");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine();

            if (opcao == 1) {
                System.out.println("------------------------");
                System.out.println("|                      |");
                System.out.println("----INCLUIR PRODUTOS----");
                System.out.println("|                      |");
                System.out.println("------------------------");
                if (qtdCadastrados < MAX_ELEMENTOS) {

                    Produto produto = new Produto();

                    System.out.println("Informe o nome do produto :");
                    produto.setNome(in.next());

                    System.out.println("Informe o código do produto :");
                    produto.setCodigo(in.next());

                    System.out.println("Informe o valor do produto :");
                    produto.setValor(in.nextDouble());

                    System.out.println("Informe a quantidade em estoque :");
                    produto.setQuantidadeEmEstoque(in.nextInt());

                    produtos[qtdCadastrados] = produto;
                    qtdCadastrados++;
                }

                System.out.println("\nProduto incluido com sucesso.");
                voltarMenu(in);
                continue;

            } else if (opcao == 2) {
                System.out.println("--------------------------");
                System.out.println("|                        |");
                System.out.println("----CONSULTAR PRODUTOS----");
                System.out.println("|                        |");
                System.out.println("--------------------------");
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há produtos cadrastados.");
                    voltarMenu(in);
                    continue;
                }
                if (produtos != null) {
                    System.out.println("Informe o nome do produto que procura : ");
                    String nextLine = in.nextLine();
                    for (int i = 0; i < MAX_ELEMENTOS; i++) {
                        String nome = produtos[i].getNome();
                        if (nome.equals(nextLine)) {
                            System.out.println("-----------PRODUTO ENCONTRADO-----------");
                            System.out.println("O nome do produto é : " + produtos[i].getNome());
                            System.out.println("O código do produto é : " + produtos[i].getCodigo());
                            System.out.println("O valor do produto é : " + produtos[i].getValor());
                            System.out.println(
                                    "O quantidade do produto em estoque é : " + produtos[i].getQuantidadeEmEstoque());
                            voltarMenu(in);
                            continue;
                        } else if (!nome.equals(nextLine)) {
                            System.out.println("\nProduto não encontrado.");
                            voltarMenu(in);
                            continue;
                        }
                    }
                }
            } else if (opcao == 3) {
                System.out.println("-------------------------");
                System.out.println("|                       |");
                System.out.println("----LISTA DE PRODUTOS----");
                System.out.println("|                       |");
                System.out.println("-------------------------");
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há produtos incluidos para exibir.");
                    voltarMenu(in);
                    continue;
                }
                if (produtos != null) {
                    for (int i = 0; i < produtos.length; i++) {
                        System.out.println(" O nome do produto cadastrado é : " + produtos[i].getNome());
                        System.out.println(" O código do produto cadastrado é : " + produtos[i].getCodigo());
                        System.out.println(" O valor do produto cadastrado é : " + produtos[i].getValor());
                        System.out.println(" O quantidade do produto em estoque cadastrado é : "
                                + produtos[i].getQuantidadeEmEstoque());
                        System.out.println("--------------------------------------");
                        System.out.println();
                    }
                    double valorTotal = 0;
                    double valorMax = 0;
                    double valorMin = 999999999;
                    for (Produto produto : produtos) {
                        valorTotal = valorTotal + produto.getValor();
                        if (produto.getValor() > valorMax) {
                            valorMax = produto.getValor();
                        }
                        if (produto.getValor() < valorMin) {
                            valorMin = produto.getValor();
                        }
                        System.out.println("Valor máximo = " + valorMax);
                        System.out.println("Valor médio = " + valorTotal / produtos.length);
                        System.out.println("Valor mínimo = " + valorMin);
                        voltarMenu(in);
                        continue;
                    }
                }

            } else if (opcao == 4) {
                System.out.println("--------------------------");
                System.out.println("|                        |");
                System.out.println("----VENDAS POR PERIODO----");
                System.out.println("|                        |");
                System.out.println("--------------------------");
                if (vendas.getDataDaVenda() == 0) {
                    System.out.println("\nNão houve vendas.");
                    voltarMenu(in);
                    continue;
                }
                System.out.println("Informe a data de emissão[DD/MM/AAAA]: ");
                int nextData = in.nextInt();
                if (vendas != null) {
                    for (int i = 0; i < produtos.length; i++) {
                        int intData = vendas.getDataDaVenda();
                        if (intData == nextData) {
                            System.out.println(" O produto é : " + produtos[i].getNome());
                            System.out.println(" A quantidade vendida foi : " + vendas.getQuantidadeVendida());
                            System.out.println(" O valor foi (R$) : " + produtos[i].getValor());
                            System.out.println(" O valor total vendido foi (R$) : "
                                    + vendas.getQuantidadeVendida() * produtos[i].getValor());
                            System.out.println("Valor médio da vendas no período : "
                                    + vendas.getQuantidadeVendida() * produtos[i].getValor() / produtos.length);
                        } else if (intData != nextData) {
                            System.out.println("\nData não registrada.");
                            voltarMenu(in);
                            continue;
                        }
                    }
                }

            } else if (opcao == 5) {
                System.out.println("--------------");
                System.out.println("|            |");
                System.out.println("----VENDAS----");
                System.out.println("|            |");
                System.out.println("--------------");
                System.out.println();
                System.out.println();
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há produtos inclusos.");
                    voltarMenu(in);
                    continue;
                }
                System.out.println("Informe o código do produto : ");
                String nextLine = in.nextLine();
                if (produtos != null) {
                    for (int i = 0; i < produtos.length; i++) {
                        String cógString = produtos[i].getCodigo();
                        if (cógString.equals(nextLine)) {
                            System.out.println("-----------PRODUTO ENCONTRADO-----------");
                            System.out.println("O nome do produto é : " + produtos[i].getNome());
                            System.out.println();
                            System.out.println("Confirmar venda?(Sim para continuar e Não para voltar ao menu)");
                            nextLine = in.nextLine();
                            String positivo = vendas.getSim();
                            if (positivo.equals(nextLine)) {
                                System.out.println("Informe a data de hoje[DD/MM/AAAA]");
                                vendas.setDataDaVenda(in.nextInt());

                                System.out.println("Informe a quantidade a ser vendida");
                                vendas.setQuantidadeVendida(in.nextInt());

                                int quantidadeEstoque = produtos[i].getQuantidadeEmEstoque();
                                if (quantidadeEstoque > i) {
                                    System.out.println("\nQuantidade insuficiente.");
                                    voltarMenu(in);
                                    continue;
                                } else if (quantidadeEstoque <= i) {
                                    System.out.println("\nVenda concluida com sucesso.");
                                    voltarMenu(in);
                                    continue;
                                }

                            }if (!positivo.equals(nextLine)) {
                                voltarMenu(in);
                                continue;

                            } else if (!cógString.equals(nextLine)) {
                                System.out.println("\nProduto não encontrado.");
                                voltarMenu(in);
                                continue;
                            }
                        }
                    }
                }
            } else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");

        System.out.flush();
    }
}