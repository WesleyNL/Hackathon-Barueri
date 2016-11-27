package br.com.insure.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import br.com.insure.R;
import br.com.insure.activity.ContratoActivity;
import br.com.insure.business.Contrato;
import br.com.insure.business.ContratoDAO;

/**
 * Created by Jefferson on 26/11/2016.
 */
public class ContratosAdapter extends RecyclerView.Adapter<ContratosAdapter.ViewHolder> {

    private Context context;
    private LinkedList<ContratoDAO> contratos;

    public ContratosAdapter(Context context, LinkedList<ContratoDAO> contratos) {
        this.context = context;
        this.contratos = contratos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.frame_contratos, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.lblID.setText(String.valueOf(contratos.get(position).getId()));
        holder.setPosicao(position);
    }

    @Override
    public int getItemCount() {
        return contratos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView lblID;
        private int posicao;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            lblID = (TextView) itemView.findViewById(R.id.lblID);
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent(view.getContext(), ContratoActivity.class);
            i.putExtra("ID", contratos.get(posicao).getId());
            view.getContext().startActivity(i);
        }

        public void setPosicao(int posicao) {
            this.posicao = posicao;
        }
    }


}
