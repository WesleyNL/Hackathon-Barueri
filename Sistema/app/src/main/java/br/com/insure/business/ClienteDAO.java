package br.com.insure.business;

import br.com.insure.database.ClienteDB;

/**
 * Created by Wesley on 26/11/2016.
 */

public class ClienteDAO extends Cliente {

    private ClienteDB con = new ClienteDB();

    public boolean salvar() {
        return con.salvar(this);
    }

    public boolean acessar() {
        return con.acessar(this);
    }
}
