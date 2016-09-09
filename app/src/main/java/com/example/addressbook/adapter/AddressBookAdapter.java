package com.example.addressbook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.addressbook.R;
import com.example.addressbook.model.Contact;

import java.util.ArrayList;

/**
 * Created by angel on 07/09/16.
 */
public class AddressBookAdapter extends BaseAdapter {

    ArrayList<Contact> listContacts;
    LayoutInflater layoutInflater;

    public AddressBookAdapter(Context ctx){
        layoutInflater = LayoutInflater.from(ctx);
    }

    public void setData(ArrayList<Contact> _listContacts){
        listContacts = _listContacts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView==null){
            convertView = layoutInflater.inflate(R.layout.layout_contact_item,null);
            vh = new ViewHolder();
            vh.txtName = (TextView) convertView.findViewById(R.id.txtName);
            vh.txtPhone = (TextView) convertView.findViewById(R.id.txtPhone);
            vh.txtEmail = (TextView) convertView.findViewById(R.id.txtEmail);
            convertView.setTag(vh);

        }else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.txtName.setText(listContacts.get(position).getName() + " " + listContacts.get(position).getLastname());
        vh.txtEmail.setText(listContacts.get(position).getEmail());
        vh.txtPhone.setText(listContacts.get(position).getPhone());

        return convertView;
    }

    @Override
    public int getCount() {
        return listContacts.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return listContacts.get(position);
    }

    private class ViewHolder{
        TextView txtName,
                txtPhone,
                txtEmail;
    }
}
