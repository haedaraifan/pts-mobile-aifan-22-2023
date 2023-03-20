package com.example.ptsresepmakanan;

public class ChildItemModel {

    int imageUrl;
    String itemName, itemDesc, itemIngredients, itemSteps;

    public ChildItemModel(String itemName, int imageUrl, String itemDesc, String itemIngredients, String itemSteps) {
        this.itemName = itemName;
        this.imageUrl = imageUrl;
        this.itemDesc = itemDesc;
        this.itemIngredients = itemIngredients;
        this.itemSteps = itemSteps;
    }

    public void setImageUrl(int imageUrl) {this.imageUrl = imageUrl;}
    public void setItemName(String itemName) {this.itemName = itemName;}
    public void setItemDesc(String itemDesc) {this.itemDesc = itemDesc;}
    public void setItemIngredients(String itemIngredients) {this.itemIngredients = itemIngredients;}
    public void setItemSteps(String itemSteps) {this.itemSteps = itemSteps;}

    public int getImageUrl() {return imageUrl;}
    public String getItemName() {return itemName;}
    public String getItemDesc() {return itemDesc;}
    public String getItemIngredients() {return itemIngredients;}
    public String getItemSteps() {return itemSteps;}

}
