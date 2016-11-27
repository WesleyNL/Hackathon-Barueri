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

/**
 * Created by Jefferson on 26/11/2016.
 */
public class ContratosAdapter extends RecyclerView.Adapter<ContratosAdapter.ViewHolder> {

    private Context context;
    private LinkedList<Contrato> contratos;

    public ContratosAdapter(Context context, LinkedList<Contrato> contratos) {
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
        holder.txtID.setText(contratos.get(position).getId());
        holder.setPosicao(position);
    }

    @Override
    public int getItemCount() {
        return contratos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView txtID;
        private int posicao;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            txtID = (TextView) itemView.findViewById(R.id.txtID);
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
