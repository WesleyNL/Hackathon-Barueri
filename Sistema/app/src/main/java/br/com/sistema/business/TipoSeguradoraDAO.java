package br.com.sistema.business;

import java.util.LinkedList;

/**
 * Created by Wesley on 26/11/2016.
 */

public class TipoSeguradoraDAO extends TipoSeguradora{

    public LinkedList<TipoSeguradora> carregar() {

        LinkedList<TipoSeguradora> lista = new LinkedList<>();

        TipoSeguradora objTipoSeguradora = new TipoSeguradora();
        objTipoSeguradora.setCodigo(1);
        objTipoSeguradora.setDescricao("Tipo 1");
        lista.add(objTipoSeguradora);

        objTipoSeguradora = new TipoSeguradora();
        objTipoSeguradora.setCodigo(2);
        objTipoSeguradora.setDescricao("Tipo 2");
        lista.add(objTipoSeguradora);

        return lista;
    }
}
