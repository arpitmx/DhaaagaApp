package com.india.suidhaga;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{
    public ImageView productimage;
    public TextView textTitle;
    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        textTitle = itemView.findViewById(R.id.title_header);
        productimage= itemView.findViewById(R.id.image);
    }
    @Override
    public void onClick(View view) {
    }
}