/**
 * @title MainActivity
 * @author Eric Rodriguez
 * @date 12-03-2023
 * @abstract This activity is the landing page for the Junglezon app
 */

package com.daclink.androidjunglezon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.daclink.androidjunglezon.db.AppDatabase;
import com.daclink.androidjunglezon.db.JungleDAO;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String USER_ID_KEY = "com.daclink.androidjunglezon.userIDKey";
    private static final String PREFERENCES_KEY = "com.daclink.androidjunglezon.PREFERENCES_KEY";
    private TextView mMainDisplay;
    private TextView mUserDisplay;
    private Button mSearchItems;
    private Button mCancelOrder;
    private Button mAccountDetails;
    private Button mIsadmin;
    private Button mLogOut;
    private JungleDAO mJungleDAO;
    private List<User> mUsers;
    private int mUserID = -1;
    private SharedPreferences mPreferences = null;
    private User mUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mJungleDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getJungleDAO();

        userCheck();
        itemCheck();
        userLogin(mUserID);


        mMainDisplay = findViewById(R.id.mainJunglezonDisplay);
        mUserDisplay = findViewById(R.id.mainUserDisplay);
        mUserDisplay.setText("Welcome " + mUser.getUserName() + "!");
        mSearchItems = findViewById(R.id.mainSearchItems);
        mCancelOrder =findViewById(R.id.mainCancelOrder);
        mAccountDetails = findViewById(R.id.mainAccountDetails);
        mIsadmin = findViewById(R.id.mainIsAdmin);

        boolean bool = mUser.getAdmin();
        if(bool) {
            mIsadmin.setVisibility(View.VISIBLE);
        }else{
            mIsadmin.setVisibility(View.INVISIBLE);
        }
        mLogOut = findViewById(R.id.mainLogOut);
        mLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIntent().putExtra(USER_ID_KEY, -1);
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putInt(USER_ID_KEY, -1);
                editor.apply();
                mUserID = -1;
                userCheck();
            }
        });
        mSearchItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SearchItems.intentFactory(getApplicationContext());
                startActivity(intent);
            }
        });




    }

    private void itemCheck() {
        Item firstItem = new Item("Shoes", 9.99, 2, "Shiny new shoes");
        Item secondItem = new Item("Socks", 2.99, 10, "Comfy new socks");
        Item thirdItem = new Item("T-Shirt", 11.99, 1, "Sparkly new t-shirt");
        Item fourthItem = new Item("Pants", 12.99, 3, "Glittery new pants");

        mJungleDAO.insert(firstItem,secondItem,thirdItem,fourthItem);
    }

    private void userCheck(){
        mUserID = getIntent().getIntExtra(USER_ID_KEY, -1);
        if(mUserID != -1){
            return;
        }
        if(mPreferences == null){
            mPreferences = this.getSharedPreferences(PREFERENCES_KEY, Context.MODE_PRIVATE);
        }

        mUserID = mPreferences.getInt(USER_ID_KEY, -1);

        if(mUserID != -1){
            return;
        }

        List<User> users = mJungleDAO.getAllUsers();
        if(users.size() == 0){
            User defaultUser = new User("testuser1", "testuser1");
            defaultUser.setAdmin(false);
            User defaultAdmin = new User("admin2", "admin2");
            defaultAdmin.setAdmin(true);
            mJungleDAO.insert(defaultUser,defaultAdmin);
        }

        Intent intent = LoginActivity.intentFactory(this);
        startActivity(intent);

    }

    private void userLogin(int userID){
        mUser = mJungleDAO.getUserByID(userID);
        if(mPreferences == null){
            mPreferences = this.getSharedPreferences(PREFERENCES_KEY, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt(USER_ID_KEY, userID);
        editor.apply();

    }

    public static Intent intentFactory(Context context, int userID) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(USER_ID_KEY, userID);

        return intent;
    }




}