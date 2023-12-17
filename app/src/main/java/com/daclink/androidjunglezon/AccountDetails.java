package com.daclink.androidjunglezon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class AccountDetails extends AppCompatActivity {

    RecyclerView.Recycler acAccountList;
    Button acCancel;
    Button acReturn;
    TextView acUserWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);





    }







    public static Intent intentFactory(Context context){
        Intent intent = new Intent(context, AccountDetails.class);

        return intent;
    }
}