package com.daclink.androidjunglezon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class AdminArea extends AppCompatActivity {

    TextView adAdminName;
    Button adAddItems;
    Button adDeleteItems;
    Button adDeleteUsers;
    Button adReturn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_area);
    }








    public static Intent intentFactory(Context context){
        Intent intent = new Intent(context, AdminArea.class);

        return intent;
    }
}