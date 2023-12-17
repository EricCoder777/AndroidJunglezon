package com.daclink.androidjunglezon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class UsersAdmin extends AppCompatActivity {

    RecyclerView.Recycler uaUserlist;
    Button uaDeleteUser;
    Button uaReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_admin);
    }







    public static Intent intentFactory(Context context){
        Intent intent = new Intent(context, UsersAdmin.class);

        return intent;
    }
}