package com.daclink.androidjunglezon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.daclink.androidjunglezon.db.AppDatabase;
import com.daclink.androidjunglezon.db.JungleDAO;

import java.util.regex.Pattern;

public class CreateAccount extends AppCompatActivity {

    EditText crUsername;
    EditText crPassword;
    Button crCreateAcct;
    Button crReturn;
    JungleDAO mJungleDAO;
    private String mUserName;
    private String mUserPassword;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        crUsername = findViewById(R.id.caUsername);
        crPassword = findViewById(R.id.caPassword);
        crCreateAcct = findViewById(R.id.caCreateAcctButton);
        crReturn = findViewById(R.id.caReturnButton);

        crCreateAcct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserName = crUsername.getText().toString().trim();
                mUserPassword = crPassword.getText().toString().trim();
                if(!checkDatabase()){
                        User user = new User(mUserName,mUserPassword);
                        mJungleDAO.insert(user);
                    Toast.makeText(CreateAccount.this, "Account Created, Please Return To Log In", Toast.LENGTH_SHORT).show();
                }
            }
        });
        crReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = MainActivity.intentFactory(getApplicationContext(),mUser.getUserID());
                startActivity(intent);
            }
        });


        mJungleDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getJungleDAO();
    }

    private boolean checkDatabase(){
        mUser = mJungleDAO.getUserByName(mUserName);
        if(mUser == null){
            //throw bad username message
            return false;
        }
        return true;
    }

    public static Intent intentFactory(Context context){
        Intent intent = new Intent(context, CreateAccount.class);

        return intent;
    }
}