package br.com.insure.business;

import java.util.LinkedList;

import br.com.insure.database.ContratoDB;

/**
 * Created by Wesley on 27/11/2016.
 */
public class ContratoDAO extends Contrato{

    private ContratoDB con = new ContratoDB();

    public boolean salvarProposta(){
        return con.salvarProposta(this);
    }

    public LinkedList<Contrato> carregarContratos(){
        return con.carregarContratos();
    }
}
