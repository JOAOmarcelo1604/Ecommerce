package br.com.dev.jm.comercio.eletronico.dao;

import br.com.dev.jm.comercio.eletronico.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDAO extends CrudRepository<UsuarioModel, Integer> {
    public UsuarioModel findByLogin(String login);
}
