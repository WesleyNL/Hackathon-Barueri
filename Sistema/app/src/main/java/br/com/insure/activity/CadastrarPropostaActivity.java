package br.com.insure.activity;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.insure.R;
import br.com.insure.utilidades.Utils;
import android.widget.ImageButton;

public class CadastrarPropostaActivity extends AppCompatActivity {

    private final int FOTO_FRONTAL = 0;
    private final int FOTO_LATERAL = 1;

    private ImageButton imgFotoFrontal;
    private ImageButton imgFotoLateral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_proposta);

        imgFotoFrontal = (ImageButton) findViewById(R.id.imgFotoFrontal);
        imgFotoLateral = (ImageButton) findViewById(R.id.imgFotoLateral);
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
}
