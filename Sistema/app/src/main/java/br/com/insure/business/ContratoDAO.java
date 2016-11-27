package br.com.insure.business;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

import java.util.LinkedList;

import br.com.insure.database.ContratoDB;
import br.com.insure.utilidades.FuncoesData;

/**
 * Created by Wesley on 27/11/2016.
 */
public class ContratoDAO extends Contrato{

    private ContratoDB con = new ContratoDB();

    public boolean salvarProposta(){
        return con.salvarProposta(this);
    }

    public LinkedList<ContratoDAO> carregarContratos(){
        return con.carregarContratos();
    }
}
