package br.com.insure.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.insure.R;
import br.com.insure.business.ContratoDAO;
import br.com.insure.business.Veiculo;
import br.com.insure.utilidades.FuncoesData;
import br.com.insure.utilidades.Utils;

import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

public class CadastrarPropostaActivity extends AppCompatActivity {

    private final int FOTO_FRONTAL = 0;
    private final int FOTO_LATERAL = 1;

    private ContratoDAO objContratoDAO;

    private ImageButton imgFotoFrontal;
    private ImageButton imgFotoLateral;

    private TextInputLayout txtModelo;
    private TextInputLayout txtAno;
    private TextInputLayout txtTempoHabilitacao;
    private CheckBox chkOutrosMotoristas;
    private CheckBox chkAlarme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_proposta);

        objContratoDAO = new ContratoDAO();

        imgFotoFrontal = (ImageButton) findViewById(R.id.imgFotoFrontal);
        imgFotoLateral = (ImageButton) findViewById(R.id.imgFotoLateral);

        txtTempoHabilitacao = (TextInputLayout) findViewById(R.id.txtTempoHabilitacao);;
        txtModelo = (TextInputLayout) findViewById(R.id.txtModelo);
        txtAno = (TextInputLayout) findViewById(R.id.txtAno);;
        chkOutrosMotoristas = (CheckBox) findViewById(R.id.chkOutrosMotoristas);
        chkAlarme = (CheckBox) findViewById(R.id.chkAlarme);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
        case FOTO_FRONTAL:
            if (resultCode == RESULT_OK) {
                imgFotoFrontal.setImageURI(data.getData());
            }
            break;
        case FOTO_LATERAL:
            if (resultCode == RESULT_OK) {
                imgFotoLateral.setImageURI(data.getData());
            }
            break;
        }
    }

    public void enviarFotoFrontal(View view) {
        encontrarFoto(FOTO_FRONTAL);
    }

    public void enviarFotoLateral(View view) {
        encontrarFoto(FOTO_LATERAL);
    }

    private void encontrarFoto(int foto) {
        startActivityForResult(Utils.getPickImageIntent(this), foto);
    }

    public void enviar(View view){

        Veiculo objVeiculo = new Veiculo();
        objVeiculo.setAlarme(chkAlarme.isChecked() ? (byte) 1 : (byte) 0);
        objVeiculo.setAno(Integer.parseInt(txtAno.getEditText().getText().toString()));
        objVeiculo.setModelo(txtModelo.getEditText().getText().toString());
        objVeiculo.setOutrosMotoristas(chkOutrosMotoristas.isChecked() ? (byte) 1 : (byte) 0);
        objVeiculo.setTempoHabilitacao(FuncoesData.toDate(txtTempoHabilitacao.getEditText().getText().toString(), FuncoesData.DDMMYYYY));
        objVeiculo.setBmpFotoFrontal(((BitmapDrawable) imgFotoFrontal.getDrawable()).getBitmap());
        objVeiculo.setBmpFotoLateral(((BitmapDrawable) imgFotoLateral.getDrawable()).getBitmap());

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
