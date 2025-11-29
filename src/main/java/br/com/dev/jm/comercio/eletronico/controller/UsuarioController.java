package br.com.dev.jm.comercio.eletronico.controller;

import br.com.dev.jm.comercio.eletronico.model.UsuarioModel;
import br.com.dev.jm.comercio.eletronico.service.usuario.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioService service;

    @PostMapping("/usuarios")
    public ResponseEntity<UsuarioModel> cadastrarUsuario(@RequestBody UsuarioModel novo) {
        UsuarioModel res =  service.cadastrarNovoUsuario(novo);
        if (res != null) {
            return ResponseEntity.status(201).body(res);
        }
        return ResponseEntity.badRequest().build();
    }


    @PutMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioModel> cadastrarUsuario(@RequestBody UsuarioModel usuario, @PathVariable Integer id) {
        usuario.setId(id);
        UsuarioModel res =  service.atualizarUsuario(usuario);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }
}
