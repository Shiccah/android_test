package com.example.recyclerview;


import android.view.View;
import android.widget.TextView;

import com.example.items.ItemInfoContainer;
import com.example.items.ItemNote;
import com.example.recyclerviewtest.R;

public class NoteItemHolder extends ItemHolder {
    private TextView itemTitleTextView;
    private TextView itemContentTextView;

    public NoteItemHolder(View itemView) {
        super(itemView);
        itemTitleTextView = (TextView) itemView.findViewById(R.id.title);
        itemContentTextView = (TextView) itemView.findViewById(R.id.content);
    }

    @Override
    public void bind(ItemInfoContainer item) {
        itemTitleTextView.setText(((ItemNote)item).getTitle());
        itemContentTextView.setText(((ItemNote)item).getContent());
    }


}
