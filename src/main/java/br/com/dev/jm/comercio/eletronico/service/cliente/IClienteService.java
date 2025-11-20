package br.com.dev.jm.comercio.eletronico.service.cliente;

import br.com.dev.jm.comercio.eletronico.model.ClienteModel;

import java.util.List;

public interface IClienteService {

    public ClienteModel cadastrarNovoCliente(ClienteModel novo);
    public ClienteModel alterarCliente(ClienteModel cliente);
    public ClienteModel recuperarClientePeloId(Integer id);
    public ClienteModel recuperarClientePeloTelefone(String telefone);
    public List<ClienteModel> recuperarTodos();
}
