package br.com.dev.jm.comercio.eletronico.service.variante;

import br.com.dev.jm.comercio.eletronico.model.ProdutoModel;
import br.com.dev.jm.comercio.eletronico.model.VarianteModel;

import java.util.List;

public interface IVarianteService {

    public VarianteModel adicionarNova(VarianteModel nova);
    public VarianteModel atualizarDados(VarianteModel variante);
    public List<VarianteModel> recuperarPorProduto(ProdutoModel p);
    public VarianteModel recuperarPeloId(Integer id);
}
