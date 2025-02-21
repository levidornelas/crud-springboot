package spring.produtosCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.produtosCrud.model.Produto;

// Serve para inicializar a ORM do JPARepository sobre a classe produto: CRUD facilitado.
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
