package com.example.addressbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    TextView txtName,
            txtPhone,
            txtAddress,
            txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        txtName = (TextView) findViewById(R.id.txtName);
        txtPhone = (TextView) findViewById(R.id.txtPhone);
        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtEmail = (TextView) findViewById(R.id.txtEmail);

        Bundle extras = getIntent().getExtras();

        txtName.setText(extras.getString("name")+" " + extras.getString("lastname"));
        txtPhone.setText(extras.getString("phone"));
        txtAddress.setText(extras.getString("address"));
        txtEmail.setText(extras.getString("email"));

    }
}
