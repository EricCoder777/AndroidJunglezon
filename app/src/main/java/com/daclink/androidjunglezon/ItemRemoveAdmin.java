package com.daclink.androidjunglezon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ItemRemoveAdmin extends AppCompatActivity {

    RecyclerView.Recycler irRemoveItemList;
    Button irRemoveItem;
    Button irReturn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_remove_admin);
    }






    public static Intent intentFactory(Context context){
        Intent intent = new Intent(context, ItemRemoveAdmin.class);

        return intent;
    }
}