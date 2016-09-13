package com.example.recyclerview;


import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.items.ItemInfoContainer;

public abstract class ItemHolder extends RecyclerView.ViewHolder {

    ItemHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind (ItemInfoContainer item);
}
