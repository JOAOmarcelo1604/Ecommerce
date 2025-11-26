package br.com.dev.jm.comercio.eletronico.service.variante;

import br.com.dev.jm.comercio.eletronico.dao.VarianteDAO;
import br.com.dev.jm.comercio.eletronico.model.ProdutoModel;
import br.com.dev.jm.comercio.eletronico.model.VarianteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VarianteServiceImpl implements IVarianteService{

    @Autowired
    VarianteDAO dao;

    @Override
    public VarianteModel adicionarNova(VarianteModel nova) {
        return dao.save(nova);
    }

    @Override
    public VarianteModel atualizarDados(VarianteModel variante) {
        return dao.save(variante);
    }

    @Override
    public List<VarianteModel> recuperarPorProduto(ProdutoModel p) {
        return dao.findByProduto(p);
    }

    @Override
    public VarianteModel recuperarPeloId(Integer id) {
        return dao.findById(id).orElse(null);
    }
}
