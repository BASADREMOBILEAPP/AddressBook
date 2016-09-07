package com.example.addressbook;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.addressbook.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvContacts;
    ArrayList<Contact> contactArrayList;
    SQLiteDatabase db = openOrCreateDatabase("addressbook",MODE_PRIVATE,null);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fetchContacts();

        lvContacts = (ListView) findViewById(R.id.lvContacts);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.itemAddedContact:
                Intent i = new Intent(this,RegisterContactActivity.class);
                startActivity(i);
                break;
            case R.id.itemExit:
                finish();
                break;
        }

        return true;
    }

    public void fetchContacts(){

    }
}
