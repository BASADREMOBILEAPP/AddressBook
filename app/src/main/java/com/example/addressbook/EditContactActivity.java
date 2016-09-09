package com.example.addressbook;

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
    String id,name,lastname,phone,address,email;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        db = new DBHelper(this);
        Bundle extras = getIntent().getExtras();

        id = extras.getString("id");
        name = extras.getString("name");
        lastname = extras.getString("lastname");
        phone = extras.getString("phone");
        address = extras.getString("address");
        email = extras.getString("email");

        edtName = (EditText) findViewById(R.id.edtName);
        edtLastname = (EditText) findViewById(R.id.edtLastname);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        edtAddress = (EditText) findViewById(R.id.edtAddress);
        edtEmail = (EditText) findViewById(R.id.edtEmail);

        btnEditContact = (Button) findViewById(R.id.btnEditContact);
        btnEditContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editContact();
                finish();
            }
        });
    }

    public void editContact(){

        Contact contact = new Contact();
        contact.setId(id);
        contact.setName(edtName.getText().toString());
        contact.setLastname(edtLastname.getText().toString());
        contact.setPhone(edtPhone.getText().toString());
        contact.setAddress(edtAddress.getText().toString());
        contact.setEmail(edtEmail.getText().toString());

        db.updateContact(contact);
    }
}

