package br.com.insure.database;

import android.graphics.BitmapFactory;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import br.com.insure.Sistema;
import br.com.insure.business.Contrato;
import br.com.insure.business.ContratoDAO;
import br.com.insure.enums.Models;
import br.com.insure.servidor.GETParametros;
import br.com.insure.servidor.Response;
import br.com.insure.servidor.Servidor;

/**
 * Created by Jefferson on 27/11/2016.
 */
public class ContratoDB {

    private Servidor servidor = new Servidor();

    public boolean salvarProposta(Contrato contrato) {

        JSONObject json = new JSONObject();
        Response response;

        try {
            json.put("cliente", Sistema.cliente.getCodigo());
            json.put("modelo", contrato.getVeiculo().getModelo());
            json.put("ano", contrato.getVeiculo().getAno());
            json.put("tempoHabilitado", contrato.getVeiculo().getTempoHabilitacao());
            json.put("fotoFrontal", contrato.getVeiculo().getBmpFotoFrontal());
            json.put("fotoLateral", contrato.getVeiculo().getBmpFotoLateral());
            json.put("hasOutrosMotoristas", contrato.getVeiculo().getOutrosMotoristas() == 1);
            json.put("hasAlarme", contrato.getVeiculo().getAlarme() == 1);

            response = servidor.requestPOST(Models.CLIENTE, "salvar", json.toString());

            if (response.getCodeResponse() != HttpURLConnection.HTTP_OK) {
                return false;
            }

            contrato.setId(new JSONObject(response.getMessageResponse()).getInt("id"));
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }

    public LinkedList<ContratoDAO> carregarContratos() {
        GETParametros parametros = new GETParametros();
        parametros.put("cliente", Sistema.cliente.getCodigo());

        LinkedList<ContratoDAO> contratos = new LinkedList<>();

        try {
            Response response = servidor.requestGET(Models.CLIENTE, "carregarContratos", parametros);

            if (response.getCodeResponse() != HttpURLConnection.HTTP_OK) {
                throw new Exception("ERRO LOL");
            }

            JSONArray json = new JSONArray(response.getMessageResponse());

            for (int i = 0; i < json.length(); i++) {
                JSONObject jsonVeiculo = json.getJSONObject(i).getJSONObject("veiculo");
                ContratoDAO contrato = new ContratoDAO();

                contrato.setId(json.getJSONObject(i).getInt("id"));
                contrato.getVeiculo().setModelo(jsonVeiculo.getString("modelo"));
                contrato.getVeiculo().setAno(jsonVeiculo.getInt("ano"));
                contrato.getVeiculo().setTempoHabilitacao(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(jsonVeiculo.getString("tempoHabilitado").replaceAll("Z$", "+0000")));
                contrato.getVeiculo().setBmpFotoFrontal(BitmapFactory.decodeByteArray(jsonVeiculo.getString("fotoFrontal").getBytes(), 0, jsonVeiculo.getString("fotoFrontal").length()));
                contrato.getVeiculo().setBmpFotoLateral(BitmapFactory.decodeByteArray(jsonVeiculo.getString("fotoFrontal").getBytes(), 0, jsonVeiculo.getString("fotoLateral").length()));
                contrato.getVeiculo().setOutrosMotoristas(jsonVeiculo.getBoolean("hasOutrosMotoristas") ? (byte) 1 : 0);
                contrato.getVeiculo().setAlarme(jsonVeiculo.getBoolean("hasAlarme") ? (byte) 1 : 0);

                contratos.add(contrato);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return contratos;
    }
}
