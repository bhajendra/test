package bpund.isurakaha.com.test.search.filter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import bpund.isurakaha.com.test.R;

/**
 * Created by isuraksha3 on 4/6/2018.
 */

public class ContactFilterAdapter extends RecyclerView.Adapter<ContactFilterAdapter.MyViewHolder> implements Filterable {

   ArrayList<Contact> contactsList;
   ArrayList<Contact> contactsFilteredList;
    ContactAdapterListener contactAdapterListener;
    Context mContext;

    // these data will come from mainactivity
  /*  public ContactFilterAdapter(ArrayList<Contact> contactsFilteredList,ArrayList<Contact> contactsList, ContactAdapterListener contactAdapterListener, Context mContext) {
        this.contactsList = contactsList;
        this.contactsFilteredList = contactsFilteredList;
        this.contactAdapterListener = contactAdapterListener;
        this.mContext = mContext;
    }*/

    public ContactFilterAdapter(SearchFilterMainActivity searchFilterMainActivity, ArrayList<Contact> contactArrayList, Context mContext ) {
        this.contactsList = contactArrayList;
        this.mContext = mContext;
        this.contactsFilteredList = contactArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        View view=layoutInflater.inflate(R.layout.user_row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Contact contact=contactsFilteredList.get(position);

        holder.name.setText(contact.getName());
        holder.phone.setText(contact.getPhone());
        Glide.with(mContext).load(contact.getImage()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        Log.d("contactSize", String.valueOf(contactsFilteredList.size()));
        return contactsFilteredList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, phone;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            phone = (TextView) view.findViewById(R.id.phone);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }

    // do filter login
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charSequnce=constraint.toString();
                if (charSequnce.isEmpty()){
                    contactsFilteredList=contactsList;
                }else {
                 ArrayList<Contact> tempFilterList=new ArrayList<>();
                    for (Contact contact: contactsList) {
                        // logic for filtering
                        if (contact.getName().toLowerCase().contains(charSequnce.toLowerCase()) || contact.getPhone().contains(charSequnce))
                            tempFilterList.add(contact);
                    }
                    contactsFilteredList=tempFilterList;
                }

                FilterResults filterResults=new FilterResults();
                filterResults.values=contactsFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

            contactsFilteredList=(ArrayList<Contact>)results.values;
                notifyDataSetChanged();
            }
        };
    }
    interface ContactAdapterListener
    {
        void onContactSelected(Contact contact);
    }
}
