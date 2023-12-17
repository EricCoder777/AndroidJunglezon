package com.daclink.androidjunglezon;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.daclink.androidjunglezon.db.AppDatabase;

@Entity(tableName = AppDatabase.ITEM_TABLE)
public class Item {
    @PrimaryKey(autoGenerate = true)
    private int mItemID;
    @ColumnInfo(name = "mItemName")
    private String mItemName;
    private double mItemPrice;
    private Integer mItemQuantity;
    private String mItemDescription;

    public Item(String mItemName, double mItemPrice, Integer mItemQuantity, String mItemDescription){
        this.mItemName = mItemName;
        this.mItemPrice = mItemPrice;
        this.mItemQuantity = mItemQuantity;
        this.mItemDescription = mItemDescription;
    }

    public int getItemID() {
        return mItemID;
    }

    public void setItemID(int mItemID) {
        this.mItemID = mItemID;
    }

    public String getItemName() {
        return mItemName;
    }

    public void setItemName(String mItemName) {
        this.mItemName = mItemName;
    }

    public double getItemPrice() {
        return mItemPrice;
    }

    public void setItemPrice(double mItemPrice) {
        this.mItemPrice = mItemPrice;
    }

    public Integer getItemQuantity() {
        return mItemQuantity;
    }

    public void setItemQuantity(Integer mItemQuantity) {
        this.mItemQuantity = mItemQuantity;
    }

    public String getItemDescription() {
        return mItemDescription;
    }

    public void setItemDescription(String mItemDescription) {
        this.mItemDescription = mItemDescription;
    }
}
