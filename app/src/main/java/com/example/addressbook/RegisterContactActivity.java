package com.example.addressbook;

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

    SQLiteDatabase db = openOrCreateDatabase("addressbook",MODE_PRIVATE,null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_contact);

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

        String name = edtName.getText().toString();
        String lastname = edtLastname.getText().toString();
        String phone = edtPhone.getText().toString();
        String address = edtAddress.getText().toString();
        String email = edtEmail.getText().toString();

        db.execSQL("CREATE TABLE IF NOT EXISTS Contacts" +
                "(Name VARCHAR," +
                "Lastname VARCHAR" +
                "Phone VARCHAR" +
                "Address VARCHAR" +
                "Email VARCHAR);");

        db.execSQL("INSERT INTO Contacts values " +
                "('"+name+"','"+lastname+"','"+phone+"','"+address+"','"+email+"')");

        Toast.makeText(RegisterContactActivity.this, "Se añadio el contacto", Toast.LENGTH_SHORT).show();
    }
}
