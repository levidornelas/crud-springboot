package spring.produtosCrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.produtosCrud.model.Produto;
import spring.produtosCrud.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public Produto criarProduto(String nome, int estoque, double preco) {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setEstoque(estoque);
        produto.setPreco(preco);
        return repository.save(produto);
    }

    public List<Produto> listarProdutos() {
        return repository.findAll();
    }

    public Produto atualizarProduto(Long id, String nome, int estoque, double preco) {
        Optional<Produto> optionalProduto = repository.findById(id);
        if (optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();
            produto.setNome(nome);
            produto.setEstoque(estoque);
            produto.setPreco(preco);
            return repository.save(produto);
        }
        return null;
    }

    public boolean deletarProduto(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}

