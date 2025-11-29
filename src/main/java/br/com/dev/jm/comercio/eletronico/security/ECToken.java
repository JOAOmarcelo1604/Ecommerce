package br.com.dev.jm.comercio.eletronico.security;

public class ECToken {
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ECToken() {
    }

    public ECToken(String token) {
        this.token = token;
    }

    private String token;
}
