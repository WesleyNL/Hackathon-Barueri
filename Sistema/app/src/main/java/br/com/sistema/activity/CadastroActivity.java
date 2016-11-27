package br.com.sistema.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.sistema.R;
import br.com.sistema.business.Cliente;
import br.com.sistema.business.ClienteBD;
import br.com.sistema.business.ClienteDAO;

public class CadastroActivity extends AppCompatActivity {

    public ClienteDAO objClienteDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        objClienteDAO = new ClienteDAO(new ClienteBD(this));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    public void salvar(View view){

        EditText txtNome = (EditText) findViewById(R.id.txtNome);
        objClienteDAO.setNome(txtNome.getText().toString().trim());

        EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
        objClienteDAO.setEmail(txtEmail.getText().toString().trim());

        EditText txtSenha = (EditText) findViewById(R.id.txtSenha);
        objClienteDAO.setSenha(txtSenha.getText().toString().trim());

        EditText txtSenhaConf = (EditText) findViewById(R.id.txtConfirmarSenha);

        if(objClienteDAO.getSenha().equalsIgnoreCase(txtSenhaConf.getText().toString())){
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
            finish();
        }else{
            Toast.makeText(this, "Login já cadastrado", Toast.LENGTH_LONG).show();
        }
    }
}
