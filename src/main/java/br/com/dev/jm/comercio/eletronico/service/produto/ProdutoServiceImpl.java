package br.com.dev.jm.comercio.eletronico.service.produto;

import br.com.dev.jm.comercio.eletronico.dao.CategoriaDAO;
import br.com.dev.jm.comercio.eletronico.dao.ProdutoDAO;
import br.com.dev.jm.comercio.eletronico.model.CategoriaModel;
import br.com.dev.jm.comercio.eletronico.model.ClienteModel;
import br.com.dev.jm.comercio.eletronico.model.ProdutoModel;
import br.com.dev.jm.comercio.eletronico.service.categoria.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImpl implements IProdutoService {

    @Autowired
    private ProdutoDAO dao;

    private static final int PAGE_SIZE = 5;

    @Override
    public Page<ProdutoModel> recuperarTodos(int numPagina) {
        Pageable page = PageRequest.of(numPagina-1, PAGE_SIZE);
        return dao.findByOrderByNomeAsc(page);
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
