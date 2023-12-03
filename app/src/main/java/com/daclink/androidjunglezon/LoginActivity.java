package com.daclink.androidjunglezon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.daclink.androidjunglezon.db.AppDatabase;
import com.daclink.androidjunglezon.db.JungleDAO;

public class LoginActivity extends AppCompatActivity {

    TextView mLoginDisplay;
    EditText mUsername;
    EditText mPassword;
    Button mLoginButton;
    TextView mNewUser;
    Button mCreateAccountButton;
    JungleDAO mJungleDAO;
    private String mUserName;
    private String mUserPassword;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginDisplay = findViewById(R.id.loginJunglezonDisplay);
        mUsername = findViewById(R.id.loginUsernameEditText);
        mPassword = findViewById(R.id.loginPasswordEditText);
        mLoginButton = findViewById(R.id.loginLoginButton);
        mNewUser = findViewById(R.id.loginNewUserDisplay);
        mCreateAccountButton = findViewById(R.id.loginCreateAccountButton);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserName = mUsername.getText().toString().trim();
                mUserPassword = mPassword.getText().toString().trim();
                if(checkDatabase()){
                    if(!checkPassword()){
                        //throw bad password error
                    }else{
                        Intent intent = MainActivity.intentFactory(getApplicationContext(),mUser.getUserID());
                        startActivity(intent);
                    }
                }
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
    private boolean checkPassword(){
        if(mUserPassword.equals(mUser.getUserPassword())){
            return true;
        }
        return false;
    }

    public static Intent intentFactory(Context context){
        Intent intent = new Intent(context, LoginActivity.class);

        return intent;
    }
}