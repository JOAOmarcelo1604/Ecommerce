package br.com.dev.jm.comercio.eletronico.controller;


import br.com.dev.jm.comercio.eletronico.dao.VarianteDAO;
import br.com.dev.jm.comercio.eletronico.model.ProdutoModel;
import br.com.dev.jm.comercio.eletronico.model.VarianteModel;
import br.com.dev.jm.comercio.eletronico.service.variante.IVarianteService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerVariante {

    @Autowired
    private IVarianteService service;

    @PostMapping("/variantes")
    public ResponseEntity<VarianteModel> salvar(@RequestBody VarianteModel nova){
        VarianteModel res = service.adicionarNova(nova);
        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/variantes/{id}")
    public ResponseEntity<VarianteModel> atualizar(@PathVariable Integer id, @RequestBody VarianteModel variante){
        variante.setId(id);
        VarianteModel res = service.atualizarDados(variante);
        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/variantes/{id}")
    public ResponseEntity<VarianteModel> recuperarPeloId(@PathVariable Integer id){
        VarianteModel res = service.recuperarPeloId(id);
        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/variantes")
    public ResponseEntity<List<VarianteModel>> recuperarPeloProduto(@RequestParam(name = "id_produto") Integer idProduto){
        ProdutoModel p = new ProdutoModel();
        p.setId(idProduto);
        return ResponseEntity.ok(service.recuperarPorProduto(p));
    }
}
