package br.com.insure.database;

import org.json.JSONObject;

import java.net.HttpURLConnection;

import br.com.insure.business.Cliente;
import br.com.insure.enums.Models;
import br.com.insure.servidor.Response;
import br.com.insure.servidor.Servidor;

/**
 * Created by Jefferson on 27/11/2016.
 */
public class ClienteDB {

    private Servidor servidor = new Servidor();

    public boolean salvar(Cliente cliente) {

        JSONObject json = new JSONObject();
        Response response;

        try {
            json.put("nome", cliente.getNome());
            json.put("email", cliente.getEmail());
            json.put("senha", cliente.getSenha());

            response = servidor.requestPOST(Models.CLIENTE, "salvar", json.toString());

            if (response.getCodeResponse() != HttpURLConnection.HTTP_OK) {
                return false;
            };

            cliente.setCodigo(new JSONObject(response.getMessageResponse()).getInt("id"));
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean acessar(Cliente cliente) {

        JSONObject json = new JSONObject();
        Response response;

        try {
            json.put("email", cliente.getEmail());
            json.put("senha", cliente.getSenha());

            response = servidor.requestPOST(Models.CLIENTE, "acessar", json.toString());

            if (response.getCodeResponse() != HttpURLConnection.HTTP_OK) {
                return false;
            };
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }
}
