package com.appinventiv.cleanarchitecturesample.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appinventiv.cleanarchitecturesample.R;
import com.appinventiv.cleanarchitecturesample.data.model.User;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>  {
    private List<User> users;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bindData(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users!=null?users.size():0;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        private final TextView title;
        private final TextView description;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
        }

        public void bindData(User user){
            title.setText(user.getUsername());
            description.setText(user.getEmail());
        }
    }
    public void notifyAdapter(List<User> users){
        this.users = users;
        notifyDataSetChanged();
    }
}
