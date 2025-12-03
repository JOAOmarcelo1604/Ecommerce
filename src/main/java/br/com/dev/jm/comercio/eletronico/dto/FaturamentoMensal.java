package br.com.dev.jm.comercio.eletronico.dto;

import java.math.BigDecimal;

public class FaturamentoMensal {
    private Integer mes;

    public FaturamentoMensal(Integer mes, Double valorTotal) {
        this.mes = mes;
        this.valorTotal = valorTotal;
    }

    private Double valorTotal;

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }




}
