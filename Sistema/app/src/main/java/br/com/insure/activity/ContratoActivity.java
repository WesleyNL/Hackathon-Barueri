package br.com.insure.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.Format;

import br.com.insure.R;
import br.com.insure.business.ContratoDAO;
import br.com.insure.utilidades.FuncoesData;

/**
 * Created by Wesley on 27/11/2016.
 */
public class ContratoActivity extends AppCompatActivity {

    private ContratoDAO objContratoDAO;

    private Button btnDownload;

    private ImageButton imgFotoFrontal;
    private ImageButton imgFotoLateral;

    private TextInputLayout txtModelo;
    private TextInputLayout txtAno;
    private TextInputLayout txtTempoHabilitacao;
    private CheckBox chkOutrosMotoristas;
    private CheckBox chkAlarme;
    private TextView lblSituacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrato);

        objContratoDAO = new ContratoDAO();

        imgFotoFrontal = (ImageButton) findViewById(R.id.imgFotoFrontal);
        imgFotoLateral = (ImageButton) findViewById(R.id.imgFotoLateral);

        txtTempoHabilitacao = (TextInputLayout) findViewById(R.id.txtTempoHabilitacao);;
        txtModelo = (TextInputLayout) findViewById(R.id.txtModelo);
        txtAno = (TextInputLayout) findViewById(R.id.txtAno);;
        chkOutrosMotoristas = (CheckBox) findViewById(R.id.chkOutrosMotoristas);
        chkAlarme = (CheckBox) findViewById(R.id.chkAlarme);

        lblSituacao = (TextView) findViewById(R.id.lblSituacaoContrato);

        btnDownload = (Button) findViewById(R.id.btnDownloadContrato);

        int id = Integer.parseInt(getIntent().getExtras().get("ID").toString());

        objContratoDAO.setId(id);

        carregar();
    }

    public void carregar(){

        objContratoDAO.carregar();

        imgFotoFrontal.setImageBitmap(objContratoDAO.getVeiculo().getBmpFotoFrontal());
        imgFotoLateral.setImageBitmap(objContratoDAO.getVeiculo().getBmpFotoLateral());
        txtTempoHabilitacao.getEditText().setText(FuncoesData.formatDate(objContratoDAO.getData(), FuncoesData.DDMMYYYY));
        txtModelo.getEditText().setText(objContratoDAO.getVeiculo().getModelo());
        txtAno.getEditText().setText(objContratoDAO.getVeiculo().getAno());
        chkAlarme.setChecked(objContratoDAO.getVeiculo().getAlarme() == 1);
        chkOutrosMotoristas.setChecked(objContratoDAO.getVeiculo().getOutrosMotoristas() == 1);

        switch(objContratoDAO.getSituacao()) {
            case 1:
                lblSituacao.setText("Enviado");
                btnDownload.setEnabled(false);
                break;
            case 2:
                lblSituacao.setText("Processando");
                btnDownload.setEnabled(false);
                break;
            case 3:
                lblSituacao.setText("Processado");
                btnDownload.setEnabled(true);
                break;
            default:
                break;
        }
    }

    public void downloadContrato(View view){

    }
}
