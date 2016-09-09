package com.example.addressbook;

import android.content.Intent;
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

    String name, lastname, phone, address, email;
    String id;
    DBHelper db;

    Button btnEditContact,btnAcceptContact;
    int EDITED_CONTACT_RESULT =1;
    int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        db = new DBHelper(this);

        txtName = (TextView) findViewById(R.id.txtName);
        txtPhone = (TextView) findViewById(R.id.txtPhone);
        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtEmail = (TextView) findViewById(R.id.txtEmail);

        id = getIntent().getExtras().getString("id");
        Contact contact = db.getData(id);

        name = contact.getName();
        lastname = contact.getLastname();
        phone = contact.getPhone();
        address = contact.getAddress();
        email = contact.getEmail();

        txtName.setText(name + " " + lastname);
        txtPhone.setText(phone);
        txtAddress.setText(address);
        txtEmail.setText(email);

        btnEditContact = (Button) findViewById(R.id.btnEditContact);
        btnEditContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ContactActivity.this, EditContactActivity.class);
                i.putExtra("id",id);
                startActivityForResult(i,REQUEST_CODE);
            }
        });

        btnAcceptContact = (Button) findViewById(R.id.btnAccept);
        btnAcceptContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE){
            if(resultCode==EDITED_CONTACT_RESULT){
                Contact contact = db.getData(id);

                txtName.setText(contact.getName() + " " + contact.getLastname());
                txtEmail.setText(contact.getEmail());
                txtPhone.setText(contact.getPhone());
                txtAddress.setText(contact.getAddress());

                setResult(EDITED_CONTACT_RESULT);
            }
        }
    }
}
