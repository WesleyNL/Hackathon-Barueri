package br.com.insure.enums;

/**
 * Created by Jefferson on 27/11/2016.
 */
public enum Models {
    CLIENTE(0),
    CONTRATO(1),
    VEICULO(2);

    public int getEnmModels;
    Models(int valor) {
        getEnmModels = valor;
    }
}
