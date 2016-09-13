package com.example.recyclerviewtest;


import android.content.Context;

import com.example.dbwork.DBWorker;
import com.example.items.ItemFolder;
import com.example.items.ItemInfoContainer;
import com.example.items.ItemNote;

import java.util.ArrayList;

public class ItemPacker {

    private static ItemPacker sItemPacker;
    private static ArrayList<ItemInfoContainer> recyclerViewItemList;

    ArrayList<ItemFolder> arrayListFolder;
    ArrayList<ItemNote> arrayListNote;
    DBWorker dbWorker;

    private ItemPacker(Context context) {

        dbWorker = new DBWorker(context);
        recyclerViewItemList = new ArrayList<>();
        arrayListFolder = dbWorker.getListFolder();
        arrayListNote = dbWorker.getListNote();

        for (int folderPos = 0; folderPos < arrayListFolder.size(); folderPos++) {
            recyclerViewItemList.add(arrayListFolder.get(folderPos));
            for (int notePosition = 0; notePosition < arrayListNote.size(); notePosition++) {
                //folder id = folder position in List +1
                if (arrayListNote.get(notePosition).getIdParentFolder() == folderPos + 1) {
                    recyclerViewItemList.add(arrayListNote.get(notePosition));
                }
            }
        }
    }

    public static ArrayList<ItemInfoContainer> getResultItemList(Context context) {
        if (sItemPacker == null) {
            sItemPacker = new ItemPacker(context);
        }
        return recyclerViewItemList;
    }
}