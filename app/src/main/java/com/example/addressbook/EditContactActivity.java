package com.example.addressbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.addressbook.model.Contact;

public class EditContactActivity extends AppCompatActivity {


    EditText edtName,edtLastname,
            edtPhone,edtAddress,edtEmail;
    Button btnEditContact;
    String id;
    DBHelper db;
    int EDITED_CONTACT_RESULT =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        db = new DBHelper(this);
        Bundle extras = getIntent().getExtras();

        id = extras.getString("id");
        Contact contact = db.getData(id);


        edtName = (EditText) findViewById(R.id.edtName);
        edtLastname = (EditText) findViewById(R.id.edtLastname);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        edtAddress = (EditText) findViewById(R.id.edtAddress);
        edtEmail = (EditText) findViewById(R.id.edtEmail);

        edtName.setText(contact.getName());
        edtLastname.setText(contact.getLastname());
        edtPhone.setText(contact.getPhone());
        edtAddress.setText(contact.getAddress());
        edtEmail.setText(contact.getEmail());

        btnEditContact = (Button) findViewById(R.id.btnEditContact);
        btnEditContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editContact()){

                    Intent i = new Intent();
                    setResult(EDITED_CONTACT_RESULT,i);
                    finish();
                }
            }
        });
    }

    public boolean editContact(){

        Contact contact = new Contact();
        contact.setId(id);
        contact.setName(edtName.getText().toString());
        contact.setLastname(edtLastname.getText().toString());
        contact.setPhone(edtPhone.getText().toString());
        contact.setAddress(edtAddress.getText().toString());
        contact.setEmail(edtEmail.getText().toString());

        return db.updateContact(contact);
    }
}

