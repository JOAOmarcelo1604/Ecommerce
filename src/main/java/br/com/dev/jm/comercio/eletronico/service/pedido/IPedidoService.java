package br.com.dev.jm.comercio.eletronico.service.pedido;

import br.com.dev.jm.comercio.eletronico.model.PedidoModel;

import java.util.List;

public interface IPedidoService {

    public PedidoModel criarNovoPedido(PedidoModel novo);
    public PedidoModel alterarDados(PedidoModel pedido);
    public List<PedidoModel> listarTodosPedidos();
    public PedidoModel recuperarPeloNumero(Integer numPedido);
    public List<PedidoModel> recuperarTodosStatus(Integer status);
}
