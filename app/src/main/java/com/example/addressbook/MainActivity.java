package com.example.addressbook;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.addressbook.adapter.AddressBookAdapter;
import com.example.addressbook.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvContacts;
    AddressBookAdapter adapter;

    ArrayList<Contact> contactArrayList;
    DBHelper db;
    int EDITED_CONTACT_RESULT =1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper(this);

        contactArrayList = db.getAllContacts();

        lvContacts = (ListView) findViewById(R.id.lvContacts);
        adapter = new AddressBookAdapter(this);
        adapter.setData(contactArrayList);
        lvContacts.setAdapter(adapter);
        lvContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this,ContactActivity.class);
                i.putExtra("id",contactArrayList.get(position).getId());

                startActivityForResult(i,REQUEST_CODE);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    int REQUEST_CODE = 1;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.itemAddedContact:
                Intent i = new Intent(this, RegisterContactActivity.class);
                startActivityForResult(i,REQUEST_CODE);
                break;
            case R.id.itemExit:
                finish();
                break;
        }

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE){
            if(resultCode==EDITED_CONTACT_RESULT){
                contactArrayList = db.getAllContacts();
                adapter.notifyDataSetChanged();
            }
        }
        return;
    }
}