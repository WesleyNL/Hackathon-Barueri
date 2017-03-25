package br.com.insure.activity;

import br.com.insure.R;
import br.com.insure.business.ContratoDAO;
import br.com.insure.business.Veiculo;
import br.com.insure.utilidades.FuncoesData;
import br.com.insure.utilidades.Utils;

import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class CadastrarPropostaActivity extends AppCompatActivity {

    private CadastrarPropostaAbasActivity adapter;

    public static ContratoDAO objContratoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_proposta);

        objContratoDAO = new ContratoDAO();

        adapter = new CadastrarPropostaAbasActivity(getSupportFragmentManager(), this);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);
    }

    public void enviar(View view){

        objContratoDAO.setVeiculo(objVeiculo);

        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);

        dialogo.setTitle("Confirmar");
        dialogo.setMessage("Deseja realmente salvarProposta?");
        dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                enviar();
            }
        });
        dialogo.setNegativeButton("Não", null);
        dialogo.show();
    }

    public void enviar(){
        if(objContratoDAO.salvarProposta()){
            Toast.makeText(this, "Enviado com sucesso", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, ContratoActivity.class);
            i.putExtra("ID", objContratoDAO.getId());
            startActivity(i);
        }else{
            Toast.makeText(this, "Não foi possível salvarProposta", Toast.LENGTH_LONG).show();
        }
    }
}
