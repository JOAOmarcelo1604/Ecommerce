package br.com.dev.jm.comercio.eletronico.service.usuario;

import br.com.dev.jm.comercio.eletronico.dao.UsuarioDAO;
import br.com.dev.jm.comercio.eletronico.model.UsuarioModel;
import br.com.dev.jm.comercio.eletronico.security.ECToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioDAO dao;

    @Override
    public UsuarioModel cadastrarNovoUsuario(UsuarioModel novo) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String novaSenha = encoder.encode(novo.getSenha());
        novo.setSenha(novaSenha);
        return dao.save(novo);
    }

    @Override
    public UsuarioModel atualizarUsuario(UsuarioModel usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String novaSenha = encoder.encode(usuario.getSenha());
        usuario.setSenha(novaSenha);
        return dao.save(usuario);
    }

    @Override
    public ECToken fazerLogin(String email, String senha) {
        return null;
    }
}
