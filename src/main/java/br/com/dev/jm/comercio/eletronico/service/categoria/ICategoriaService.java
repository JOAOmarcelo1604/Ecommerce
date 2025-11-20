package br.com.dev.jm.comercio.eletronico.service.categoria;

import br.com.dev.jm.comercio.eletronico.model.CategoriaModel;

import java.util.List;

public interface ICategoriaService{

    public CategoriaModel criarNova(CategoriaModel nova);
    public CategoriaModel alterar(CategoriaModel categoria);
    public List<CategoriaModel> listarTudo();
    public void apagarCategoria(Integer id);

}
