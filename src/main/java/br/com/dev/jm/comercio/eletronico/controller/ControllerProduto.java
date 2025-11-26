package br.com.dev.jm.comercio.eletronico.controller;


import br.com.dev.jm.comercio.eletronico.model.CategoriaModel;
import br.com.dev.jm.comercio.eletronico.model.ProdutoModel;
import br.com.dev.jm.comercio.eletronico.service.cliente.IClienteService;
import br.com.dev.jm.comercio.eletronico.service.produto.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerProduto {

    @Autowired
    public IProdutoService service;

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoModel>> getAll(){

        return ResponseEntity.ok(service.recuperarTodos());
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<ProdutoModel> buscarPeloId(@PathVariable Integer id){
        ProdutoModel res = service.buscarPeloId(id);
        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/produtos/search")
    public ResponseEntity<List<ProdutoModel>> buscarPeloNome(@RequestParam(name = "key") String key){
        List<ProdutoModel> lista = service.recuperarPorPalavraChave(key);
        if(lista.size() > 0){
            return ResponseEntity.ok(lista);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/produtos/categorias/{id}")
    public ResponseEntity<List<ProdutoModel>> buscarPeloCategoria(@PathVariable Integer id){
        CategoriaModel categ = new CategoriaModel();
        categ.setId(id);
        return  ResponseEntity.ok(service.buscarPelaCategoria(categ));
    }

    @PostMapping("/produtos")
    public ResponseEntity<ProdutoModel> NovoProduto(@RequestBody ProdutoModel novo){
        ProdutoModel res = service.CadastrarNovoProduto(novo);
        if(res != null){
            return ResponseEntity.status(201).body(res);
        }
        return ResponseEntity.badRequest().build();
    }


    @PutMapping("/produto/{id}")
    public ResponseEntity<ProdutoModel> atualizarProduto(@PathVariable Integer id, @RequestBody ProdutoModel prod){
        prod.setId(id);
        ProdutoModel res = service.alterarProduto(prod);
        if(res != null){
            return ResponseEntity.status(201).body(res);
        }
        return ResponseEntity.badRequest().build();

    }


    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<?> removerProduto(@PathVariable Integer id){
        service.excluirProduto(id);
        return ResponseEntity.ok("Removida com sucesso");
    }



/*

   public ProdutoModel CadastrarNovoProduto(ProdutoModel novo);
    public ProdutoModel alterarProduto(ProdutoModel produto);
    public void excluirProduto(Integer id);
 */

}


