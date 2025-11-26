package br.com.dev.jm.comercio.eletronico.dao;

import br.com.dev.jm.comercio.eletronico.model.ProdutoModel;
import br.com.dev.jm.comercio.eletronico.model.VarianteModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VarianteDAO extends CrudRepository<VarianteModel, Integer> {

    public List<VarianteModel> findByProduto(ProdutoModel p);

}
