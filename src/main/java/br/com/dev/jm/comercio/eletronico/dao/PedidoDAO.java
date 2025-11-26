package br.com.dev.jm.comercio.eletronico.dao;

import br.com.dev.jm.comercio.eletronico.model.PedidoModel;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface PedidoDAO extends CrudRepository<PedidoModel, Integer> {

    public List<PedidoModel> findAllByStatus(Integer status);
}
