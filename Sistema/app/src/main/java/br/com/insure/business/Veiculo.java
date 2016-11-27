package br.com.insure.business;

import android.graphics.Bitmap;

import java.util.Date;

/**
 * Created by Wesley on 26/11/2016.
 */
public class Veiculo {

    private String modelo;
    private int ano;
    private Date tempoHabilitacao;
    private byte outrosMotoristas;
    private byte alarme;
    private Bitmap bmpFotoFrontal;
    private Bitmap bmpFotoLateral;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Date getTempoHabilitacao() {
        return tempoHabilitacao;
    }

    public void setTempoHabilitacao(Date tempoHabilitacao) {
        this.tempoHabilitacao = tempoHabilitacao;
    }

    public byte getOutrosMotoristas() {
        return outrosMotoristas;
    }

    public void setOutrosMotoristas(byte outrosMotoristas) {
        this.outrosMotoristas = outrosMotoristas;
    }

    public byte getAlarme() {
        return alarme;
    }

    public void setAlarme(byte alarme) {
        this.alarme = alarme;
    }

    public Bitmap getBmpFotoFrontal() {
        return bmpFotoFrontal;
    }

    public void setBmpFotoFrontal(Bitmap bmpFotoFrontal) {
        this.bmpFotoFrontal = bmpFotoFrontal;
    }

    public Bitmap getBmpFotoLateral() {
        return bmpFotoLateral;
    }

    public void setBmpFotoLateral(Bitmap bmpFotoLateral) {
        this.bmpFotoLateral = bmpFotoLateral;
    }
}
