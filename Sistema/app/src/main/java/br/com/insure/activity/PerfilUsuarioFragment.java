package br.com.insure.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import br.com.insure.R;

/**
 * Created by Jefferson on 16/05/2016.
 */
public class PerfilUsuarioFragment extends Fragment {

    private TextInputLayout txtTempoHabilitacao;
    private TextInputLayout txtIdade;
    private TextInputLayout txtCepMora;
    private TextInputLayout txtCepTrabalha;

    public static PerfilUsuarioFragment newInstance() {
        return new PerfilUsuarioFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastrar_perfil, container, false);

        carregarComponentes(view);

        return view;
    }

    private void carregarComponentes(View view) {
        txtTempoHabilitacao = (TextInputLayout) view.findViewById(R.id.txtTempoHabilitacao);
        txtIdade = (TextInputLayout) view.findViewById(R.id.txtIdade);
        txtCepMora = (TextInputLayout) view.findViewById(R.id.txtCepMora);
        txtCepTrabalha = (TextInputLayout) view.findViewById(R.id.txtCepTrabalha);
    }
}
