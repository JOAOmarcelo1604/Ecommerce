package br.com.dev.jm.comercio.eletronico.dao;

import br.com.dev.jm.comercio.eletronico.dto.FaturamentoMensal;
import br.com.dev.jm.comercio.eletronico.model.PedidoModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PedidoDAO extends CrudRepository<PedidoModel, Integer> {

    public List<PedidoModel> findAllByStatus(Integer status);


    /*criando uma query costumizada para recuperar faturamento */

    @Query("SELECT new " +
            "br.com.dev.jm.comercio.eletronico.dto.FaturamentoMensal(month(p.dataPedido), sum(p.valorTotal))" +
            " FROM PedidoModel p " +
            " WHERE year(p.dataPedido) = :ano" +
            " GROUP BY month(p.dataPedido)"
    )
    public List<FaturamentoMensal> recuperarFaturamento(@Param("ano") Integer ano);


}
