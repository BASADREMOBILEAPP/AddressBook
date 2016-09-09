package com.example.addressbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.addressbook.model.Contact;

public class ContactActivity extends AppCompatActivity {

    TextView txtName,
            txtPhone,
            txtAddress,
            txtEmail;

    String name,lastname,phone,address,email;
    String id;
    DBHelper db;

    Button btnEditContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        db = new DBHelper(this);

        txtName = (TextView) findViewById(R.id.txtName);
        txtPhone = (TextView) findViewById(R.id.txtPhone);
        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtEmail = (TextView) findViewById(R.id.txtEmail);

        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");
        name = extras.getString("name");
        lastname = extras.getString("lastname");
        phone = extras.getString("phone");
        address = extras.getString("address");
        email = extras.getString("email");

        txtName.setText(name+" " + lastname);
        txtPhone.setText(phone);
        txtAddress.setText(address);
        txtEmail.setText(email);

        btnEditContact = (Button) findViewById(R.id.btnEditContact);
        btnEditContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editContact();
            }
        });

    }

    public void editContact(){

        Contact contact = new Contact();
        contact.setId(id);
        contact.setName(name);
        contact.setLastname(lastname);
        contact.setPhone(phone);
        contact.setAddress(address);
        contact.setEmail(email);

        db.updateContact(contact);
    }
}
