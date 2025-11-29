package br.com.dev.jm.comercio.eletronico.model;


import jakarta.persistence.*;


@Entity
@Table( name = "tbl_usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;

    @Column(name = "nome_usuario", nullable = false, length = 45)
    private String nome;

    @Column(name = "login_usuario", nullable = false, length = 45, unique = true)
    private String login;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Column(name = "senha", nullable = false, length = 100)
    private String senha;
}
