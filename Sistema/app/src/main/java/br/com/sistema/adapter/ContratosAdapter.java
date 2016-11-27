package br.com.sistema.adapter;

import android.preference.EditTextPreference;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashSet;
import java.util.LinkedList;

import br.com.sistema.R;

/**
 * Created by Jefferson on 26/11/2016.
 */
public class ContratosAdapter extends RecyclerView.Adapter<ContratosAdapter.ViewHolder> {

    private LinkedList<Contrato> contratos;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.frame_contratos, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtID.setText(contratos.get(position).getID());
        holder.txtNomeBem.setText(contratos.get(position).getNomeBem());
    }

    @Override
    public int getItemCount() {
        return contratos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtID;
        public TextView txtNomeBem;

        public ViewHolder(View itemView) {
            super(itemView);

            txtID = (TextView) itemView.findViewById(R.id.txtID);
            txtNomeBem = (TextView) itemView.findViewById(R.id.txtNomeBem);
        }
    }
}
