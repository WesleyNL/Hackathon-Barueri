package br.com.insure.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.insure.R;
import br.com.insure.utilidades.Utils;

public class SegurosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguros);
    }

    public void criarProposta(View view){
        Intent i = new Intent(this, CadastrarPropostaActivity.class);
        startActivity(i);
    }
}
