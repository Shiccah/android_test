package com.example.recyclerviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.items.ItemInfoContainer;
import com.example.recyclerview.UserItemAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private UserItemAdapter mAdapter;
    private RecyclerView mRecyclerView;
    public static MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivity = this;

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<ItemInfoContainer> itemList = ItemPacker.getResultItemList(this);
        mAdapter = new UserItemAdapter(itemList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
