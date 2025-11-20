package br.com.dev.jm.comercio.eletronico.dao;

import br.com.dev.jm.comercio.eletronico.model.CategoriaModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaDAO extends CrudRepository<CategoriaModel, Integer> {
    public List<CategoriaModel> findAllByOrderByNomeAsc();
}
