package com.example.recyclerview;


import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.example.items.ItemFolder;
import com.example.items.ItemInfoContainer;
import com.example.recyclerviewtest.R;

public class FolderItemHolder extends ItemHolder {
    private TextView itemNameTextView;
    View itemView;

    public FolderItemHolder(View itemView) {
        super(itemView);
        itemNameTextView = (TextView) itemView.findViewById(R.id.title);
        this.itemView = itemView;
    }

    @Override
    public void bind(ItemInfoContainer item) {
        itemNameTextView.setText(((ItemFolder)item).getName());
        itemView.setBackgroundColor(Color.parseColor(((ItemFolder)item).getColor()));
    }


}
