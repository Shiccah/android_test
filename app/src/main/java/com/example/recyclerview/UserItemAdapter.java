package com.example.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.items.ItemFolder;
import com.example.items.ItemInfoContainer;
import com.example.items.ItemNote;
import com.example.recyclerviewtest.MainActivity;
import com.example.recyclerviewtest.R;

import java.util.List;

public class UserItemAdapter extends RecyclerView.Adapter<ItemHolder> {

    private List<ItemInfoContainer> mItems;
    private int TYPE_FOLDER =0;
    private int TYPE_NOTE =1;

    public UserItemAdapter(List<ItemInfoContainer> listItems) {
        mItems = listItems;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = MainActivity.mainActivity.getLayoutInflater();
        View view = null;
        if(viewType == TYPE_FOLDER) {
            view = li.inflate(R.layout.list_folder, parent, false);
            return new FolderItemHolder(view);
        } else if(viewType == TYPE_NOTE){
            view = li.inflate(R.layout.list_note, parent, false);
            return new NoteItemHolder(view);
        }
        throw new RuntimeException("the type of Item is not defined");
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        ItemInfoContainer item = mItems.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(mItems.get(position) instanceof ItemFolder){
            return TYPE_FOLDER;
        } else if(mItems.get(position) instanceof ItemNote){
            return TYPE_NOTE;
        }
        throw new RuntimeException("Unknown type");
    }
}
