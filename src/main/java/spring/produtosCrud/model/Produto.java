package spring.produtosCrud.model;

import jakarta.persistence.*;

@Entity // Definindo a classe como uma entidade do jakarta: será uma tabela no banco.
@Table(name = "Produto") // Definindo o nome da tabela
public class Produto {
    @Id // Tornando o atributo id a chave Primária da tabela produto.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncrement (ou serial, no postgres); atributo gerado automaticamente.
    @Column(name = "Produto_ID", nullable = false)
    private Long id;

    @Column(name = "produto_nome", nullable = false)
    private String nome;

    @Column(name = "produto_preco", nullable = false)
    private double preco;

    @Column(name = "produto_estoque", nullable = false)
    private int estoque;

    @Override
    public String toString() {
        return "Produto{" +
                ", id=" + id +
                "estoque=" + estoque +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
