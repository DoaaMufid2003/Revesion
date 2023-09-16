package com.example.revesion.FragmenttoFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.revesion.databinding.CustomitemBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    ArrayList<Name> nameArrayList;
    Context context;
    MyLestiner lestiner;
    First3Fragment.OnFragmentClicklisener onFragmentClicklisener;



    public Adapter(ArrayList<Name> nameArrayList,MyLestiner lestiner, First3Fragment.OnFragmentClicklisener onFragmentClicklisener) {
        this.nameArrayList =nameArrayList ;
        this.lestiner=lestiner;
        this.onFragmentClicklisener=onFragmentClicklisener;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomitemBinding binding=CustomitemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int pos=position;
Name name=nameArrayList.get(pos);
holder.name.setText(name.getName());
//lestiner.onclick(nameArrayList.get(pos));
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      lestiner.onclick(nameArrayList.get(pos));
    }
});
    }

    @Override
    public int getItemCount() {
        return nameArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        Name names;

        public MyViewHolder(@NonNull CustomitemBinding binding) {
            super(binding.getRoot());
            name=binding.textView;
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lestiner.onclick(names);
                }
            });


        }
    }
}
