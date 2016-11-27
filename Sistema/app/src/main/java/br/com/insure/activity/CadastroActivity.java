package br.com.insure.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.insure.R;
import br.com.insure.business.ClienteBD;
import br.com.insure.business.ClienteDAO;

public class CadastroActivity extends AppCompatActivity {

    public ClienteDAO objClienteDAO;

    public TextInputLayout txtNome;
    public TextInputLayout txtEmail;
    public TextInputLayout txtSenha;
    public TextInputLayout txtSenhaConf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

//        getActionBar().setDisplayHomeAsUpEnabled(true);

        objClienteDAO = new ClienteDAO(new ClienteBD(this));

        txtNome = (TextInputLayout) findViewById(R.id.txtNome);
        txtEmail = (TextInputLayout) findViewById(R.id.txtEmail);
        txtSenha = (TextInputLayout) findViewById(R.id.txtSenha);
        txtSenhaConf = (TextInputLayout) findViewById(R.id.txtConfirmarSenha);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    public void salvar(View view){

        objClienteDAO.setNome(txtNome.getEditText().getText().toString().trim());
        objClienteDAO.setEmail(txtEmail.getEditText().getText().toString().trim());
        objClienteDAO.setSenha(txtSenha.getEditText().getText().toString().trim());

        if(!objClienteDAO.getSenha().equalsIgnoreCase(txtSenhaConf.getEditText().getText().toString())){
            Toast.makeText(this, "Senha inválida", Toast.LENGTH_LONG).show();
            return;
        }

        if(objClienteDAO.getNome().isEmpty() || objClienteDAO.getEmail().isEmpty() || objClienteDAO.getSenha().isEmpty()){
            Toast.makeText(this, "Dados inválidos", Toast.LENGTH_LONG).show();
            return;
        }

        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);

        dialogo.setTitle("Confirmar");
        dialogo.setMessage("Deseja realmente salvar?");
        dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                salvar();
            }
        });
        dialogo.setNegativeButton("Não", null);
        dialogo.show();
    }

    public void salvar(){
        if(objClienteDAO.salvar()){
            Toast.makeText(this, "Usuário cadastrado com sucesso", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "Login já cadastrado", Toast.LENGTH_LONG).show();
        }
    }
}
