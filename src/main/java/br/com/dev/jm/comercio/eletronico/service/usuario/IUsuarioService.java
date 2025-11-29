package br.com.dev.jm.comercio.eletronico.service.usuario;

import br.com.dev.jm.comercio.eletronico.model.UsuarioModel;
import br.com.dev.jm.comercio.eletronico.security.ECToken;

public interface IUsuarioService {

    public UsuarioModel cadastrarNovoUsuario(UsuarioModel novo);
    public UsuarioModel atualizarUsuario(UsuarioModel usuario);
    public ECToken fazerLogin(String email, String senha);
}
