package br.com.insure.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.LinkedList;

import br.com.insure.R;
import br.com.insure.adapter.ContratosAdapter;
import br.com.insure.business.Contrato;
import br.com.insure.business.ContratoDAO;
import br.com.insure.business.Veiculo;
import br.com.insure.utilidades.FuncoesData;

public class SegurosActivity extends Activity {

    public RecyclerView recyclerView;
    public RecyclerView.Adapter adapter;

    private ContratoDAO objContratoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguros);

        objContratoDAO = new ContratoDAO();

        carregar();
    }

    @Override
    protected void onResume() {
        super.onResume();

//        carregar();
    }

    public void carregar(){

        final Context context = this;
        final Handler hRecycleView = new Handler();
        final LinkedList<ContratoDAO> listaContratos = objContratoDAO.carregarContratos();

        new Thread(new Runnable() {
            @Override
            public void run() {

                hRecycleView.post(new Runnable() {
                    @Override
                    public void run() {
                        if (listaContratos == null || listaContratos.isEmpty()) {
                            Toast.makeText(context, "Nenhum contrato encontrado", Toast.LENGTH_LONG).show();
                            return;
                        }

                        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(context));

                        adapter = new ContratosAdapter(SegurosActivity.this, listaContratos);
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        }).start();
    }

    public void criarProposta(View view){
        Intent i = new Intent(this, CadastrarPropostaActivity.class);
        startActivity(i);
    }
}
