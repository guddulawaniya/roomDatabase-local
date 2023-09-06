package com.example.livedata;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.viewholder> {

    List<User> list;

    public myAdapter(List<User> list) {
        this.list = list;

    }

    @NonNull
    @Override
    public myAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_layout, parent, false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myAdapter.viewholder holder, int position) {

        User module = list.get(position);
        holder.name.setText(module.getFirstName());
        holder.emailaddress.setText(module.getEmailid());
        holder.password.setText(module.getPassword());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        TextView name, emailaddress, password;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            emailaddress = itemView.findViewById(R.id.emailaddress);
            password = itemView.findViewById(R.id.password);
        }
    }
}
