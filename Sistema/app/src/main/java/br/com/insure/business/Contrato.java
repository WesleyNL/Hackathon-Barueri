package br.com.insure.business;

import java.util.Date;

/**
 * Created by Wesley on 26/11/2016.
 */
public class Contrato {

    private int id;
    private byte situacao;
    private Date data;
    private Veiculo veiculo = new Veiculo();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getSituacao() {
        return situacao;
    }

    public void setSituacao(byte situacao) {
        this.situacao = situacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
