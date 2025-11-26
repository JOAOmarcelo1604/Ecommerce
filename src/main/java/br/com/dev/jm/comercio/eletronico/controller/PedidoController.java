package br.com.dev.jm.comercio.eletronico.controller;

import br.com.dev.jm.comercio.eletronico.model.PedidoModel;
import br.com.dev.jm.comercio.eletronico.service.pedido.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidoController {

    @Autowired
    private IPedidoService service;

    @PostMapping("/pedidos")
    public ResponseEntity<PedidoModel> inserirNovo(@RequestBody PedidoModel novo) {
        PedidoModel res = service.criarNovoPedido(novo);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<PedidoModel>> recuperarTodos(){
        return ResponseEntity.ok(service.listarTodosPedidos());
    }

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<PedidoModel> recuperarPeloId(@PathVariable Integer id) {
        PedidoModel res = service.recuperarPeloNumero(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }
}
