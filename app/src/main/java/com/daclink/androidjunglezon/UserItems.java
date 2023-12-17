package com.daclink.androidjunglezon;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.daclink.androidjunglezon.db.AppDatabase;

@Entity(tableName = AppDatabase.USER_ITEM_TABLE)
public class UserItems {
    @PrimaryKey(autoGenerate = true)
    private int mUserItemID;
    private String mItemName;
    private double mItemPrice;
    private Integer mItemQuantity;
    private String mItemDescription;
    private int mUserID;

    UserItems(String mItemName, double mItemPrice, Integer mItemQuantity, String mItemDescription, int mUserID){
        this.mItemName = mItemName;
        this.mItemPrice = mItemPrice;
        this.mItemQuantity = mItemQuantity;
        this.mItemDescription = mItemDescription;
        this.mUserID = mUserID;
    }

    public int getUserItemID() {
        return mUserItemID;
    }

    public void setUserItemID(int mUserItemID) {
        this.mUserItemID = mUserItemID;
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

    public int getUserID() {
        return mUserID;
    }

    public void setUserID(int mUserID) {
        this.mUserID = mUserID;
    }
}
