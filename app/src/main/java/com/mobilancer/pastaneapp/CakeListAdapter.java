package com.mobilancer.pastaneapp;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobilancer.pastaneapp.model.Cake;

import java.util.List;

public class CakeListAdapter extends RecyclerView.Adapter<CakeListAdapter.CakeViewHolder> {

    private List<Cake> cakeList;
    private CustomOnClickListener customOnClickListener;
    public CakeListAdapter(List<Cake> cakeList, CustomOnClickListener customOnClickListener){
       this.cakeList = cakeList;
       this.customOnClickListener = customOnClickListener;
    }

    @Override
    public CakeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_single_cake_layout, parent, false);
        return new CakeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CakeViewHolder holder, int position) {
        final Cake cake = cakeList.get(position);
        holder.cakeName.setText(cake.getName());
        holder.cakeDesc.setText(cake.getDesc());
        holder.cakeAmount.setText(String.valueOf(cake.getAmount()));
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("elif", "clicked " + cake.getName());
                if (customOnClickListener != null){
                    customOnClickListener.onItemClicked(cake);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return cakeList.size();
    }

    public static class CakeViewHolder extends RecyclerView.ViewHolder{

        ImageView cakeImage;
        TextView cakeName;
        TextView cakeDesc;
        TextView cakeAmount;
        View rootView;

        public CakeViewHolder(View itemView) {
            super(itemView);
            cakeImage = itemView.findViewById(R.id.ivCake);
            cakeName = itemView.findViewById(R.id.txtCakeName);
            cakeDesc = itemView.findViewById(R.id.txtCakeDesc);
            cakeAmount = itemView.findViewById(R.id.txtCakeAmount);
            rootView = itemView;
        }
    }
}
