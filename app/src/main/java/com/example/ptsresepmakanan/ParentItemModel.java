package com.example.ptsresepmakanan;

import java.util.List;

public class ParentItemModel {
    String categoryTitle;
    List<ChildItemModel> childItemModelList;

    public ParentItemModel(String categoryTitle, List<ChildItemModel> childItemModelList) {
        this.categoryTitle = categoryTitle;
        this.childItemModelList = childItemModelList;
    }

    public void setCategoryTitle(String categoryTitle) {this.categoryTitle = categoryTitle;}
    public void setChildItemModelList(List<ChildItemModel> childItemModelList) {this.childItemModelList = childItemModelList;}

    public String getCategoryTitle() {return categoryTitle;}
    public List<ChildItemModel> getChildItemModelList() {return childItemModelList;}
}
