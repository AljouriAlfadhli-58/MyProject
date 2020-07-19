package com.example.mahaasel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class FarmAdapter extends RecyclerView.Adapter<FarmAdapter.ViewHolder>{
    ArrayList<MyFarms> myFarms;
    Context context;

    public FarmAdapter(Context context,ArrayList<MyFarms> myFarms){
        this.context = context;
        this.myFarms = myFarms;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_farms_list_item_2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.imageView.setImageResource(myFarms.get(position).getLangImg());
        holder.textView.setText(myFarms.get(position).getLangName());
        holder.textView2.setText(myFarms.get(position).getLangTime());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( myFarms.get(position).getKey()==1){
                    Intent i = new Intent(context,details.class);
                    context.startActivity(i);
                }
                else if (myFarms.get(position).getKey()==2){
                    Intent i2 = new Intent(context,details2.class);
                    context.startActivity(i2);
                }
                else{
                    Intent i3 = new Intent(context,details3.class);
                    context.startActivity(i3);
                }

            }
        });
    }


    @Override
    public int getItemCount() {
        return myFarms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;
        public TextView textView2;
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            imageView = itemView.findViewById(R.id.imageView2);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView6);
        }
    }
}
