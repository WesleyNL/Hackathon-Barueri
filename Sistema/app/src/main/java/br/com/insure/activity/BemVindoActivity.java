package br.com.insure.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.security.AccessControlContext;

import br.com.insure.R;

public class BemVindoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);
    }

    public void minhaConta(View view){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    public void cadastrar(View view){
        Intent i = new Intent(this, CadastroActivity.class);
        startActivity(i);
    }
}
