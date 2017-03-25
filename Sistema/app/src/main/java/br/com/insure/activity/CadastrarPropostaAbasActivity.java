package br.com.insure.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.LinkedList;

/**
 * Created by Jefferson on 21/05/2016.
 */
public class CadastrarPropostaAbasActivity extends FragmentPagerAdapter {
    private LinkedList<Object> abasFragmentos = new LinkedList<Object>();

    public CadastrarPropostaAbasActivity(FragmentManager fm, Context context) {
        super(fm);

        abasFragmentos.add(0, PerfilUsuarioFragment.newInstance());
        abasFragmentos.add(1, PerfilVeiculoFragment.newInstance());
    }

    @Override
    public int getCount() {
        return abasFragmentos.size();
    }

    @Override
    public Fragment getItem(int position) {
        return (Fragment) abasFragmentos.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "";
    }
}