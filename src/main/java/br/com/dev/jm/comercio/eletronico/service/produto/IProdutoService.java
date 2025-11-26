package br.com.dev.jm.comercio.eletronico.service.produto;

import br.com.dev.jm.comercio.eletronico.model.CategoriaModel;
import br.com.dev.jm.comercio.eletronico.model.ProdutoModel;

import java.util.List;


public interface IProdutoService {

    public List<ProdutoModel> recuperarTodos();
    public ProdutoModel CadastrarNovoProduto(ProdutoModel novo);
    public ProdutoModel alterarProduto(ProdutoModel produto);
    public List<ProdutoModel> recuperarPorPalavraChave(String palavraChave);
    public ProdutoModel buscarPeloId(Integer id);
    public List<ProdutoModel> buscarPelaCategoria(CategoriaModel categoria);
    public void excluirProduto(Integer id);



}
