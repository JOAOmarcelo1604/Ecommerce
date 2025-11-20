package br.com.dev.jm.comercio.eletronico.dao;

import br.com.dev.jm.comercio.eletronico.model.ClienteModel;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDAO extends CrudRepository<ClienteModel, Integer> {

    public ClienteModel findByTelefone(String telefone);
}
