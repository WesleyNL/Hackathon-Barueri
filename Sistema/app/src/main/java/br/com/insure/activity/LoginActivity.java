package br.com.insure.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import br.com.insure.R;
import br.com.insure.Sistema;
import br.com.insure.business.ClienteDAO;

public class LoginActivity extends AppCompatActivity {

    public ClienteDAO objCliente;
    public static final String LEMBRAR_LOGIN = "LEMBRAR_LOGIN";

    private TextInputLayout txtEmail = null;
    private TextInputLayout txtSenha = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        getActionBar().setDisplayHomeAsUpEnabled(true);

        Sistema.cliente = new ClienteDAO();

        SharedPreferences objSP = getSharedPreferences(LEMBRAR_LOGIN, MODE_PRIVATE);
        String email = objSP.getString("EMAIL", null);
        String senha = objSP.getString("SENHA", null);

        CheckBox chkLembrar = (CheckBox) findViewById(R.id.checkBox);
        chkLembrar.setChecked(false);

        txtEmail = (TextInputLayout) findViewById(R.id.txtEmail);
        txtSenha = (TextInputLayout) findViewById(R.id.txtSenha);

        if(email != null){
            chkLembrar.setChecked(true);

            txtEmail.getEditText().setText(email);
            txtSenha.getEditText().setText(senha);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    public void acessar(View view){

        objCliente.setEmail(txtEmail.getEditText().getText().toString().trim());
        objCliente.setSenha(txtSenha.getEditText().getText().toString().trim());

        if(objCliente.getEmail().isEmpty() || objCliente.getSenha().isEmpty()){
            Toast.makeText(this, "Usuário ou senha inválidos", Toast.LENGTH_LONG).show();
            return;
        }

        if(!objCliente.acessar()){
            Toast.makeText(this, "Usuário ou senha inválidos", Toast.LENGTH_LONG).show();
            return;
        }

        CheckBox chkLembrar = (CheckBox) findViewById(R.id.checkBox);

        SharedPreferences.Editor objSP = getSharedPreferences(LEMBRAR_LOGIN, MODE_PRIVATE).edit();

        if(chkLembrar.isChecked()){
            objSP.putString("EMAIL", objCliente.getEmail());
            objSP.putString("SENHA", objCliente.getSenha());
        }else{
            objSP.clear();
        }

        objSP.commit();

        Intent i = new Intent(this, SegurosActivity.class);
        startActivity(i);
    }
}