package br.com.dev.jm.comercio.eletronico.controller;


import br.com.dev.jm.comercio.eletronico.model.ClienteModel;
import br.com.dev.jm.comercio.eletronico.service.cliente.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService cliServ;

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteModel>> getAll(){
        return ResponseEntity.ok(cliServ.recuperarTodos());
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<ClienteModel> getById(@PathVariable Integer id){
        ClienteModel resut = cliServ.recuperarClientePeloId(id);
        if(resut != null){
            return ResponseEntity.ok(resut);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/clientes")
    public ResponseEntity<ClienteModel> insertNew(@RequestBody ClienteModel novo){
        try {
            ClienteModel result = cliServ.cadastrarNovoCliente(novo);
            if (result != null) {
                return ResponseEntity.status(201).body(result);
            }
        }
        catch (Exception ex) {
            System.out.println("LOG - ERRO AO CADASTRAR NOVO CLIENTE" + ex.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<ClienteModel> update(@PathVariable Integer id, @RequestBody ClienteModel cliente){
        cliente.setId(id);
        try{
            ClienteModel result = cliServ.alterarCliente(cliente);
            if (result != null) {
                return ResponseEntity.ok(result);
            }
        }
        catch (Exception ex){
            System.out.println("LOG - ERRO AO ATUALIZAR " + ex.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/clientes/busca")
    public ResponseEntity<ClienteModel> searchByPhone(@RequestParam(name = "telefone") String telefone){
        ClienteModel res = cliServ.recuperarClientePeloTelefone(telefone);
        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

}
