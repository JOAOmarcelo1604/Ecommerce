package br.com.dev.jm.comercio.eletronico.dao;

import br.com.dev.jm.comercio.eletronico.model.CategoriaModel;
import br.com.dev.jm.comercio.eletronico.model.ProdutoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface ProdutoDAO extends JpaRepository<ProdutoModel, Integer> {

    public List<ProdutoModel> findByNomeContaining(String palavra);
    //public Page<ProdutoModel> findByOrderByNomeAsc(Pageable pageable);
    public List<ProdutoModel> findByCategoriasContaining(CategoriaModel categorias);

    Page<ProdutoModel> findByOrderByNomeAsc(org.springframework.data.domain.Pageable page);
}
