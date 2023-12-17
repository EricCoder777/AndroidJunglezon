package com.daclink.androidjunglezon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.daclink.androidjunglezon.db.JungleDAO;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SearchItems extends AppCompatActivity {

    AutoCompleteTextView seSearchItems;
    Button seSearch;
    Button sePickForMe;
    TextView seItemList;
    Button seBuyItem;
    Button seReturn;
    private JungleDAO mJungleDAO;
    private User mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_items);

        seSearchItems = (AutoCompleteTextView) findViewById(R.id.seSearchText);
        seSearch = findViewById(R.id.seSearch);
        sePickForMe = findViewById(R.id.sePick);
        seItemList = findViewById(R.id.seItem);
        seBuyItem = findViewById(R.id.seBuyB);
        seReturn = findViewById(R.id.seReturn);

        List<Item> items = mJungleDAO.getAllItems();
        StringBuilder sb = new StringBuilder();
        for(Item i : items) {
            sb.append(mJungleDAO.getItemNames());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice, Collections.singletonList(sb.toString()));
        seSearchItems.setThreshold(1);
        seSearchItems.setAdapter(adapter);

        seSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchName = seSearchItems.getText().toString();
                StringBuilder sb = new StringBuilder();
                sb.append(mJungleDAO.getItemByName(searchName));
                seItemList.setText(sb.toString());
                seBuyItem.setVisibility(View.VISIBLE);
            }
        });

        seBuyItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buyName = seSearchItems.getText().toString();
                Item boughtItem = mJungleDAO.getItemByName(buyName);
                UserItems userItems =
    new UserItems(boughtItem.getItemName(), boughtItem.getItemPrice(),1,boughtItem.getItemDescription(), mUser.getUserID());
                mJungleDAO.insert(userItems);
                Toast.makeText(SearchItems.this, "Bought Item!", Toast.LENGTH_SHORT).show();
                seItemList.setText("Item purchased");
                seBuyItem.setVisibility(View.INVISIBLE);
            }
        });

    }





    public static Intent intentFactory(Context context){
        Intent intent = new Intent(context, SearchItems.class);

        return intent;
    }
}