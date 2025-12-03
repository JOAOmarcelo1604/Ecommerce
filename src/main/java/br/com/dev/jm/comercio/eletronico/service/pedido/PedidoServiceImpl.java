package br.com.dev.jm.comercio.eletronico.service.pedido;

import br.com.dev.jm.comercio.eletronico.dao.PedidoDAO;
import br.com.dev.jm.comercio.eletronico.dto.FaturamentoMensal;
import br.com.dev.jm.comercio.eletronico.model.ItemPedidoModel;
import br.com.dev.jm.comercio.eletronico.model.PedidoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoServiceImpl implements IPedidoService{

    @Autowired
    PedidoDAO dao;


    @Override
    public PedidoModel criarNovoPedido(PedidoModel novo) {
        novo.setStatus(1);
        for(ItemPedidoModel item : novo.getItens()){
            item.setPedido(novo);
        }

        double total = 0.0, desconto = 0.0;
        for(ItemPedidoModel item : novo.getItens()){
            total += item.getValorTotal();
        }
        novo.setValorBruto(total);
        if(total >= 30.0){
            desconto = total * 0.10;
        }
        total = total - desconto;

        novo.setDesconto(desconto);
        novo.setValorTotal(total);
        return dao.save(novo);
    }

    @Override
    public PedidoModel alterarDados(PedidoModel pedido) {
        return dao.save(pedido);
    }

    @Override
    public List<PedidoModel> listarTodosPedidos() {
        return (List<PedidoModel>) dao.findAll();
    }

    @Override
    public PedidoModel recuperarPeloNumero(Integer numPedido) {
        return dao.findById(numPedido).orElse(null);
    }

    @Override
    public List<PedidoModel> recuperarTodosStatus(Integer status) {
        return dao.findAllByStatus(status);
    }

    @Override
    public List<FaturamentoMensal> recuperarFaturamentoMensal(Integer ano) {
        return dao.recuperarFaturamento(ano);
    }
}
