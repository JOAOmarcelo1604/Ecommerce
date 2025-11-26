package br.com.dev.jm.comercio.eletronico.dao;

import br.com.dev.jm.comercio.eletronico.model.CategoriaModel;
import br.com.dev.jm.comercio.eletronico.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoDAO extends JpaRepository<ProdutoModel, Integer> {

    public List<ProdutoModel> findByNomeContaining(String palavra);
    public List<ProdutoModel> findByOrderByNomeAsc();
    public List<ProdutoModel> findByCategoriasContaining(CategoriaModel categorias);
}
