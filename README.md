# Spring Boot CRUD de Produtos

Este é um projeto Spring Boot que implementa operações básicas de CRUD (Create, Read, Update, Delete) para gerenciar produtos. O projeto utiliza Spring Data JPA para persistência de dados em um banco de dados PostgreSQL, para armazenar as informações dos produtos.

## Funcionalidades

- **Criar Produto**: Adiciona um novo produto ao banco de dados.
- **Listar Produtos**: Exibe todos os produtos cadastrados.
- **Atualizar Produto**: Atualiza as informações de um produto existente.
- **Deletar Produto**: Remove um produto do banco de dados.

## Tecnologias Utilizadas

- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Spring Data JPA**: Facilita a integração com o banco de dados usando JPA.
- **Hibernate**: ORM (Object-Relational Mapping) utilizado pelo Spring Data JPA.
- **Banco de Dados**: PostgreSQL.

## Estrutura do Projeto

- **Model**: Contém a entidade `Produto` que representa a tabela no banco de dados.
- **Repository**: Interface `ProdutoRepository` que estende `JpaRepository` para operações de CRUD.
- **Service**: Classe `ProdutoService` que contém a lógica de negócio para manipulação dos produtos.
- **Controller**: Classe `GerenciarProdutos` que implementa a interface `CommandLineRunner` para interação via console.
