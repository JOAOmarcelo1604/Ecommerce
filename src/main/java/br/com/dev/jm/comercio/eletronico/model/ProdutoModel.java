package br.com.dev.jm.comercio.eletronico.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.w3c.dom.Text;

import java.util.List;

@Entity
@Table(name = "tbl_produto")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer id;

    @Column(name = "nome_produto", nullable = false, length = 50)
    private String nome;

    @Column(name = "descrico_produto",  length = 45, columnDefinition = "TEXT")
    private String descricao;

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Integer disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Integer getDestaque() {
        return destaque;
    }

    public void setDestaque(Integer destaque) {
        this.destaque = destaque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CategoriaModel> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaModel> categorias) {
        this.categorias = categorias;
    }

    @Column(name ="preco_produto")
    private Double preco;

    @Column(name = "destaque")
    private Integer destaque;

    public List<VarianteModel> getVariantes() {
        return variantes;
    }

    public void setVariantes(List<VarianteModel> variantes) {
        this.variantes = variantes;
    }

    @Column(name = "disponivel")
    private Integer disponibilidade;

    @ManyToMany
    @JoinTable(name = "tbl_categoria_produto",
               joinColumns = @JoinColumn(name = "id_produto"),
               inverseJoinColumns = @JoinColumn(name = "id_categoria")
    )
    private List<CategoriaModel> categorias;


    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("produto")
    private List<VarianteModel> variantes;


}
