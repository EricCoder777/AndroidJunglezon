package com.daclink.androidjunglezon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ItemAddAdmin extends AppCompatActivity {

    RecyclerView.Recycler iaItemList;
    EditText iaItemName;
    EditText iaItemPrice;
    EditText iaItemQuant;
    Button iaAddItem;
    Button iaReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_add_admin);
    }






    public static Intent intentFactory(Context context){
        Intent intent = new Intent(context, ItemAddAdmin.class);

        return intent;
    }
}