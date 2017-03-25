package br.com.insure.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import br.com.insure.R;
import br.com.insure.business.Veiculo;
import br.com.insure.utilidades.FuncoesData;
import br.com.insure.utilidades.Utils;

/**
 * Created by Jefferson on 27/11/2016.
 */
public class PerfilVeiculoFragment extends Fragment {

    private final int FOTO_FRONTAL = 0;
    private final int FOTO_LATERAL = 1;

    private ImageView imgFotoFrontal;
    private ImageView imgFotoLateral;

    private TextInputLayout txtModelo;
    private TextInputLayout txtAno;

    private CheckBox chkOutrosMotoristas;
    private CheckBox chkAlarme;

    public static PerfilUsuarioFragment newInstance() {
        return new PerfilUsuarioFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastrar_perfil, container, false);

        carregarComponentes(view);

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case FOTO_FRONTAL:
                if (resultCode == AppCompatActivity.RESULT_OK) {
                    imgFotoFrontal.setImageURI(data.getData());
                }
                break;
            case FOTO_LATERAL:
                if (resultCode == AppCompatActivity.RESULT_OK) {
                    imgFotoLateral.setImageURI(data.getData());
                }
                break;
        }
    }

    public void enviarFotoFrontal(View view) {
        encontrarFoto(view.getContext(), FOTO_FRONTAL);
    }

    public void enviarFotoLateral(View view) {
        encontrarFoto(view.getContext(), FOTO_LATERAL);
    }

    private void encontrarFoto(Context context, int foto) {
        startActivityForResult(Utils.getPickImageIntent(context), foto);
    }

    private void carregarComponentes(View view) {
        imgFotoFrontal = (ImageView) view.findViewById(R.id.imgFotoFrontal);
        imgFotoFrontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarFotoFrontal(v);
            }
        });
        imgFotoLateral = (ImageView) view.findViewById(R.id.imgFotoLateral);
        imgFotoLateral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarFotoLateral(v);
            }
        });

        txtModelo = (TextInputLayout) view.findViewById(R.id.txtModelo);
        txtAno = (TextInputLayout) view.findViewById(R.id.txtAno);;
        chkOutrosMotoristas = (CheckBox) view.findViewById(R.id.chkOutrosMotoristas);
        chkAlarme = (CheckBox) view.findViewById(R.id.chkAlarme);
    }

    public void enviar(View view) {
        Veiculo objVeiculo = new Veiculo();
        objVeiculo.setAlarme(chkAlarme.isChecked() ? (byte) 1 : 0);
        objVeiculo.setAno(Integer.parseInt(txtAno.getEditText().getText().toString()));
        objVeiculo.setModelo(txtModelo.getEditText().getText().toString());
        objVeiculo.setOutrosMotoristas(chkOutrosMotoristas.isChecked() ? (byte) 1 : 0);
        objVeiculo.setTempoHabilitacao(FuncoesData.toDate(txtTempoHabilitacao.getEditText().getText().toString(), FuncoesData.DDMMYYYY));
        objVeiculo.setBmpFotoFrontal(((BitmapDrawable) imgFotoFrontal.getDrawable()).getBitmap());
        objVeiculo.setBmpFotoLateral(((BitmapDrawable) imgFotoLateral.getDrawable()).getBitmap());
    }
}