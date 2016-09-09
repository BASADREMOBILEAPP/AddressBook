package com.example.addressbook;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.addressbook.model.Contact;

public class RegisterContactActivity extends AppCompatActivity {

    EditText edtName,edtLastname,
            edtPhone,edtAddress,edtEmail;
    Button btnRegisterContact;

    DBHelper db;
    int CONTACT_CREATED_RESULT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_contact);
        db = new DBHelper(this);

        edtName = (EditText) findViewById(R.id.edtName);
        edtLastname = (EditText) findViewById(R.id.edtLastname);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        edtAddress = (EditText) findViewById(R.id.edtAddress);
        edtEmail = (EditText) findViewById(R.id.edtEmail);

        btnRegisterContact = (Button) findViewById(R.id.btnRegisterContact);
        btnRegisterContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerContact();
            }
        });
    }

    public void registerContact(){
        Contact contact = new Contact();
        contact.setName(edtName.getText().toString());
        contact.setAddress(edtAddress.getText().toString());
        contact.setEmail(edtEmail.getText().toString());
        contact.setPhone(edtPhone.getText().toString());
        contact.setLastname(edtLastname.getText().toString());

        if(db.insertContact(contact)) Toast.makeText(RegisterContactActivity.this, "Se añadio el contacto", Toast.LENGTH_SHORT).show();
        else Toast.makeText(RegisterContactActivity.this, "No se registro el contacto", Toast.LENGTH_SHORT).show();
        setResult(CONTACT_CREATED_RESULT);
        finish();
    }
}
