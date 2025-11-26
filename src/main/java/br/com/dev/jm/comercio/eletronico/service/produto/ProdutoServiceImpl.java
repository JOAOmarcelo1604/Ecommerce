package br.com.dev.jm.comercio.eletronico.service.produto;

import br.com.dev.jm.comercio.eletronico.dao.CategoriaDAO;
import br.com.dev.jm.comercio.eletronico.dao.ProdutoDAO;
import br.com.dev.jm.comercio.eletronico.model.CategoriaModel;
import br.com.dev.jm.comercio.eletronico.model.ClienteModel;
import br.com.dev.jm.comercio.eletronico.model.ProdutoModel;
import br.com.dev.jm.comercio.eletronico.service.categoria.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImpl implements IProdutoService {

    @Autowired
    private ProdutoDAO dao;

    @Override
    public List<ProdutoModel> recuperarTodos() {
        return (List<ProdutoModel>) dao.findByOrderByNomeAsc();
    }


    @Override
    public ProdutoModel CadastrarNovoProduto(ProdutoModel novo) {

        return dao.save(novo);
    }

    @Override
    public ProdutoModel alterarProduto(ProdutoModel produto) {
        return dao.save(produto);
    }

    @Override
    public List<ProdutoModel> recuperarPorPalavraChave(String palavraChave) {
        return dao.findByNomeContaining(palavraChave);
    }

    @Override
    public ProdutoModel buscarPeloId(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<ProdutoModel> buscarPelaCategoria(CategoriaModel categoria) {
        return dao.findByCategoriasContaining(categoria);
    }

    @Override
    public void excluirProduto(Integer id) {
        dao.deleteById(id);
    }
}
