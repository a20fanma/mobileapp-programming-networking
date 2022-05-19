package com.example.networking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MountainAdapter extends RecyclerView.Adapter<MountainAdapter.MountainHolder> {

    private Context context;
    private ArrayList<Mountain> mountains;

    public MountainAdapter(Context context, ArrayList<Mountain> mountains) {
        this.context = context;
        this.mountains = mountains;
    }



    @NonNull
    @Override
    public MountainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mountain_layout_item,parent,false);
        return new MountainHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MountainAdapter.MountainHolder holder, int position) {

        Mountain mountain = mountains.get(position);

    }

    @Override
    public int getItemCount() {
        return mountains.size();
    }

    class MountainHolder extends RecyclerView.ViewHolder{

        public MountainHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
