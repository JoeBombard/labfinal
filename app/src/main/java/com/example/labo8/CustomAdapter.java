package com.example.labo8;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    ArrayList<Banane> bananes;
    MainActivity2 select;
    public CustomAdapter(ArrayList<Banane> banane, MainActivity2 mainActivity2){
        bananes = banane;
        select = mainActivity2;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bananeconvertion,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setUniterView(bananes.get(position).getUnite());
        holder.setValeurView((bananes.get(position).getValeur()));
        holder.setImage();
    }

    @Override
    public int getItemCount() {
        return bananes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

    TextView uniterView;
    TextView valeurView;
    ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);/**/
            itemView.setOnClickListener(view ->      {
                Snackbar.make(view, R.string.test, Snackbar.LENGTH_LONG).show();


                Intent intent= new Intent();
                intent.putExtra("rate", bananes.get(getAdapterPosition()));   //set new password bananes.get(getAdapterPosition())
                select.setResult(Activity.RESULT_OK, intent); // set your result
                select.finish(); // return back to MainActivity

            });
            uniterView = itemView.findViewById(R.id.uniterdanslayout);
            valeurView = itemView.findViewById(R.id.valeurdanslayout);
            imageView = itemView.findViewById(R.id.imageViewLayout);

        }
        public void setUniterView(int uniter){uniterView.setText(uniter);}
        public void setValeurView(int valeur){valeurView.setText(valeur);}
        public void setImage(){imageView.setImageResource(R.drawable.scale);}



    }
}
