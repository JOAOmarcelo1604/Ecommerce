package br.com.dev.jm.comercio.eletronico.service.cliente;

import br.com.dev.jm.comercio.eletronico.dao.ClienteDAO;
import br.com.dev.jm.comercio.eletronico.model.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteDAO clienteDAO;

    @Override
    public ClienteModel cadastrarNovoCliente(ClienteModel novo) {
        return clienteDAO.save(novo);
    }

    @Override
    public ClienteModel alterarCliente(ClienteModel cliente) {
        return clienteDAO.save(cliente);
    }

    @Override
    public ClienteModel recuperarClientePeloId(Integer id) {
        return clienteDAO.findById(id).orElse(null);
    }

    @Override
    public ClienteModel recuperarClientePeloTelefone(String telefone) {
        return clienteDAO.findByTelefone(telefone);
    }

    @Override
    public List<ClienteModel> recuperarTodos() {

        return (List<ClienteModel>) clienteDAO.findAll();
    }
}
