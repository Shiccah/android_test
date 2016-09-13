package com.example.items;

public class ItemNote extends ItemInfoContainer{

    int idParentFolder;
    String title;
    String content;

    public ItemNote(int idParentFolder, String title, String content){
        this.setParentFolder(idParentFolder);
        this.setContent(content);
        this.setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    public ItemNote setTitle(String title){
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public ItemNote setContent(String content) {
        this.content = content;
        return this;
    }

    public int getIdParentFolder() {
        return idParentFolder;
    }

    public ItemNote setParentFolder(int idParentFolder) {
        this.idParentFolder = idParentFolder;
        return this;
    }
}
