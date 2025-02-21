package spring.produtosCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.produtosCrud.model.Produto;
import spring.produtosCrud.service.ProdutoService;

import java.util.List;
import java.util.Scanner;

@Component
public class GerenciarProdutos implements CommandLineRunner {
    @Autowired
    private ProdutoService service;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== CRUD de Produtos ===");
            System.out.println("1 - Criar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Atualizar Produto");
            System.out.println("4 - Deletar Produto");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> criarProduto(scanner);
                case 2 -> listarProdutos();
                case 3 -> atualizarProduto(scanner);
                case 4 -> deletarProduto(scanner);
                case 5 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 5);
    }

    private void criarProduto(Scanner scanner) {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Quantidade em estoque: ");
        int estoque = scanner.nextInt();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        Produto produto = service.criarProduto(nome, estoque, preco);
        System.out.println("Produto criado: " + produto);
    }

    private void listarProdutos() {
        List<Produto> produtos = service.listarProdutos();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("\n=== Lista de Produtos ===");
            produtos.forEach(System.out::println);
        }
    }

    private void atualizarProduto(Scanner scanner) {
        System.out.print("ID do produto a atualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova quantidade em estoque: ");
        int estoque = scanner.nextInt();
        System.out.print("Novo preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        Produto produto = service.atualizarProduto(id, nome, estoque, preco);
        if (produto != null) {
            System.out.println("Produto atualizado: " + produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private void deletarProduto(Scanner scanner) {
        System.out.print("ID do produto a deletar: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        if (service.deletarProduto(id)) {
            System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}
