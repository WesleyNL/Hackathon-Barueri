package br.com.insure.business;

/**
 * Created by Wesley on 26/11/2016.
 */

public class Cliente {

    private int codigo;
    private String nome;
    private String email;
    private String senha;
    private int tipoSeguradora;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTipoSeguradora() {
        return tipoSeguradora;
    }

    public void setTipoSeguradora(int tipoSeguradora) {
        this.tipoSeguradora = tipoSeguradora;
    }
}
