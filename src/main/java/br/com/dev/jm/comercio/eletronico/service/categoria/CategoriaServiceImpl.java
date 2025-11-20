package br.com.dev.jm.comercio.eletronico.service.categoria;

import br.com.dev.jm.comercio.eletronico.dao.CategoriaDAO;
import br.com.dev.jm.comercio.eletronico.model.CategoriaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CategoriaServiceImpl implements ICategoriaService{


    @Autowired
    private CategoriaDAO dao;


    @Override
    public CategoriaModel criarNova(CategoriaModel nova) {
        return dao.save(nova);
    }

    @Override
    public CategoriaModel alterar(CategoriaModel categoria) {
        return dao.save(categoria);
    }

    @Override
    public List<CategoriaModel> listarTudo() {
        return dao.findAllByOrderByNomeAsc();
    }

    @Override
    public void apagarCategoria(Integer id) {
        dao.deleteById(id);

    }
}
