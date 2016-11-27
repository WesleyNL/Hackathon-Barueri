package br.com.sistema.business;

/**
 * Created by Wesley on 26/11/2016.
 */

public class ClienteDAO extends Cliente {

    private ClienteBD con;

    public ClienteDAO(ClienteBD con){
        this.con = con;
    }

    public boolean salvar(){
        return con.salvar(this, 0);
    }

    public boolean editar(){
        return con.salvar(this, 1);
    }

    public boolean acessar(){
        return con.acessar(this);
    }
}
