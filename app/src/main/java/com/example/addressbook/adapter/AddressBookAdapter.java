package com.example.addressbook.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.addressbook.model.Contact;

import java.util.ArrayList;

/**
 * Created by angel on 07/09/16.
 */
public class AddressBookAdapter extends BaseAdapter {

    ArrayList<Contact> listContacts;

    public AddressBookAdapter(ArrayList<Contact> _listContacts){
        listContacts = _listContacts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    private class ViewHolder{

    }
}
