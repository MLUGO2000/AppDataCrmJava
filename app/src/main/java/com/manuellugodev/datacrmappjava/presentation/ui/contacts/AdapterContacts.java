package com.manuellugodev.datacrmappjava.presentation.ui.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.manuellugodev.datacrmappjava.R;
import com.manuellugodev.datacrmappjava.domain.contact.Contact;

import java.util.List;

public class AdapterContacts extends RecyclerView.Adapter<AdapterContacts.MyHolderContacts> {
    private Context context;
    private List<Contact> listContacts=List.of();

    public AdapterContacts(Context context) {
          this.context=context;
      }

    public void updateDataList(List<Contact> contacts){
        listContacts=contacts;
        notifyDataSetChanged();
    }


      @NonNull
      @Override
      public AdapterContacts.MyHolderContacts onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(context).inflate(R.layout.item_contacts,parent,false);

            return new MyHolderContacts(view);
        }
       @Override
       public void onBindViewHolder(@NonNull AdapterContacts.MyHolderContacts holder, int position) {
          Contact contact=listContacts.get(position);

          holder.idContact.setText(contact.getId());
          holder.contactNo.setText(contact.getContactNo());
          holder.lastNameContact.setText(contact.getLastName());
          holder.lastNameContact.setText(contact.getLastName());
          holder.createdTime.setText(contact.getCreatedTime());

        }

        @Override
        public int getItemCount() {
            return listContacts.size();
        }

      public class MyHolderContacts extends RecyclerView.ViewHolder {
            TextView idContact,contactNo,lastNameContact,createdTime;

            public MyHolderContacts(@NonNull View itemView) {
                super(itemView);

                idContact=itemView.findViewById(R.id.idContacts);
                contactNo=itemView.findViewById(R.id.contactNo);
                lastNameContact=itemView.findViewById(R.id.lastNameContacts);
                createdTime=itemView.findViewById(R.id.createdTimeContacts);
            }

        }
}
