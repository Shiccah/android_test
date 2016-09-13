package com.example.dbwork;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.items.ItemFolder;
import com.example.items.ItemNote;

import java.util.ArrayList;


public class DBWorker {

    public static final String TABLE_FOLDERS = "folders";
    public static final String TABLE_NOTES = "notes";

    public static final String FOLDER_NAME = "name";
    public static final String FOLDER_COLOR = "color";

    public static final String NOTE_PARENT_FOLDER_ID = "folder_id";
    public static final String NOTE_TITLE = "title";
    public static final String NOTE_CONTENT = "content";


    DBHelper dbHelper;
    ArrayList<ItemFolder> arrayListFolder;
    ArrayList<ItemNote> arrayListNote;

    SQLiteDatabase dataBase;

    public DBWorker(Context context) {
        dbHelper = new DBHelper(context);
        dataBase = dbHelper.openDataBase();
        getDataFromDataBase();
    }

    public ArrayList<ItemFolder> getListFolder() {
        return arrayListFolder;
    }

    public ArrayList<ItemNote> getListNote() {
        return arrayListNote;
    }

    private void getDataFromDataBase(){
        if(dataBase == null) throw new RuntimeException("No database connection (dataBase == null)");
        getListItemFromDB(TABLE_FOLDERS, new String[]{FOLDER_NAME, FOLDER_COLOR});
        getListItemFromDB(TABLE_NOTES, new String[]{NOTE_PARENT_FOLDER_ID, NOTE_TITLE, NOTE_CONTENT});
    }

    private void getListItemFromDB(String tableName, String[] column) {

        if (arrayListFolder == null || arrayListNote == null) {
            arrayListFolder = new ArrayList<>();
            arrayListNote  = new ArrayList<>();
        }

        Cursor cursor = dataBase.query(tableName, column, null, null, null, null, null);
        cursor.moveToFirst();

        if (tableName.equals(TABLE_FOLDERS)) {
            do {
                arrayListFolder.add(new ItemFolder(cursor.getString(cursor.getColumnIndex(column[0])),
                        cursor.getString(cursor.getColumnIndex(column[1]))));
            } while (cursor.moveToNext());
        } else if (tableName.equals(TABLE_NOTES)) {
            do {
                arrayListNote.add(new ItemNote(cursor.getInt(cursor.getColumnIndex(column[0])),
                        cursor.getString(cursor.getColumnIndex(column[1])),
                        cursor.getString(cursor.getColumnIndex(column[2]))));
            } while (cursor.moveToNext());
        } else {
            throw new IllegalArgumentException("Unknown table name.");
        }
        cursor.close();
    }
}
